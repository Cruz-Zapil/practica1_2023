package com.practica2.listaMapa;

import java.awt.Dimension;
import javax.swing.JButton;

public class Casilla extends JButton {

    // private boolean activo;
    // private int tipoFicha;
    private boolean desactivado;
    private int fila, columan;

    private int id;
    private int alrededor;
    private boolean revelada = false;
    private int tamanio;
    private int coordenadaX = -1;
    private int coordenadaY = -1;
    private boolean bomb = false;
    private String tipoFicha;

    ////// 
    private int cantidad;
    private int tipoBomba;


    public Casilla(int tamanio, int id, int coordenadaX, int coordenadaY, String tipoFicha, Boolean revelada) {
        this.id = id;
        this.setPreferredSize(new Dimension(tamanio, tamanio));
        this.tamanio = tamanio;
        this.alrededor = 0;
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
        this.tipoFicha = tipoFicha;
        this.revelada = revelada;
        // cambiarIcono(Casilla.LLAMA, true);
        // this.setBackground(Color.blue);
      //  usarIcon();
        this.setBorderPainted(false);
    }

 /*   public void usarIcon(){
        this.setIcon(new PintarCasilla().pintarAgua());  
    }*/

    public Casilla(int id, int tamaniox , int tamanioy, int cantidad, int tipoBomba, String text){
        this.id = id;
        this.setPreferredSize(new Dimension(tamaniox, tamanioy));
        this.cantidad = cantidad;
        this.tipoBomba = tipoBomba;
        setText(text);
        

    }
    
 
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad  -= cantidad;
    }

    public int getTipoBomba() {
        return tipoBomba;
    }

    public void setTipoBomba(int tipoBomba) {
        this.tipoBomba = tipoBomba;
    }

    public boolean isDesactivado() {
        return desactivado;
    }

    public void setDesactivado(boolean desactivado) {
        this.desactivado = desactivado;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColuman() {
        return columan;
    }

    public void setColuman(int columan) {
        this.columan = columan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAlrededor() {
        return alrededor;
    }

    public void setAlrededor(int alrededor) {
        this.alrededor = alrededor;
    }

    public boolean isRevelada() {
        return revelada;
    }

    public void setRevelada(boolean revelada) {
        this.revelada = revelada;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }

    public int getCoordenadaX() {
        return coordenadaX;
    }

    public void setCoordenadaX(int coordenadaX) {
        this.coordenadaX = coordenadaX;
    }

    public int getCoordenadaY() {
        return coordenadaY;
    }

    public void setCoordenadaY(int coordenadaY) {
        this.coordenadaY = coordenadaY;
    }

    public boolean isBomb() {
        return bomb;
    }

    public void setBomb(boolean bomb) {
        this.bomb = bomb;
    }

    public String getTipoFicha() {
        return tipoFicha;
    }

    public void setTipoFicha(String tipoFicha) {
        this.tipoFicha = tipoFicha;
    }

    /*
     * public void cambiarIcono(String rutaImagen, boolean inicio) throws
     * IOException {
     * BufferedImage myPicture = ImageIO.read(new File(rutaImagen));
     * Image newimg = myPicture.getScaledInstance(tamanio, tamanio,
     * java.awt.Image.SCALE_SMOOTH);
     * if (inicio) {
     * super.setIcon(new ImageIcon(newimg));
     * super.setEnabled(true);
     * super.revalidate();
     * super.repaint();
     * } else {
     * super.setEnabled(true);
     * if (revelada) {
     * if (alrededor != 0) {
     * super.setText(alrededor + "");
     * super.setHorizontalTextPosition(SwingConstants.CENTER);
     * // super.setFont(new Font("Arial", Font.PLAIN, (int) (tamanio * 0.8)));
     * }
     * if (!bomb) {
     * super.setEnabled(false);
     * }
     * }
     * super.setIcon(new ImageIcon(newimg));
     * super.revalidate();
     * super.repaint();
     * }
     * }
     */

     
}
