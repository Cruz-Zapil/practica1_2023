package com.practica2.juego.habilidadBomba;

import java.util.Random;

import com.practica2.listaMapa.Casilla;
import com.practica2.listaMapa.PintarCasilla;
import com.practica2.puntajes.GuardarPunteo;

public class Misil {
    private Casilla[][] pieza;
    private int largo;
    private int ancho;
    private Random random = new Random();

    public Misil(Casilla[][] pieza, int largo, int ancho, int y, int x) {

        this.pieza = pieza;
        this.largo = largo;
        this.ancho = ancho;

        int disparo = random.nextInt(4 - 1) + 1;
        elegirDisparo(disparo, y,x);
    }


    public void elegirDisparo(int numero , int posy, int posx) {

        switch (numero) {
            case 1:
            abajo(posy, posx);
                break;
            case 2:
            izquierda(posy, posx);
                break;
            case 3:
            derrecha(posy, posx);
                break;
            case 4:
            arriba(posy, posx);
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
            if (!pieza[posy + ny][posx].isRevelada()) {
                // int xx = ()-posx;
                localizandoTipo(pieza[posy + ny][posx].getTipoFicha(), posy + ny, posx);
                ny++;
            } else {
                break;
            }
        } while ((ny + posy) < largo);
    }

    public void izquierda(int posy, int posx) {
        int nx = 0;

        do {
            if (!pieza[posy][posx + nx].isRevelada()) {
                // int xx = ()-posx;
                localizandoTipo(pieza[posy][posx + nx].getTipoFicha(), posy, posx + nx);
                nx++;
            } else {
                break;
            }
        } while ((nx + posx) >= 0);
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
        new GuardarPunteo(40);

    }

    public void pintarBarco2(int posy, int posx) {

        pieza[posy][posx].setIcon(new PintarCasilla().pintarBarco());
        pieza[posy][posx].setRevelada(true);
        new GuardarPunteo(100);

    }

    public void pintarBarco3(int posy, int posx) {

        pieza[posy][posx].setIcon(new PintarCasilla().pintarBarco());
        pieza[posy][posx].setRevelada(true);
        new GuardarPunteo(40);

    }

    public void pintarBomba(int posy, int posx) {

        pieza[posy][posx].setIcon(new PintarCasilla().pintarBomba());
        pieza[posy][posx].setRevelada(true);
        new GuardarPunteo(25);
    }

}
