package br.com.banco_digital_java;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContaCorrente extends Conta {

    private double limiteCredito = 500.00; // Limite padrão

    public ContaCorrente(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void sacar(double valor) {
        if (saldoatual + limiteCredito >= valor) {
            saldoatual -= valor;
        } else {
            System.out.println("Saldo insuficiente!");
        }
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato Conta Corrente ===");
        super.imprimirInfoConta();
        System.out.println(String.format("Limite de Crédito: %.2f", limiteCredito));
    }
}