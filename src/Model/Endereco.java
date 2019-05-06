package Model;


import java.io.Serializable;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
@SequenceGenerator(name="endereco_seq", sequenceName = "endereco_seq" ,initialValue=1, allocationSize = 1)
public class Endereco extends Model implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "endereco_seq")
    private int id;
    private String cidade;
    private String bairro;
    private String endereco;
    private String numero;
    private String complemento;
    private String uf;
    private String cep;
    
    @ManyToOne
    private Cliente cliente;
    
    @ManyToOne
    private Empresa empresa;
    
    public Endereco() {
    }

    public Endereco(int id, String cidade, String bairro, String endereco, String numero, String complemento, String uf, String cep, Cliente cliente) {
        this.id = id;
        this.cidade = cidade;
        this.bairro = bairro;
        this.endereco = endereco;
        this.numero = numero;
        this.complemento = complemento;
        this.uf = uf;
        this.cep = cep;
        this.cliente = cliente;
    }

    public Endereco(String cidade, String bairro, String endereco, String numero, String complemento, String uf, String cep, Cliente cliente) {
        this.cidade = cidade;
        this.bairro = bairro;
        this.endereco = endereco;
        this.numero = numero;
        this.complemento = complemento;
        this.uf = uf;
        this.cep = cep;
        this.cliente = cliente;
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
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

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
    
    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

   
    
    

    
    
}
