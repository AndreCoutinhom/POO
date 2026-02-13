package poo;

// Já essa classe é criada para que os objetos sejam instanciados.
// A nova classe é determinada como um verbo referente à classe:
public class UsaVeiculo {
    public static void main(String[] args) {
        // criando um veículo
        Veiculo v1 = new Veiculo();
        // Os parâmetros determinam os atributos do veículo criado
        v1.marca = "Ford";
        v1.modelo = "Ranger";
        v1.chassi = "1AB23C4DE";
        v1.placa = "ABC-1234";
        v1.capacidadeTanque = 50;

        Veiculo v2 = new Veiculo();
        v2.marca = "VW";
        v2.modelo = "Up";

        // Seus comportamentos são declarados:
        System.out.println(v1.acelerar());
        System.out.println(v2.frear());

        // O objeto decide onde o metodo será apresentado, e não fica preso a o que a classe determina. Isso é desacoplamento.
        System.out.println(v1.buzinar(7));
    }
}
