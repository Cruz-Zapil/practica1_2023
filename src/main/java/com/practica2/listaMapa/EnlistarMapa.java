package com.practica2.listaMapa;

import com.practica2.archivos.LogicaArchivos;

public class EnlistarMapa {

    private String[] listaMapa;
   // private String rutaFichero = "src//main//java//com//practica2//ficheros//mapas.th";

    private LogicaArchivos miArchivo = new LogicaArchivos();

    public void mapasCargadas() {
        /// seleccionamos el archivo
        String lista = new LogicaArchivos().leerArchivosIterior("mapas.th");

        // dividimos el archivo
        listaMapa = lista.split("tablero");

        /// recorremos todo el arrego

        for (int i = 1; i < listaMapa.length; i++) {
            /// descomponemos el arvhivo seleccionado
            String[] mapaDesco = listaMapa[i].split("\n");
            char[] primerLinea = mapaDesco[1].toCharArray();

            /// almacena la dimesion del mapa
            String dimension = "";

            for (int j = 0; j < primerLinea.length; j++) {
                if (Character.isDigit(primerLinea[j])) {
                    dimension += primerLinea[j];
                }
                if (primerLinea[j] == 'x' || primerLinea[j] == 'X') {
                    dimension += primerLinea[j];
                }
            }
            String[] dimensiones = dimension.split("X");
            String x, y;
            x = dimensiones[0];
            y = dimensiones[1];
            int xx = Integer.valueOf(x);
            int yy = Integer.valueOf(y);

            if ((xx * yy) <= 36) {

                miArchivo.escribirArchivo(listaMapa[i], "nivel1//nivel1.th",true);
                System.out.print(listaMapa[i]);

            } else if ((xx * yy) > 36 && (xx * yy) <= 64) {

                miArchivo.escribirArchivo(listaMapa[i], "nivel2//nivel2.th",true);
            } else if ((xx * yy) > 64) {
                miArchivo.escribirArchivo(listaMapa[i], "nivel3//nivle3.th",true);
            }
        }

    }



    private String[] listaMapaNivel;
    private String[][] atributos;
    private String[] listaDeMapasDivididas;
    String dimension = "";
    int barco = 0;
    int misil = 0;
    int torpedo = 0;
    int hecatombe = 0;
    int numeroMapas;

    public void leerMapasNivel(String nivel) {

        /// seleccionamos el archivo
        listaMapaNivel = new LogicaArchivos().leerArchivosIterior("nivel"+nivel+"/nivel"+nivel+".th").split("<<");
        listaDeMapasDivididas = new String[listaMapaNivel.length];
        numeroMapas=listaMapaNivel.length;
        atributos = new String[listaMapaNivel.length][6];

        for (int i = 1; i < listaMapaNivel.length; i++) {

            dimension = "";
            barco = 0;
            misil = 0;
            torpedo = 0;
            hecatombe = 0;
            System.out.println(listaMapaNivel[i]);

            String[] mapaDesco = listaMapaNivel[i].split("\n");
            

            char[] primerLinea = mapaDesco[1].toCharArray();
           

            /// almacena la dimesion del mapa

            for (int j = 0; j < primerLinea.length; j++) {
                if (Character.isDigit(primerLinea[j])) {
                    dimension += primerLinea[j];
                }
                if (primerLinea[j] == 'x' || primerLinea[j] == 'X') {
                    dimension += primerLinea[j];
                }
            }

            for (int j2 = 2; j2 < mapaDesco.length; j2++) {

                char[] auxi = mapaDesco[j2].toCharArray();
                for (int z = 0; z < auxi.length; z++) {
                    analisis(auxi[z]);
                }
            }

            atributos[i][0] = "1";
            atributos[i][1] = dimension;
            atributos[i][2] = String.valueOf(barco);
            atributos[i][3] = String.valueOf(misil);
            atributos[i][4] = String.valueOf(torpedo);
            atributos[i][5] = String.valueOf(hecatombe);

        }

    }

    public void analisis(char auxi) {
        switch (auxi) {
            case 'B':
                barco++;
                break;
            case 'T':
                torpedo++;
                break;
            case 'I':
                misil++;
                break;
            case 'O':
                hecatombe++;
                break;
            default:
        }
    }



    public int numeroMapa(){
        return numeroMapas;
    }

    public String[][] getAtributos() {
        return atributos;
    }

    public String getMapa(int numero){

        return listaMapaNivel[numero];
        
    }

}
