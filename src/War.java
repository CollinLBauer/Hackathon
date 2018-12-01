/*
 * War.java
 *
 * Plays a game of War.
 *
 */

import java.util.ArrayList;
import java.util.Scanner;

public class War{

    private static void compareCards(Deck deck1, Deck deck2,
                                                Deck discard1, Deck discard2,
                                                ArrayList<Card> pile){
        Card card1 = deck1.getTopCard();
        Card card2 = deck2.getTopCard();
        System.out.printf("Comparing %s to %s\n",card1.toString(),card2.toString());

        pile.add(card1);
        pile.add(card2);

        if (card1.getNumber() - card2.getNumber() > 0){
            System.out.println("Player 1 wins round.");
            for (int i = 0; i < pile.size(); i++){
                discard1.addCard(pile.get(i));
            }
        }
        else if (card1.getNumber() - card2.getNumber() < 0){
            System.out.println("Player 2 wins round.");
            for (int i = 0; i < pile.size(); i++){
                discard2.addCard(pile.get(i));
            }
        }
        else{
            System.out.println("Cards tied. Calling recusively."); //debug
            compareCards(deck1, deck2, discard1, discard2, pile);

        }
    }

    private static void playWar(Scanner scnr){
        System.out.println("Let's play war!\n");

        // initialize decks
        Deck player1 = new Deck(false);
        player1.shuffle();
        Deck player2 = player1.split();

        Deck discard1 = new Deck();
        Deck discard2 = new Deck();

        ArrayList<Card> dummy = new ArrayList<Card>();

        for (int i = 0; i < player1.getSize(); i++){
            compareCards(player1, player2, discard1, discard2, dummy);
        }
        if (discard1.getSize() > discard2.getSize()){
            System.out.println("\nPlayer 1 wins!");
        }
        else if (discard1.getSize() < discard2.getSize()){
            System.out.println("\nPlayer 2 wins!");
        }
        else{
            System.out.println("Game tied.");
        }


    }

    public static void main(String[] args){
        System.out.println("This program plays a game of War.");

        //initialize scanner & handlers
        Scanner keyboard = new Scanner(System.in);
        char checkChar;
        boolean cont = true;

        /*
        // debug prints
        System.out.println("Decks created successfully. Checking their contents below...\n");
        System.out.printf("----------------\nPlayer 1's deck...\n%s\n\n",player1.toString());
        System.out.printf("----------------\nPlayer 1's deck...\n%s\n\n",player2.toString());
        */


        while (cont){
            checkChar = ' ';

            playWar(keyboard);

            //checks to see if the user wants to play again.
            while (checkChar != 'Y' && checkChar != 'N') {
                System.out.print("Would you like to play again? Y/N: ");
                checkChar = Character.toUpperCase(keyboard.nextLine().charAt(0));
                if (checkChar == 'N') {
                    cont = false;
                }
                if (checkChar != 'Y' && checkChar != 'N') {
                    System.out.println("Please enter Y or N.");
                }
            }
        }

    }
}
