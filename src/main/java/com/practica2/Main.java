package com.practica2;
import javax.swing.JFrame;

/**
 * Hello world!
 *
 */
public class Main extends JFrame {


  private Panel tablero;
  public static boolean primeraVez = true;

  public static void main(String args[]) {


    Main a = new Main();
    a.ventana();
  }

  public void ventana() {

    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setTitle(" Practiva 1");
    this.setBounds(400, 400, 375, 400);

    this.setLayout(null);

    tablero = new Panel();
    this.setContentPane(tablero);

   // this.add(tablero);

   
    this.setResizable(false);
    this.setVisible(true);
  }


}
