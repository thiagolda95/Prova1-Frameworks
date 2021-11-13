package ifam.edu.dao;

import ifam.edu.model.Pessoa;
import ifam.edu.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class PessoaDAO {

    private EntityManager entityManager;

    public PessoaDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void salvar (Pessoa pessoa){

        EntityManager entityManager = JPAUtil.getEntityManager();

        entityManager.getTransaction().begin();

        entityManager.persist(pessoa);

        entityManager.getTransaction().commit();

        entityManager.close();

    }

    public List<Pessoa> listar(){
        EntityManager entityManager = JPAUtil.getEntityManager();

        Query query = entityManager.createQuery("select e from pessoa e");

        List<Pessoa> pessoas = query.getResultList();

        return pessoas;
    }

    public List<Pessoa> listarParteNome(String nome){
        Query query = entityManager.createQuery("select p from pessoa p where p.nome like :parNome");

        query.setParameter("parNome","%"+nome+"%");

        List<Pessoa> obj = query.getResultList();
        return obj;
    }

    public void remover(Integer id){
        EntityManager entityManager = JPAUtil.getEntityManager();

        Pessoa pessoa = entityManager.find(Pessoa.class, id);

        entityManager.getTransaction().begin();

        entityManager.remove(pessoa);

        entityManager.getTransaction().commit();

        entityManager.close();

    }

    public Pessoa consultar(Integer id){
        EntityManager entityManager = JPAUtil.getEntityManager();

        Pessoa pessoa = entityManager.find(Pessoa.class, id);
        entityManager.close();
        return pessoa;
    }
}
