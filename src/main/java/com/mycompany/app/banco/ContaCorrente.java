package com.mycompany.app.banco;

import java.util.Objects;

public class ContaCorrente implements Conta {

    public final double saldoAtual;
    public final double limite;
    public final int numeroConta;

    public ContaCorrente(double saldoAtual, double limite, int numeroConta)
    {
        this.saldoAtual = saldoAtual;
        this.limite = limite;
        this.numeroConta = numeroConta;
    }

    public ContaCorrente()
    {
        saldoAtual = 0.0;
        limite = 50;
        numeroConta = 0;
    }

    public ContaCorrente withSaldoAtual(double saldoAtual)
    {
        return new ContaCorrente(saldoAtual, limite, numeroConta);
    }

    public ContaCorrente withLimite(double limite)
    {
        return new ContaCorrente(saldoAtual, limite, numeroConta);
    }

    public ContaCorrente withNumeroConta(int numeroConta)
    {
        return new ContaCorrente(saldoAtual, limite, numeroConta);
    }

    @Override
    public ContaCorrente saca(double valor)
    {
        if (this.saldoAtual < valor)
        {
            return this;
        }
        else
        {
            return new ContaCorrente(saldoAtual - valor, limite, numeroConta);
        }
    }

    @Override
    public ContaCorrente deposita(double valor)
    {
        if ((valor < 0) || (valor == 0))
        {
            return this;
        }
        else
        {
            return new ContaCorrente(saldoAtual + valor, limite, numeroConta);
        }
    }

    @Override
    public Conta bonificacao() {
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContaCorrente that = (ContaCorrente) o;
        return Double.compare(that.saldoAtual, saldoAtual) == 0 &&
                Double.compare(that.limite, limite) == 0 &&
                numeroConta == that.numeroConta;
    }

    @Override
    public int hashCode() {

        return Objects.hash(saldoAtual, limite, numeroConta);
    }
}
