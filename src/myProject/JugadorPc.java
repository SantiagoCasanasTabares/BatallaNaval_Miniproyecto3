package myProject;

import java.util.ArrayList;
import java.util.Random;

public class JugadorPc {
    private Barco barco1, barco2, barco3, barco4, barco5, barco6, barco7, barco8, barco9, barco10;
    private ArrayList<Barco> barcos;
    private int[][] barcosPc;
    private boolean[][] disparosPc;
    private Random random;


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

        barcosPc = new int[10][10];
        disparosPc = new boolean[10][10];
        arrayBidDisparos();
        arrayBidBarcos();
    }

    public void arrayBidBarcos(){
        for (int i=0; i < barcosPc.length; i++){
            for (int j=0; j < barcosPc.length; j++){
                barcosPc[i][j]=0;
            }
        }
    }

    public void arrayBidDisparos(){
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
        int pcX, pcY;
        do {
            pcX = random.nextInt(10);
            pcY = random.nextInt(10);
            disparosPc[pcX][pcY] = true;
        }while (disparosPc[pcX][pcY] != true);
    }


    public void posicionarBarcos(){

    }

    public int[][] getBarcosPc() {
        return barcosPc;
    }

    public boolean[][] getDisparosPc() {
        return disparosPc;
    }


    public void mostrar(){
        for (int x=0; x < barcosPc.length; x++){
            for (int y=0; y < barcosPc[x].length; y++)
                System.out.print(" | " + barcosPc[x][y]+ " | ");
            System.out.println("\n--------------------------------------------------------------");
        }
    }

    public void mostrarDisparos(){
        for (int x=0; x < disparosPc.length; x++){
            for (int y=0; y < disparosPc[x].length; y++)
                System.out.print(" | " + disparosPc[x][y]+ " | ");
            System.out.println("\n--------------------------------------------------------------");
        }
    }
}



