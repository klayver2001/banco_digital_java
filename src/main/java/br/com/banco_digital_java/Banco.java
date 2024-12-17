package br.com.banco_digital_java;

import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Banco {
    private List<Conta> contas = new ArrayList<>();
    private String nome;

    public void adicionarConta(Conta conta) {
        contas.add(conta);
    }

    public void imprimirRelatorioBanco() {
        System.out.println("=== Relatório do Banco: " + nome + " ===");
        for (Conta conta : contas) {
            conta.imprimirInfoConta();
            System.out.println("---------------------");
        }
    }

    public void imprimirRelatorioCliente(String nomeCliente) {
        System.out.println("=== Relatório do Cliente: " + nomeCliente + " ===");
        for (Conta conta : contas) {
            if (conta.getCliente().getNome().equalsIgnoreCase(nomeCliente)) {
                conta.imprimirInfoConta();
                conta.imprimirHistorico();
                System.out.println("---------------------");
            }
        }
    }
}