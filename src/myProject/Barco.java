package myProject;


public class Barco {
    private int casillasPorBarco;




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

    public int getCasillasPorBarco() {
        return casillasPorBarco;
    }

}
