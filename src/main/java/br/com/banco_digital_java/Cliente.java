package br.com.banco_digital_java;


import lombok.Data;

@Data 
public class Cliente {
    private String nome;
    private String cpf;
    
    public Cliente(String nome, String  cpf) {
    	this.nome = nome;
    	this.cpf = cpf;
    }
}