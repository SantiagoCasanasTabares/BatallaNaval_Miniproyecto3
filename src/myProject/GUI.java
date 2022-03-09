package myProject;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        constraints.gridwidth = 2;
        this.add(imagentitulo, constraints);


        mostrar = new JButton("Mostrar");
        constraints.gridx = 0;
        constraints.gridy = 1;
        mostrar.addActionListener(escucha);
        //constraints.gridwidth = 2;
        this.add(mostrar, constraints);

        disparar = new JButton("disparar");
        constraints.gridx = 0;
        constraints.gridy = 2;
        disparar.addActionListener(escucha);
        //constraints.gridwidth = 2;
        this.add(disparar, constraints);


        ponerBarcos = new JButton("Poner barcos");
        constraints.gridx = 0;
        constraints.gridy = 3;
        ponerBarcos.addActionListener(escucha);
        //constraints.gridwidth = 2;
        this.add(ponerBarcos, constraints);

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
    private class Escucha implements ActionListener {

        JugadorPc jugadorPc = new JugadorPc();


        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource()==mostrar){
                //jugadorPc.disparar();
                jugadorPc.mostrarDisparos();
                jugadorPc.mostrar();
                System.out.println("barcos");
            }else if (e.getSource()==disparar){
                jugadorPc.disparar();
                jugadorPc.mostrarDisparos();
                System.out.println("dispara");
            }else{
                jugadorPc.posicionarBarcos();
                jugadorPc.mostrar();
                System.out.println("Puso los barcos");
            }
        }
    }
}
