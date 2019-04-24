package Model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


//@Entity
//@Table
public class Empresa extends Model implements Serializable{
    //@Id
   // @GeneratedValue
    private int id;
    private String nome;
    private String cnpj;
    private String telefone;

    public Empresa() {
    }

    public Empresa(String nome, String cnpj, String telefone) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.telefone = telefone;
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
    
    
    
}
