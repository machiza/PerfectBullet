package mz.co.hossiman.perfectbullet.model;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by secreto on 2/28/18.
 */

public class Produto implements Serializable {

    private String nome;
    private Categoria categoria;
    private Marca marca;
    private String tipo;
    private float preco;
    private float valorCompra;
    private int quantidade;
    private int thumbnail;
    private Fornecedor fornecedor;
    private Utilizador utilizador;
    private int selected;

//    private Timestamp timestamp;

    public Produto() {
    }

    public Produto(String nome, Categoria categoria, Marca marca, String tipo, float preco, float valorCompra, int quantidade, int thumbnail, Fornecedor fornecedor, Utilizador utilizador) {
        this.nome = nome;
        this.categoria = categoria;
        this.marca = marca;
        this.tipo = tipo;
        this.preco = preco;
        this.valorCompra = valorCompra;
        this.quantidade = quantidade;
        this.thumbnail = thumbnail;
        this.fornecedor = fornecedor;
        this.utilizador = utilizador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public float getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(float valorCompra) {
        this.valorCompra = valorCompra;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Utilizador getUtilizador() {
        return utilizador;
    }

    public void setUtilizador(Utilizador utilizador) {
        this.utilizador = utilizador;
    }

    public int getSelected() {
        return selected;
    }

    public void setSelected(int selected) {
        this.selected = selected;
    }
}
