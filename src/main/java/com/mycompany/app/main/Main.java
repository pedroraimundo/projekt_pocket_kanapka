package com.mycompany.app.main;

import com.mycompany.app.banco.*;

public class Main
{
    public static void main(String... args)
    {
        Cliente cli = new Cliente("Kiber", "69696969696", TipoConta.Poupanca);

        cli = cli.deposita(300.50).saca(10.0);

        Relatorios.relatorio().informacoesCliente(cli);
    }
}
