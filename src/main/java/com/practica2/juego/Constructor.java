package com.practica2.juego;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.practica2.archivos.LogicaArchivos;
import com.practica2.listaMapa.Casilla;

public class Constructor extends JPanel {

    // private int ancho;
    // private int largo;

    private String mapa;
    private String[] mapa2;
    private String[][] simbolo;
    private Casilla casilla[][];
    private Casilla bombas[] = new Casilla[4];
    
    private int x, y;

    public Constructor(int ancho, int largo, String mapa) {

        casilla = new Casilla[largo][ancho];
        simbolo = new String[largo][ancho];
        this.x = ancho;
        this.y = largo;
        this.mapa = mapa;
        this.setVisible(true);
        this.setBounds(100, 100, 300, 300);
        // setOpaque(true);
        setLayout(new GridLayout(largo, ancho, 3, 3));
        // this.setLayout();
        System.out.println(mapa);
        mapa2 = mapa.split("\n");

        for (int i = 0; i < largo; i++) {
            String[] auxi = mapa2[i].split(",");
            for (int j = 0; j < ancho; j++) {
                simbolo[i][j] = auxi[j];
            }
        }

        System.out.println(" estamos en tablero ");
        mapa();
        diseniarVetntana();
        darClick();
    }

    public void mapa() {

        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                casilla[i][j] = new Casilla(40, i + j, i, j, simbolo[i][j], false);
                System.out.print(casilla[i][j].getTipoFicha());
                
                this.add(casilla[i][j]);
            }
            System.out.println();
        }
    }

    public void diseniarVetntana() {
        Juegos vetanaTablero = new Juegos(this);
        vetanaTablero.add(agregarBotton(), BorderLayout.NORTH);
    }

    public Component agregarBotton() {

        JPanel panelBotones = new JPanel();
        bombas[0] = new Casilla(0, 110, 35, 10, 0, "Bomba");
        bombas[1] = new Casilla(1, 110, 35, 4, 1, "Torpedo");
        bombas[2] = new Casilla(2, 110, 35, 4, 2, "Misil");
        bombas[3] = new Casilla(3, 110, 35, 4, 3, "Hectatombe");
    
        for (int i = 0; i < bombas.length; i++) {
            panelBotones.add(bombas[i]);
        }

        JButton sali = new JButton("Salir");
        sali.addMouseListener(salir);
        sali.setBackground(Color.LIGHT_GRAY);
        
        panelBotones.add(sali);
        panelBotones.setBounds(0, 0, 500, 100);
        panelBotones.setVisible(true);
        return panelBotones;
    }

    public void darClick() {

        Jugabilidad jugable = new Jugabilidad(casilla, bombas, x, y);
        for (int j2 = 0; j2 < y; j2++) {
            for (int k = 0; k < x; k++) {
                casilla[j2][k].addMouseListener(jugable);
            }
        }
        for (int i = 0; i < bombas.length; i++) {
            bombas[i].addMouseListener(jugable);
        }
    }


    private MouseListener salir = new MouseListener() {

        @Override
        public void mouseClicked(MouseEvent event) {

            System.out.println(" esta saliendo de la partida");
            LogicaArchivos guardarpunteo = new LogicaArchivos();
            guardarpunteo.leerArchivosIterior("auxiliar.txt");
            guardarpunteo.escribirArchivo(",,"+guardarpunteo.leerArchivosIterior("auxiliar.txt"),"/estadisticas/punteos.war",true);

        }

        @Override
        public void mouseEntered(MouseEvent eve) {}

        @Override
        public void mouseExited(MouseEvent arg0) {}

        @Override
        public void mousePressed(MouseEvent arg0) {}

        @Override
        public void mouseReleased(MouseEvent arg0) {}

        
    };

}
