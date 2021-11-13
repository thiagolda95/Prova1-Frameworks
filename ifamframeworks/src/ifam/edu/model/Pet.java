package ifam.edu.model;

import org.hibernate.type.LocalDateTimeType;

import javax.persistence.*;


public class Pet {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(unique = true, nullable = false)
    private String nome;

    @Enumerated(EnumType.STRING)
    private SexoPetENUM sexo;

    private LocalDateTimeType nascimento;

    @ManyToOne
    private Pessoa proprietario;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Raca raca;


    public Pet() {
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

    public SexoPetENUM getSexo() {
        return sexo;
    }

    public void setSexo(SexoPetENUM sexo) {
        this.sexo = sexo;
    }

    public LocalDateTimeType getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDateTimeType nascimento) {
        this.nascimento = nascimento;
    }

    public Pessoa getPessoa() {
        return proprietario;
    }

    public Raca getRaca() {
        return raca;
    }

    public void setRaca(Raca raca) {
        this.raca = raca;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
