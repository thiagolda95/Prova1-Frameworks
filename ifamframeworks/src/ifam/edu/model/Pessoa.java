package ifam.edu.model;

import javax.persistence.*;
import java.time.LocalDateTime;

public class Pessoa {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(unique = true, nullable = false)
    private String nome;

    @Enumerated(EnumType.STRING)
    private SexoPessoaENUM sexo;

    @Column(unique = true, nullable = false)
    private String documento;

    private String telefone;

    private String email;

    private LocalDateTime nascimento;

    private String endereco;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Cidade cidade;

    @Enumerated(EnumType.STRING)
    private PessoaENUM tipo;

    public Pessoa() {
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

    public SexoPessoaENUM getSexo() {
        return sexo;
    }

    public void setSexo(SexoPessoaENUM sexo) {
        this.sexo = sexo;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }
    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDateTime nascimento) {
        this.nascimento = nascimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public PessoaENUM getTipo() {
        return tipo;
    }

    public void setTipo(PessoaENUM tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", sexo=" + sexo + '\'' +
                ", documento=" + documento + '\'' +
                ", telefone=" + telefone + '\'' +
                ", email=" + email + '\'' +
                ", nascimento=" + nascimento + '\'' +
                ", endereco=" + endereco + '\'' +
                ", cidade=" + cidade + '\'' +
                ", tipo=" + tipo + '\'' +
                '}';
    }
}
