package ifam.edu;

import ifam.edu.dao.PessoaDAO;
import ifam.edu.dao.PetDAO;
import ifam.edu.model.*;
import ifam.edu.util.JPAUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class Main {

    //Métodos de preenchimento de atributos e as associações entre os objetos;

    public static  void inserirPaisNoBD(){

        EntityManager em = JPAUtil.getEntityManager();

        //Transient
        Pais p1 = new Pais();
        Pais p2 = new Pais();
        Pais p3 = new Pais();
        p1.setNome("Brasil");
        p2.setNome("Argentina");
        p3.setNome("Estados Unidos");

        //Persistir
        em.getTransaction().begin();
        em.persist(p1);
        em.persist(p2);
        em.persist(p3);
        em.getTransaction().commit();
        em.close();

    }

    public static void inserirEstadoComPaisNoBD(){

        EntityManager em = JPAUtil.getEntityManager();

        //Instância de 1 pais para associar ao Estado
        Pais p1 = new Pais();
        p1.setNome("Brasil");
        p1.setCodigoISO("BRA");

        //Instâncias de estado para associar ao p1
        Estado e1 = new Estado();
        Estado e2 = new Estado();
        Estado e3 = new Estado();

        //Inserindo dados no estado 1
        e1.setNome("Amazonas");
        e1.setCodigoIBGE("AM");
        e1.setPais(p1);

        //Inserindo dados no estado 2
        e2.setNome("Pará");
        e2.setCodigoIBGE("PA");
        e2.setPais(p1);

        //Inserindo dados no estado 3
        e3.setNome("São Paulo");
        e3.setCodigoIBGE("SP");
        e3.setPais(p1);

        //Persistir
        em.getTransaction().begin();
        em.persist(e1);
        em.persist(e2);
        em.persist(e3);
        em.getTransaction().commit();
        em.close();

    }

    public static void inserirCidadeComEstadoNoBD(){

        EntityManager em = JPAUtil.getEntityManager();

        Estado e1 = new Estado();
        e1.setNome("Amazonas");
        e1.setCodigoIBGE("AM");

        Cidade c1 = new Cidade();
        c1.setNome("Manaus");
        c1.setCodigoIBGE("MAO");
        c1.setEstado(e1);

        em.getTransaction().begin();
        em.persist(c1);
        em.getTransaction().commit();
        em.close();

    }

    public static void inserirPessoaCidadeAssociacao(){

        EntityManager em = JPAUtil.getEntityManager();

        Cidade c1 = new Cidade();
        c1.setNome("Rio de Janeiro");
        c1.setCodigoIBGE("RJ");

        Pessoa p1 = new Pessoa();
        p1.setNome("João");
        p1.setDocumento("0001");
        p1.setSexo(SexoPessoaENUM.MASCULINO);
        p1.setCidade(c1);

        Pessoa p2 = new Pessoa();
        p2.setNome("Raquel");
        p2.setDocumento("0002");
        p2.setSexo(SexoPessoaENUM.FEMININO);
        p2.setCidade(c1);

        em.getTransaction().begin();
        em.persist(p1);
        em.persist(p2);
        em.getTransaction().commit();
        em.close();

    }

    public static void inserirPetRacaAssociacao(){

        EntityManager em = JPAUtil.getEntityManager();

        Raca r1 = new Raca();
        r1.setNome("Pug");

        Pet pet1 = new Pet();
        pet1.setNome("Greg");
        pet1.setRaca(r1);

        Pet pet2 = new Pet();
        pet2.setNome("Gigi");
        pet2.setRaca(r1);

        em.getTransaction().begin();
        em.persist(pet1);
        em.persist(pet2);
        em.getTransaction().commit();
        em.close();

    }
    
    

    public static void inserirPessoaComCidadeNoBD() {

        EntityManager em = JPAUtil.getEntityManager();

        Estado estado = new Estado();
        estado.setNome("Sao Paulo");
        estado.setCodigoIBGE("SP");

        //Transient
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Raniele");
        pessoa.setDocumento("1111111");
        pessoa.setTelefone("4587-6321");
        pessoa.setSexo(SexoPessoaENUM.FEMININO);

        Cidade cidade = new Cidade();
        cidade.setEstado(estado);
        cidade.setNome("Manaus");

        pessoa.setCidade(cidade);

        em.getTransaction().begin();
        em.persist(estado);
        em.persist(cidade);
        em.persist(pessoa);
        em.getTransaction().commit();
        em.close();
    }

    public static void consultar() {
        EntityManager em = JPAUtil.getEntityManager();
        Cidade cidade = em.find(Cidade.class, 1);

        System.out.println("Cidade - Id" + cidade.getId());
        System.out.println("Cidade - Nome" + cidade.getNome());

        Pessoa pessoa = em.find(Pessoa.class, 1);

        System.out.println("Pessoa - Id" + cidade.getId());
        System.out.println("Pessoa - Nome" + pessoa.getNome());
        System.out.println("Pessoa - Cidade" + pessoa.getCidade().getNome());
        System.out.println("Pessoa - Estado" + pessoa.getCidade().getEstado().getNome());
    }

    private static void remover() {

        EntityManager em = JPAUtil.getEntityManager();

        em.getTransaction().begin();

        Pessoa pessoa = em.find(Pessoa.class, 1);

        em.remove(pessoa);

        em.getTransaction().commit();
    }

    //2.d Implemente classes que demonstre a utilização dessas classes e todos os métodos.
    //Método inserir Pessoa
    public static void inserirPessoaDAO(){

        Pessoa p = new Pessoa();

        p.setNome("Mariana");

        p.setEndereco("R. 5 - Japiim");

        EntityManager em = JPAUtil.getEntityManager();

        PessoaDAO dao = new PessoaDAO(em);

        em.getTransaction().begin();

        dao.salvar(p);

        em.getTransaction().commit();

        em.close();

    }

    //Método consultar Pessoa
    public static void consultarPessoaDao() {

        EntityManager entityManager = JPAUtil.getEntityManager();

        PessoaDAO dao = new PessoaDAO(entityManager);

        entityManager.getTransaction().begin();

        Pessoa pessoa = dao.consultar(1);

        System.out.println(pessoa.toString());

        entityManager.getTransaction().commit();

        entityManager.close();

    }

    //Método remover Pessoa
    public static void removerPessoaDao() {

        EntityManager entityManager = JPAUtil.getEntityManager();

        PessoaDAO dao = new PessoaDAO(entityManager);

        entityManager.getTransaction().begin();

        dao.remover(1);

        entityManager.getTransaction().commit();

        entityManager.close();


    }

    //Método listar pessoa por parte do nome
    public static void listarParteNomePessoaDAO(){

        EntityManager entityManager = JPAUtil.getEntityManager();

        PessoaDAO pessoaDAO = new PessoaDAO(entityManager);

        List<Pessoa> pessoas = pessoaDAO.listarParteNome("M");

        for(Pessoa p:pessoas){

            System.out.println(p);
        }

        entityManager.close();;
    }

    //Método listar Pessoas
    public static void listarPessoaDao() {

        EntityManager entityManager = JPAUtil.getEntityManager();

        PessoaDAO dao = new PessoaDAO(entityManager);

        List<Pessoa> pessoas = dao.listar();

        for (Pessoa pessoa : pessoas) {

            System.out.println(pessoa.toString());

        }
        entityManager.close();

    }

    //2.d Implemente classes que demonstre a utilização dessas classes e todos os métodos.
    //Método inserir Pet
    public static void inserirPetDAO(){

        Pet pet = new Pet();

        pet.setNome("Scott");

        pet.setSexo(SexoPetENUM.MACHO);


        EntityManager em = JPAUtil.getEntityManager();

        PetDAO dao = new PetDAO(em);

        em.getTransaction().begin();

        dao.salvar(pet);

        em.getTransaction().commit();

        em.close();

    }

    //Método consultar Pet
    public static void consultarPetDao() {

        EntityManager entityManager = JPAUtil.getEntityManager();

        PetDAO dao = new PetDAO(entityManager);

        entityManager.getTransaction().begin();

        Pet pet = dao.consultar(1);

        System.out.println(pet.toString());

        entityManager.getTransaction().commit();

        entityManager.close();

    }

    //Método remover Pet
    public static void removerPetDao() {

        EntityManager entityManager = JPAUtil.getEntityManager();

        PetDAO dao = new PetDAO(entityManager);

        entityManager.getTransaction().begin();

        dao.remover(1);

        entityManager.getTransaction().commit();

        entityManager.close();


    }

    //Método listar pet por parte do nome
    public static void listarParteNomePetDAO(){

        EntityManager entityManager = JPAUtil.getEntityManager();

        PetDAO pet = new PetDAO(entityManager);

        List<Pet> pets = pet.listarParteNomePet("S");

        for(Pet p:pets){

            System.out.println(p);
        }

        entityManager.close();;
    }

    //Método listar todos os Pets
    public static void listarPetDao() {

        EntityManager entityManager = JPAUtil.getEntityManager();

        PetDAO petdao = new PetDAO(entityManager);

        List<Pet> pets = petdao.listar();

        for (Pet pet: pets) {

            System.out.println(pet.toString());

        }
        entityManager.close();

    }


    public static void main(String[] args) {

    inserirPaisNoBD();
    inserirCidadeComEstadoNoBD();
    inserirPessoaComCidadeNoBD();
    inserirPessoaDAO();
    inserirPetDAO();
    inserirPessoaCidadeAssociacao();
    inserirPetRacaAssociacao();


    }

}
