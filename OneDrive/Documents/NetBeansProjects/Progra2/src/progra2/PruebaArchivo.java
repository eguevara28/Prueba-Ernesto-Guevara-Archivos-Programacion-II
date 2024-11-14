/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progra2;

import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Date;

/**
 *
 * @author ernes
 */
public class PruebaArchivo {

    private File miarchivo = null;

    void setFile(String direccion) {
        miarchivo = new File(direccion);
    }

    void info() {
        if (miarchivo.exists()) {
            System.out.println("\nNombre: " + miarchivo.getName());
            System.out.println("Path: " + miarchivo.getPath());
            System.out.println("Absoluta: " + miarchivo.getAbsolutePath());
            System.out.println("Bytes: " + miarchivo.length());
            System.out.println("Modificado en: " + new Date(miarchivo.lastModified()));
            System.out.println("Padre: " + miarchivo.getAbsoluteFile().getParentFile().getName());
            if (miarchivo.isFile()) {
                System.out.println("Es Archivo");
            } else if (miarchivo.isDirectory()) {
                System.out.println("Es Folder");
            }
            System.out.println("-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-");
        } else {
            System.out.println("No existe!");
        }
    }

    boolean crearArchivo() throws IOException {
        return miarchivo.createNewFile();
    }

    boolean crearFolder() throws IOException {
        return miarchivo.mkdirs();
    }

    void borrar() {
        if (antidoto(miarchivo)) {
            System.out.println("Borrado!");
        } else {
            System.out.println("No se pudo borrar!");
        }
    }

    void dir() {
        if (miarchivo.isDirectory()) {
            System.out.println("Directorio de: " + miarchivo.getAbsolutePath());
            System.out.println("");
            int cfiles = 0, cdirs = 0, tbytes = 0;
            for (File child : miarchivo.listFiles()) {
                if (!child.isHidden()) {
                    Date ultimo = new Date(child.lastModified());
                    System.out.println(ultimo + "\t");
                    if (child.isDirectory()) {
                        cdirs++;
                        System.out.println("<DIR>\t\t");
                    } else {
                        cfiles++;
                        tbytes += child.length();
                        System.out.println("    \t" + child.length() + "\t");
                    }
                    System.out.println(child.getName());
                }
            }
            System.out.println(cfiles + " archivos\t" + tbytes + " bytes");
            System.out.println(cdirs + " dirs\t");
        }
    }

    private boolean antidoto(File mf) {
        if (mf.isDirectory()) {
            for (File child : mf.listFiles()) {
                antidoto(child);
            }
        }
        return mf.delete();
    }

    private void tree(File dir, String tab) {
        if (dir.isDirectory()) {
            System.out.println(tab + dir.getName());
            for (File child : dir.listFiles()) {
                if (!child.isHidden()) {
                    tree(child, tab + "--");
                }
            }
        }
    }

    void tree() {
        tree(miarchivo, "-");
    }

    boolean addToFolder(String nombreCarpeta, String ruta) throws IOException {
        File carpeta = new File(ruta);
        if (miarchivo.isFile() && miarchivo.isDirectory()) {
            File nuevaCarpeta = new File(carpeta, nombreCarpeta);
            return nuevaCarpeta.mkdirs();
        } else {
            System.out.println("No se pudo agregar correctamente");
        }
        return false;
    }

    public void escribirArchivoSobreescribir(String texto) throws IOException {
        try (FileWriter fw = new FileWriter(miarchivo)) {
            fw.write(texto);
            System.out.println("Text sobreescrito en el archivo");
        } catch (IOException e) {
            System.out.println("Eror al escribir en el archivo deseado: " + e.getMessage());
        }
    }

    public void escribirArchivoAnadir(String texto) {
        try (FileWriter fw = new FileWriter(miarchivo, true)) {
            fw.write(texto);
            System.out.println("Texto añadido al archivo.");
        } catch (IOException e) {
            System.out.println("Error al añadir al archivo deseado: " + e.getMessage());
        }
    }

    public void leerArchivo() {
        try (FileReader fr = new FileReader(miarchivo); BufferedReader br = new BufferedReader(fr)) {
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    public void leerArchivoLineaPorLinea() {
        try (FileReader fr = new FileReader(miarchivo); BufferedReader br = new BufferedReader(fr)) {
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println("Línea: " + linea);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

}
