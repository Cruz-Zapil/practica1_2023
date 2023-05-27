package com.practica2.listaMapa;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.practica2.juego.Constructor;

public class TablaDeMpas extends JFrame {

    private JTable tabla;
    private int nivel;
    EnlistarMapa listaNueva = new EnlistarMapa();
    String[][] atributos;

    public TablaDeMpas(int nivel) {

        this.nivel = nivel;
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle(" Elige un mapa ");
        this.setBounds(400, 400, 550, 450);
        this.setLayout(null);

        /// seleccionar mapa

        // this.add(tablero);
        agregarTabla();

        this.setResizable(false);
        this.setVisible(true);

    }

    public void agregarTabla() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("id");
        modelo.addColumn("Dimesion");
        modelo.addColumn("Barcos");
        modelo.addColumn("Misin");
        modelo.addColumn("Torpedo");
        modelo.addColumn("hecatombe");

        listaNueva.leerMapasNivel(String.valueOf(nivel));
        atributos = listaNueva.getAtributos();

        for (int i = 1; i < listaNueva.numeroMapas; i++) {
            modelo.addRow(atributos[i]);
        }
        tabla = new JTable(modelo);

        tabla.addMouseListener(ml);
        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setBounds(12, 22, 500, 300);
        this.add(scroll);

    }

    private MouseListener ml = new MouseListener() {

        @Override
        public void mouseClicked(MouseEvent event) {

            int seleccionFila = tabla.rowAtPoint(event.getPoint());
            System.out.println(listaNueva.getMapa(seleccionFila + 1));
            System.out.println(seleccionFila + 1);
            llamarContructor(seleccionFila + 1);

        }

        @Override
        public void mouseEntered(MouseEvent arg0) {
        }

        @Override
        public void mouseExited(MouseEvent arg0) {
        }

        @Override
        public void mousePressed(MouseEvent arg0) {
        }

        @Override
        public void mouseReleased(MouseEvent arg0) {
        }
    };

    public void llamarContructor(int nMapaElegido) {

        String[] dimensiones = atributos[nMapaElegido][1].split("X");
        String x, y;
        x = dimensiones[0].trim();
        y = dimensiones[1].trim();
        int xx = Integer.valueOf(x);
        int yy = Integer.valueOf(y);
        System.out.println(" dimensiones: ancho: " + xx + " largo: " + yy);


        String[]mapaDesco =listaNueva.getMapa(nMapaElegido).split("\n");
        String mapaSelec = "";
        for (int j2 = 2; j2 < mapaDesco.length; j2++) {

            mapaSelec += mapaDesco[j2];
            if (j2 <= mapaDesco.length - 1) {
                mapaSelec += "\n";
            }
        }
        System.out.println(mapaSelec);
        new Constructor(xx,yy, mapaSelec);
    }
}
