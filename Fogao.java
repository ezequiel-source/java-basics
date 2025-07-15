// Documentação da Classe Fogao
/**
 * A classe Fogao representa um fogão simples com estado de ligado/desligado e temperatura,
 * focando em conceitos básicos sem o uso explícito do operador 'this'.
 */
public class Fogao {

    // Variáveis de instância (atributos) da classe Fogao
    boolean desligado = true; // Indica se o fogão está desligado (true = desligado, false = ligado)
    String marca = "Brastemp"; // A marca do fogão
    int temperatura = 0;       // A temperatura atual do fogão. Essa é a variável que queremos alterar.

    /**
     * Liga ou desliga o fogão.
     * @param ligar Um valor booleano: true para ligar, false para desligar.
     */
    void fogaoLigado(boolean ligar) {
        // Se 'ligar' é true, 'desligado' se torna false (fogão ligado).
        // Se 'ligar' é false, 'desligado' se torna true (fogão desligado).
        desligado = !ligar;

        if (ligar) {
            System.out.println("O fogão foi ligado.");
        } else {
            System.out.println("O fogão foi desligado.");
        }
    }

    /**
     * Aumenta a temperatura do fogão.
     * @param quanto O valor em que a temperatura será aumentada.
     */
    void aumentar(int quanto) {
        if (!desligado) { // Só aumenta a temperatura se o fogão estiver ligado
            temperatura = temperatura + quanto; // Adiciona 'quanto' à variável de instância 'temperatura'
            System.out.println("Temperatura aumentada para: " + temperatura);
        } else {
            System.out.println("Não é possível aumentar a temperatura. O fogão está desligado.");
        }
    }

    /**
     * Diminui a temperatura do fogão.
     * @param quanto O valor em que a temperatura será diminuída.
     */
    void diminuir(int quanto) {
        if (!desligado) { // Só diminui a temperatura se o fogão estiver ligado
            if (temperatura - quanto >= 0) { // Garante que a temperatura não seja menor que zero
                temperatura = temperatura - quanto; // Subtrai 'quanto' da variável de instância 'temperatura'
                System.out.println("Temperatura diminuída para: " + temperatura);
            } else {
                temperatura = 0; // Define a temperatura para 0 se a diminuição a deixaria negativa
                System.out.println("Temperatura foi definida para 0. Não pode ser negativa.");
            }
        } else {
            System.out.println("Não é possível diminuir a temperatura. O fogão está desligado.");
        }
    }

    /**
     * Imprime o estado atual do fogão.
     */
    void printStates() {
        System.out.println("--- Estado Atual do Fogão ---");
        System.out.println("Marca: " + marca);
        // Exibe o estado de ligado (true para ligado, false para desligado)
        System.out.println("Fogão ligado: " + !desligado);
        System.out.println("Temperatura: " + temperatura);
        System.out.println("-----------------------------");
    }

    // Método principal (main) para testar a classe Fogao
    public static void main(String[] args) {
        Fogao meuFogao = new Fogao(); // Cria um novo objeto Fogao

        meuFogao.printStates(); // Estado inicial

        meuFogao.fogaoLigado(true); // Liga o fogão
        meuFogao.aumentar(50);      // Aumenta a temperatura em 50
        meuFogao.aumentar(20);      // Aumenta a temperatura em 20 novamente
        meuFogao.printStates();     // Verifica o estado após aumentar

        meuFogao.diminuir(30);      // Diminui a temperatura em 30
        meuFogao.printStates();     // Verifica o estado após diminuir

        meuFogao.fogaoLigado(false); // Desliga o fogão
        meuFogao.aumentar(10);       // Tenta aumentar a temperatura com o fogão desligado
        meuFogao.printStates();      // Verifica o estado final
    }
}
