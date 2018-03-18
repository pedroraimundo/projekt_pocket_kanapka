package com.mycompany.app.banco.conta;

import com.mycompany.app.banco.conta.transacao.TipoTransacao;
import com.mycompany.app.banco.conta.transacao.Transacao;

import java.util.Arrays;
import java.util.Objects;

public class ContaCorrente implements Conta {

    public final double saldoAtual;
    public final double limite;
    public final int numeroConta;
    public  Transacao[] transacoes;
    private int counter;
    private int trxsize;
    private static final int TRXBUFFERSIZE = 100;

    private ContaCorrente(double saldoAtual, double limite, int numeroConta, Transacao[] transacoes, int counter, int trxsize)
    {
        this.saldoAtual = saldoAtual;
        this.limite = limite;
        this.numeroConta = numeroConta;
        this.transacoes = transacoes;
        this.counter = counter;
        this.trxsize = trxsize;
    }

    public ContaCorrente()
    {
        this(5.0, 50, 0, new Transacao[TRXBUFFERSIZE], 0 , 100);
    }

    public ContaCorrente withSaldoAtual(double saldoAtual)
    {
        return new ContaCorrente(saldoAtual, limite, numeroConta, transacoes, counter, trxsize);
    }

    public ContaCorrente withLimite(double limite)
    {
        return new ContaCorrente(saldoAtual, limite, numeroConta, transacoes, counter, trxsize);
    }

    public ContaCorrente withNumeroConta(int numeroConta)
    {
        return new ContaCorrente(saldoAtual, limite, numeroConta, transacoes, counter, trxsize);
    }

    public ContaCorrente withTransacoes(Transacao[] transacoes)
    {
        return new ContaCorrente(saldoAtual, limite, numeroConta, transacoes, counter, trxsize);
    }

    public ContaCorrente withCounter(int counter)
    {
        return new ContaCorrente(saldoAtual, limite, numeroConta, transacoes, counter, trxsize);
    }

    public ContaCorrente withTrxsize(int trxsize)
    {
        return new ContaCorrente(saldoAtual, limite, numeroConta, transacoes, counter, trxsize);
    }

    public Conta addTransacao(Transacao trx)
    {
        if(counter < trxsize)
        {
            transacoes[counter] = trx;
            counter++;
            return this.withTransacoes(transacoes).withCounter(counter + 1);
        }
        else
        {
            trxsize += TRXBUFFERSIZE;
            Transacao[] transacoesPlus = new Transacao[trxsize];
            for (int i = 0; i > transacoes.length; i++)
            {
                transacoesPlus[i] = transacoes[i];
            }
            transacoes = transacoesPlus;
            transacoes[counter] = trx;
            return this.withTransacoes(transacoes).withCounter(counter + 1).withTrxsize(trxsize);
        }
    }

    @Override
    public Conta saca(double valor)
    {
        if (this.saldoAtual < valor)
        {
            return this.addTransacao(new Transacao(valor, TipoTransacao.Saque));
        }
        else
        {
            return this.withSaldoAtual(saldoAtual - valor)
                    .addTransacao(new Transacao(valor, TipoTransacao.Saque));
        }
    }

    @Override
    public Conta deposita(double valor)
    {
        if ((valor < 0) || (valor == 0))
        {
            return this.addTransacao(new Transacao(valor, TipoTransacao.Deposito));
        }
        else
        {
            return this.withSaldoAtual(saldoAtual + valor)
                    .addTransacao(new Transacao(valor, TipoTransacao.Deposito));
        }
    }

    @Override
    public Conta bonificacao() {
        return this;
    }

    @Override
    public TipoConta tipoConta() {
        return TipoConta.Corrente;
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

    @Override
    public String toString() {
        return "ContaCorrente{" +
                "saldoAtual=" + saldoAtual +
                ", limite=" + limite +
                ", numeroConta=" + numeroConta +
                ", transacoes=" + Arrays.toString(transacoes) +
                ", counter=" + counter +
                ", trxsize=" + trxsize +
                '}';
    }
}
