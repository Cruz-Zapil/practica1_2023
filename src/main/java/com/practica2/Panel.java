
package com.practica2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import com.practica2.archivos.CargarArchivo;
import com.practica2.listaMapa.ElegirNivel;
import com.practica2.listaMapa.TablaDeMpas;
import com.practica2.puntajes.TablaPunteo;

public class Panel extends JPanel {

    private JButton[] botones = new JButton[4];
    private Image imagen;

    public Panel() {
        this.setVisible(true);
        this.setBackground(Color.lightGray);
        setLayout(null);
        this.generarBotones();
        agregarnombre();
    }

    public void generarBotones() {
        int x = 25;
        int y = 125;

        for (int i = 0; i < 4; i++) {
            botones[i] = new JButton();
            botones[i].setBounds(x, y, 150, 50);
            botones[i].addMouseListener(ml);
            this.add(botones[i]);
            x = 200;
            if (i == 1) {
                y = 200;
                x = 25;
            }
        }
    }



    @Override
    public void paint(Graphics g) {

        imagen = new ImageIcon(getClass().getResource("src/main/java/com/practica2/image/Fondo1.jpg")).getImage();
        if (imagen != null) {

            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
            this.setOpaque(false);

        } else {
            this.setOpaque(true);
        }
        super.paint(g);

    }

    private MouseListener ml = new MouseListener() {

        @Override
        public void mouseClicked(MouseEvent e) {

            if (e.getSource() == botones[0]) {
                if (botones[0].isEnabled()) {
                    if (Main.primeraVez) {
                        /// cargar archivo
                        CargarArchivo abrir = new CargarArchivo();
                        abrir.setVisible(true);
                        

                    }else {
                        /// desea cargar archivo 
                    }
                }
            }else if (e.getSource() == botones[1]) {
                if (botones[1].isEnabled()) {
                    
                    new ElegirNivel();
                }

                
            }else if(e.getSource() == botones[2]){
                if (botones[2].isEnabled()) {
                    TablaPunteo tablaPunteo= new TablaPunteo();                    

                }


            }else if(e.getSource() == botones[3]){
                if (botones[3].isEnabled()) {
                   TablaDeMpas a=   new TablaDeMpas(1);
                    new TablaDeMpas(2);
                    new TablaDeMpas(3);
                    
                }


            }
        }

        @Override
        public void mouseEntered(MouseEvent arg0) {
            System.out.println("");
        }

        @Override
        public void mouseExited(MouseEvent arg0) {
            System.out.println("");
        }

    
        @Override
        public void mouseReleased(MouseEvent arg0) {
         System.out.println("");
        }

        @Override
        public void mousePressed(MouseEvent arg0) {
            System.out.println("");
        }

        

    };

    public void agregarnombre(){
        
        botones[0].setText("NUEVA PARTIDA");    
        botones[1].setText("INICIAR PARTIDA");    
        botones[2].setText("ESTADISTICA");        
        botones[3].setText("COLECCION TABLEROS");        
    }
}
