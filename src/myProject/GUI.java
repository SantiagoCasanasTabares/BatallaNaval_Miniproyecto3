package myProject;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Esta clase es usada para manejar toda la interfaz visual del juego
 * @author Santiago Casañas - santiago.casanas@correounivalle.edu.co - 2025301
 * @author Jesus Adrian Peña - jesus.guetio@correounivalle.edu.co - 2025513
 * @version v.1.0.0 date:21/03/2022
 */
public class GUI extends JFrame {

    public static final String MENSAJE_AYUDA_INICIAL= "Bienvenido a batalla naval "
            + "\nTienes en frente dos paneles: principal y de posición. "
            + "\nEn el panel principal podrás realizar tus diaparos para "
            + "\n intentar destruir los barcos del jugador pc. "
            + "\nMientras que en el de posición ubicarás tus barcos, usando "
            + "\nclic derecho para ubicarlos horizontalmente, e izquierdo "
            + "\npara ubicarlos de manera vertical, teniendo a disposición: "
            + "\n4 fragatas(1 casilla), 3 destructores(2 casillas), "
            + "\n2 submarinos(3 casillas) y 1 portaaviones(4 casillas).  "
            + "\nLuego presiona el boton para darle vida al jugador PC.";

    private ImageIcon titulo;
    private JLabel imagentitulo;
    private Escucha escucha;
    private JPanel panelPrincipal, panelPosicion, panelTitulo, panelBotones, panelCasillas;
    private JButton mostrar, crearPC, jugar, salir;
    private Control control;
    private GUI gui=this;
    private JLabel[][] pruebaPC;

    /**
     * Constructor of GUI class
     */
    public GUI(){
        initGUI();

        //Default JFrame configuration
        this.setTitle("Battleship");
        this.pack();
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * This method is used to set up the default JComponent Configuration,
     * create Listener and control Objects used for the GUI class
     */
    private void initGUI() {
        //Set up JFrame Container's Layout
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        /**
         * Create Listener Object and Control Object
         */
        escucha = new Escucha();
        control = new Control();
        control.setCasillasPc();
        control.setCasillasHumano();


        /**
         * set the color of the panel
         */
        this.getContentPane().setBackground(new Color(238,241,240));


        /**
         * set up components -------------------------------------------------------------------------------------------
         */

        /**
         * tittle
         */

        panelTitulo = new JPanel();
        titulo = new ImageIcon(getClass().getResource("/Resources/tittle.png"));
        imagentitulo = new JLabel(titulo);
        panelTitulo.add(imagentitulo, BorderLayout.CENTER);
        panelTitulo.setPreferredSize(new Dimension(690, 200));
        panelTitulo.setOpaque(false);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.gridheight = 1;
        add(panelTitulo, constraints);



        panelPrincipal = new JPanel(null);
        panelPrincipal.setPreferredSize(new Dimension(390, 390));
        TitledBorder titledBorderPalabra = BorderFactory.createTitledBorder(new EtchedBorder(EtchedBorder.LOWERED), "Panel Principal", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION);
        panelPrincipal.setBorder(titledBorderPalabra);
        titledBorderPalabra.setTitleColor(Color.black);
        panelPrincipal.setOpaque(false);
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        add(panelPrincipal, constraints);

        panelPosicion = new JPanel(null);
        panelPosicion.setPreferredSize(new Dimension(390, 390));
        TitledBorder titledBorderPalabra2 = BorderFactory.createTitledBorder(new EtchedBorder(EtchedBorder.LOWERED), "Panel Posición", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION);
        panelPosicion.setBorder(titledBorderPalabra2);
        titledBorderPalabra2.setTitleColor(Color.black);
        panelPosicion.setOpaque(false);
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        add(panelPosicion, constraints);

        Casillas[][] humano = control.getCasillasHumano();

/**
 *agrega la matriz de casiilas al panel del jugador
 */
        //Panel donde se posiciona
        for( int fila = 0 ; fila < humano.length; fila++ )
        {
            //Estando en la fila se recorrer las columnas
            for( int columna = 0 ; columna < humano.length; columna++ )
            {
                //Se crea el boton y se agrega a las celda de la matriz

                //Se agrega el boton al panel
                control.getCasillasHumano()[fila][columna].setBounds((fila*36)+10,(columna*36)+20,36,36);
                control.getCasillasHumano()[fila][columna].setSize(36,36);
                control.getCasillasHumano()[fila][columna].setVisible(true);
                panelPosicion.add( control.getCasillasHumano()[fila][columna]);
                panelPrincipal.repaint();
                panelPrincipal.updateUI();
                panelPrincipal.validate();
            }
        }

        Casillas[][] pc = control.getCasillasPc();

        /**
         * agrega la matriz de casillas del pc a su respectivo panel
         */
        //panel donde se dispara
        for( int fila = 0 ; fila < pc.length; fila++ )
        {
            //Estando en la fila se recorrer las columnas
            for( int columna = 0 ; columna < pc.length; columna++ )
            {
                //Se crea el boton y se agrega a las celda de la matriz
                control.getCasillasPc()[fila][columna].setBounds((fila*36)+10,(columna*36)+20,36,36);
                control.getCasillasPc()[fila][columna].setSize(36,36);
                control.getCasillasPc()[fila][columna].setVisible(true);
                //humano.getCasillasJugador()[fila][columna].addMouseListener(escucha);
                panelPrincipal.add(control.getCasillasPc()[fila][columna]);
                panelPosicion.repaint();
                panelPosicion.updateUI();
                panelPosicion.validate();

            }
        }


        mostrar = new JButton("Mostrar");
        constraints.fill = GridBagConstraints.NONE;
        mostrar.addActionListener(escucha);
        this.add(mostrar, constraints);


        crearPC = new JButton("Dar vida al PC");
        crearPC.addActionListener(escucha);
        crearPC.setEnabled(false);
        this.add(crearPC, constraints);


        jugar = new JButton("Jugar");
        jugar.addActionListener(escucha);
        this.add(jugar, constraints);

        salir = new JButton("Salir");
        salir.addActionListener(escucha);
        this.add(salir, constraints);

        panelBotones = new JPanel();
        panelBotones.setPreferredSize(new Dimension(690, 50));
        panelBotones.setOpaque(false);
        panelBotones.add(jugar);
        panelBotones.add(crearPC);
        panelBotones.add(mostrar);
        panelBotones.add(salir);
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        constraints.gridheight = 1;
        add(panelBotones, constraints);


    }

    /**
     * Main process of the Java program
     * @param args Object used in order to send input data from command line when
     *             the program is execute by console.
     */
    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            GUI miProjectGUI = new GUI();

        });
    }



    /**
     * inner class that extends an Adapter Class or implements Listeners used by GUI class
     */
    private class Escucha implements ActionListener, MouseListener {
        int barco=0;


        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource()==mostrar){

                JDialog dialog = new JDialog();
                JPanel lab = new JPanel();
                lab.setPreferredSize(new Dimension(400, 400));
                TitledBorder titledBorderPalabra3 = BorderFactory.createTitledBorder(new EtchedBorder(EtchedBorder.LOWERED), "Panel del PC", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION);
                lab.setBorder(titledBorderPalabra3);
                titledBorderPalabra3.setTitleColor(Color.black);
                dialog.add(lab);
                dialog.setSize(450, 490);

                pruebaPC = new JLabel[10][10];
                for( int fila = 0 ; fila < control.getCasillasPc().length; fila++ )
                {
                    //Estando en la fila se recorrer las columnas
                    for( int columna = 0 ; columna < control.getCasillasPc().length; columna++ )
                    {
                        //Se crea el boton y se agrega a las celda de la matriz
                        if (control.getCasillasPc()[fila][columna].getIdbarco()!=0) {
                            pruebaPC[fila][columna] = new JLabel(new ImageIcon(getClass().getResource("/Resources/barco.png")));
                            lab.add(pruebaPC[fila][columna]);
                        }else{
                            pruebaPC[fila][columna] = new JLabel(new ImageIcon(getClass().getResource("/Resources/agua.png")));
                            lab.add(pruebaPC[fila][columna]);
                        }

                        lab.repaint();
                        lab.updateUI();
                        lab.validate();
                    }
                }


                dialog.setVisible(true);

            }else if (e.getSource()==crearPC){

                for( int fila = 0 ; fila < control.getCasillasPc().length; fila++ )
                {
                    //Estando en la fila se recorrer las columnas
                    for( int columna = 0 ; columna < control.getCasillasPc().length; columna++ )
                    {

                        control.getCasillasPc()[fila][columna].addMouseListener(escucha);

                    }
                }

                crearPC.setEnabled(false);


            }else if(e.getSource()==jugar){

                control.setBarcosJugador(control.getBarcos());
                JOptionPane.showMessageDialog(null, MENSAJE_AYUDA_INICIAL, "Como jugar", JOptionPane.DEFAULT_OPTION);

                for( int fila = 0 ; fila < control.getCasillasHumano().length; fila++ )
                {
                    //Estando en la fila se recorrer las columnas
                    for( int columna = 0 ; columna < control.getCasillasHumano().length; columna++ )
                    {
                        control.getCasillasHumano()[fila][columna].addMouseListener(escucha);
                    }
                }


                jugar.setEnabled(false);


            }else{
                System.exit(0);
            }
        }



        @Override
        public void mouseClicked(MouseEvent e) {


            /**
             * for para posicionar barcos del jugador en donde el clickee
             */
            for( int fila = 0 ; fila < control.getCasillasHumano().length; fila++ )
            {
                for( int columna = 0 ; columna < control.getCasillasHumano().length; columna++ )
                {
                    if(e.getSource()==control.getCasillasHumano()[fila][columna]){
                        int casillasDelBarco= control.casillasPorBarco(control.getBarcos().get(barco));
                        int idCasilla = control.getCasillasHumano()[fila][columna].getIdbarco();
                        if(e.getButton()==MouseEvent.BUTTON1 && idCasilla==0){
                            for (int i=fila;i<fila+casillasDelBarco;i++){
                                control.getCasillasHumano()[i][columna].setIdbarco(casillasDelBarco);
                                control.getCasillasHumano()[i][columna].ponerBarco();
                                control.getCasillasHumano()[i][columna].setIdImagen();
                            }
                            barco++;
                        }else if(e.getButton()==MouseEvent.BUTTON3 && idCasilla==0){
                            for (int j=columna;j<columna+casillasDelBarco;j++){
                                control.getCasillasHumano()[fila][j].setIdbarco(casillasDelBarco);
                                control.getCasillasHumano()[fila][j].ponerBarco();
                                control.getCasillasHumano()[fila][j].setIdImagen();
                            }
                            barco++;
                        }else if (idCasilla!=0){
                            JOptionPane.showMessageDialog(null, "No puedes poner un barco aquí.");
                        }
                    }
                }
            }

            /**
             * luego de que el jugador posicione sus barcos, se le retiran los escuchas a sus casillas
             */
            if(barco==10){
                crearPC.setEnabled(true);
                for( int fila = 0 ; fila < control.getCasillasHumano().length; fila++ ) {
                    for (int columna = 0; columna < control.getCasillasHumano().length; columna++) {
                        control.getCasillasHumano()[fila][columna].removeMouseListener(escucha);
                    }
                }
            }


            /**
             * for para disparar
             */


            for( int fila = 0 ; fila < control.getCasillasPc().length; fila++ )
            {
                for( int columna = 0 ; columna < control.getCasillasPc().length; columna++ )
                {
                    if(e.getSource()==control.getCasillasPc()[fila][columna]){


                        control.disparar();


                        if(control.getCasillasPc()[fila][columna].getIdbarco()!=0){
                            control.getCasillasPc()[fila][columna].removeMouseListener(escucha);
                            control.getCasillasPc()[fila][columna].setDisparo(true);
                            control.getCasillasPc()[fila][columna].cambiarNumero();
                            control.getCasillasPc()[fila][columna].setIdImagen();
                            control.restarVidaPc();
                        }else if (control.getCasillasPc()[fila][columna].getIdbarco()==0){
                            control.getCasillasPc()[fila][columna].removeMouseListener(escucha);
                            control.getCasillasPc()[fila][columna].setDisparo(true);
                            control.getCasillasPc()[fila][columna].cambiarNumero();
                            control.getCasillasPc()[fila][columna].setIdImagen();
                        }
                    }
                }
                if (control.detertminarEstado()==1){
                    int seleccion = JOptionPane.showOptionDialog(
                            null,
                            control.getMensajeFinal(1),
                            null,
                            JOptionPane.YES_NO_CANCEL_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null,    // null para icono por defecto.
                            new Object[] { "Reiniciar", "Salir" },   // null para YES, NO y CANCEL
                            null);

                    if (seleccion == 0) {
                        GUI.main(null);
                        gui.dispose();
                        control.setEstado(0);
                    }else if (seleccion ==1){
                        System.exit(0);
                    }
                }else if (control.detertminarEstado()==2){
                    int seleccion = JOptionPane.showOptionDialog(
                            null,
                            control.getMensajeFinal(2),
                            null,
                            JOptionPane.YES_NO_CANCEL_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null,    // null para icono por defecto.
                            new Object[] { "Reiniciar", "Salir" },   // null para YES, NO y CANCEL
                            null);

                    if (seleccion == 0) {
                        GUI.main(null);
                        gui.dispose();
                        control.setEstado(0);
                    }else if (seleccion ==1){
                        System.exit(0);
                    }

                }
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }


}
