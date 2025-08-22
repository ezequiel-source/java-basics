public class Motor {
    // Atributos privados da classe externa Motor
    private String tipoMotor;
    private int potenciaCavalos;

    // Construtor do Motor
    public Motor(String tipoMotor, int potenciaCavalos) {
        this.tipoMotor = tipoMotor;
        this.potenciaCavalos = potenciaCavalos;
        System.out.println("Motor " + this.tipoMotor + " criado com " + this.potenciaCavalos + " cv.");
    }

    // Método para ligar o motor e a embreagem
    public void ligar() {
        System.out.println("Motor ligado.");
        // Cria uma instância da classe interna Embreagem
        Embreagem embreagem = new Embreagem();
        embreagem.engatarMarcha();
    }

    // Classe interna Embreagem
    // Observe que ela pode ser privada, se você não precisar acessá-la de fora da classe Motor
    private class Embreagem {
        // Atributos privados da classe interna Embreagem
        private String tipoEmbreagem = "Monodisco a seco";
        private int discoEmbreagem = 1;

        // Construtor da Embreagem (não é necessário, mas é bom para ilustrar)
        public Embreagem() {
            System.out.println("Embreagem criada: " + this.tipoEmbreagem + " com " + this.discoEmbreagem + " disco(s).");
            // Acesso a um atributo da classe externa (Motor)
            System.out.println("A embreagem está acoplada a um motor de " + potenciaCavalos + " cv.");
        }

        // Método da Embreagem
        public void engatarMarcha() {
            System.out.println("Embreagem acionada para engatar a marcha.");
        }
    }
}
