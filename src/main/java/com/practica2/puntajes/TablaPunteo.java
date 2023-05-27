package com.practica2.puntajes;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.practica2.archivos.LogicaArchivos;

public class TablaPunteo extends JFrame {

    private JTable tabla;
    private String[][] atributos;

    private JButton acendente;
    private JButton desendente;
    private String[] listaPunto;

    public TablaPunteo() {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle(" Punteo ");
        this.setBounds(400, 400, 550, 440);
        this.setLayout(null);
        agregarTabla();
        botones();

        this.setResizable(false);
        this.setVisible(true);

    }

    DefaultTableModel modelo = new DefaultTableModel();

    public void agregarTabla() {

        listaPunto = new LogicaArchivos().leerArchivosIterior("estadisticas//punteo.war").split(",,");
        atributos = new String[(listaPunto.length) + 1][2];
        for (int i = 0; i < listaPunto.length - 1; i++) {

            System.out.println(listaPunto[i + 1]);
            atributos[i] = listaPunto[i + 1].split(",");
        }

        modeloTM(atributos);
        // bubbleSort();
        // bubbleSort();

    }

    public void modeloTM(String[][] arreglo) {

        for (int i = 0; i < listaPunto.length - 1; i++) {

            for (int j = 0; j < 2; j++) {
                System.out.print(arreglo[i][j]);
            }
            System.out.println();
        }

        modelo.addColumn("Nombre");
        modelo.addColumn("Punteo");

        int n = listaPunto.length - 1;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                int num1 = Integer.parseInt(arreglo[j][1].trim());
                int num2 = Integer.parseInt(arreglo[j + 1][1].trim());
                if (num1 > num2) {
                    // Intercambiar elementos
                    String[] temp = arreglo[j];
                    System.out.print(temp);
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = temp;
                }
            }
        }

        for (int i = 0; i < listaPunto.length - 1; i++) {
            modelo.addRow(arreglo[i]);
        }

        tabla = new JTable(modelo);

        tabla.addMouseListener(ml);
        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setBounds(25, 100, 500, 300);
        this.add(scroll);

    }

    public void botones() {
        acendente = new JButton("acendente");
        desendente = new JButton("desendente");
        acendente.setBounds(0, 0, 110, 35);
        desendente.setBounds(0, 0, 110, 35);
        acendente.addMouseListener(ml);
        desendente.addMouseListener(ml);

        add(acendente, BorderLayout.NORTH);
        add(desendente, BorderLayout.NORTH);
    }

    private MouseListener ml = new MouseListener() {

        @Override
        public void mouseClicked(MouseEvent event) {

            if (event.getSource() == acendente) {
                System.out.println(" hola 1");

            } else if (event.getSource() == desendente) {
                System.out.println(" hola 2");
            }
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
}
