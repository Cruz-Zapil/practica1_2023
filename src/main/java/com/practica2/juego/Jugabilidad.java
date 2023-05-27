package com.practica2.juego;

import java.awt.event.MouseListener;
import java.util.Random;

import com.practica2.juego.habilidadBomba.Misil;
import com.practica2.juego.habilidadBomba.Torpedo;
import com.practica2.listaMapa.Casilla;

public class Jugabilidad implements MouseListener {

    private Casilla[][] pieza;
    private Casilla[] botones;
    public int punteo=0;
    private int clicks = 0;
    private int puntos = 0;
    private Random random = new Random();
    private int ancho, largo;
    private int bracos;

    public Jugabilidad(Casilla[][] casilla, Casilla[] botones, int x, int y) {
        pieza = casilla;
        this.botones = botones;
        this.ancho = x;
        this.largo = y;
    }

    public Jugabilidad() {

    }

    public boolean bombaElegida = false;
    public int tipoBombaElegida = 0;

    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {

        if (bombaElegida == false) {

            for (int i = 0; i < botones.length; i++) {
                if (e.getSource() == botones[i]) {
                    if (botones[i].getCantidad() > 0) {
                        tipoBombaElegida = botones[i].getTipoBomba();
                        System.out.print(" eligiendo tipo: " + tipoBombaElegida);
                        botones[i].setCantidad(1);
                        bombaElegida = true;
                    } else {
                        System.out.println(" ya no le queda invetario");
                    }
                } else if (i == botones.length - 1) {
                    break;
                }
            }

        } else {
            System.out.println(" tiene seleccionado una bomba, usa primero  ");
        }

        if (bombaElegida) {

            for (int i = 0; i < largo; i++) {
                for (int j = 0; j < ancho; j++) {
                    if (e.getSource() == pieza[i][j]) {
                        if (!pieza[i][j].isRevelada()) {
                            System.out.println(" x: " + j + " y: " + i);
                            usandoBomba(tipoBombaElegida, i, j);
                            System.out.println("\n\n usando tipo bomba: " + tipoBombaElegida);
                            System.out.println(pieza[i][j].getTipoFicha());
                            clicks++;
                            bombaElegida = false;
                            break;
                        } else {
                            System.out.println(" ya fue revelada esta casiila elige otra");
                        }
                    }
                }
            }
        }
    }

   

    public void usandoBomba(int tipo, int posy, int posx) {

        switch (tipo) {

            case 0:
                break;
            case 1:
            new Torpedo(pieza, largo, ancho,posy, posx);
          //  System.out.println("x : "+ posy + " y "+ posx);
                break;
            case 2:
            new Misil(pieza, largo,ancho, posy, posx);
                break;
            case 3:
                break;
            default:
                System.out.println(" algo fallo ");
                break;
        }
    }

   
 /*
 

    public void bomba(int posy, int posx) {

        System.out.println("*");
        pieza[posy][posx].setIcon(new PintarCasilla().pintarBomba());
        pieza[posy][posx].setRevelada(true);

    }

    public void bMisil(int posy, int posx) {

        System.out.println("misil");
        pieza[posy][posx].setIcon(new PintarCasilla().pintarBomba());
        pieza[posy][posx].setRevelada(true);
    }

    public void opcionMisil(int opcion, int posx, int posy) {

        // arriba(posx, posy);
        switch (opcion) {
            case 1:
                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
        }
    }

    public void arriba(int posy, int posx) {

        int ny = 0;
        do {
            if (!pieza[posy + ny][posx].isRevelada()) {
                // int xx = ()-posx;
                localizandoTipo(pieza[posy + ny][posx].getTipoFicha(), posy + ny, posx);
                ny--;
            } else {
                break;
            }
        } while ((ny + posy) < largo);
    }

    public void derrecha(int posy, int posx) {
        int nx = 0;
        do {
            if (!pieza[posy][posx + nx].isRevelada()) {
                // int xx = ()-posx;
                localizandoTipo(pieza[posy][posx + nx].getTipoFicha(), posy, posx + nx);
                nx++;                
            } else {
                break;
            }
        } while ((nx + posx) < ancho);
    }

    public void abajo(int posy, int posx) {   
        int ny = 0;
        do {
            if (!pieza[posy + ny][posx ].isRevelada()) {
                // int xx = ()-posx;
                localizandoTipo(pieza[posy + ny][posx ].getTipoFicha(), posy + ny, posx );
                ny++;
            } else {
                break;
            }
        } while ( (ny + posy) < largo);
    }

    public void izquierda(int posy, int posx) {
        int nx = 0;
   
        do {
            if (!pieza[posy ][posx + nx].isRevelada()) {
                // int xx = ()-posx;
                localizandoTipo(pieza[posy ][posx + nx].getTipoFicha(), posy , posx + nx);
                nx++;
            } else {
                break;
            }
        } while ((nx + posx) >= 0 );
    }

*/

   

    @Override
    public void mouseEntered(java.awt.event.MouseEvent arg0) {
    }

    @Override
    public void mouseExited(java.awt.event.MouseEvent arg0) {
    }

    @Override
    public void mousePressed(java.awt.event.MouseEvent arg0) {
    }

    @Override
    public void mouseReleased(java.awt.event.MouseEvent arg0) {
    }

}
