package br.com.banco_digital_java;


import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public abstract class Conta implements IConta {

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int idAgencia;
    protected int idNumeroConta;
    protected double saldoatual = 0.00;
    protected Cliente cliente;

    private List<String> historicoTransacoes = new ArrayList<>();

    public Conta(Cliente cliente) {
        this.idAgencia = AGENCIA_PADRAO;
        this.idNumeroConta = SEQUENCIAL++;
        this.cliente = cliente;
    }

    @Override
    public void sacar(double valor) {
        saldoatual -= valor;
        registrarTransacao(String.format("Saque: -%.2f", valor));
    }

    @Override
    public void depositar(double valor) {
        saldoatual += valor;
        registrarTransacao(String.format("Depósito: +%.2f", valor));
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
        registrarTransacao(String.format("Transferência para conta %d: -%.2f", contaDestino.idNumeroConta, valor));
    }

    protected void registrarTransacao(String descricao) {
        historicoTransacoes.add(descricao);
    }

    public void imprimirHistorico() {
        System.out.println("=== Histórico de Transações ===");
        for (String transacao : historicoTransacoes) {
            System.out.println(transacao);
        }
    }

    protected void imprimirInfoConta() {
        System.out.println(String.format("Titular: %s", cliente.getNome()));
        System.out.println(String.format("CPF: %s", cliente.getCpf()));
        System.out.println(String.format("Agencia: %d", idAgencia));
        System.out.println(String.format("Conta: %d", idNumeroConta));
        System.out.println(String.format("Saldo: %.2f", saldoatual));
    }
}
