package mz.co.hossiman.perfectbullet.model;

/**
 * Created by secreto on 3/17/18.
 */

public class Funcao {

    private String nome;
    private String descricao;

    public Funcao() {
    }

    public Funcao(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
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
}
