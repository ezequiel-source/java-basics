public class Carro{
 String marca = "Toyota";
 String modelo = "Prius";
 int velocidade = 0;
 int acelerar = 0;
 int freio = 0;
 boolean desligado = true;
 
 //ligar carro
 void ligarCarro(boolean ligar){
   desligado = !ligar;
 
 if (ligar){
   System.out.println("O carro foi ligado.");
 } else {
   System.out.println("O carro foi desligado.");
 }
} 
 
 void mudarVelocidade(int newValue){
   velocidade = newValue;
 }
 
 void acelerar(int newValue){
   //acelerar é acrescentar velocidade
   acelerar = velocidade++;
 }
 
 //frear a velocidade vai a 0
 //reduza a velocidade enquanto for maior que 0
 void frear(int newValue){
   do{
    velocidade--;
   }while(velocidade > 0);
 }

}
