/*
   VERSION 0
*/
import java.util.Scanner;
public class GalletasAngulo{
   public static void main(String args[]){
      Scanner leer = new Scanner(System.in);
      final int TAM_ARREGLO = 3;
      int claves[]= new int[TAM_ARREGLO];
      String nombres[]= new String[TAM_ARREGLO];
      String sabores[]= new String[TAM_ARREGLO];
      float precios[]= new float[TAM_ARREGLO];
      int cantidades[]= new int[TAM_ARREGLO];
      int resp, cont=0, clave;
      boolean existe;
      
           
      //inicio do-while
      do {
          //Men�
      System.out.println("INVENTARIO GALLETAS ANGULO");
      System.out.print("�Qu� es lo que desea hacer? [1-6]");
      System.out.println("[1] Registro de galletas");
      System.out.println("[2] Consultar un tipo de galleta");
      System.out.println("[3] Consultar todas las galletas");
      System.out.println("[4] Modificar datos de galletas");
      System.out.println("[5] Eliminar datos de galletas");
      System.out.println("[6] Finalizar");
      System.out.print("�Que desea hacer? [1-6]");
      resp = leer.nextInt();
      
      switch (resp) {
         case 1:
           if(cont < TAM_ARREGLO) {
            System.out.println("\nREGISTRO DE GALLETAS ANGULO");
            System.out.println("Ingrese la clave de la galletas");
            clave = leer.nextInt();
            if (clave >=1 && clave <=111) {
               //buscar clave repetida
               existe = false;
               for(int x=0; x<cont; x++) {
                  if(clave ==claves[x]) {
                  existe =true;
                  break;
                     
                  }
               }
               //altas
               if(existe==false){
                  claves[cont]= clave;
                  leer.nextLine();
                  System.out.println("Nombre: ");
                  nombres[cont]=leer.nextLine();
                  System.out.println("Sabor: ");
                  sabores[cont]=leer.nextLine();
                  System.out.println("Precio: $");
                  precios[cont]=leer.nextFloat();
                  System.out.println("Cantidad de galletas: ");
                  cantidades[cont]=leer.nextInt();
                  cont++;
               }else{
                  System.out.println("\nLa clave:["+ clave +"] ya fue utilizada");
               }
            }else {
               System.out.println("\nLa clave no es valida");
            }
           } else {
            System.out.println("NO HAY ESPACIO DISPONIBLE");
           }
            break;
         case 2:
         
            break;
         case 3:
         
            break;
         case 4:
         
            break;
         case 5:
         
            break;
         case 6:
            System.out.println("PROGRAMADORES: Andrea Carolina Roman Garc�a && Ramses De La Cruz Cervantes");
            System.out.println("Fecha: 29/11/2022");
            break;
         default:
            System.out.println("La opcion no es valida");
      }
      } while (resp != 6);
   }
}      