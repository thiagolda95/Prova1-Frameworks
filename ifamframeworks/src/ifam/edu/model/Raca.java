package ifam.edu.model;

import javax.persistence.*;
import java.util.List;

public class Raca {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(unique = true, nullable = false)
    private String nome;

    @ManyToOne
    private Especie especie;

    @OneToMany(mappedBy = "raca")
    private List<Pet> pets;

    public Raca() {
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

    public Especie getEspecie() {
        return especie;
    }

    public void setEspecie(Especie especie) {
        this.especie = especie;
    }

    public List<Pet> getPets() {
        return pets;
    }

}
