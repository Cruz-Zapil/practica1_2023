package com.practica2.juego.habilidadBomba;

import java.util.Random;
import com.practica2.listaMapa.Casilla;
import com.practica2.listaMapa.PintarCasilla;
import com.practica2.puntajes.GuardarPunteo;

public class Torpedo {

    private Casilla[][] pieza;
    private int largo;
    private int ancho;
    private Random random = new Random();

    public Torpedo(Casilla[][] pieza, int largo, int ancho, int y, int x) {

        this.pieza = pieza;
        this.largo = largo;
        this.ancho = ancho;

        int disparo = random.nextInt(4 - 1) + 1;
        elegirDisparo(disparo, y,x);

    }

    public void elegirDisparo(int numero , int posy, int posx) {

        switch (numero) {
            case 1:
            abajoDerecha(posy, posx);
                break;
            case 2:
            abajoIzquierda(posy, posx);
                break;
            case 3:
            arribaDerecha(posy, posx);
                break;
            case 4:
            arribaIzquierda(posy, posx);
            break;
        }

    }

    public boolean abajoDerecha(int posy, int posx) {
        //// se resta la X y se suma la Y " el limite es la x"
        int nx = 0, ny = 0;
        do {
            if (!pieza[posy + ny][posx + nx].isRevelada()) {
                localizandoTipo(pieza[posy + ny][posx + nx].getTipoFicha(), posy + ny, posx + nx);
                nx++;
                ny++;
            } else {
                break;
            }
        } while ((nx + posx) < ancho && (ny + posy) < largo);
        return true;
    }

    public void arribaDerecha(int posy, int posx) {
        //// se resta la X y se suma la Y " el limite es la x"
        int nx = 0;
        int ny = 0;
        do {
            if (!pieza[posy + ny][posx + nx].isRevelada()) {
                // int xx = ()-posx;
                localizandoTipo(pieza[posy + ny][posx + nx].getTipoFicha(), posy + ny, posx + nx);
                nx++;
                ny--;
            } else {
                break;
            }
        } while ((nx + posx) < ancho && (ny + posy) >= 0);
    }

    public void arribaIzquierda(int posy, int posx) {
        //// se resta la X y se suma la Y " el limite es la x"
        int nx = 0;
        int ny = 0;
        do {
            if (!pieza[posy + ny][posx + nx].isRevelada()) {
                // int xx = ()-posx;
                localizandoTipo(pieza[posy + ny][posx + nx].getTipoFicha(), posy + ny, posx + nx);
                nx--;
                ny--;
            } else {
                break;
            }
        } while ((nx + posx) >= 0 && (ny + posy) >= 0);
    }

    public void abajoIzquierda(int posy, int posx) {
        //// se resta la X y se suma la Y " el limite es la x"
        int nx = 0;
        int ny = 0;
        do {
            if (!pieza[posy + ny][posx + nx].isRevelada()) {
                // int xx = ()-posx;
                localizandoTipo(pieza[posy + ny][posx + nx].getTipoFicha(), posy + ny, posx + nx);
                nx--;
                ny++;
            } else {
                break;
            }
        } while ((nx + posx) >= 0 && (ny + posy) < largo);
    }

    public void localizandoTipo(String logo, int posy, int posx) {
        switch (logo) {
            case "~":
                pieza[posy][posx].setIcon(new PintarCasilla().pintarAgua());
                pieza[posy][posx].setRevelada(true);

                break;

            case "B1":
                pintarBarco1(posy, posx);
                break;

            case "B2":
                pintarBarco2(posy, posx);
                break;

            case "B3":
                pintarBarco3(posy, posx);
                break;

            case "T":
                pintarBomba(posy, posx);
                break;

            case "I":
                pintarBomba(posy, posx);
                break;

            case "O":
                pintarBomba(posy, posx);
                break;

        }
    }

    public void pintarBarco1(int posy, int posx) {
        pieza[posy][posx].setIcon(new PintarCasilla().pintarBarco());
        pieza[posy][posx].setRevelada(true);
        new GuardarPunteo(100);

    }

    public void pintarBarco2(int posy, int posx) {
        pieza[posy][posx].setIcon(new PintarCasilla().pintarBarco());
        pieza[posy][posx].setRevelada(true);
        new GuardarPunteo(40);
    }

    public void pintarBarco3(int posy, int posx) {
        pieza[posy][posx].setIcon(new PintarCasilla().pintarBarco());
        pieza[posy][posx].setRevelada(true);
        new GuardarPunteo(25);
    }

    public void pintarBomba(int posy, int posx) {
        pieza[posy][posx].setIcon(new PintarCasilla().pintarBomba());
        pieza[posy][posx].setRevelada(true);
    }

}
