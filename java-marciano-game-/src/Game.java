import java.util.Scanner;
import java.util.Random;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Game {
  public static void main(String[] args) {
    clear();
    Date dataHoraAtual = new Date();
    
    Random rand = new Random();
    Scanner ler = new Scanner(System.in);

    String data = new SimpleDateFormat("dd/MM/yyyy").format(dataHoraAtual);
    String hora = new SimpleDateFormat("HH:mm:ss").format(dataHoraAtual);

    int tree = rand.nextInt(101);

    boolean loop = false;

    int vida = 7;

    int tent = 0;

    try {
      while(!loop) {
        if(tent < vida) {
          if(tent == 0){
            System.out.println("O marciano fugiu do seu planeta natal e se escondeu atrás de uma árvore, é sua missão achar ele! Ou a Terra vai explodir!");
          }
          System.out.println("Você tem " + (vida - tent) + " tentativas!");
          System.out.print("Digite um valor: ");
          int chute = ler.nextInt();
          tent += 1;
          clear();
          if(chute == tree) {
            if(tent == 1) {
              System.out.println("Parabéns, você achou ele com " + tent + " tentativa!");
              System.out.println("TerraSalva("+ data+ " às " +hora+");");
            } else {
              System.out.println("Parabéns, você achou ele com " + tent + " tentativas!");
              System.out.println("TerraSalva("+ data+ " às " +hora+");");
            }
            loop = true;
          }
          if(chute < tree){
            System.out.println("O marciano está em uma árvore de valor maior");
          }
          if(chute > tree){
            System.out.println("O marciano está em uma árvore de valor menor");
          }
          
        }else {
          clear();
          tent = 0;
          System.out.println("Você fracassou!");
          System.out.println("O marciano estava na árvore: " + tree);
          System.out.println("TerraExplode();");
          System.out.println("TerraReinicia("+ data+ " às " +hora+");");
          System.out.println("");
          tree = rand.nextInt(101);
          loop = false;
        }
      }
    } catch (Exception e) {
      System.err.println("Erro, por favor digite um número inteiro! " + e);
    }
  }
  public final static void clear() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }
}
