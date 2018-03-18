package com.mycompany.app.banco.relatorios;

import com.mycompany.app.banco.cliente.Cliente;
import com.mycompany.app.banco.conta.Conta;
import com.mycompany.app.banco.conta.ContaCorrente;
import com.mycompany.app.banco.conta.ContaPoupanca;
import com.mycompany.app.banco.conta.TipoConta;
import com.mycompany.app.banco.conta.transacao.Transacao;

public class Relatorios
{
    private static Relatorios _relatorio = null;

    public static Relatorios relatorio()
    {
        if (_relatorio == null)
        {
            _relatorio = new Relatorios();
        }

        return _relatorio;
    }

    private Relatorios()
    {
    }

    public void informacoesCliente(Cliente cliente)
    {
        System.out.println("NOME:\n");
        System.out.println(cliente.nome);

        System.out.println("CPF:\n");
        System.out.println(cliente.cpf);

        System.out.println("TIPO CONTA:\n");
        System.out.println(cliente.conta.tipoConta());

        informacoesConta(cliente.conta);
    }

    public void informacoesConta(Conta conta)
    {
        System.out.println("NUMERO CONTA:\n");
        if(conta.tipoConta() == TipoConta.Corrente)
        {
            ContaCorrente cc = (ContaCorrente) conta;
            System.out.println(cc.numeroConta);

            System.out.println("LIMITE:\n");
            System.out.println(cc.limite);

            System.out.println("SALDO ATUAL:\n");
            System.out.println(cc.saldoAtual);

            historico(cc.transacoes);
        }
        else
        {
            ContaPoupanca cp = (ContaPoupanca) conta;
            System.out.println(cp.numeroConta);

            System.out.println("LIMITE:\n");
            System.out.println(cp.limite);

            System.out.println("SALDO ATUAL:\n");
            System.out.println(cp.saldoAtual);

            historico(cp.transacoes);
        }
    }

    public void historico(Transacao[] transacoes)
    {
        for(Transacao trx : transacoes)
        {
            if (trx != null)
            {
                System.out.println(trx);
            }
        }
    }
}
