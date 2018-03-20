package mz.co.hossiman.perfectbullet.model;

/**
 * Created by secreto on 3/16/18.
 */

public class Cliente {

    private String nome;
    private float saldo;

    public Cliente() {
    }

    public Cliente(String nome, float saldo) {
        this.nome = nome;
        this.saldo = saldo;
    }

    public void deposito(float valor) {
        this.saldo += valor;
    }

    public void debitarPagamento(float valor) {
        this.saldo -= valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
}
