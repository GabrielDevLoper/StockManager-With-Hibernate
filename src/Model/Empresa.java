package Model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table
@SequenceGenerator(name="empresa_seq", sequenceName = "empresa_seq" ,initialValue=1, allocationSize = 1)// comando para criar uma sequencia propria para a tabela atual.
public class Empresa extends Model implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "empresa_seq")//GenerationType.IDENTITY esse identity faz com que o cada tabela tenha sua propria sequencia de pk;
    private int id;
    private String nome;
    private String cnpj;
    private String telefone;
    @OneToOne (cascade = CascadeType.ALL)
    private Endereco endereco;

    public Empresa() {
    }

    public Empresa(String nome, String cnpj, String telefone, Endereco endereco) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.telefone = telefone;
        this.endereco = endereco;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    
    
    
}
