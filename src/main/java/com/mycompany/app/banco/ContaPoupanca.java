package com.mycompany.app.banco;

import org.omg.CORBA.TRANSACTION_MODE;

import java.util.Date;
import java.util.Objects;

public class ContaPoupanca implements Conta {

    private static final double JUROS = 0.05;
    public final double saldoAtual;
    public final double limite;
    public final int numeroConta;
    public  Transacao[] transacoes;
    private int counter;
    private int trxsize;
    private static final int TRXBUFFERSIZE = 100;

    private ContaPoupanca(double saldoAtual, double limite, int numeroConta, Transacao[] transacoes, int counter, int trxsize) {
        this.saldoAtual = saldoAtual;
        this.limite = limite;
        this.numeroConta = numeroConta;
        this.transacoes = transacoes;
        this.counter = counter;
        this.trxsize = trxsize;
    }

    public ContaPoupanca()
    {
        this(10.0, 50, 0, new Transacao[TRXBUFFERSIZE], 0, 100);
    }

    public ContaPoupanca withSaldoAtual(double saldoAtual) {
        return new ContaPoupanca(saldoAtual, limite, numeroConta, transacoes, counter, trxsize);
    }

    public ContaPoupanca withLimite(double limite) {
        return new ContaPoupanca(saldoAtual, limite, numeroConta, transacoes, counter, trxsize);
    }

    public ContaPoupanca withNumeroConta(int numeroConta) {
        return new ContaPoupanca(saldoAtual, limite, numeroConta, transacoes, counter, trxsize);
    }

    public ContaPoupanca withTrancacoes(Transacao[] transacoes) {
        return new ContaPoupanca(saldoAtual, limite, numeroConta, transacoes, counter, trxsize);
    }

    public ContaPoupanca withCounter(int counter) {
        return new ContaPoupanca(saldoAtual, limite, numeroConta, transacoes, counter, trxsize);
    }

    public ContaPoupanca withTrxsize(int trxsize) {
        return new ContaPoupanca(saldoAtual, limite, numeroConta, transacoes, counter, trxsize);
    }

    @Override
    public Conta saca(double valor)
    {
        if(valor <= 0)
        {
            return addTransacao(new Transacao(valor, TipoTransacao.Saque));
        }
        else
        {
            return  withSaldoAtual(saldoAtual - valor).addTransacao(new Transacao(valor, TipoTransacao.Saque));
        }
    }

    @Override
    public Conta deposita(double valor) {

        if ((valor < 0) || (valor == 0))
        {
            return addTransacao(new Transacao(valor, TipoTransacao.Deposito));
        }
        else
        {
            ContaPoupanca cp = bonificacao();
            return withSaldoAtual(cp.saldoAtual + valor).addTransacao(new Transacao(valor, TipoTransacao.Deposito));
        }
    }

    public Conta addTransacao(Transacao trx)
    {
        if(counter < trxsize)
        {
            transacoes[counter] = trx;
            return withTrancacoes(transacoes).withCounter(counter + 1);
        }
        else
        {
            trxsize += TRXBUFFERSIZE;
            Transacao[] trxPlus = new Transacao[trxsize];

            for(int i = 0; i < transacoes.length; i++)
            {
                trxPlus[i] = transacoes[i];
            }
            transacoes = trxPlus;
            transacoes[counter] = trx;
            return withTrancacoes(transacoes).withCounter(counter + 1).withTrxsize(trxsize);
        }
    }

    @Override
    public ContaPoupanca bonificacao() {
        return withSaldoAtual(saldoAtual + (saldoAtual * JUROS));
    }

    @Override
    public TipoConta tipoConta() {
        return TipoConta.Poupanca;
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

    @Override
    public String toString() {
        return "ContaPoupanca{" +
                "saldoAtual=" + saldoAtual +
                ", limite=" + limite +
                ", numeroConta=" + numeroConta +
                '}';
    }
}
