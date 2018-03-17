package com.mycompany.app.banco;

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

        System.out.println("NUMERO CONTA:\n");
        if(cliente.conta.tipoConta() == TipoConta.Corrente)
        {
            ContaCorrente cc = (ContaCorrente) cliente.conta;
            System.out.println(cc.numeroConta);
        }
        else
        {
            ContaPoupanca cp = (ContaPoupanca) cliente.conta;
            System.out.println(cp.numeroConta);
        }
    }
}
