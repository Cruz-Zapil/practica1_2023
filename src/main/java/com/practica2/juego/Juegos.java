package com.practica2.juego;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class  Juegos extends JFrame {

    private Constructor tablero;
   // private Casilla bombas[];
 

    public Juegos(JPanel tablero){

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle(" Practiva 1");
       

        this.setBounds(400, 400,500 ,600);
    
        this.setLayout(null);
       // agregarBotton();
        this.add(tablero);
        this.setVisible(true);
    }


    
}
