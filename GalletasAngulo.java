/*
   VERSION 4 CARO
   VERSION TERMINADA
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
      int resp, cont=0, clave, celda, cambio;
      boolean existe;
      char respuesta;
      
           
      //inicio do-while
      do {
          //Menú
      System.out.println("INVENTARIO GALLETAS ANGULO");
      System.out.print("¿Qué es lo que desea hacer? [1-6]\n");
      System.out.println("[1] Registro de galletas");
      System.out.println("[2] Consultar un tipo de galleta");
      System.out.println("[3] Consultar todas las galletas");
      System.out.println("[4] Modificar datos de galletas");
      System.out.println("[5] Eliminar datos de galletas");
      System.out.println("[6] Finalizar");
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
                  System.out.print("\nNombre: ");
                  nombres[cont]=leer.nextLine();
                  System.out.print("\nSabor: ");
                  sabores[cont]=leer.nextLine();
                  System.out.print("\nPrecio: $");
                  precios[cont]=leer.nextFloat();
                  System.out.print("\nCantidad de galletas: ");
                  cantidades[cont]=leer.nextInt();
                  cont++;
               }else{
                  System.out.println("\nLa clave:["+ clave +"] ya fue utilizada");
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
               System.out.println("Ingrese la clave de las galletas");
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
                     System.out.println("Sabor: "+ sabores[celda]);
                     System.out.println("Precio: $"+ precios[celda]);
                     System.out.println("Cantidad: "+ cantidades[celda]);
                     System.out.println(" ");
                  } else{
                     System.out.println("\n NO EXITE NINGUNA GALLETA CON ESTA CLAVE ("+ clave +")");
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
               System.out.println("\nCONSULTAR TODOS LOS PAQUETES DE GALLETAS");
               //metodo burbuja
               for (int x=0; x<cont; x++) {
                  for (int z=0; z<cont-1-x; z++) {
                     if(claves[z] > claves[z+1]) {
                        //claves
                        int auxiliar = claves[z];
                        claves[z] = claves[z+1];
                        claves[z+1] = auxiliar;
                        
                        //nombres
                        String auxiliarCad = nombres[z];
                        nombres[z] = nombres[z+1];
                        nombres[z+1] = auxiliarCad;
                        
                        //sabor
                        auxiliarCad = sabores[z];
                        sabores[z] = sabores[z+1];
                        sabores[z+1] = auxiliarCad;
                        
                        //precio
                        Float auxiliarFloat = precios[z];
                        precios[z] = precios[z+1];
                        precios[z+1] = auxiliar;
                        
                        //cantidad
                        int auxiliarInt= cantidades[z];
                        cantidades[z] = cantidades[z+1];
                        cantidades[z+1] = auxiliar;
                     }
                  }
               }
               for (int x=0; x<cont; x++) {
                  System.out.print("\nClave"+ claves[x]);
                  System.out.print("\nNombre: "+ nombres[x]);
                  System.out.print("\nSabor: "+ sabores[x]);
                  System.out.print("\nPrecio: $"+ precios[x]);
                  System.out.print("\nCantidad: "+ cantidades[x]);
                  System.out.println(" ");
                  System.out.println("o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o");
               }
            } else {
               System.out.println("\nNO SE HA REGISTRADO NINGUN PAQUETE DE GALLETAS");
            }
         
            break;
         case 4:
            //Modificar atleta
            if(cont>0) {
               System.out.println("MODIFICAR UN TIPO DE GALLETAS");
               System.out.println("Ingrese la clave de las galletas");
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
                        System.out.println("[1] Nombre: "+ nombres[celda]);
                        System.out.println("[2] Sabor: "+ sabores[celda]);
                        System.out.println("[3] Precio: $"+ precios[celda]);
                        System.out.println("[4] Cantidad: "+ cantidades[celda]);
                        System.out.println("[5] Ninguno");
                        System.out.println("¿Que desea Modificar? [1-5]");
                        cambio= leer.nextInt();
                        
                        switch (cambio) {
                           case 1:
                              leer.nextLine();
                              System.out.print("Ingrese el nuevo nombre: ");
                              nombres[celda]= leer.nextLine();
                              break;
                            case 2:
                              leer.nextLine();
                              System.out.print("Ingrese el nuevo sabor: ");
                              sabores[celda]= leer.nextLine();
                              break;
                            case 3:
                              System.out.print("Ingrese el nuevo precio: ");
                              precios[celda]= leer.nextFloat();
                              break;
                            case 4:
                              System.out.print("Ingrese el nuevo cantidad de galletas: ");
                              cantidades[celda]= leer.nextInt();
                              break;
                            case 5:
                              
                              break;
                            default:
                              System.out.println("Opcion no valida");

                        }
                     } while (cambio!=5);
                  } else{
                     System.out.println("\n NO EXITE NINGUNA GALLETA CON ESTA CLAVE ("+ clave +")");
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
               System.out.println("Ingrese la clave de las galletas");
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
                     System.out.println("Sabor: "+ sabores[celda]);
                     System.out.println("Precio: $"+ precios[celda]);
                     System.out.println("Cantidad: "+ cantidades[celda]);
                     leer.nextLine();
                     System.out.println(" ¿Seguro que desea eliminar estas galletas? [S/N]: ");
                     respuesta = leer.nextLine().charAt(0);
                     if (respuesta == 's'|| respuesta == 'S') {
                        //desplazamiento
                        for(int x=celda; x<cont-1; x++) {
                           claves[x]= claves[x+1];
                           nombres[x]= nombres[x+1];
                           sabores[x]= sabores[x+1];
                           precios[x]= precios[x+1];
                           cantidades[x]= cantidades[x+1];
                        }
                        cont--;
                        System.out.println("Ya se han eliminado las galletas");
                     }
                  } else{
                     System.out.println("\n NO EXITE NINGUNA GALLETA CON ESTA CLAVE ("+ clave +")");
                  }
               } else{
                  System.out.println("\nLA CLAVE NO ES VALIDA");
               }
            }else {
             System.out.println("\nNO SE HA REGISTRADO NINGUN PAQUETE DE GALLETAS");
              
            }

            break;
         case 6:
            System.out.println("PROGRAMADORES: Andrea Carolina Roman García && Ramses De La Cruz Cervantes");
            System.out.println("Fecha: 29/11/2022");
            break;
         default:
            System.out.println("La opcion no es valida");
      }
      } while (resp != 6);
   }
}      