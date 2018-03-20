package mz.co.hossiman.perfectbullet.model;

/**
 * Created by secreto on 3/8/18.
 */

public class Fornecedor {

    private String nome;
    private String email;
    private int telemovel;
    private String cidade;

    public Fornecedor() {
    }

    public Fornecedor(String nome, String email, int telemovel, String cidade) {
        this.nome = nome;
        this.email = email;
        this.telemovel = telemovel;
        this.cidade = cidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelemovel() {
        return telemovel;
    }

    public void setTelemovel(int telemovel) {
        this.telemovel = telemovel;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}
