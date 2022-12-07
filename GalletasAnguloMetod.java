/*
   GALLETAS ANGULO
*/
import java.util.Scanner;
public class GalletasAnguloMetod{
   static Scanner leer = new Scanner(System.in);
   public static void main(String args[]){
      final int TAM_ARREGLO = 100;
      int claves[]= new int[TAM_ARREGLO];
      String nombres[]= new String[TAM_ARREGLO], auxiliarCad = "";
      char tipo[]= new char[TAM_ARREGLO], auxiliarChar = ' ';
      float precios[]= new float[TAM_ARREGLO], auxiliarFloat = 0;
      int cantidades[]= new int[TAM_ARREGLO];
      int resp, cont=0, clave, celda, celdaVery, cambio, auxiliar = 0, auxiliarInt = 0;
      boolean existe,indicador = true,indicadorLleno,indicadorClave,indicadorRegistros;
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
                  if (rangoDeClave(clave)) {
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
               if(proRegistros(cont)) {
                  System.out.println("CONSULTAR UN TIPO DE GALLETAS");
                  System.out.print("Ingrese la clave de las galletas: ");
                  clave=leer.nextInt();
                  if(rangoDeClave(clave)) {
                  //Buscar galletas
                     celda=-1;
                     celdaVery = buscaClaveDeGalletas(cont, celda, clave, claves);
                     if (celdaVery!= -1) {
                        System.out.printf("--------Paquete de galletas %d---------\n", celdaVery+1);
                        System.out.printf("Nombre: %s\n",nombres[celdaVery]);
                        System.out.printf("tipo: %S\n",tipo[celdaVery]);
                        System.out.printf("Precio: $%.2f\n", precios[celdaVery]);
                        System.out.printf("Cantidad: %d\n", cantidades[celdaVery]);
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
               if(proRegistros(cont)) {
                  System.out.println("\nLISTADO DE ALMACEN");
                  metodoBurbuja(cont, auxiliar, claves, auxiliarCad, nombres, auxiliarChar, tipo, auxiliarFloat , precios, auxiliarInt, cantidades);
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
               if(proRegistros(cont)) {
                  System.out.println("MODIFICAR UN TIPO DE GALLETAS");
                  System.out.print("Ingrese la clave de las galletas: ");
                  clave=leer.nextInt();
                  if(rangoDeClave(clave)) {
                  //Buscar galletas
                     celda=-1;
                     celdaVery = buscaClaveDeGalletas(cont, celda, clave, claves);
                     if (celdaVery!= -1) {
                        do {
                           System.out.printf("\n[1] Nombre: %s\n", nombres[celdaVery]);
                           System.out.printf("[2] tipo: %S\n", tipo[celdaVery]);
                           System.out.printf("[3] Precio: $%.2f\n", precios[celdaVery]);
                           System.out.printf("[4] Cantidad: %d\n", cantidades[celdaVery]);
                           System.out.println("[5] Ninguno");
                           System.out.println("¿Que desea Modificar? [1-5]");
                           cambio = leer.nextInt();
                           seleccionDeCambio(cambio, nombres, celdaVery, indicador, tipo, precios, cantidades);     
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
               if(proRegistros(cont)) {
                  System.out.println("\nELIMINAR UN TIPO DE GALLETAS");
                  System.out.print("Ingrese la clave de las galletas: ");
                  clave=leer.nextInt();
                  if(rangoDeClave(clave)) {
                  //Buscar galletas
                     celda = -1;
                     celdaVery = buscaClaveDeGalletas(cont, celda, clave, claves);
                     if (celdaVery!= -1) {
                        System.out.println("Nombre: "+ nombres[celdaVery]);
                        System.out.println("tipo: "+ tipo[celdaVery]);
                        System.out.println("Precio: $"+ precios[celdaVery]);
                        System.out.println("Cantidad: "+ cantidades[celdaVery]);
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
               integrantesFecha();
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
   static boolean rangoDeClave (int clave){
      boolean indicadorClave = false;
      if(clave>=1 && clave<=111){
         indicadorClave = true;
      }
      return indicadorClave;
   }
   static boolean proRegistros (int cont){
      boolean indicadorRegistros = false;     
      if(cont > 0){
         indicadorRegistros = true;
      }
      return indicadorRegistros;
   }
   static int buscaClaveDeGalletas(int cont, int celda, int clave, int claves[]) {
      for (int x=0; x<cont; x++) {
         if(clave == claves[x]){
            celda = x;
            break;
         }
      }
      return celda;
   }
   static void seleccionDeCambio(int cambio, String nombres[], int celdaVery, boolean indicador, char tipo[], float precios[], int cantidades[]){
      if(cambio == 1){
         leer.nextLine();
         System.out.print("Ingrese el nuevo nombre: ");
         nombres[celdaVery]= leer.nextLine();
      }else{ 
         if(cambio == 2){
            leer.nextLine();
            indicador = false;
            do{
               System.out.print("Ingrese el nuevo tipo: [F = fibra] [H = hibrida]");
               tipo[celdaVery]= leer.nextLine().charAt(0);
               if(tipo[celdaVery] == 'f' || tipo[celdaVery] == 'F' || tipo[celdaVery] == 'h' || tipo[celdaVery] == 'H'){
                  indicador = true;
               }else if(indicador == false){
                  System.out.println("\nEL DATO QUE INGRESO NO ES VALIDO\n");
               }
            }while(indicador == false);   
         }else{
            if(cambio == 3){
               System.out.print("Ingrese el nuevo precio: ");
               precios[celdaVery]= leer.nextFloat();
            }else {
               if(cambio == 4){
                  System.out.print("Ingrese el nuevo cantidad de galletas: ");
                  cantidades[celdaVery]= leer.nextInt();
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
   }
   static void metodoBurbuja(int cont, int auxiliar, int claves[], String auxiliarCad, String nombres[], char auxiliarChar, char tipo[], float auxiliarFloat ,float precios[], int auxiliarInt, int cantidades[]){
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
                 precios[z+1] = auxiliarFloat;
           //cantidad
                 auxiliarInt= cantidades[z];
                 cantidades[z] = cantidades[z+1];
                 cantidades[z+1] = auxiliarInt;
              }
          }
      }
   }
   static void integrantesFecha(){
      System.out.println("PROGRAMADORES: Andrea Carolina Roman García y Ramses De La Cruz Cervantes");
      System.out.println("Fecha: 7/12/2022");
   } 
}
