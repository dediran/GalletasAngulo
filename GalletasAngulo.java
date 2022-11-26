/*
   VERSION 0
*/
import java.util.Scanner;
public class GalletasAngulo{
   public static void main(String args[]){
      Scanner leer = new Scanner(System.in);
      int resp;
      
           
      //inicio do-while
      do {
          //Menú
      System.out.println("INVENTARIO GALLETAS ANGULO");
      System.out.print("¿Qué es lo que desea hacer? [1-6]");
      System.out.println("[1] Registro de galletas");
      System.out.println("[2] Consultar tipo de galleta");
      System.out.println("[3] Consultar todas las galletas");
      System.out.println("[4] Modificar datos de galletas");
      System.out.println("[5] Eliminar datos de galletas");
      System.out.println("[6] Finalizar");
      resp = leer.nextInt();

         
         switch (resp){
            case1:
            
               break;
            case2:
            
               break;
            case3:
            
               break;
            case4:
            
               break;
            case5:
            
               break;
            case6:
               System.out.println("Programadores:De La Cruz Cervantes Ramses & Roman García Andrea Carolina");
               System.out.println("Fecha: 03/Diciembre/2022");
               break;
            default: System.out.println("!ERROR numero no valido");
         }
      } while (resp!=6);
   }
}