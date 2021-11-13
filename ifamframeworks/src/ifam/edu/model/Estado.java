package ifam.edu.model;

import javax.persistence.*;

public class Estado {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(unique = true, nullable = false)
    private String nome;

    @Column(unique = true, nullable = false)
    private String codigoIBGE;

    @ManyToOne
    private Pais pais;

    public Estado() {
    }

    public Estado(String nome, String codigoIBGE, Pais pais) {
        this.nome = nome;
        this.codigoIBGE = codigoIBGE;
        this.pais = pais;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigoIBGE() {
        return codigoIBGE;
    }

    public void setCodigoIBGE(String codigoIBGE) {
        this.codigoIBGE = codigoIBGE;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "Estado{" +
                "nome='" + nome + '\'' +
                ", codigoIBGE=" + codigoIBGE + '\'' +
                ", pais=" + pais +
                '}';
    }
}
