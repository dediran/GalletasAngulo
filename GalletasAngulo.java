/*
   VERSION 0 CAR
   VERSION 1 RAM
*/
import java.util.Scanner;
public class GalletasAngulo{
   public static void main(String args[]){
      Scanner leer = new Scanner(System.in);
      int claves[] = new int[4];
      String nombres[] = new String[4];
      float precios[] = new float[4];
      char tamallos[] = new char[4];
      boolean stock[] = new boolean[4];
      int resp,cont = 1;
      char puntoBool;
      boolean indicador = true,espacio = true;
      
          
      do {
         System.out.println("INVENTARIO GALLETAS ANGULO");
         System.out.println("¿Qué es lo que desea hacer? [1-6]");
         System.out.println("[1] Registro de galletas");
         System.out.println("[2] Consultar un paquete de galletas");
         System.out.println("[3] Consultar todos los paquetes de galletas");
         System.out.println("[4] Modificar datos de los paquetes de galletas");
         System.out.println("[5] Eliminar datos de los paquetes de galletas");
         System.out.print("[6] Finalizar\n");
         resp = leer.nextInt();
      
         switch (resp){
            case 1:
                  if (cont-1 == claves.length){
                     espacio = false;   
                  }else {
                     espacio = true;
                  }
               if(espacio){
                  do{
                     System.out.printf("\nclave[%d]: ",cont-1);
                     claves[cont-1] = leer.nextInt();
                     if(claves[cont-1] >= 1 && claves[cont-1] <= 111){
                        indicador = false;
                     }
                  }while(indicador);
                  for(int i = 0; i<cont; i++){
                     if(cont == 1 && i == 0){
                        indicador = true;
                        break;
                     }
                     if(claves[cont-1] == claves[i]){
                        if(cont-1 == i){
                           break;
                        }
                        indicador = false;
                        claves[cont-1] = 0;              
                        break;
                     }else{
                        indicador = true;
                     }                
                  }
                  if(indicador){
                     leer.nextLine();
                     System.out.printf("nombre del paquete[%d]",cont-1);
                     nombres[cont-1] = leer.nextLine();
                     System.out.printf("precio del paquete[%d]",cont-1);
                     precios[cont-1] = leer.nextFloat();
                     System.out.printf("tamaño del paquete[%d]",cont-1);
                     tamallos[cont-1] = leer.next().charAt(0);
                     System.out.printf("hay disponibles en el almacen? [s = SI] , [n = NO]");
                     puntoBool = leer.next().charAt(0);
                     if(puntoBool == 's'|| puntoBool == 'S'){
                        stock[cont-1] = true;
                     }else if(puntoBool == 'n' || puntoBool == 'N'){
                        stock[cont-1] = false;
                     }
                  }else{
                     System.out.println("ESTA CLAVE ESTA REPETIDA\n");
                     cont--;
                  }
                  cont++;
               }else{
                  System.out.println("\nEL ESPACIO ESTA LLENO\n");
               }   
               break;
            case 2:
            
               break;
            case 3:
               for(int x = 0; x < 4; x++){
                  System.out.printf("clave[%d] = %d | nombre[%d] = %s  | precio[%d] = %.2f  | tamaño[%d] = %S   |  stock[%d] = %s\n", x, claves[x], x, nombres[x], x, precios[x], x, tamallos[x], x, stock[x]);
               }
               break;
            case 4:
            
               break;
            case 5:
            
               break;
            case 6:
               System.out.println("\nProgramadores:De La Cruz Cervantes Ramses\nRoman García Andrea Carolina");
               System.out.println("Fecha: 03/Diciembre/2022");
               break;
            default: System.out.println("\n!ERROR numero no valido\n");
         }
      }while (resp != 6);
   }
}