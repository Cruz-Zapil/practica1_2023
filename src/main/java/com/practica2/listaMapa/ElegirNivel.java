package com.practica2.listaMapa;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class ElegirNivel extends JFrame {

    private JButton nivel1,nivel2,nivel3;

    public ElegirNivel(){
    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    this.setTitle(" Elija nivel");
    this.setBounds(400, 400, 300,200);

    this.setLayout(new FlowLayout(FlowLayout.CENTER,50,50));
    agregarComponente();

    this.setResizable(false);
    this.setVisible(true);
    }

    public void agregarComponente(){
        nivel1 = new JButton("nivel 1");
        nivel2 = new JButton("nivel 2");
        nivel3 = new JButton("nivel 3");
        nivel1.addMouseListener(ml);
        nivel2.addMouseListener(ml);
        nivel3.addMouseListener(ml);
        add(nivel1);
        add(nivel2);
        add(nivel3);
    }



    private MouseListener ml = new MouseListener() {        
        @Override
        public void mouseClicked(MouseEvent eve) {
            
            if (eve.getSource() == nivel1) {
                new TablaDeMpas(1);
                
            }else if(eve.getSource() == nivel2){
                new TablaDeMpas(2);

            }else if( eve. getSource() == nivel3){
                new TablaDeMpas(3);

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
