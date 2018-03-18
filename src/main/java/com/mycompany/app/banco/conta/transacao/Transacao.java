package com.mycompany.app.banco.conta.transacao;

import java.util.Date;
import java.util.Objects;

public class Transacao
{
    public final double valor;
    public final TipoTransacao opTransacao;
    public final Date trxDate;

    public Transacao(double valor, TipoTransacao opTransacao, Date trxDate)
    {
        this.valor = valor;
        this.opTransacao = opTransacao;
        this.trxDate = trxDate;
    }

    public Transacao(double valor, TipoTransacao opTransacao)
    {
        this(valor, opTransacao, new Date());
    }

    public Transacao withValor(double valor)
    {
        return new Transacao(valor, opTransacao, trxDate);
    }

    public Transacao withTipoTransacao(TipoTransacao opTransacao)
    {
        return new Transacao(valor, opTransacao, trxDate);
    }

    public Transacao withDate(Date trxDate)
    {
        return new Transacao(valor, opTransacao, trxDate);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transacao transacao = (Transacao) o;
        return Double.compare(transacao.valor, valor) == 0 &&
                opTransacao == transacao.opTransacao &&
                Objects.equals(trxDate, transacao.trxDate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(valor, opTransacao, trxDate);
    }

    @Override
    public String toString() {
        return "Transacao{" +
                "valor=" + valor +
                ", opTransacao=" + opTransacao +
                ", trxDate=" + trxDate +
                '}';
    }
}
