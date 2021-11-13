package ifam.edu.model;

import javax.persistence.*;
import java.util.List;

public class Cidade {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(unique = true, nullable = false)
    private String nome;

    @Column(unique = true, nullable = false)
    private String codigoIBGE;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Estado estado;

    @OneToMany(mappedBy = "cidade")
    private List<Pessoa> pessoas;

    public Cidade() {
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

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public List<Pessoa> getPessoa() {
        return pessoas;
    }

    @Override
    public String toString() {
        return "Cidade{" +
                "nome='" + nome + '\'' +
                ", codigoIBGE=" + codigoIBGE + '\'' +
                ", estado=" + estado + '\'' +
                ", pessoas=" + pessoas + '\'' +
                '}';
    }
}
