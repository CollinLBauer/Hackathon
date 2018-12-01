/*
 * War.java
 *
 * Plays a game of War.
 *
 */

import java.util.Scanner;

public class War{

    private static int compareCards(Card card1, Card card2){
        return card1.getNumber() - card2.getNumber();
    }

    private static void playWar(Scanner scnr){
        System.out.println("Let's play war!");

        // initialize decks
        Deck player1 = new Deck(false);
        player1.shuffle();
        Deck player2 = player1.split();

        Deck discard1 = new Deck();
        Deck discard2 = new Deck();

        Card card1;
        Card card2;
        for (int i = 0; i < player1.getSize(); i++){
            card1 = player1.getTopCard();
            card2 = player2.getTopCard();
            if (compareCards(card1, card2)

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
