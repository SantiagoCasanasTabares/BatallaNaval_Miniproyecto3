package myProject;

import javax.swing.*;


/**
 * Esta clase es usada para manejar las casillas
 * @author Santiago Casañas - santiago.casanas@correounivalle.edu.co - 2025301
 * @author Jesus Adrian Peña - jesus.guetio@correounivalle.edu.co - 2025513
 * @version v.1.0.0 date:21/03/2022
 */

public class Casillas extends JLabel {
    private int idbarco, idImagen, posicion;
    private boolean disparo;
    private ImageIcon imagenAgua, imagenFallo, imagenTocado, imagenHundido, imagenBarco;
    
    public Casillas(int id2, boolean disparo2){
        this.idbarco = id2;
        this.disparo = disparo2;
        this.idImagen = 0;
        imagenAgua = new ImageIcon(getClass().getResource("/Resources/agua.png"));
        imagenFallo = new ImageIcon(getClass().getResource("/Resources/fallo.png"));
        imagenTocado = new ImageIcon(getClass().getResource("/Resources/tocado.png"));
        imagenHundido = new ImageIcon(getClass().getResource("/Resources/hundido.png"));
        imagenBarco = new ImageIcon(getClass().getResource("/Resources/barco.png"));

    }

    /**
     * establece una imagen dependiendo del id de la casilla
     */
    public void setIdImagen(){
        switch (idImagen){
            case 0: this.setIcon(imagenAgua);
            break;
            case 1: this.setIcon(imagenFallo);
            break;
            case 2: this.setIcon(imagenTocado);
            break;
            case 3: this.setIcon(imagenHundido);
            break;
            case 4: this.setIcon(imagenBarco);
            break;
        }
    }

    /**
     * cambia la id de la imagen dependiendo del disparo del jugador
     */
    public void cambiarNumero(){
        if(disparo && idbarco==0){
            this.idImagen=1;
        }else if(disparo && idbarco!=0){
            this.idImagen=2;
        }
    }

    /**
     * establece la id del barco a una casilla para que se le asigne esa imagen
     */
    public void ponerBarco(){
        this.idImagen=4;
    }

    /**
     * obtiene la id del barco
     * @return
     */
    public int getIdbarco() {
        return idbarco;
    }

    /**
     * setter de la id del barco
     * @param idbarco
     */
    public void setIdbarco(int idbarco) {
        this.idbarco = idbarco;
    }

    /**
     * verifica si se disparo
     * @return
     */
    public boolean isDisparo() {
        return disparo;
    }

    /**
     * setter del disparo
     * @param disparo
     */
    public void setDisparo(boolean disparo) {
        this.disparo = disparo;
    }


    /**
     * obtiene la posicion
     * @return
     */
    public int getPosicion() {
        return posicion;
    }

    /**
     * setter de posicion
     * @param posicion
     */
    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

}
