package br.com.banco_digital_java;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContaPoupanca extends Conta {

    private static final double TAXA_JUROS = 0.005; // 0.5% ao mês

    public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }

    public void aplicarJuros() {
        double juros = saldoatual * TAXA_JUROS;
        saldoatual += juros;
        System.out.println(String.format("Juros aplicados: %.2f", juros));
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato Conta Poupança ===");
        super.imprimirInfoConta();
    }
}