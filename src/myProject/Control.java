package myProject;

import java.util.ArrayList;
import java.util.Random;

/**
 * Esta clase es usada para manejar toda la logica del juego
 * @author Santiago Casañas - santiago.casanas@correounivalle.edu.co - 2025301
 * @author Jesus Adrian Peña - jesus.guetio@correounivalle.edu.co - 2025513
 * @version v.1.0.0 date:21/03/2022
 */

public class Control {
    private Barco barco1, barco2, barco3, barco4, barco5, barco6, barco7, barco8, barco9, barco10;
    private int vidaPc, vidaHumano, estado;
    private String[] mensajeFinal;
    private Casillas[][] casillasHumano, casillasPc;
    private ArrayList<Barco> barcos;
    private JugadorHumano humano;
    private JugadorPc pc;
    private Random random;

    public Control(){
        barcos = new ArrayList<>();
        barco1 = new Barco("p");
        barcos.add(barco1);
        barco2 = new Barco("s");
        barcos.add(barco2);
        barco3 = new Barco("s");
        barcos.add(barco3);
        barco4 = new Barco("d");
        barcos.add(barco4);
        barco5 = new Barco("d");
        barcos.add(barco5);
        barco6 = new Barco("d");
        barcos.add(barco6);
        barco7 = new Barco("f");
        barcos.add(barco7);
        barco8 = new Barco("f");
        barcos.add(barco8);
        barco9 = new Barco("f");
        barcos.add(barco9);
        barco10 = new Barco("f");
        barcos.add(barco10);


        vidaHumano = 20;
        vidaPc = 20;
        mensajeFinal = new String[1];

        pc = new JugadorPc();
        humano = new JugadorHumano();

        casillasHumano = new Casillas[10][10];
        casillasPc = new Casillas[10][10];

        random = new Random();

    }

    /**
     * disminuye la vida del jugador pc
     */
    public void restarVidaPc(){
        vidaPc--;
    }

    /**
     *
     * disminuye la vida del jugador humano
     */
    public void restarVidaHumano(){
        vidaHumano--;
    }

    /**
     * determina el estado de juego, dependiendo de las vidas de los jugadores
     * @return estado del juego
     */
    public int detertminarEstado(){
        if (vidaPc==0){
            estado = 1;
        }else if (vidaHumano==0){
            estado = 2;
        }
        return estado;
    }

    /**
     * setter de casillas del jugador
     */
    public void setCasillasHumano() {
        this.casillasHumano = humano.getCasillasJugadorPosicion();
    }

    /**
     * obtiene las casillas del jugador
     * @return casillas del jugador
     */
    public Casillas[][] getCasillasHumano() {
        return casillasHumano;
    }

    /**
     * obtiene las casillas del pc
     * @return casillas del pc
     */
    public Casillas[][] getCasillasPc() {
        return casillasPc;
    }

    /**
     * setter de casillas del pc
     */
    public void setCasillasPc() {
        this.casillasPc = pc.getBarcosPc();
    }




    /**
     * setter de barcos
     * @param barcosJugador
     */
    public void setBarcosJugador(ArrayList<Barco> barcosJugador) {
        this.barcos = barcosJugador;
    }

    /**
     * getter de barcos
     * @return barcos
     */
    public ArrayList<Barco> getBarcos() {
        return barcos;
    }

    /**
     * recibe un objeto de tipo barco y devuelve el numero de casillas que ocupa ese barco
     * @param barcoJugador
     * @return casillas que ocupa el barco
     */
    public int casillasPorBarco(Barco barcoJugador) {
        return barcoJugador.getCasillasPorBarco();
    }

    /**
     * Muestra un mensaje al final de la partida dependiendo de quien fue el ganador
     * @param status
     * @return mensaje final
     */
    public String[] getMensajeFinal(int status){
        switch (status) {
            case 1: mensajeFinal[0] = "Destruiste todos los barcos del "
                                      +"\nPC, ¡¡felicidades, ganaste!!";
            break;
            case 2: mensajeFinal[0] = "El PC ha destruido tus barcos, perdiste. "
                                     +"\nPero puedes volver a jugar.";
        }
        return mensajeFinal;
    }

    /**
     * genera una coordenada aleatoria y marca esa posicion como true para
     * recordar que ahí ya hubo un disparo, en caso de haber un disparo previo
     * realiza la instrucción de nuevo, simulando el disparo del pc.
     */
    public void disparar(){
        int pcX, pcY, i=0;

        while (i<1){
            pcX = random.nextInt(10);
            pcY = random.nextInt(10);
            if (casillasHumano[pcY][pcX].isDisparo() == false){
                casillasHumano[pcX][pcY].setDisparo(true);
                System.out.println("vida en juego"+getVidaHumano());
                casillasHumano[pcX][pcY].cambiarNumero();
                casillasHumano[pcX][pcY].setIdImagen();
                System.out.println(pcX+", "+pcY);

                if (casillasHumano[pcY][pcX].getIdbarco()!=0){
                    restarVidaHumano();
                    System.out.println("vida en juego"+getVidaHumano());
                }

                i++;

            }else{
                casillasHumano[pcX][pcY].setDisparo(true);
            }
        }


    }



    /**
     * getter vida del humano
     * @return vida del humano
     */
    public int getVidaHumano() {
        return vidaHumano;
    }


    /**
     * setter del estado del juego
     * @param estado
     */
    public void setEstado(int estado) {
        this.estado = estado;
    }
}
