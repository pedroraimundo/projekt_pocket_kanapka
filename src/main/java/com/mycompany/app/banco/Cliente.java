package com.mycompany.app.banco;

import java.util.Objects;

public class Cliente
{
    public final String nome;
    public final String cpf;
    public final ContaCorrente contaCorrente;

    public Cliente(String nome, String cpf, ContaCorrente contaCorrente)
    {
        this.nome = nome;
        this.cpf = cpf;
        this.contaCorrente = contaCorrente;
    }

    public Cliente(String nome, String cpf)
    {
        this(nome, cpf, new ContaCorrente());
    }

    public Cliente withNome(String nome)
    {
        return new Cliente(nome, cpf, contaCorrente);
    }

    public Cliente withCpf(String cpf)
    {
        return new Cliente(nome, cpf, contaCorrente);
    }

    public Cliente withConta(ContaCorrente contaCorrente)
    {
        return new Cliente(nome, cpf, contaCorrente);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(nome, cliente.nome) &&
                Objects.equals(cpf, cliente.cpf) &&
                Objects.equals(contaCorrente, cliente.contaCorrente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, cpf, contaCorrente);
    }
}
