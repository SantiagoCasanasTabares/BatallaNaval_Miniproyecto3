package myProject;

import java.util.ArrayList;
import java.util.Random;

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
    }

    public void arrayBidCasillas(){
        int posicion=0;

        for (int i=0; i < casillasPc.length; i++){
            for (int j=0; j < casillasPc.length; j++){
                casillasPc[i][j] = new Casillas(0, false);
                casillasPc[i][j].setPosicion(posicion);
                casillasPc[i][j].setIdImagen();
                /*casillasPc[i][j].setX(x);
                casillasPc[i][j].setY(y);
                y++;*/
                posicion++;
            }
            //y=0;
           //x++;
        }
    }


    public int[]  posicionDelElemento (Casillas[][] matriz, int numero){

        int[][] posiciones = new int[10][10];

        for (int k=0; k < posiciones.length; k++) {
            for (int l = 0; l < posiciones.length; l++) {
                posiciones[k][l] = matriz[k][l].getPosicion();
            }
        }

        int[] posicion=new int[2];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {

                if(matriz[i][j].getPosicion()==numero){
                    posicion[0]=i;
                    posicion[1]=j;
                }
            }
        }
        return posicion;
    }

    /**
     * genera una coordenada aleatoria y marcaesa posicion como true para
     * recordar que ahí ya hubo un disparo, en caso de haber un disparo previo
     * realiza la instrucción de nuevo.
     */
    public void disparar(){
        int pcX, pcY;
        do {
            pcX = random.nextInt(10);
            pcY = random.nextInt(10);
            casillasPc[pcX][pcY].setDisparo(true);
        }while (casillasPc[pcX][pcY].isDisparo() != true);



    }


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


    public void posicionarBarcos(){
        int orientacion = random.nextInt(2);

        if (orientacion==0){
            ponerEnColumnas();
        }else{
            ponerEnFilas();
        }
    }


    /**
     * Falta el metodo para saber que se recibió un disparo y asi cambiar la imagen
     * @return
     */


    public Casillas[][] getBarcosPc() {
        return casillasPc;
    }


    public ArrayList<Barco> getBarcos() {
        return barcos;
    }


    public void mostrar(){
        for (int x=0; x < casillasPc.length; x++){
            for (int y=0; y < casillasPc[x].length; y++)
                System.out.print(" | " + casillasPc[x][y].getIdbarco()+ " | ");
            System.out.println("\n--------------------------------------------------------------");
        }
    }

    public void mostrarPos(){
        for (int x=0; x < casillasPc.length; x++){
            for (int y=0; y < casillasPc[x].length; y++)
                System.out.print(" | " + casillasPc[x][y].getPosicion()+" | ");
            System.out.println("\n--------------------------------------------------------------");
        }
    }

    public void mostrarDisparos(){
        for (int x=0; x < casillasPc.length; x++){
            for (int y=0; y < casillasPc[x].length; y++)
                System.out.print(" | " + casillasPc[x][y].isDisparo()+ " | ");
            System.out.println("\n--------------------------------------------------------------");
        }
    }

    public int getNumBarco() {
        return numBarco;
    }
}



