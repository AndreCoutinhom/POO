package br.senac.sp.poo.banco;

import java.util.Date;

public class TestaConta {
    public static void main(String[] args) {
        // Criando o cliente
        Cliente cliente1 = new Cliente();
        cliente1.nome = "Dom Pedro II";
        cliente1.cpf = "000.000.000-01";
        cliente1.rg = "00.000.000-1";
        cliente1.nacionalidade = "Português";
        cliente1.dataNascimento = new Date(1825-1900,11,2);

        // Criando a conta aproveitando os construtores criados na classe Conta.

        Conta conta1 = new Conta("0123-4", "6789-0", cliente1);


        // Testar um depósito
        conta1.depositar(500);

        // Testar um saque
        conta1.sacar(50);

        // Exibir o resumo
        System.out.println(conta1.resumo());

    }
}
