package interfaz;


import jdk.swing.interop.SwingInterOpUtils;
import pokino.Carta;
import pokino.Cartones;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageProducer;
import java.net.URL;

public class InterfazCliente extends JFrame {
    private Cartones cartones = new Cartones();
    private JPanel mainPanel = new JPanel();

    public InterfazCliente(String title){
        super(title);
        mainPanel.setLayout(new GridLayout(5,5,10,10));

        Carta[][] cartonEjemplo = cartones.getCartones().get(0).getCarton();
        for (int i = 0; i <cartonEjemplo.length ; i++) {
            for (int j = 0; j <cartonEjemplo[i].length ; j++) {
                String route = "src/main/java/interfaz/images/"+cartonEjemplo[i][j].getSimbolo().toString().toUpperCase()+"_"+cartonEjemplo[i][j].getNumero()+".jpg";
                System.out.println(route);
                Icon cardIcon = new ImageIcon(route);
                Image scaledImg = ((ImageIcon) cardIcon).getImage().getScaledInstance(100, 150,  java.awt.Image.SCALE_SMOOTH);
                cardIcon = new ImageIcon(scaledImg);

                JButton boton = new JButton(cardIcon);
                boton.setPreferredSize(new Dimension(100, 150));
//                boton.setIcon(cardIcon);
                mainPanel.add(boton);
            }
        }

        this.add(mainPanel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        InterfazCliente interfazCliente = new InterfazCliente("Ejemplo");
    }
}
