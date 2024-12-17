package br.com.banco_digital_java;

public class App {

    public static void main(String[] args) {
        Banco bancoBrasilInveste = new Banco();
        bancoBrasilInveste.setNome("Brasil Investe");
        
        
        Cliente klayverAlencar = new Cliente("Klayver Alencar", "123.456.789-11");
        Cliente michaeleGomes = new Cliente("Michaele Gomes","123.456.789-12");
        
      
        Conta ccKlayverAlencar = new ContaCorrente(klayverAlencar);
        ccKlayverAlencar.depositar(2000);
        ccKlayverAlencar.sacar(300);
        
        Conta cpKlayverAlencar = new ContaPoupanca(klayverAlencar);
        cpKlayverAlencar.depositar(1500);
        ((ContaPoupanca) cpKlayverAlencar).aplicarJuros();

        Conta ccMichaeleGomes = new ContaCorrente(michaeleGomes);
        ccMichaeleGomes.depositar(1500);
        ccMichaeleGomes.transferir(0, ccMichaeleGomes);
        
        Conta cpMichaeleGomes = new ContaPoupanca(michaeleGomes);
        cpMichaeleGomes.depositar(500);
        ((ContaPoupanca) cpMichaeleGomes).aplicarJuros();
        
        
        bancoBrasilInveste.adicionarConta(ccKlayverAlencar);
        bancoBrasilInveste.adicionarConta(cpKlayverAlencar);

        bancoBrasilInveste.adicionarConta(ccMichaeleGomes);
        bancoBrasilInveste.adicionarConta(cpMichaeleGomes);
        
        ccKlayverAlencar.transferir(500, cpKlayverAlencar);
        ccMichaeleGomes.transferir(1000, cpMichaeleGomes);
        ccKlayverAlencar.sacar(500);
        
        bancoBrasilInveste.imprimirRelatorioBanco();
        bancoBrasilInveste.imprimirRelatorioCliente("Klayver Alencar");
        bancoBrasilInveste.imprimirRelatorioCliente("Michaele Gomes");
    }
}
