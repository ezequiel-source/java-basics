 //Documentação para a classe chuveiro
 /**
 * Estado: ligado, desligado
 * Comportamento: morno, quente, frio (métodos)
 */

public class Chuveiro{
 
 //Variáveis de instância da classe Chuveiro
 boolean desligado = true;
 //Aqui a variável para indicar temperatura
 int temperatura = 0;

 void chuveiroLigado(boolean ligar){
  desligado = !ligar;

 if (ligar) {
    System.out.println("O chuveiro foi ligado.");
  } else {
    System.out.println("O chuveiro foi desligado");
   }
 }

 //Aumentar temperatura para morno
 void aumentar(int quanto) {
  if(!desligado) {
    if(temperatura + quanto > 0) {
      temperatura = temperatura + quanto;
      System.out.println("Temperatura aumentada para: " + temperatura);
   } else {
     System.out.println("Não é possível aumentar a temperatura. O chuveiro esta desligado");
     }
   }
  }

 void diminuir(int quanto) {
  if(!desligado) {
   if(temperatura - quanto <= 0) {
      temperatura =  temperatura - quanto;
      System.out.println("Temperatura diminuida para: " + temperatura);
   } else {
     temperatura = 0;
     System.out.println("O chuveiro esta frio " + temperatura);
     }
   }
 }

/**
* Imprime o estado atual do chuveiro
 */
 void printStates() {
   System.out.println("--- Estado Atual do Chuveiro ---");
   System.out.println("Chuveiro ligado: " + !desligado);
   System.out.println("------------------------------");
  }


//Método main para testar a classe chuveiro
 public static void main(String[] args){
  Chuveiro meuChuveiro = new Chuveiro();

  meuChuveiro.printStates();

  meuChuveiro.chuveiroLigado(true);
  meuChuveiro.aumentar(30);
  meuChuveiro.aumentar(5);
  meuChuveiro.printStates();

  meuChuveiro.diminuir(10);
  meuChuveiro.printStates();

  meuChuveiro.chuveiroLigado(false);
  meuChuveiro.aumentar(15);
  meuChuveiro.printStates();
 
  }
}
