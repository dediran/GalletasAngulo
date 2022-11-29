/*
   VERSION 0 CAR
   VERSION 1 RAM
   VERSION 2 RAM
   VERSION 3 CAR
*/
import java.util.Scanner;
public class GalletasAngulo{
   public static void main(String args[]){
      Scanner leer = new Scanner(System.in);
      int claves[] = new int[100], auxCl, clave;
      String nombres[] = new String[100], auxNom;
      float precios[] = new float[100], auxPres;
      char tamallos[] = new char[100], auxTam;
      boolean stock[] = new boolean[100], auxStock;
      int resp,cont = 1,contG = 0,flag = 0;
      char puntoBool, seguro;
      boolean indicador = true,indBorra = true,espacio = true, tamInd = true, confirm = true;
      
          
      do {
         System.out.println("\nINVENTARIO GALLETAS ANGULO");
         System.out.println("¿Qué es lo que desea hacer? [1-6]");
         System.out.println("[1] Registro de galletas");
         System.out.println("[2] Consultar un paquete de galletas");
         System.out.println("[3] Consultar todos los paquetes de galletas");
         System.out.println("[4] Modificar datos de los paquetes de galletas");
         System.out.println("[5] Eliminar datos de los paquetes de galletas");
         System.out.print("[6] Finalizar\n");
         resp = leer.nextInt();
      
         switch (resp){
            case 1://altas
               if (cont-1 == claves.length){
                  espacio = false;   
               }else {
                  espacio = true;
               }
               if(espacio){
                  do{
                     System.out.print("\nclave: ");
                     claves[cont-1] = leer.nextInt();
                     if(claves[cont-1] >= 1 && claves[cont-1] <= 111){
                        indicador = false;
                     }else{
                        indicador = true;
                        System.out.println("---------------------------------------------------");
                        System.out.println("El rango de las claves debe estar entre [1 a 111]");
                        System.out.print("---------------------------------------------------");
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
                     System.out.printf("           PAQUETE %d         \n",cont);
                     leer.nextLine();
                     System.out.printf("Nombre del Paquete de galletas");
                     nombres[cont-1] = leer.nextLine();
                     System.out.printf("Precio del paquete de galletas");
                     precios[cont-1] = leer.nextFloat();
                     do{
                        System.out.printf("tamaño del paquete [P = pequeño] [M = mediano] [G = grande]");
                        tamallos[cont-1] = leer.next().charAt(0);
                        if(tamallos[cont-1] == 'P' || tamallos[cont-1] == 'p' || tamallos[cont-1] == 'm' || tamallos[cont-1] == 'M' || tamallos[cont-1] == 'g' || tamallos[cont-1] == 'G'){
                           tamInd = false;
                        }else {
                           tamInd = true;
                           System.out.println("---------------------------------------------------");
                           System.out.println("Valor no aceptado Intente de nuevo");
                           System.out.println("---------------------------------------------------");
                        }
                     }while(tamInd);   
                     System.out.printf("hay disponibles en el almacen? [s = SI] , [n = NO]");
                     puntoBool = leer.next().charAt(0);
                     if(puntoBool == 's'|| puntoBool == 'S'){
                        stock[cont-1] = true;
                     }else if(puntoBool == 'n' || puntoBool == 'N'){
                        stock[cont-1] = false;
                     }
                  }else{
                     System.out.println("---------------------------------------------------");
                     System.out.println("ESTA CLAVE ESTA REPETIDA");
                     System.out.println("---------------------------------------------------");
                     cont--;
                  }
                  cont++;
               }else{
                  System.out.println("---------------------------------------------------");
                  System.out.println("EL ESPACIO ESTA LLENO");
                  System.out.println("---------------------------------------------------");
               }   
               break;
            case 2: // consulta invidual
               System.out.print("clave del paquete de galletas");
               clave = leer.nextInt();
               
               break;
            case 3: // consulta general
               for(int x = 0; x<claves.length; x++){
                 if(claves[x] == 0){
                  contG++;
                 }
               }
               if(contG != claves.length){
                  for(int i = 0; i<claves.length-1; i++){
                     for(int j = 0; j<claves.length-1-i; j++){
                        if(claves[j] > claves[j+1]){
                           auxCl = claves[j];
                           claves[j] = claves[j+1];
                           claves[j+1] = auxCl;
                           auxNom = nombres[j];
                           nombres[j] = nombres[j+1];
                           nombres[j+1] = auxNom;
                           auxPres = precios[j];
                           precios[j] = precios[j+1];
                           precios[j+1] = auxPres;
                           auxTam = tamallos[j];
                           tamallos[j] = tamallos[j+1];
                           tamallos[j+1] = auxTam;
                           auxStock = stock[j];
                           stock[j] = stock[j+1];
                           stock[j+1] = auxStock;
                        }
                     }
                  }
                  for(int x = 0; x<claves.length; x++){
                  //contador que acomoda el numero del texto de PAQUETE
                     if(claves[x] != 0){
                       System.out.printf("                                        PAQUETE %d\n", x);
                       System.out.printf("clave[%d] = %d | nombre[%d] = %s  | precio[%d] = %.2f  | tamaño[%d] = %S   |  stock[%d] = %s\n", x, claves[x], x, nombres[x], x, precios[x], x, tamallos[x], x, stock[x]);
                     }
                  }
               }else{
                     System.out.println("---------------------------------------");
                     System.out.println("El Invetario esta Vacio");
                     System.out.println("---------------------------------------");
                  }  
               break;
            case 4: // modificaciones
               //FALTA ESTO
               break;
            case 5: // bajas
               contG = 0;
               for(int x = 0; x<claves.length; x++){
                 if(claves[x] == 0){
                  contG++;
                 }
               }
               if(contG != claves.length){
                  do{
                     System.out.print("Ingrese la clave del paquete de galletas a borrar");
                     clave = leer.nextInt();
                     if(clave >= 1 && clave <= 111){
                        indBorra = false;
                     }else{
                        System.out.println("---------------------------------------------------");
                        System.out.println("El rango de las claves debe estar entre [1 a 111]");
                        System.out.println("---------------------------------------------------");
                        indBorra = true;
                     }
                  }while(indBorra);
                  for(int x = 0; x<cont-1; x++){
                      if(clave == claves[x]){
                         System.out.printf("                                        PAQUETE %d\n", x+1);
                         System.out.printf("clave: %d | nombre: %s  | precio: %.2f  | tamaño: %S   |  stock: %s\n", claves[x], nombres[x], precios[x], tamallos[x], stock[x]);
                         flag = x;
                         break;
                      }
                  }
                  System.out.print("esta seguro de borrar el paquete de galletas? [s = Si] [n = No]");
                  seguro = leer.next().charAt(0);
                  if(seguro == 's'|| seguro == 'S'){
                     confirm = true;
                  }else if(seguro == 'n' || seguro == 'N'){
                     confirm = false;
                  }
                  if(confirm){
                     for(int x = flag; x<claves.length; x++) {
                        claves[x] = claves[x+1];
                        nombres[x] = nombres[x+1];
                        precios[x] = precios[x+1];
                        tamallos[x] = tamallos[x+1];
                        stock[x] = stock[x+1];
                     } 
                  }else{}
               }else{
                   System.out.println("---------------------------------------");
                   System.out.println("El Invetario esta Vacio");
                   System.out.println("---------------------------------------"); 
               }      
               break;
            case 6: // fin
               System.out.println("\nProgramadores:De La Cruz Cervantes Ramses y Roman García Andrea Carolina");
               System.out.println("Fecha: 03/Diciembre/2022");
               break;
            default: System.out.println("\n!ERROR numero no valido\n");
         }
      }while (resp != 6);
   }
}