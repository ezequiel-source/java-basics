public class Carro {
    public static void main(String[] args) {
        // Cria uma instância da classe externa Motor
        Motor meuMotor = new Motor("V8", 500);

        // Chama o método ligar, que por sua vez, usa a classe interna Embreagem
        meuMotor.ligar();
    }
}
