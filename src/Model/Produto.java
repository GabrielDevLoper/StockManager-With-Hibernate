package Model;

import java.io.Serializable;

public class Produto extends Model implements Serializable {
    
    private int id;
    private String categoria;
    private String descricacao;
    private String unidade;
    private String quantidade;
    private double valorUnd;
    private double valorTotal;

    public Produto(String categoria, String descricacao, String unidade, String quantidade, double valorUnd, double valorTotal) {
        this.categoria = categoria;
        this.descricacao = descricacao;
        this.unidade = unidade;
        this.quantidade = quantidade;
        this.valorUnd = valorUnd;
        this.valorTotal = valorTotal;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescricacao() {
        return descricacao;
    }

    public void setDescricacao(String descricacao) {
        this.descricacao = descricacao;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorUnd() {
        return valorUnd;
    }

    public void setValorUnd(double valorUnd) {
        this.valorUnd = valorUnd;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
    
    

    
    
    
}
