package com.nathanraposo.myapp.myapp.model;

/**
 * Created by nathan on 20/09/17.
 */

public class Produtos {

    private Long id;
    private String nome;
    private String descricao;
    private int quantidade;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Produtos produtos = (Produtos) o;

        if (quantidade != produtos.quantidade) return false;
        if (id != null ? !id.equals(produtos.id) : produtos.id != null) return false;
        if (nome != null ? !nome.equals(produtos.nome) : produtos.nome != null) return false;
        return descricao != null ? descricao.equals(produtos.descricao) : produtos.descricao == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (descricao != null ? descricao.hashCode() : 0);
        result = 31 * result + quantidade;
        return result;
    }

    @Override
    public String toString() {
        return "Produtos{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", quantidade=" + quantidade +
                '}';
    }
}
