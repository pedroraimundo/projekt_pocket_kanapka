package com.mycompany.app.banco;

import java.util.Objects;

public class Cliente
{
    public final String nome;
    public final String cpf;
    public final Conta conta;

    public Cliente(String nome, String cpf, TipoConta tipoConta)
    {
        this(nome, cpf, tipoConta == TipoConta.Corrente ? new ContaCorrente() : new ContaPoupanca());
    }

    private Cliente(String nome, String cpf, Conta conta)
    {
        this.nome = nome;
        this.cpf = cpf;
        this.conta = conta;
    }

    public Cliente withNome(String nome)
    {
        return new Cliente(nome, cpf, conta);
    }

    public Cliente withCpf(String cpf)
    {
        return new Cliente(nome, cpf, conta);
    }

    public Cliente withConta(Conta conta)
    {
        return new Cliente(nome, cpf, conta);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(nome, cliente.nome) &&
                Objects.equals(cpf, cliente.cpf) &&
                Objects.equals(conta, cliente.conta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, cpf, conta);
    }
}
