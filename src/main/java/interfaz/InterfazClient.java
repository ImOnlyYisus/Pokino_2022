package interfaz;

import jugar.Match;
import pokino.Carta;
import pokino.Carton;
import pokino.Cartones;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.CookieHandler;
import java.util.Random;

public class InterfazClient extends JFrame implements ActionListener {
    private static Random rd = new Random();
    private Cartones cartones = new Cartones(); //Twelves cartones
    private Carton cartonEjemplo = cartones.getCartones().get(rd.nextInt(cartones.getCartones().size())); //Random carton on the "cartones"
    private Match partida = new Match(); //Match contains utils methods
    private Carta cartaRonda = partida.nextCarta(); //To known which card is showing at the moment

    //Interface components
    private JRadioButton toggleMode = new JRadioButton("Modo Automatico");
    private JPanel panelPrincipal = new JPanel();
    private JLabel tiempo = new JLabel("");
    private JLabel playerText = new JLabel("Player:");
    private JButton nextRoundBtn = new JButton("Siguiente ronda:");
    private JLabel namePlayer = new JLabel("Jugadorx");
    private JPanel panelCartas = new JPanel();
    private JPanel panelInfo = new JPanel();
    private JButton ultimaCarta = new JButton();
    private JLabel ultimaCartaText = new JLabel("ULTIMA CARTA");
    private JButton anteriorCarta = new JButton();
    private JLabel anteriorCartaText = new JLabel("ANTER. CARTA");


    public InterfazClient() {
        super("Pokino 2022 <<Jesus & Hind>>");

        ImageIcon icon = new ImageIcon("src/main/java/interfaz/images/logo.png");
        this.setIconImage(icon.getImage());


        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    private void initComponents() {
        GroupLayout jPanel1Layout = new GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        toggleMode.setFont(new java.awt.Font("Segoe UI", 0, 18));

        toggleMode.setFont(new java.awt.Font("Segoe UI", 0, 18));

        playerText.setFont(new java.awt.Font("Segoe UI", 0, 14));

        nextRoundBtn.setFont(new java.awt.Font("Segoe UI", 1, 12));
        nextRoundBtn.addActionListener(this);

        namePlayer.setFont(new java.awt.Font("Segoe UI", 0, 14));

        //Panel botones
        panelCartas.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
        panelCartas.setLayout(new java.awt.GridLayout(5, 5, 3, 3));

        //Matrix of buttons with images
        for (int i = 0; i < cartonEjemplo.getCarton().length; i++) {
            for (int j = 0; j < cartonEjemplo.getCarton()[i].length; j++) {
                String route = "src/main/java/interfaz/images/" + cartonEjemplo.getCarton()[i][j].getSimbolo().toString().toUpperCase() + "_" + cartonEjemplo.getCarton()[i][j].getNumero() + ".jpg";
                Icon cardIcon = new ImageIcon(route);
                Image scaledImg = ((ImageIcon) cardIcon).getImage().getScaledInstance(65, 105, java.awt.Image.SCALE_SMOOTH);
                cardIcon = new ImageIcon(scaledImg);
                JToggleButton boton = new JToggleButton(cardIcon);
                boton.setPreferredSize(new Dimension(80, 115));

                //Envent: when the button is pressed, the card is selected
                boton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (cartonEjemplo.buscarCarta(cartaRonda) != null) {
                            boton.setBackground(Color.green);
                            cartonEjemplo.buscarCarta(cartaRonda).setEstaMarcado(true);
                        }

                    }
                });

                panelCartas.add(boton);
            }
        }

        panelInfo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));


        String route = "src/main/java/interfaz/images/" + cartaRonda.getSimbolo() + "_" + cartaRonda.getNumero() + ".jpg";
        Icon cardIcon = new ImageIcon(route);
        Image scaledImg = ((ImageIcon) cardIcon).getImage().getScaledInstance(65, 105, java.awt.Image.SCALE_SMOOTH);
        cardIcon = new ImageIcon(scaledImg);
        ultimaCarta.setIcon(cardIcon);
        ultimaCarta.addActionListener(this);


        Icon cardIcon2 = new ImageIcon("src/main/java/interfaz/images/BACK.jpg");
        Image scaledImg2 = ((ImageIcon) cardIcon2).getImage().getScaledInstance(65, 105, java.awt.Image.SCALE_SMOOTH);
        cardIcon2 = new ImageIcon(scaledImg2);
        anteriorCarta.setIcon(cardIcon2);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(panelInfo);
        panelInfo.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(ultimaCartaText)
                                                .addGap(50, 50, 50))
                                        .addComponent(ultimaCarta, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(anteriorCartaText)
                                        .addComponent(anteriorCarta, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(62, 62, 62))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(anteriorCartaText)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(anteriorCarta, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(ultimaCartaText)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(ultimaCarta, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(panelCartas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(playerText)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(namePlayer))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(toggleMode)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(tiempo))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(48, 48, 48)
                                                .addComponent(panelInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(135, 135, 135)
                                                .addComponent(nextRoundBtn)))
                                .addGap(57, 57, 57))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(panelCartas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(playerText)
                                                        .addComponent(namePlayer))
                                                .addGap(39, 39, 39)
                                                .addComponent(panelInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(nextRoundBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 279, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(toggleMode)
                                                        .addComponent(tiempo))
                                                .addGap(0, 20, Short.MAX_VALUE)))
                                .addContainerGap())
        );

        pack();
    }

    public JLabel getTiempo() {
        return tiempo;
    }


    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InterfazClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                InterfazClient interfazClient = new InterfazClient();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //When the user clicks on the next round button
        if (e.getSource() == nextRoundBtn) {
            //If the game is in the auto mode
            if (toggleMode.isSelected()) {
                //If pokino is true, the game is over
                if (partida.comprobarPokino(cartonEjemplo)) {
                    JOptionPane.showMessageDialog(this, "Has ganado el premio de pokino +\nSE HA ACABADO LA PARTIDA");

                } else {
                    //If the game is not over, the next round is played
                    pasarRonda();

                    //Cards components
                    Component[] botones = panelCartas.getComponents();

                    //Check if the cartaRonda is in the panel and if it is, mark it as selected and the background is changed to green
                    for (int i = 0; i < cartonEjemplo.getCarton().length; i++) {
                        for (int j = 0; j < cartonEjemplo.getCarton()[i].length; j++) {
                            if (cartonEjemplo.getCarton()[i][j].equals(cartaRonda)) {
                                cartonEjemplo.getCarton()[i][j].setEstaMarcado(true);
                                if (i == 0) {
                                    botones[j].setBackground(Color.GREEN);
                                } else if (i == 1) {
                                    botones[j + 5].setBackground(Color.GREEN);
                                } else if (i == 2) {
                                    botones[j + 10].setBackground(Color.GREEN);
                                } else if (i == 3) {
                                    botones[j + 15].setBackground(Color.GREEN);
                                } else if (i == 4) {
                                    botones[j + 20].setBackground(Color.GREEN);
                                }

                                break;
                            }
                        }
                    }

                    //Check the others prizes (poker, full, esquina, estampa)
                    if (partida.premio(cartonEjemplo) != null) {
                        String premioRnd = partida.premio(cartonEjemplo);
                        if (!partida.getPremios().contains(partida.premio(cartonEjemplo))) {
                            JOptionPane.showMessageDialog(this, "Has ganado el premio de " + premioRnd);
                            partida.añadirPremio(premioRnd);
                        }
                    }
                }

            } else { //If the game is in the manual mode
                //Cards components
                Component[] botones = panelCartas.getComponents();
                if (partida.comprobarPokino(cartonEjemplo)) {
                    JOptionPane.showMessageDialog(this, "Has ganado el premio de pokino +\nSE HA ACABADO LA PARTIDA");

                } else {


                    //If the player press ""Next round"" button and the cards is in the panel, the background of the card button changes to orange to notify the user
                    //that the card is not selected
                    for (int i = 0; i < cartonEjemplo.getCarton().length; i++) {
                        for (int j = 0; j < cartonEjemplo.getCarton()[i].length; j++) {
                            if (cartonEjemplo.getCarton()[i][j].equals(cartaRonda)) {
                                if (!cartonEjemplo.getCarton()[i][j].isEstaMarcado()) {
                                    if (i == 0) {
                                        botones[j].setBackground(Color.orange);
                                    } else if (i == 1) {
                                        botones[j + 5].setBackground(Color.orange);
                                    } else if (i == 2) {
                                        botones[j + 10].setBackground(Color.orange);
                                    } else if (i == 3) {
                                        botones[j + 15].setBackground(Color.orange);
                                    } else if (i == 4) {
                                        botones[j + 20].setBackground(Color.orange);
                                    }
                                }
                                break;
                            }

                        }
                    }

                    //Check the others prizes (poker, full, esquina, estampa)
                    if (partida.premio(cartonEjemplo) != null) {
                        String premioRnd = partida.premio(cartonEjemplo);
                        if (!partida.getPremios().contains(partida.premio(cartonEjemplo))) {
                            JOptionPane.showMessageDialog(this, "Has ganado el premio de " + premioRnd);
                            partida.añadirPremio(premioRnd);
                        }
                    }

                    //If the card has been selected, the round is passed
                    if (cartonEjemplo.buscarCarta(cartaRonda) != null) {
                        if (cartonEjemplo.buscarCarta(cartaRonda).isEstaMarcado()) {
                            pasarRonda();
                        }
                    } else {
                        pasarRonda();
                    }
                }

            }

        }

    }

    //Method that passes the round
    private void pasarRonda() {
        //Change the cards that is showing in the panel
        Carta rondaAnterior = cartaRonda;
        cartaRonda = partida.nextCarta();

        String route = "src/main/java/interfaz/images/" + cartaRonda.getSimbolo() + "_" + cartaRonda.getNumero() + ".jpg";
        Icon cardIcon = new ImageIcon(route);
        Image scaledImg = ((ImageIcon) cardIcon).getImage().getScaledInstance(65, 105, java.awt.Image.SCALE_SMOOTH);
        cardIcon = new ImageIcon(scaledImg);
        ultimaCarta.setIcon(cardIcon);

        Icon cardIcon2 = new ImageIcon("src/main/java/interfaz/images/" + rondaAnterior.getSimbolo() + "_" + rondaAnterior.getNumero() + ".jpg");
        Image scaledImg2 = ((ImageIcon) cardIcon2).getImage().getScaledInstance(65, 105, java.awt.Image.SCALE_SMOOTH);
        cardIcon2 = new ImageIcon(scaledImg2);
        anteriorCarta.setIcon(cardIcon2);
    }

}



