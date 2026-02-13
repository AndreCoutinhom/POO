package poo;

// Quando a classe é criada, os atributos dos objetos desta classe já são declarados:
public class Veiculo {
// Para cada atributo se determina o seu nível de visibilidade, seu tipo e então o nome:
    public String chassi;
    public String marca;
    public String modelo;
    public String placa;
    public int capacidadeTanque;
// Comportamentos entram sempre como void:
    public String acelerar() {
        String aceleracao = "O veiculo " + marca + " de modelo " + modelo + " está acelerando...";
        return aceleracao;
    }

    public String frear() {
        String freio = "O veiculo " + marca + " de modelo " + modelo + " está freando...";
        return freio;
    }

/*
// Usando essa primeira versão, duas funções acabam por fazer a mesma coisa. Ainda queremos que haja uma resposta quando não houver a quantidade de buzinas especificadas.
// Por isso na nova versão usamos o metodo já criado.
public void buzinar() {
        System.out.println("Bi bi!");
    }
*/

    // Na nova versão, o metodo criado depois e utilizado para nao precisar ser repetido.
    // Outra coisa é o desacoplamento. Aqui não temos mais o void e sim a String, porque a função retorna uma string, mas sem especificar onde aparecerá.
    // A classe retorna o valor, mas a decisão sobre ONDE será aplicada cabe ao objeto.
    public String buzinar() {
        return buzinar(2);
    }

    // Um comportamento com novos parâmetros já possui outra assinatura, mesmo que o nome seja idêntico.
    public String buzinar(int qtd) {
        String buzina = "";
        for(int i = 0; i < qtd; i++) {
            buzina += "Bi! ";
        }
        buzina += "\n";
        return buzina;
    }

}
