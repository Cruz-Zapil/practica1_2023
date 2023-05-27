package com.practica2.archivos;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.practica2.usuario.Usuario;

public class CargarArchivo extends JFrame {

    private JTextArea areaText;
    private JButton boton, boton2, boton3;
    private LogicaArchivos miArchivo = new LogicaArchivos();
    private JFileChooser miBuscador;

    public CargarArchivo() {

       // this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Carga un archivo");
        this.setBounds(400, 400, 400, 600);
        this.setLayout(null);

        agregarComponent();

        this.setResizable(false);
        this.setVisible(true);
    }

    void agregarComponent() {
        /// crear componentes
        areaText = new JTextArea();
        boton2 = new JButton("Elegir");
        boton = new JButton("Agregar");
        boton3 = new JButton("Limpiar");

        /// agregar detalles
        areaText.setBounds(50, 75, 300, 400);
        JScrollPane scrollBar = new JScrollPane(areaText);
        scrollBar.setBounds(50, 75, 300, 400);

        boton2.setBounds(50, 30, 95, 35);
        boton.setBounds(150, 30, 95, 35);
        boton3.setBounds(250, 30, 95, 35);

        /// agregar acciones de mouse
        // areaText.addMouseListener(ml);
        boton.addMouseListener(ml);
        boton2.addMouseListener(ml);
        boton3.addMouseListener(ml);

        /// agregar a frame
        // this.add(areaText);
        this.add(scrollBar);
        this.add(boton);
        this.add(boton2);
        this.add(boton3);

    }

    private MouseListener ml = new MouseListener() {

        @Override
        public void mouseClicked(MouseEvent e) {

            if (e.getSource() == boton2) {
                cargarArchivo();
            }
            if (e.getSource() == boton) {

                if (areaText.getText().length() != 0) {
                    guardarArchivo();

                    /// abrimos bentana
                    Usuario usuario = new Usuario();                    
                    usuario.setVisible(true);
                    

                } else {
                    JOptionPane.showMessageDialog(null, "No ha ingresado un archivo", " Aviso",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
            if (e.getSource() == boton3) {
                areaText.setText("");
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

    public void cargarArchivo() {
        String textoLeido;
        miBuscador = new JFileChooser(".");
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos de mapa (.th)", "th");

        
        miBuscador.setFileFilter(filtro);

        int valor = miBuscador.showOpenDialog(miBuscador);
        if (valor == JFileChooser.APPROVE_OPTION) {

            textoLeido = miArchivo.leerArchivoExterior(miBuscador.getSelectedFile().getAbsolutePath());
            System.out.println(miBuscador.getSelectedFile().getAbsolutePath());
            areaText.setText(textoLeido);
        }
    }


    public void guardarArchivo() {
        miArchivo.escribirArchivo(areaText.getText(), "mapas.th",true);
        JOptionPane.showMessageDialog(null, "Archivo cargado con exito!!", getTitle(), JOptionPane.PLAIN_MESSAGE);
    }
}
