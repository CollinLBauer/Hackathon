/*
 * War.java
 *
 * Plays a game of War.
 *
 */

public class War{

    public static void main(String[] args){
        System.out.println("Let's play war!");

        Deck player1 = new Deck(false);
        player1.shuffle();
        Deck player2 = player1.split();

        // debug prints
        System.out.println("Decks created successfully. Checking their contents below...\n");
        System.out.printf("----------------\nPlayer 1's deck...\n%s\n\n",player1.toString());
        System.out.printf("----------------\nPlayer 1's deck...\n%s\n\n",player2.toString());

    }
}
