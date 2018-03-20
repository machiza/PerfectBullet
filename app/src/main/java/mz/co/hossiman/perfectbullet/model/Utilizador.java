package mz.co.hossiman.perfectbullet.model;

/**
 * Created by secreto on 3/8/18.
 */

public class Utilizador {

    private String nome;
    private int telemovel;
    private String email;
    private String senha;
    private Funcao funcao;

    public Utilizador() {
    }

    public Utilizador(String nome, int telemovel, String email, String senha, Funcao funcao) {
        this.nome = nome;
        this.telemovel = telemovel;
        this.email = email;
        this.senha = senha;
        this.funcao = funcao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTelemovel() {
        return telemovel;
    }

    public void setTelemovel(int telemovel) {
        this.telemovel = telemovel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Funcao getFuncao() {
        return funcao;
    }

    public void setFuncao(Funcao funcao) {
        this.funcao = funcao;
    }
}
