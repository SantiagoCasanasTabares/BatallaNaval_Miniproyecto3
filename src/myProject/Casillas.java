package myProject;

import javax.swing.*;

public class Casillas extends JLabel {
    private int idbarco, idImagen, x, y, posicion;
    private boolean disparo;
    private ImageIcon imagenAgua, imagenFallo, imagenTocado, imagenHundido;
    
    public Casillas(int id2, boolean disparo2){
        this.idbarco = id2;
        this.disparo = disparo2;
        this.idImagen = 0;
        imagenAgua = new ImageIcon(getClass().getResource("/Resources/agua.png"));
        imagenFallo = new ImageIcon(getClass().getResource("/Resources/fallo.png"));
        imagenTocado = new ImageIcon(getClass().getResource("/Resources/tocado.png"));
        imagenHundido = new ImageIcon(getClass().getResource("/Resources/hundido.png"));

    }

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
        }
    }

    public void cambiarNumero(){
        if(disparo && idbarco==0){
            this.idImagen=1;
        }else if(disparo && idbarco!=0){
            this.idImagen=2;
        }
    }

    public int getIdbarco() {
        return idbarco;
    }

    public void setIdbarco(int idbarco) {
        this.idbarco = idbarco;
    }

    public boolean isDisparo() {
        return disparo;
    }

    public void setDisparo(boolean disparo) {
        this.disparo = disparo;
    }

    @Override
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }
}
