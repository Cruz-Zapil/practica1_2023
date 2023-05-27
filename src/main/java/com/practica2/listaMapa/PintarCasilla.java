package com.practica2.listaMapa;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class PintarCasilla {

    // boolean flag = false;
    static final String AGUA = "src/main/java/com/practica2/image/Agua.png";
    static final String BONBA = "src/main/java/com/practica2/image/Bomba.jpg";
    static final String LLAMA = "src/main/java/com/practica2/image/Llma.jpg";
    static final String BARCO = "src/main/java/com/practica2/image/Barco.jpg";


    private  ImageIcon imagen;
    private  Icon icono;


    public Icon pintarAgua() {

        imagen =new ImageIcon(AGUA);    
        return icono = new ImageIcon(imagen.getImage().getScaledInstance(40,40,Image.SCALE_DEFAULT));

    }

     public Icon pintarBomba() {
      imagen = new ImageIcon(BONBA);
      return icono = new ImageIcon(imagen.getImage().getScaledInstance(40,40,Image.SCALE_DEFAULT));
    }
    

    public Icon pintarLlama(){
      imagen = new ImageIcon(LLAMA);
      return icono = new ImageIcon(imagen.getImage().getScaledInstance(40,40,Image.SCALE_DEFAULT));

    }
    public Icon pintarBarco(){
      imagen = new ImageIcon(BARCO);
      return icono = new ImageIcon(imagen.getImage().getScaledInstance(40, 40,Image.SCALE_DEFAULT ));
    }

}
