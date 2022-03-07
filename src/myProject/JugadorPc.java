package myProject;

import java.util.Random;

public class JugadorPc {
    private int[][] barcosPc;
    private boolean[][] disparosPc;


    public JugadorPc() {
        barcosPc = new int[10][10];
        disparosPc = new boolean[10][10];
        arrayDisparos();
    }

    public void arrayDisparos(){
        for (int i=0; i < disparosPc.length; i++){
            for (int j=0; j < disparosPc.length; j++){
                disparosPc[i][j]=false;
            }
        }
    }


    /**
     * genera una coordenada aleatoria y marcaesa posicion como true para
     * recordar que ahí ya hubo un disparo, en caso de haber un disparo previo
     * realiza la instrucción de nuevo.
     */
    public void disparar(){
        Random random = new Random();
        int pcX, pcY;
        do {
            pcX = random.nextInt(10);
            pcY = random.nextInt(10);
            disparosPc[pcX][pcY] = true;
        }while (disparosPc[pcX][pcY] == true);
    }

    public int[][] getBarcosPc() {
        return barcosPc;
    }

    public boolean[][] getDisparosPc() {
        return disparosPc;
    }
}
