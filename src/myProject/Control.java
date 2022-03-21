package myProject;

public class Control {
    private int vidaPc, vidaHumano, estado;
    private String[] mensajeFinal;

    public Control(){
        vidaHumano = 20;
        vidaPc = 20;
        mensajeFinal = new String[1];
    }

    public void restarVidaPc(){
        vidaPc--;
    }

    public void restarVidaHumano(){
        vidaHumano--;
    }

    public void detertminarEstado(){
        if (vidaPc==0){
            estado = 1;
        }else if (vidaHumano==0){
            estado = 2;
        }
    }

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



}
