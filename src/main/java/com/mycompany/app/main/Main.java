package com.mycompany.app.main;

        import com.mycompany.app.banco.Cliente;
        import com.mycompany.app.banco.Relatorios;
        import com.mycompany.app.banco.TipoConta;

public class Main
{
    public static void main(String... args)
    {
        Cliente cli = new Cliente("Kiber", "69696969696", TipoConta.Poupanca);

        Relatorios.relatorio().informacoesCliente(cli);
    }
}
