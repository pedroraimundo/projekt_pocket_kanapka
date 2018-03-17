package com.mycompany.app.banco;

public interface Conta {

    Conta saca(double valor);

    Conta deposita(double valor);

    Conta bonificacao();

    TipoConta tipoConta();

}
