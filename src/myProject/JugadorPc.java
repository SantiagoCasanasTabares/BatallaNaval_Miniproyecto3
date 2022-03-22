package myProject;

import java.util.ArrayList;
import java.util.Random;

/**
 * Esta clase es usada para crear las casillas del jugador pc y posicionar sus barcos
 * @author Santiago Casañas - santiago.casanas@correounivalle.edu.co - 2025301
 * @author Jesus Adrian Peña - jesus.guetio@correounivalle.edu.co - 2025513
 * @version v.1.0.0 date:21/03/2022
 */

public class JugadorPc {
    private Barco barco1, barco2, barco3, barco4, barco5, barco6, barco7, barco8, barco9, barco10;
    private ArrayList<Barco> barcos;
    private Casillas[][] casillasPc;
    private Random random;
    private int numBarco = 0;


    public JugadorPc() {
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

        random = new Random();

        casillasPc = new Casillas[10][10];
        arrayBidCasillas();
        posicionarBarcos();
    }

    /**
     * crea la matriz de casillas asignandole un id y boolean inicial, para representar los disparos y lo que hay en cada casilla.
     * ademas, le establece una imagen inicial a cada casilla.
     */
    public void arrayBidCasillas(){
        int posicion=0;

        for (int i=0; i < casillasPc.length; i++){
            for (int j=0; j < casillasPc.length; j++){
                casillasPc[i][j] = new Casillas(0, false);
                casillasPc[i][j].setPosicion(posicion);
                casillasPc[i][j].setIdImagen();
                posicion++;
            }
        }
    }


    /**
     * Acomoda aleatoriamente los barcos del jugador pc de manera horizontal
     */

    public void ponerEnFilas(){
        numBarco = 0;
        int fila = 0;

        while (numBarco < 10){

            int casillas = barcos.get(numBarco).getCasillasPorBarco();
            int columna = 0;

            switch (casillas){
                case 1: columna = random.nextInt(10);
                    break;
                case 2: columna = random.nextInt(9);
                    break;
                case 3: columna = random.nextInt(8);
                    break;
                case 4: columna = random.nextInt(7);
                    break;
            }

            /**
             * necesitamos un for que convierta el 0 del idBarco de la casilla a su identidicador
             */

            for (int vidaBarco = barcos.get(numBarco).getCasillasPorBarco();vidaBarco > 0 ; vidaBarco--){
                if (casillas==4){
                    casillasPc[fila][columna].setIdbarco(4);
                    columna++;
                }else if (casillas==3){
                    casillasPc[fila][columna].setIdbarco(3);
                    columna++;
                }else if (casillas==2){
                    casillasPc[fila][columna].setIdbarco(2);
                    columna++;
                }else{
                    casillasPc[fila][columna].setIdbarco(1);
                    columna++;
                }
            }

            fila++;
            numBarco++;

        }
    }


    /**
     *
     * Acomoda los barcos del pc de manera aleatoria en vertical
     */
    public void ponerEnColumnas(){
        numBarco = 0;
        int columna = 0;

        while (numBarco < 10){

            int casillas = barcos.get(numBarco).getCasillasPorBarco();
            int fila = 0;

            switch (casillas){
                case 1: fila = random.nextInt(10);
                    break;
                case 2: fila = random.nextInt(9);
                    break;
                case 3: fila = random.nextInt(8);
                    break;
                case 4: fila = random.nextInt(7);
                    break;
            }

            /**
             * necesitamos un for que convierta el 0 del idBarco de la casilla a su identidicador
             */

            for (int vidaBarco = barcos.get(numBarco).getCasillasPorBarco();vidaBarco > 0 ; vidaBarco--){
                if (casillas==4){
                    casillasPc[fila][columna].setIdbarco(4);
                    fila++;
                }else if (casillas==3){
                    casillasPc[fila][columna].setIdbarco(3);
                    fila++;
                }else if (casillas==2){
                    casillasPc[fila][columna].setIdbarco(2);
                    fila++;
                }else{
                    casillasPc[fila][columna].setIdbarco(1);
                    fila++;
                }
            }

            columna++;
            numBarco++;

        }
    }


    /**
     * Acomoda los barcos del jugador pc de manera alatoria en la matriz de casilla, ya sea en horizontal o vertical
     */
    public void posicionarBarcos() {
        int orientacion = random.nextInt(2);

        if (orientacion == 0) {
            ponerEnColumnas();
        } else {
            ponerEnFilas();
        }
    }


    /**
     * obtiene las casillas del jugador pc
     * @return casillas del pc
     */
    public Casillas[][] getBarcosPc() {
        return casillasPc;
    }


}



