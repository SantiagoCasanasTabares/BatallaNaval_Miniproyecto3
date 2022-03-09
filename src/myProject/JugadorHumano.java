package myProject;

import java.util.ArrayList;

public class JugadorHumano {
    private Barco barco1, barco2, barco3, barco4, barco5, barco6, barco7, barco8, barco9, barco10;
    private ArrayList<Barco> barcosJugador;
    private Casillas[][] casillasJugador;

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

        casillasJugador = new Casillas[10][10];
        arrayBidCasillasJugador();
    }

    public void arrayBidCasillasJugador(){
        int x=0, y=0;

        for (int i=0; i < casillasJugador.length; i++){
            for (int j=0; j < casillasJugador.length; j++){
                casillasJugador[i][j] = new Casillas(0, false);
                casillasJugador[i][j].setX(x);
                casillasJugador[i][j].setY(y);
                y++;
            }
            y=0;
            x++;
        }
    }




}
