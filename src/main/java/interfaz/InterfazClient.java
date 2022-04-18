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
import java.util.Collections;

public class InterfazClient extends JFrame implements ActionListener {
    private Cartones cartones = new Cartones();
    private Carton cartonEjemplo =cartones.getCartones().get(0);
    private Match partida = new Match();
    private Carta cartaRonda = partida.nextCarta();

    private JPanel panelPrincipal = new JPanel();
    private JLabel tiempoRestante = new JLabel("Tiempo restante:");
    private JLabel tiempo = new JLabel("00:00");
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

        //Timer
//        Thread hiloCrono = new Thread(new Cronotimer(tiempo));

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

        tiempoRestante.setFont(new java.awt.Font("Segoe UI", 0, 18));

        tiempo.setFont(new java.awt.Font("Segoe UI", 0, 18));

        playerText.setFont(new java.awt.Font("Segoe UI", 0, 14));

        nextRoundBtn.setFont(new java.awt.Font("Segoe UI", 1, 12));
        nextRoundBtn.addActionListener(this);

        namePlayer.setFont(new java.awt.Font("Segoe UI", 0, 14));

        //Panel botones
        panelCartas.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
        panelCartas.setLayout(new java.awt.GridLayout(5, 5, 3, 3));


        for (int i = 0; i <cartonEjemplo.getCarton().length ; i++) {
            for (int j = 0; j <cartonEjemplo.getCarton()[i].length ; j++) {
                String route = "src/main/java/interfaz/images/"+cartonEjemplo.getCarton()[i][j].getSimbolo().toString().toUpperCase()+"_"+cartonEjemplo.getCarton()[i][j].getNumero()+".jpg";
                Icon cardIcon = new ImageIcon(route);
                Image scaledImg = ((ImageIcon) cardIcon).getImage().getScaledInstance(65,105,  java.awt.Image.SCALE_SMOOTH);
                cardIcon = new ImageIcon(scaledImg);
                JToggleButton boton = new JToggleButton(cardIcon);
                boton.setPreferredSize(new Dimension(80,115));
                boton.addActionListener(this);
                panelCartas.add(boton);
            }
        }

        panelInfo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));


        String route = "src/main/java/interfaz/images/"+ cartaRonda.getSimbolo()+"_"+ cartaRonda.getNumero()+".jpg";
        Icon cardIcon = new ImageIcon(route);
        Image scaledImg = ((ImageIcon) cardIcon).getImage().getScaledInstance(65,105,  java.awt.Image.SCALE_SMOOTH);
        cardIcon = new ImageIcon(scaledImg);
        ultimaCarta.setIcon(cardIcon);
        ultimaCarta.addActionListener(this);


        Icon cardIcon2 = new ImageIcon("src/main/java/interfaz/images/BACK.jpg");
        Image scaledImg2 = ((ImageIcon) cardIcon2).getImage().getScaledInstance(65,105,  java.awt.Image.SCALE_SMOOTH);
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
                                                                .addComponent(tiempoRestante)
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
                                                        .addComponent(tiempoRestante)
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
        if(e.getSource() == nextRoundBtn){
            if(partida.comprobarPremios(cartonEjemplo)){
                JOptionPane.showMessageDialog(this, "Has ganado un premio");
            }else{
                Carta rondaAnterior = cartaRonda;
                cartaRonda = partida.nextCarta();

                String route = "src/main/java/interfaz/images/"+ cartaRonda.getSimbolo()+"_"+ cartaRonda.getNumero()+".jpg";
                Icon cardIcon = new ImageIcon(route);
                Image scaledImg = ((ImageIcon) cardIcon).getImage().getScaledInstance(65,105,  java.awt.Image.SCALE_SMOOTH);
                cardIcon = new ImageIcon(scaledImg);
                ultimaCarta.setIcon(cardIcon);

                Icon cardIcon2 = new ImageIcon("src/main/java/interfaz/images/"+ rondaAnterior.getSimbolo()+"_"+ rondaAnterior.getNumero()+".jpg");
                Image scaledImg2 = ((ImageIcon) cardIcon2).getImage().getScaledInstance(65,105,  java.awt.Image.SCALE_SMOOTH);
                cardIcon2 = new ImageIcon(scaledImg2);
                anteriorCarta.setIcon(cardIcon2);
            }

        }



        if(e.getSource() == ultimaCarta){
            //Botones de las cartas
            Component[] botones = panelCartas.getComponents();

            for (int i = 0; i <cartonEjemplo.getCarton().length ; i++) {
                for (int j = 0; j <cartonEjemplo.getCarton()[i].length ; j++) {
                    if(cartonEjemplo.getCarton()[i][j].equals(cartaRonda)){
                        cartonEjemplo.getCarton()[i][j].setEstaMarcado(true);
                        if(i==0){
                            botones[j].setBackground(Color.GREEN);
                        }else if(i==1){
                            botones[j+5].setBackground(Color.GREEN);
                        } else if(i==2){
                            botones[j+10].setBackground(Color.GREEN);
                        } else if(i==3){
                            botones[j+15].setBackground(Color.GREEN);
                        }else if(i==4){
                            botones[j+20].setBackground(Color.GREEN);
                        }

                        break;
                    }
                }
            }
        }

    }
}


