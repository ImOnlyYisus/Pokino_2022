package jugar;

import pokino.*;

import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Jugar {


    public static void main(String[] args) {
        int numeroCarton;
        Scanner sc=new Scanner(System.in);
        Carton carton=new Carton();
        carton.imprimirCarton();

       /* System.out.println("Que carton quieres de 1 a 12?");
        numeroCarton=sc.nextInt();
        Cartones cartones=new Cartones();
        cartones.cartonElegido(numeroCarton).imprimirCarton();//solo para provar si funciona*/


        //take out a random card and show it in the screen
        //take a random card and see if it exist in carton choosed
        Baraja b=new Baraja();
        Carta cartaAleatoria=b.obtenerCartaAleatoria();
        System.out.println("carta aleatoria "+cartaAleatoria);//solo para provar
        //first check if the card exist in el carton or not
        //System.out.println(cartones.cartonElegido(numeroCarton).isCartaExist(cartaAleatoria));
        System.out.println("if carta exist"+carton.isCartaExist(cartaAleatoria));

        //if the card exist in the carton we see the position where is it
       // if(cartones.cartonElegido(numeroCarton).isCartaExist(cartaAleatoria)){

            /*here start the logic of the game*/
            //first make the methods of check esquina,estampa,poker,centro,full,pokino
            //the game shall stop when we find pokino
            //every time we take a random card and check if exist we have to call all the metodos which will take time when we are playing

        //}
        //cartones.cartonElegido(numeroCarton).imprimirCarton();
        System.out.println("all same "+carton.coincidenciaVertical());
//        System.out.println("all same "+carton.coincidenciaLinea());
    }
}
