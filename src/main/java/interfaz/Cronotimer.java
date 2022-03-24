package interfaz;

import javax.swing.*;
import javax.swing.plaf.TableHeaderUI;
import java.util.Timer;

public class Cronotimer implements Runnable {
    private int minutos=2;
    private int segundos=20;
    JLabel tiempo;

    private void actualizarTiempo(){
        String act = (minutos<=9?"0":"")+minutos+":"+(segundos<=9?"0":"")+segundos;
        tiempo.setText(act);
    }

    public Cronotimer(JLabel texto) {
        this.tiempo=texto;
        run();
    }


    @Override
    public void run() {
        if(minutos>0 || segundos>0){
            this.runTimer();
        }else{
            Thread.currentThread().interrupt();
        }

    }

    public void runTimer(){
        while (minutos>0 ||segundos>0){
            if(minutos>0){
                segundos--;
            }

            if(segundos==0){
                if(minutos>0){
                    minutos--;
                    segundos=60;
                }
            }
            actualizarTiempo();
            try {
                Thread.sleep(1000L);    // 1000L = 1000ms = 1 second
            }
            catch (InterruptedException e) {
                //I don't think you need to do anything for your particular problem
            }
        }
    }
}
