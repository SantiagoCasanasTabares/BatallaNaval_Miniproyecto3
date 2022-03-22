package myProject;

import java.util.ArrayList;
import java.util.Random;

/**
 * Esta clase es usada para mcrear la s casillas del jugador humano
 * @author Santiago Casañas - santiago.casanas@correounivalle.edu.co - 2025301
 * @author Jesus Adrian Peña - jesus.guetio@correounivalle.edu.co - 2025513
 * @version v.1.0.0 date:21/03/2022
 */

public class JugadorHumano {
    private ArrayList<Barco> barcosJugador;
    private Casillas[][] casillasJugadorPosicion;
    private Random random;

    public JugadorHumano() {

        casillasJugadorPosicion = new Casillas[10][10];
        arrayBidCasillasJugador();
    }

    /**
     * crea la matriz de casillas asignandole un id y boolean inicial, para representar los disparos y lo que hay en cada casilla.
     * ademas, le establece una imagen inicial a cada casilla.
     */
    public void arrayBidCasillasJugador(){
        int posPanelposicion=0;

        for (int i=0; i < casillasJugadorPosicion.length; i++){
            for (int j=0; j < casillasJugadorPosicion.length; j++){
                casillasJugadorPosicion[i][j] = new Casillas(0, false);
                casillasJugadorPosicion[i][j].setPosicion(posPanelposicion);
                casillasJugadorPosicion[i][j].setIdImagen();
                posPanelposicion++;
            }
        }
    }


    /**
     * obtiene la matriz de casillas del jugador
     * @return matriz de casillas
     */
    public Casillas[][] getCasillasJugadorPosicion() {
        return casillasJugadorPosicion;
    }


}


