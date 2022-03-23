package interfaz;

import javax.swing.*;
import java.awt.*;

import static javax.swing.SwingConstants.EAST;
import static javax.swing.SwingConstants.WEST;

public class InterfazPrueba extends JFrame {
    private JPanel panelPrincipal = new JPanel();
    private JPanel panelBotones = new JPanel();
    private JPanel panelInfo = new JPanel();
    private Dimension tamañoPantalla = Toolkit.getDefaultToolkit().getScreenSize();

    public InterfazPrueba(String title) {
        super(title);

        panelBotones.setLayout(new GridLayout(5, 5, 10, 10));
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                JButton boton = new JButton("Boton");
                panelBotones.add(boton);
            }
        }

//        this.add(mainPanel);
        panelInfo.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        JLabel textUltCard = new JLabel("ULTIMA CARTA");
        c.fill = GridBagConstraints.PAGE_START;
        c.gridy=0;
        c.gridx=0;
        panelInfo.add(textUltCard, c);

        JButton btn2= new JButton("ULTIMA CART");
        btn2.setPreferredSize(new Dimension(100,150));
        c.fill = GridBagConstraints.PAGE_START;
        c.gridy=1;
        c.gridx=0;
        c.insets = new Insets(10,0,10,5);
        panelInfo.add(btn2, c);

        JLabel textUltCard2 = new JLabel("ANTERIOR CART");
        c.fill = GridBagConstraints.PAGE_START;
        c.gridy=0;
        c.gridx=1;
        panelInfo.add(textUltCard2, c);

        JButton btn3= new JButton("ANTERIOR CART");
        btn3.setPreferredSize(new Dimension(100,150));
        c.fill = GridBagConstraints.PAGE_START;
        c.gridy=1;
        c.gridx=1;
        panelInfo.add(btn3, c);

        JButton btn5 = new JButton("5");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridy=4;
        c.gridx=0;
        panelInfo.add(btn5, c);

        panelPrincipal.setLayout(new GridLayout(1,2));

        panelPrincipal.add(panelBotones);
        panelPrincipal.add(panelInfo);
        this.add(panelPrincipal);
        this.pack();
        this.setSize(tamañoPantalla.width / 2, tamañoPantalla.height - 200);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        InterfazPrueba a = new InterfazPrueba("Pene");
    }
}
