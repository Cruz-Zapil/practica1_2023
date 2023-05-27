package com.practica2.usuario;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.practica2.archivos.LogicaArchivos;
import com.practica2.listaMapa.ElegirNivel;
import com.practica2.listaMapa.EnlistarMapa;

public class Usuario extends JFrame {

    private JTextField nameTxt;
    private JButton registrar;
    private JLabel txtName, txtEdad;

    public Usuario(){

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Registrarse");
        this.setBounds(400, 400, 300, 350);

        this.setLayout(null);     
        addComponent();   

        this.setResizable(false);
        this.setVisible(true);

    }

    public void addComponent(){  
        /// agregar texto 
        nameTxt = new JTextField(" ingresa el nombre");
        registrar= new JButton("Registrar");

        // agregar atributos
        nameTxt.setBounds(75,100,150,35);
        registrar.setBounds(75, 210,80,35);

        //// agregar acciones 
        nameTxt.addMouseListener(ml);
        registrar.addMouseListener(ml);

        this.add(nameTxt);
        this.add(registrar);
    }

     MouseListener ml = new MouseListener(){

        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getSource() == nameTxt) {
                nameTxt.setText("");
            }

            if (e.getSource() == registrar) {
                LogicaArchivos guardarUsuario = new LogicaArchivos();       
                
                if (nameTxt.getText().length()!=0 ) {
                    
                    guardarUsuario.escribirArchivo(nameTxt.getText()+","+"0","auxiliar.txt",false);
                    JOptionPane.showMessageDialog(null, " datos registados"," Registro",JOptionPane.INFORMATION_MESSAGE );
                   
                        EnlistarMapa listamapa = new EnlistarMapa();
                        listamapa.mapasCargadas();
                        ElegirNivel nivel = new ElegirNivel();                  
                    
                }
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
