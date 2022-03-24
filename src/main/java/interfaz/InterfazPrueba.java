package interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        panelInfo.setLayout(null);

        JLabel textUltCard = new JLabel("ULTIMA CARTA");
        textUltCard.setSize(150,50);
        textUltCard.setLocation(90,30);
        textUltCard.setFont(new Font("Elephant",Font.BOLD,14));
        panelInfo.add(textUltCard);

        JButton btn2= new JButton("ULTIMA CART");
        btn2.setPreferredSize(new Dimension(100,150));
        btn2.setSize(100,150);
        btn2.setLocation(92,75);

        panelInfo.add(btn2);

        JLabel textUltCard2 = new JLabel("ANTERIOR CART");
        textUltCard2.setSize(150,50);
        textUltCard2.setLocation(275,30);
        textUltCard2.setFont(new Font("Elephant",Font.BOLD,14));
        panelInfo.add(textUltCard2);

        JButton btn3= new JButton("ANTERIOR CART");
        btn3.setPreferredSize(new Dimension(100,150));
        btn3.setSize(100,150);
        btn3.setLocation(280,75);
        panelInfo.add(btn3);

        JLabel tiempo= new JLabel("Tiempo restante:");
        tiempo.setSize(200,50);
        tiempo.setLocation(50,tamañoPantalla.height-280);
        tiempo.setFont(new Font("Elephant",Font.BOLD,20));
        panelInfo.add(tiempo);

        JLabel crono= new JLabel("00:00");
        crono.setSize(150,50);
        crono.setLocation(230,tamañoPantalla.height-280);
        crono.setFont(new Font("Elephant",Font.BOLD,20));


        panelInfo.add(crono);


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

        Thread hiloCrono = new Thread(new Cronotimer(crono));

        if(!hiloCrono.isAlive()){
            JFrame popUp = new JFrame();

            JDialog jDialog = new JDialog(popUp);
            jDialog.setTitle("Ronda finalizada");
            jDialog.setLayout(new FlowLayout());
            JButton jButton = new JButton("Siguiente ronda");
            jButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    jDialog.setVisible(false);
                }
            });

            jDialog.add(new JLabel("Se ha terminado el tiempo"));
            jDialog.add(jButton);
            jDialog.setSize(200,100);
            jDialog.setLocationRelativeTo(null);
            jDialog.setResizable(false);
            jDialog.setVisible(true);
        }

    }

    public static void main(String[] args) {
        InterfazPrueba a = new InterfazPrueba("PRUEBA");
    }
}
