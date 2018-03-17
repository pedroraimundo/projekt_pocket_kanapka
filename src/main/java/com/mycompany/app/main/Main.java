package com.mycompany.app.main;

import com.mycompany.app.banco.ContaCorrente;

import java.util.Optional;

public class Main
{
    public static void main(String... args)
    {
        ContaCorrente c = new ContaCorrente().withNumeroConta(1).withSaldoAtual(300).saca(10);
    }

    public static Optional<Double> div(double a, double b)
    {
        if (b == 0)
        {
            return Optional.empty();
        }
        else
        {
            return Optional.of(a/b);
        }
    }
}