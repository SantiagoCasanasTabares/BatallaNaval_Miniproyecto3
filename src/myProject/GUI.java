package myProject;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

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
    private JugadorPc jugadorPc;

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
    private class Escucha {

    }
}
