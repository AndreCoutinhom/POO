package br.senac.sp.poo.banco;

public class Conta {
    private double saldo;
    public Cliente titular; // Quando um atributo puder ter muitos dados, é sábio criar outra classe para que possa ser chamada.
    public String numAgencia;
    public String numero;
    public Cliente dependente;

    // Utilizando o método construtor:
    // O método construtor inicializa objetos antes de serem efetivamente utilizados. O java geralmente faz isso por padrão de forma automática, mas é um bom costume para que se tenha controle sobre a atividade dos objetos, e impedir alguns bugs básicos.
    // Abaixo, por exemplo, os parâmetros são predispostos para que ao se chamar um objeto, seus atributos sejam declarados em menos linhas de código.

    public Conta (String numAgencia, String numero) {
        this.numAgencia = numAgencia;
        this.numero = numero;
    }

    public Conta (String numAgencia, String numero, Cliente titular) {
        this(numAgencia, numero); // Invocando o construtor de uma outra classe.
        this.titular = titular;
    }

    public Conta(Cliente titular) {
        this.titular = titular; // O 'this' serve para que a atribuição reconheça o atributo de dentro da própria classe.
    }

    public Conta() {}

    /**
     * A função de depósito aumenta o saldo de acordo com o valor declarado.
     * @param valor A quantidade que se deseja depositar.
     */

    public void depositar(double valor) {
        saldo += valor;
    }

    /**
     * Aqui verificamos se o saldo é disponível para se realizar qualquer retirada (saque ou transferência).
     * @param valor A quantidade que se deseja retirar.
     * @return Verdadeiro se o saldo for maior do que o valor.
     */

    private boolean verificaSaldo(double valor) {
        return saldo >= valor;
    }

    /**
     * Aqui usamos a função de verificação de saldo antes de conseguir, efetivamente, realizar um saque. O saque diminui o saldo de acordo com o valor declarado.
     * @param valor A quantidade sacada.
     * @return Verdadeiro se for possível sacar e falso se não.
     */

    public boolean sacar(double valor) {
        if (verificaSaldo(valor)) {
            saldo -= valor;
            return true;
        }
        return false;

    }

    /**
     * As funções de verificação, depósito e saque são combinadas para fazer uma transferência de valor de uma conta para a outra.
     * @param valor O valor que se deseja transferir.
     * @param destino A conta para qual se destina o depósito.
     */


    public void transferir(double valor, Conta destino) {
        if (sacar(valor)) {
            destino.depositar(valor);
        }
    }

    /**
     * Aqui geramos um resumo de todo o estado da conta bancária de um cliente.
     * @return Uma string com todos os dados concatenados.
     */

    public String resumo() {
        return String.format("Ag:%s%nNum:%s%n%nTitular:%n%s%nSaldo:R$ %6.2f",
                numAgencia,numero,titular.resumoCliente(),saldo);

    }

}
