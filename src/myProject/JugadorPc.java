package myProject;

import java.util.ArrayList;
import java.util.Random;

public class JugadorPc {
    private Barco barco1, barco2, barco3, barco4, barco5, barco6, barco7, barco8, barco9, barco10;
    private ArrayList<Barco> barcos;
    private Casillas[][] casillasPc;
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

        casillasPc = new Casillas[10][10];
        arrayBidCasillas();
    }

    public void arrayBidCasillas(){
        for (int i=0; i < casillasPc.length; i++){
            for (int j=0; j < casillasPc.length; j++){
                casillasPc[i][j]=;

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
            casillasPc[pcX][pcY].setDisparo(true);
        }while (casillasPc[pcX][pcY].isDisparo() != true);
    }


    public void posicionarBarcos(){

    }

    public Casillas[][] getBarcosPc() {
        return casillasPc;
    }




    public void mostrar(){
        for (int x=0; x < casillasPc.length; x++){
            for (int y=0; y < casillasPc[x].length; y++)
                System.out.print(" | " + casillasPc[x][y].getIdbarco()+ " | ");
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
}



