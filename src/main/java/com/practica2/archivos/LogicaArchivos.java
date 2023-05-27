package com.practica2.archivos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class LogicaArchivos {

    String RUTA;
    String rutaB = "";
    private String rutaFichero = "src/main/java/com/practica2/ficheros/";

    public LogicaArchivos() {
    }

    public String leerArchivoExterior(String ruta) {
        System.out.println("ruta Exterior: "+ ruta);
        FileReader lector = null;
        BufferedReader br = null;
        this.RUTA = ruta;

        String lectura = " ";
        String contenido = " ";

        try {
            lector = new FileReader(ruta);
            br = new BufferedReader(lector);
            while ((lectura = br.readLine()) != null) {
                contenido += lectura + "\n";

            }
            br.close();
            lector.close();
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.WARNING_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e, " Error", JOptionPane.WARNING_MESSAGE);
        }
        return contenido;
    }

    public String leerArchivosIterior(String ruta){
        System.out.println(rutaFichero+ruta);
        FileReader lector = null;
        BufferedReader br = null;
      

        String lectura = " ";
        String contenido = " ";

        try {
            lector = new FileReader(rutaFichero+ruta);
            br = new BufferedReader(lector);
            while ((lectura = br.readLine()) != null) {
                contenido += lectura + "\n";

            }
            br.close();
            lector.close();
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.WARNING_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e, " Error", JOptionPane.WARNING_MESSAGE);
        }
        return contenido;

    }


    public void escribirArchivo(String texto, String ruta, boolean reescribir) {
        System.out.println(" rutas firchero "+rutaFichero+ruta);
        try {
            File archivo = new File(rutaFichero + ruta);
            if (!archivo.exists()) {
                archivo.createNewFile();
            }
            FileWriter escritor = new FileWriter(archivo, reescribir);
            BufferedWriter buffer = new BufferedWriter(escritor);
            buffer.write(texto);
            buffer.close();
            escritor.close();
        } catch (IOException error) {
            System.out.println(error);
        }
    }


}
