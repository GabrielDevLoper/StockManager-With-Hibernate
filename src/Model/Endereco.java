package Model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import static javax.persistence.FetchType.EAGER;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table
public class Endereco extends Model implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)//GenerationType.IDENTITY esse identity faz com que o cada tabela tenha sua propria sequencia de pk;
    private int id;
    private String cidade;
    private String bairro;
    private String rua;
    private String numero;
    private String complemento;
    @OneToOne //(cascade = {CascadeType.PERSIST, CascadeType.REFRESH}, fetch = EAGER)
    private Cliente cliente;

    public Endereco(String cidade, String bairro, String rua, String numero, String complemento, Cliente cliente) {
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
        this.cliente = cliente;
    }

    

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public Endereco() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
    
    
    
    
    
}
