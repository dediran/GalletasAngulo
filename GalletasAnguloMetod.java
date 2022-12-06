/*
   GALLETAS ANGULO
*/
import java.util.Scanner;
public class GalletasAnguloMetod{
   public static void main(String args[]){
      Scanner leer = new Scanner(System.in);
      final int TAM_ARREGLO = 3;
      int claves[]= new int[TAM_ARREGLO];
      String nombres[]= new String[TAM_ARREGLO], auxiliarCad;
      char tipo[]= new char[TAM_ARREGLO], auxiliarChar;
      float precios[]= new float[TAM_ARREGLO], auxiliarFloat;
      int cantidades[]= new int[TAM_ARREGLO];
      int resp, cont=0, clave, celda, cambio, auxiliar, auxiliarInt;
      boolean existe,indicador,indicadorLleno;
      char respuesta;
      do {
          //Menú
         System.out.println("\nINVENTARIO GALLETAS ANGULO");
         System.out.println("¿Qué es lo que desea hacer? [1-6]");
         System.out.println("[1] Registro de galletas");
         System.out.println("[2] Consultar un tipo de galleta");
         System.out.println("[3] Consultar todas las galletas");
         System.out.println("[4] Modificar datos de galletas");
         System.out.println("[5] Eliminar datos de galletas");
         System.out.println("[6] Finalizar");
         resp = leer.nextInt();
      
         switch (resp) {
            case 1:
               indicadorLleno = espacioLleno (cont, TAM_ARREGLO);
               if(indicadorLleno) {
                  System.out.println("\nREGISTRO DE GALLETAS ANGULO");
                  System.out.print("Ingrese la clave de las galletas: ");
                  clave = leer.nextInt();
                  if (clave >=1 && clave <= 111) {
                     existe = clavesRepetidas (cont, clave, claves);     
                  //altas
                     if(existe == false){
                        claves[cont] = clave;
                        leer.nextLine();
                        System.out.print("Ingrese el Nombre del paquete de galletas: ");
                        nombres[cont]=leer.nextLine();
                        indicador = false;
                        do{
                           System.out.print("Ingrese el tipo de paquete de galletas [F = fibra] [H = hibridas]: ");
                           tipo[cont]=leer.nextLine().charAt(0);
                           if(tipo[cont] == 'f' || tipo[cont] == 'F' || tipo[cont] == 'h' || tipo[cont] == 'H'){
                              indicador = true;
                           }else if(indicador == false) {
                              System.out.println("\nEL DATO QUE INGRESO NO ES VALIDO\n");
                           }
                        }while(indicador == false);   
                        System.out.print("ingrese el Precio de las galletas: $");
                        precios[cont]=leer.nextFloat();
                        System.out.print("ingrese la Cantidad de galletas: ");
                        cantidades[cont]=leer.nextInt();
                        cont++;
                     }else{
                        System.out.printf("\nLa clave:[%d] ya fue utilizada\n", clave);
                     }
                  }else {
                     System.out.println("\nLA CLAVE NO ES VALIDA");
                  }
               } else {
                  System.out.println("NO HAY ESPACIO DISPONIBLE");
               }
               break;
            case 2:
            //consultar tipo de galleta
               if(cont>0) {
                  System.out.println("CONSULTAR UN TIPO DE GALLETAS");
                  System.out.print("Ingrese la clave de las galletas: ");
                  clave=leer.nextInt();
                  if(clave>=1 && clave<=111) {
                  //Buscar galletas
                     celda=-1;
                     for (int x=0; x<cont; x++) {
                        if(clave == claves[x]){
                           celda = x;
                           break;
                        }
                     }
                     if (celda!= -1) {
                        System.out.printf("--------Paquete de galletas %d---------\n", celda+1);
                        System.out.printf("Nombre: %s\n",nombres[celda]);
                        System.out.printf("tipo: %S\n",tipo[celda]);
                        System.out.printf("Precio: $%.2f\n", precios[celda]);
                        System.out.printf("Cantidad: %d\n", cantidades[celda]);
                     } else{
                        System.out.printf("\n NO EXITE NINGUNA GALLETA CON ESTA CLAVE %d\n", clave);
                     }
                  } else{
                     System.out.println("\nLA CLAVE NO ES VALIDA");
                  }
               }else {
                  System.out.println("\nNO SE HA REGISTRADO NINGUN PAQUETE DE GALLETAS");
               
               }
               break;
            case 3:
            //Consulta general
               if(cont>0) {
                  System.out.println("\nLISTADO DE ALMACEN");
                  for (int x=0; x<cont; x++) {
                     for (int z=0; z<cont-1-x; z++) {
                        if(claves[z] > claves[z+1]) {
                        //claves
                           auxiliar = claves[z];
                           claves[z] = claves[z+1];
                           claves[z+1] = auxiliar;
                        //nombres
                           auxiliarCad = nombres[z];
                           nombres[z] = nombres[z+1];
                           nombres[z+1] = auxiliarCad;
                        //tipo
                           auxiliarChar = tipo[z];
                           tipo[z] = tipo[z+1];
                           tipo[z+1] = auxiliarChar;
                        //precio
                           auxiliarFloat = precios[z];
                           precios[z] = precios[z+1];
                           precios[z+1] = auxiliar;
                        //cantidad
                           auxiliarInt= cantidades[z];
                           cantidades[z] = cantidades[z+1];
                           cantidades[z+1] = auxiliar;
                        }
                     }
                  }
                  for (int x=0; x<cont; x++) {
                     System.out.printf("--------Paquete de galletas %d---------\n", x+1);
                     System.out.printf("Clave: %d\n",claves[x]);
                     System.out.printf("Nombre: %s\n", nombres[x]);
                     System.out.printf("tipo: %S\n", tipo[x]);
                     System.out.printf("Precio: $%.2f\n", precios[x]);
                     System.out.printf("Cantidad: %d\n", cantidades[x]);
                  }
               } else {
                  System.out.println("\nNO SE HA REGISTRADO NINGUN PAQUETE DE GALLETAS");
               }
            
               break;
            case 4:
            //Modificar galletas
               if(cont>0) {
                  System.out.println("MODIFICAR UN TIPO DE GALLETAS");
                  System.out.print("Ingrese la clave de las galletas: ");
                  clave=leer.nextInt();
                  if(clave>=1 && clave<=111) {
                  //Buscar galletas
                     celda=-1;
                     for (int x=0; x<cont; x++) {
                        if(clave == claves[x]){
                           celda = x;
                           break;
                        }
                     }
                     if (celda!= -1) {
                        do {
                           System.out.printf("\n[1] Nombre: %s\n", nombres[celda]);
                           System.out.printf("[2] tipo: %S\n", tipo[celda]);
                           System.out.printf("[3] Precio: $%.2f\n", precios[celda]);
                           System.out.printf("[4] Cantidad: %d\n", cantidades[celda]);
                           System.out.println("[5] Ninguno");
                           System.out.println("¿Que desea Modificar? [1-5]");
                           cambio = leer.nextInt();
                        
                           if(cambio == 1){
                                 leer.nextLine();
                                 System.out.print("Ingrese el nuevo nombre: ");
                                 nombres[celda]= leer.nextLine();
                           }else{ 
                              if(cambio == 2){
                                 leer.nextLine();
                                 indicador = false;
                                 do{
                                    System.out.print("Ingrese el nuevo tipo: [F = fibra] [H = hibrida]");
                                    tipo[celda]= leer.nextLine().charAt(0);
                                    if(tipo[celda] == 'f' || tipo[celda] == 'F' || tipo[celda] == 'h' || tipo[celda] == 'H'){
                                       indicador = true;
                                    }else if(indicador == false){
                                       System.out.println("\nEL DATO QUE INGRESO NO ES VALIDO\n");
                                    }
                                 }while(indicador == false);   
                              }else{
                                 if(cambio == 3){
                                    System.out.print("Ingrese el nuevo precio: ");
                                    precios[celda]= leer.nextFloat();
                                 }else {
                                    if(cambio == 4){
                                       System.out.print("Ingrese el nuevo cantidad de galletas: ");
                                       cantidades[celda]= leer.nextInt();
                                    }else {
                                       if(cambio == 5){
                                          System.out.println("No se a cambiado ningun dato");
                                       }else {
                                          System.out.println("Opcion no valida");
                                       }
                                    }
                                 }
                              }
                           }      
                        }while (cambio != 5);
                     } else{
                        System.out.printf("\n NO EXITE NINGUNA GALLETA CON ESTA CLAVE (%d)\n", clave);
                     }
                  } else{
                     System.out.println("\nLA CLAVE NO ES VALIDA");
                  }
               }else {
                  System.out.println("\nNO SE HA REGISTRADO NINGUN PAQUETE DE GALLETAS");
               
               }
            
               break;
            case 5:
            //Eliminar Galletas
               if(cont>0) {
                  System.out.println("\nELIMINAR UN TIPO DE GALLETAS");
                  System.out.print("Ingrese la clave de las galletas: ");
                  clave=leer.nextInt();
                  if(clave>=1 && clave<=111) {
                  //Buscar galletas
                     celda=-1;
                     for (int x=0; x<cont; x++) {
                        if(clave == claves[x]){
                           celda = x;
                           break;
                        }
                     }
                     if (celda!= -1) {
                        System.out.println("Nombre: "+ nombres[celda]);
                        System.out.println("tipo: "+ tipo[celda]);
                        System.out.println("Precio: $"+ precios[celda]);
                        System.out.println("Cantidad: "+ cantidades[celda]);
                        leer.nextLine();
                        System.out.print("¿Seguro que desea eliminar estas galletas? [S/N]: ");
                        respuesta = leer.nextLine().charAt(0);
                        if (respuesta == 's'|| respuesta == 'S') {
                        //desplazamiento
                           for(int x=celda; x<cont-1; x++) {
                              claves[x]= claves[x+1];
                              nombres[x]= nombres[x+1];
                              tipo[x]= tipo[x+1];
                              precios[x]= precios[x+1];
                              cantidades[x]= cantidades[x+1];
                           }
                           cont--;
                           System.out.println("Ya se han eliminado las galletas");
                        }
                     } else{
                        System.out.printf("\nNO EXITE NINGUNA GALLETA CON ESTA CLAVE (%d)\n",clave);
                     }
                  } else{
                     System.out.println("\nLA CLAVE NO ES VALIDA");
                  }
               }else {
                  System.out.println("\nNO SE HA REGISTRADO NINGUN PAQUETE DE GALLETAS");
               
               }
               break;
            case 6:
               System.out.println("PROGRAMADORES: Andrea Carolina Roman García y Ramses De La Cruz Cervantes");
               System.out.println("Fecha: 30/11/2022");
               break;
            default:
               System.out.println("La opcion no es valida");
         }
      } while (resp != 6);
   }
   static boolean espacioLleno (int cont, int TAM_ARREGLO) {
      boolean lleno = false;
      if (cont < TAM_ARREGLO){
          lleno = true;
      }
      return lleno; 
   }
   static boolean clavesRepetidas (int cont, int clave, int claves[]){
      boolean existes = false;
      for(int x=0; x<cont; x++) {
         if(clave == claves[x]) {
            existes = true;
            break;
         }
      }
      return existes;
   } 
}