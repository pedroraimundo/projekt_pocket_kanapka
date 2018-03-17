package com.mycompany.app.banco;

import java.util.Objects;

public class ContaPoupanca implements Conta {

    private static final double JUROS = 0.05;
    public final double saldoAtual;
    public final double limite;
    public final int numeroConta;

    public ContaPoupanca(double saldoAtual, double limite, int numeroConta)
    {
        this.saldoAtual = saldoAtual;
        this.limite = limite;
        this.numeroConta = numeroConta;
    }

    public ContaPoupanca()
    {
        saldoAtual = 0.0;
        limite = 50;
        numeroConta = 0;
    }

    public ContaPoupanca withSaldoAtual(double saldoAtual)
    {
        return new ContaPoupanca(saldoAtual, limite, numeroConta);
    }

    public ContaPoupanca withLimite(double limite)
    {
        return new ContaPoupanca(saldoAtual, limite, numeroConta);
    }

    public ContaPoupanca withNumeroConta(int numeroConta)
    {
        return new ContaPoupanca(saldoAtual, limite, numeroConta);
    }


    @Override
    public Conta saca(double valor) {
        return null;
    }

    @Override
    public Conta deposita(double valor) {

        double newSaldoAtual = this.saldoAtual * 0.05;

        if ((valor < 0) || (valor == 0))
        {
            return this;
        }
        else
        {
            return new ContaPoupanca(newSaldoAtual + valor, limite, numeroConta);
        }
    }

    @Override
    public Conta bonificacao() {
        return new ContaPoupanca(saldoAtual+(saldoAtual * JUROS), limite, numeroConta);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContaPoupanca that = (ContaPoupanca) o;
        return Double.compare(that.saldoAtual, saldoAtual) == 0 &&
                Double.compare(that.limite, limite) == 0 &&
                numeroConta == that.numeroConta;
    }

    @Override
    public int hashCode() {

        return Objects.hash(saldoAtual, limite, numeroConta);
    }
}
