/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progra2;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author ernes
 */
public class MiArchivo {

    public static void main(String[] args) {
        PruebaArchivo pa = new PruebaArchivo();
        Scanner lea = new Scanner(System.in).useDelimiter("\n");
        int options = 0;

        do {
            System.out.println("""
                           1 - Set Archivo/Folder
                           2 - Ver Informacion
                           3 - Crear Archivo
                           4 - Crear Folder
                           5 - Agregar Archivo a Folder
                           6 - Borrar
                           7 - comando DIR
                           8 - TREE
                           9 - Escribir en archivo sobreescribiendo
                           10 - Escribir en archivo añadiendo en una nueva linea
                           11 - Leer todo el archivo
                           12 - Leer el archivo linea por linea
                           9 - Salir
                           """);
            System.out.print("Escoge una de las opciones: ");
            try {
                options = lea.nextInt();
                switch (options) {
                    case 1:
                        System.out.print("Direccion");
                        pa.setFile(lea.next());
                        break;
                    case 2:
                        pa.info();
                        break;
                    case 3:
                        if (pa.crearArchivo()) {
                            System.out.println("Se creo el archivo!");
                        } else {
                            System.out.println("No se creo el archivo!");
                        }
                        break;
                    case 4:
                        if (pa.crearFolder()) {
                            System.out.println("Se creo el folder!");
                        } else {
                            System.out.println("No se creo el folder!");
                        }
                        break;
                    case 5:
                        System.out.println("Nombre de la carpeta a agregar: ");
                        String folderName = lea.next();
                        System.out.println("Ruta de destino: ");
                        String ruta = lea.next();
                        
                        try{
                            if (pa.addToFolder(folderName, ruta)) 
                                System.out.println("Carpeta agregada correctamente");
                            else
                                System.out.println("No se pudo agregar la carpeta");
                        }catch (IOException e) {
                            System.out.println("Error al agregar la carpeta"+e.getMessage());
                        }
                        
                        break;
                    case 6:
                        pa.borrar();
                        break;
                    case 7:
                        pa.dir();
                    case 8:
                        pa.tree();
                    case 9:
                        System.out.print("Escribe el texto para sobreescribir: ");
                        String textoSobreescribir = lea.next();
                        pa.escribirArchivoSobreescribir(textoSobreescribir);
                        break;
                    case 10:
                        System.out.print("Escribe el texto para añadir: ");
                        String textoAnadir = lea.next();
                        pa.escribirArchivoAnadir(textoAnadir);
                        break;
                    case 11:
                        pa.leerArchivo();
                        break;
                    case 12:
                        pa.leerArchivoLineaPorLinea();
                        break;
                    default:
                        System.out.println("Sistema fuera");
                }
            } catch (InputMismatchException e) {
                System.out.println("Ingresar una opcion valida!");
                lea.next();
            } catch (NullPointerException e) {
                System.out.println("Por favor, Sleccionar primero la opcion 1");
            } catch (IOException e) {
                System.out.println("Error" + e.getMessage());
            }
        } while (options != 13);

    }

}
