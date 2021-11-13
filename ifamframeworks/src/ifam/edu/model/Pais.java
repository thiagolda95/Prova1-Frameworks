package ifam.edu.model;


import javax.persistence.*;

@Entity(name= "pais")
public class Pais {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(unique = true, nullable = false)
    private String nome;

    @Column(unique = true, nullable = false)
    private String codigoISO;

    public Integer getId() {
        return id;
    }

    public Pais() {
    }

    public Pais(String nome, String codigoISO) {
        this.nome = nome;
        this.codigoISO = codigoISO;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigoISO() {
        return codigoISO;
    }

    public void setCodigoISO(String codigoISO) {
        this.codigoISO = codigoISO;
    }

    @Override
    public String toString() {
        return "Pais{" +
                "nome='" + nome + '\'' +
                ", codigo ISO=" + codigoISO +
                '}';
    }
}
