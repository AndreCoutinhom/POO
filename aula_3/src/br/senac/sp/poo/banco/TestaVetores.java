package br.senac.sp.poo.banco;

import jdk.jshell.spi.ExecutionControl;

import java.util.Date;

public class TestaVetores {
    public static void main(String[] args) {
        Conta[] conta = new Conta[10]; // Aqui são criados 10 espaços para contas, mas ainda não existem contas.
        criarContas(conta);
        exibirContas(conta);
    }

    public static void criarContas(Conta[] contas) {
        for (int i = 0; i < contas.length; i++) {
            contas[i] = new Conta(null, null, new Cliente());
        }
    }

    public static void exibirContas(Conta[] contas) {
        // O laço for reduzido é usado exclusivamente para exibição. Ele não é capaz de alterar nenhum dado do objeto, apenas apenas exibir referências.
        // Essa é a principal diferença de usar um for reduzido (for each) de usar o modelo tradicional usado acima.
        for (Conta c : contas) {
            if (c != null) {
                // Verificar se é nulo para criar e não sobrepor outros da array.
                if (c.titular() == null) {
                    // Criar um titular dentro da conta
                    c.trocarTitular(new Cliente());
                    c.titular().dataNascimento = new Date();
                }

                System.out.println(c.resumo());
            } else {
                System.out.println(c);
            }
        }
    }

}
