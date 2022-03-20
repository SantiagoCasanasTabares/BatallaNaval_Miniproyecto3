package myProject;

import java.util.ArrayList;
import java.util.Random;

public class JugadorHumano {
    private Barco barco1, barco2, barco3, barco4, barco5, barco6, barco7, barco8, barco9, barco10;
    private ArrayList<Barco> barcosJugador;
    private Casillas[][] casillasJugadorPosicion, casillasJugadorPrincipal;
    private Random random;

    public JugadorHumano() {
        barcosJugador = new ArrayList<>();
        barco1 = new Barco("p");
        barcosJugador.add(barco1);
        barco2 = new Barco("s");
        barcosJugador.add(barco2);
        barco3 = new Barco("s");
        barcosJugador.add(barco3);
        barco4 = new Barco("d");
        barcosJugador.add(barco4);
        barco5 = new Barco("d");
        barcosJugador.add(barco5);
        barco6 = new Barco("d");
        barcosJugador.add(barco6);
        barco7 = new Barco("f");
        barcosJugador.add(barco7);
        barco8 = new Barco("f");
        barcosJugador.add(barco8);
        barco9 = new Barco("f");
        barcosJugador.add(barco9);
        barco10 = new Barco("f");
        barcosJugador.add(barco10);
        random = new Random();

        casillasJugadorPosicion = new Casillas[10][10];
        casillasJugadorPrincipal = new Casillas[10][10];
        arrayBidCasillasJugador();
    }

    public void arrayBidCasillasJugador(){
        int posPanelposicion=0;
        int posPanelPrincipal=0;

        for (int i=0; i < casillasJugadorPosicion.length; i++){
            for (int j=0; j < casillasJugadorPosicion.length; j++){
                casillasJugadorPosicion[i][j] = new Casillas(0, false);
                casillasJugadorPosicion[i][j].setPosicion(posPanelposicion);
                casillasJugadorPosicion[i][j].setIdImagen();
                posPanelposicion++;
            }
        }

        for (int i=0; i < casillasJugadorPrincipal.length; i++){
            for (int j=0; j < casillasJugadorPrincipal.length; j++){
                casillasJugadorPrincipal[i][j] = new Casillas(0, false);
                casillasJugadorPrincipal[i][j].setPosicion(posPanelPrincipal);
                casillasJugadorPrincipal[i][j].setIdImagen();
                posPanelPrincipal++;
            }
        }
    }


    /**
     * genera una coordenada aleatoria y marca esa posicion como true para
     * recordar que ahí ya hubo un disparo, en caso de haber un disparo previo
     * realiza la instrucción de nuevo, simulando el disparo del pc.
     */
    public void disparar(){
        int pcX, pcY;
        do {
            pcX = random.nextInt(10);
            pcY = random.nextInt(10);
            casillasJugadorPosicion[pcX][pcY].setDisparo(true);
        }while (casillasJugadorPosicion[pcX][pcY].isDisparo() != true);

        casillasJugadorPosicion[pcX][pcY].cambiarNumero();
        casillasJugadorPosicion[pcX][pcY].setIdImagen();

    }


    public int getIdBarcoJugador(Barco barcoJugador) {
        return barcoJugador.getCasillasPorBarco();
    }


    public ArrayList<Barco> getBarcosJugador() {
        return barcosJugador;
    }

    public void setBarcosJugador(ArrayList<Barco> barcosJugador) {
        this.barcosJugador = barcosJugador;
    }


    public Casillas[][] getCasillasJugadorPosicion() {
        return casillasJugadorPosicion;
    }
}
