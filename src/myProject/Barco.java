package myProject;

/**
 * Esta clase es usada para crear los barcos
 * @author Santiago Casañas - santiago.casanas@correounivalle.edu.co - 2025301
 * @author Jesus Adrian Peña - jesus.guetio@correounivalle.edu.co - 2025513
 * @version v.1.0.0 date:21/03/2022
 */

public class Barco {
    private int casillasPorBarco;

    /**
     * constructor de barco, le asigna un numero de casillas dependiendo del tipo de barco que es
     * @param letraBarco
     */
    public Barco(String letraBarco){

        switch (letraBarco){
            case "p": casillasPorBarco=4;//portaaviones
                break;
            case "s": casillasPorBarco=3;//submarinos
                break;
            case "d": casillasPorBarco=2;//destructores
                break;
            case "f": casillasPorBarco=1;//fragatas
                break;
        }

    }

    /**
     * obtiene las casillas que ocupa cada barco
     * @return
     */
    public int getCasillasPorBarco() {
        return casillasPorBarco;
    }

}
