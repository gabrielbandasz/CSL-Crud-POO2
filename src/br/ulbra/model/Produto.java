package br.ulbra.model;

import br.ulbra.model.Fornecedor;

public class Produto {

    private int id;
    private String nome;
    private double preco;
    private Fornecedor fornecedor; // relação 1:N

    public Produto() {
    }

    public Produto(int id, String nome, double preco, Fornecedor fornecedor) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.fornecedor = fornecedor;
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

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String toString() {
        return this.getNome(); 
    }

}
