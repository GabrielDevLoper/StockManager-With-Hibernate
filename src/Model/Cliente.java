package Model;


import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table
@SequenceGenerator(name="cliente_seq", sequenceName = "cliente_seq" ,initialValue=1, allocationSize = 1)// comando para criar uma sequencia propria para a tabela atual.
public class Cliente extends Model implements Serializable {
    
    @Id //Fazendo com que o banco de dados transforme o id em serial.
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "cliente_seq")//GenerationType.IDENTITY esse identity faz com que o cada tabela tenha sua propria sequencia de pk;
    private int id;
    @Column(unique = true)//este comando impossibilita de cadastrar nomes iguais na coluna nome.
    private String nome;
    private String telefone;
    private String cpf;
    @OneToOne (cascade = CascadeType.ALL)
    private Endereco endereco;

    public Cliente() {
    }

    public Cliente(String nome, String telefone, String cpf, Endereco endereco) {
        this.nome = nome;
        this.telefone = telefone;
        this.cpf = cpf;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    
    

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nome=" + nome + ", telefone=" + telefone + ", cpf=" + cpf + '}';
    }
    
    
    
    
    
}
