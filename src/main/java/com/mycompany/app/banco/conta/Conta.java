package com.mycompany.app.banco.conta;

public interface Conta {

    Conta saca(double valor);

    Conta deposita(double valor);

    Conta bonificacao();

    TipoConta tipoConta();

    String toString();
}
