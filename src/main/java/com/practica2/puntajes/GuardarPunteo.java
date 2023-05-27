package com.practica2.puntajes;

import com.practica2.archivos.LogicaArchivos;

public class GuardarPunteo {
    
    public GuardarPunteo(int punteo){
        LogicaArchivos escribirPunto = new LogicaArchivos();

        String[] auxi= escribirPunto.leerArchivosIterior("auxiliar.txt").split(",");
        System.out.println(" punteo actual: "+ auxi[1]);
        String n= auxi[1].trim();
        int punts = Integer.parseInt(n);
        punts+=punteo;
        System.out.println(punts);
        escribirPunto.escribirArchivo(auxi[0]+"," + punts , "auxiliar.txt",false);
    }
    
}
