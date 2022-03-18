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

    private ImageIcon titulo;
    private JLabel imagentitulo;
    private Escucha escucha;
    private JPanel panelPrincipal, panelPosicion;
    private JButton mostrar, disparar, ponerBarcos;
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
        titulo = new ImageIcon(getClass().getResource("/Resources/tittle.png"));
        imagentitulo = new JLabel(titulo);
        imagentitulo.setBorder(new EmptyBorder(0, 20, 20, 0));
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.anchor = GridBagConstraints.NORTHEAST;
        this.add(imagentitulo, constraints);


        mostrar = new JButton("Mostrar");
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.fill = GridBagConstraints.NONE;
        mostrar.addActionListener(escucha);
        //constraints.gridwidth = 2;
        this.add(mostrar, constraints);

        disparar = new JButton("disparar");
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.fill = GridBagConstraints.NONE;

        disparar.addActionListener(escucha);
        //constraints.gridwidth = 2;
        this.add(disparar, constraints);


        ponerBarcos = new JButton("Poner barcos");
        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.fill = GridBagConstraints.NONE;
        ponerBarcos.addActionListener(escucha);
        //constraints.gridwidth = 2;
        this.add(ponerBarcos, constraints);


        panelPrincipal = new JPanel(null);
        panelPrincipal.setPreferredSize(new Dimension(390, 390));
        TitledBorder titledBorderPalabra = BorderFactory.createTitledBorder(new EtchedBorder(EtchedBorder.LOWERED), "Panel Principal", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION);
        panelPrincipal.setBorder(titledBorderPalabra);
        titledBorderPalabra.setTitleColor(Color.black);
        //panelPrincipal.setOpaque(false);
        constraints.gridx = 1;
        constraints.gridy = 1;
        add(panelPrincipal, constraints);

        panelPosicion = new JPanel(null);
        panelPosicion.setPreferredSize(new Dimension(390, 390));
        TitledBorder titledBorderPalabra2 = BorderFactory.createTitledBorder(new EtchedBorder(EtchedBorder.LOWERED), "Panel Posición", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION);
        panelPosicion.setBorder(titledBorderPalabra2);
        titledBorderPalabra2.setTitleColor(Color.black);
        //panelPrincipal.setOpaque(false);
        constraints.gridx = 0;
        constraints.gridy = 1;
        add(panelPosicion, constraints);


        /*for( int fila = 0 ; fila < humano.getCasillasJugador().length; fila++ )
        {
            unaFila=fila;
            //Estando en la fila se recorrer las columnas
            for( int columna = 0 ; columna < humano.getCasillasJugador().length; columna++ )
            {
                unaColumna=columna;
                //Se crea el boton y se agrega a las celda de la matriz

                //Se agrega el boton al panel
                humano.getCasillasJugador()[fila][columna].setBounds((fila*36)+10,(columna*36)+20,36,36);
                humano.getCasillasJugador()[fila][columna].setSize(36,36);
                humano.getCasillasJugador()[fila][columna].setVisible(true);
                humano.getCasillasJugador()[fila][columna].addActionListener(escucha);
                unaFila++;
                unaColumna++;
                panelPosicion.add( humano.getCasillasJugador()[fila][columna]);
                panelPosicion.repaint();
                panelPosicion.updateUI();
                panelPosicion.validate();

            }
        }*/


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


        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource()==mostrar){
                //jugadorPc.disparar();
                pc.mostrarDisparos();
                pc.mostrarPos();
                System.out.println(pc.posicionDelElemento(pc.getBarcosPc(),0));
                System.out.println("barcos");

                //JButton[][] botones = new JButton[10][10];


                for( int fila = 0 ; fila < pc.getBarcosPc().length; fila++ )
                {
                    //Estando en la fila se recorrer las columnas
                    for( int columna = 0 ; columna < pc.getBarcosPc().length; columna++ )
                    {
                        //Se crea el boton y se agrega a las celda de la matriz

                        //Se agrega el boton al panel
                        pc.getBarcosPc()[fila][columna].setBounds((fila*36)+10,(columna*36)+20,36,36);
                        pc.getBarcosPc()[fila][columna].setSize(36,36);
                        pc.getBarcosPc()[fila][columna].setVisible(true);
                        panelPrincipal.add( pc.getBarcosPc()[fila][columna]);
                        panelPrincipal.repaint();
                        panelPrincipal.updateUI();
                        panelPrincipal.validate();
                    }
                }

                for( int fila = 0 ; fila < humano.getCasillasJugador().length; fila++ )
                {
                    //Estando en la fila se recorrer las columnas
                    for( int columna = 0 ; columna < humano.getCasillasJugador().length; columna++ )
                    {
                        //Se crea el boton y se agrega a las celda de la matriz

                        //Se agrega el boton al panel
                        humano.getCasillasJugador()[fila][columna].setBounds((fila*36)+10,(columna*36)+20,36,36);
                        humano.getCasillasJugador()[fila][columna].setSize(36,36);
                        humano.getCasillasJugador()[fila][columna].setVisible(true);
                        humano.getCasillasJugador()[fila][columna].addMouseListener(escucha);
                        panelPosicion.add( humano.getCasillasJugador()[fila][columna]);
                        panelPosicion.repaint();
                        panelPosicion.updateUI();
                        panelPosicion.validate();

                    }
                }
            }else if (e.getSource()==disparar){
                pc.disparar();
                pc.mostrarDisparos();
                System.out.println("dispara");
            }else if(e.getSource()==ponerBarcos){
                pc.posicionarBarcos();
                pc.mostrar();
                System.out.println(pc.posicionDelElemento(pc.getBarcosPc(),4));
                System.out.println("Puso los barcos");
            }
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            for( int fila = 0 ; fila < humano.getCasillasJugador().length; fila++ )
            {
                for( int columna = 0 ; columna < humano.getCasillasJugador().length; columna++ )
                {
                    if(e.getSource()==humano.getCasillasJugador()[fila][columna]){
                        System.out.println(fila+","+columna);
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
