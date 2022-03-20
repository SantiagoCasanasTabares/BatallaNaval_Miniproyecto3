package myProject;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * This class is used for ...
 * @autor Paola-J Rodriguez-C paola.rodriguez@correounivalle.edu.co
 * @version v.1.0.0 date:21/11/2021
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
            + "\n2 submarinos(3 casillas) y 1 portaaviones(4 casillas).  ";

    private ImageIcon titulo;
    private JLabel imagentitulo;
    private Escucha escucha;
    private JPanel panelPrincipal, panelPosicion, panelTitulo, panelBotones;
    private JButton mostrar, disparar, jugar, salir;
    private JugadorPc pc;
    private JugadorHumano humano;

    /**
     * Constructor of GUI class
     */
    public GUI(){
        initGUI();

        //Default JFrame configuration
        this.setTitle("Battleship");
        this.pack();
        this.setResizable(true);
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
        pc = new JugadorPc();
        humano = new JugadorHumano();


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


        //Panel donde se posiciona
        for( int fila = 0 ; fila < humano.getCasillasJugadorPosicion().length; fila++ )
        {
            //Estando en la fila se recorrer las columnas
            for( int columna = 0 ; columna < humano.getCasillasJugadorPosicion().length; columna++ )
            {
                //Se crea el boton y se agrega a las celda de la matriz

                //Se agrega el boton al panel
                humano.getCasillasJugadorPosicion()[fila][columna].setBounds((fila*36)+10,(columna*36)+20,36,36);
                humano.getCasillasJugadorPosicion()[fila][columna].setSize(36,36);
                humano.getCasillasJugadorPosicion()[fila][columna].setVisible(true);
                //pc.getBarcosPc()[fila][columna].addMouseListener(escucha);
                panelPosicion.add( humano.getCasillasJugadorPosicion()[fila][columna]);
                panelPrincipal.repaint();
                panelPrincipal.updateUI();
                panelPrincipal.validate();
            }
        }

        //panel donde se dispara
        for( int fila = 0 ; fila < pc.getBarcosPc().length; fila++ )
        {
            //Estando en la fila se recorrer las columnas
            for( int columna = 0 ; columna < pc.getBarcosPc().length; columna++ )
            {
                //Se crea el boton y se agrega a las celda de la matriz
                pc.getBarcosPc()[fila][columna].setBounds((fila*36)+10,(columna*36)+20,36,36);
                pc.getBarcosPc()[fila][columna].setSize(36,36);
                pc.getBarcosPc()[fila][columna].setVisible(true);
                //humano.getCasillasJugador()[fila][columna].addMouseListener(escucha);
                panelPrincipal.add( pc.getBarcosPc()[fila][columna]);
                panelPosicion.repaint();
                panelPosicion.updateUI();
                panelPosicion.validate();

            }
        }


        mostrar = new JButton("Mostrar");
        constraints.fill = GridBagConstraints.NONE;
        mostrar.addActionListener(escucha);
        this.add(mostrar, constraints);


        disparar = new JButton("disparar");
        disparar.addActionListener(escucha);
        this.add(disparar, constraints);


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
        panelBotones.add(disparar);
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
                //jugadorPc.disparar();
                pc.mostrarDisparos();
                pc.mostrarPos();


                //JButton[][] botones = new JButton[10][10];



            }else if (e.getSource()==disparar){
                pc.mostrarDisparos();
                System.out.println("dispara");
            }else if(e.getSource()==jugar){

                humano.setBarcosJugador(humano.getBarcosJugador());
                JOptionPane.showMessageDialog(null, MENSAJE_AYUDA_INICIAL, "Como jugar", JOptionPane.DEFAULT_OPTION);

                for( int fila = 0 ; fila < humano.getCasillasJugadorPosicion().length; fila++ )
                {
                    //Estando en la fila se recorrer las columnas
                    for( int columna = 0 ; columna < humano.getCasillasJugadorPosicion().length; columna++ )
                    {
                        humano.getCasillasJugadorPosicion()[fila][columna].addMouseListener(escucha);
                    }
                }


                for( int fila = 0 ; fila < pc.getBarcosPc().length; fila++ )
                {
                    //Estando en la fila se recorrer las columnas
                    for( int columna = 0 ; columna < pc.getBarcosPc().length; columna++ )
                    {

                        pc.getBarcosPc()[fila][columna].addMouseListener(escucha);

                    }
                }

                pc.posicionarBarcos();
                pc.mostrar();


                jugar.setEnabled(false);

            }else{
                System.exit(0);
            }
        }



        @Override
        public void mouseClicked(MouseEvent e) {

            /**
             * for para posicionar barcos
             */
            for( int fila = 0 ; fila < humano.getCasillasJugadorPosicion().length; fila++ )
            {
                for( int columna = 0 ; columna < humano.getCasillasJugadorPosicion().length; columna++ )
                {
                    if(e.getSource()==humano.getCasillasJugadorPosicion()[fila][columna]){
                        int casillasDelBarco= humano.getIdBarcoJugador(humano.getBarcosJugador().get(barco));
                        if(e.getButton()==MouseEvent.BUTTON1){
                            for (int i=fila;i<fila+casillasDelBarco;i++){
                                humano.getCasillasJugadorPosicion()[i][columna].setIdbarco(casillasDelBarco);
                                humano.getCasillasJugadorPosicion()[i][columna].ponerBarco();
                                humano.getCasillasJugadorPosicion()[i][columna].setIdImagen();
                            }
                        }else if(e.getButton()==MouseEvent.BUTTON3){
                            for (int j=columna;j<columna+casillasDelBarco;j++){
                                humano.getCasillasJugadorPosicion()[fila][j].setIdbarco(casillasDelBarco);
                                humano.getCasillasJugadorPosicion()[fila][j].ponerBarco();
                                humano.getCasillasJugadorPosicion()[fila][j].setIdImagen();
                            }
                        }
                        System.out.println(barco);
                        barco++;
                    }
                }
            }

            if(barco==10){
                for( int fila = 0 ; fila < humano.getCasillasJugadorPosicion().length; fila++ ) {
                    for (int columna = 0; columna < humano.getCasillasJugadorPosicion().length; columna++) {
                        humano.getCasillasJugadorPosicion()[fila][columna].removeMouseListener(escucha);
                    }
                }
            }


            /**
             * for para disparar
             */

            for( int fila = 0 ; fila < pc.getBarcosPc().length; fila++ )
            {
                for( int columna = 0 ; columna < pc.getBarcosPc().length; columna++ )
                {
                    if(e.getSource()==pc.getBarcosPc()[fila][columna]){

                        humano.disparar();

                        if(pc.getBarcosPc()[fila][columna].getIdbarco()==4){
                            pc.getBarcosPc()[fila][columna].removeMouseListener(escucha);
                            pc.getBarcosPc()[fila][columna].setDisparo(true);
                            pc.getBarcosPc()[fila][columna].cambiarNumero();
                            pc.getBarcosPc()[fila][columna].setIdImagen();
                        }else if (pc.getBarcosPc()[fila][columna].getIdbarco()==3){
                            pc.getBarcosPc()[fila][columna].removeMouseListener(escucha);
                            pc.getBarcosPc()[fila][columna].setDisparo(true);
                            pc.getBarcosPc()[fila][columna].cambiarNumero();
                            pc.getBarcosPc()[fila][columna].setIdImagen();
                        }else if (pc.getBarcosPc()[fila][columna].getIdbarco()==2){
                            pc.getBarcosPc()[fila][columna].removeMouseListener(escucha);
                            pc.getBarcosPc()[fila][columna].setDisparo(true);
                            pc.getBarcosPc()[fila][columna].cambiarNumero();
                            pc.getBarcosPc()[fila][columna].setIdImagen();
                        }else if (pc.getBarcosPc()[fila][columna].getIdbarco()==1){
                            pc.getBarcosPc()[fila][columna].removeMouseListener(escucha);
                            pc.getBarcosPc()[fila][columna].setDisparo(true);
                            pc.getBarcosPc()[fila][columna].cambiarNumero();
                            pc.getBarcosPc()[fila][columna].setIdImagen();
                        }else if (pc.getBarcosPc()[fila][columna].getIdbarco()==0){
                            pc.getBarcosPc()[fila][columna].removeMouseListener(escucha);
                            pc.getBarcosPc()[fila][columna].setDisparo(true);
                            pc.getBarcosPc()[fila][columna].cambiarNumero();
                            pc.getBarcosPc()[fila][columna].setIdImagen();
                        }
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
