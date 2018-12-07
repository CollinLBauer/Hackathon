import java.util.ArrayList;
import java.util.Random;

public class StdDeck extends Deck{

    /* Deck constructor; creates a standard deck of cards
     * Accepts a boolean as an argument, which specifies whether the deck has jokers.
     * Creates cards Ace through King in each of the four sets,
     *   and adds them to the deck.
     * If the deck has jokers, it adds two jokers.
     */
    public StdDeck(boolean joker) {
        myDeck = new ArrayList<>();
        String[] suits = {"Diamonds", "Hearts", "Spades", "Clubs"};

        for (int i =0; i < suits.length; i++) {
            
            for (int j = 1; j < 14; j ++) {
                StdCard myCard = new StdCard(suits[i],j);
                myDeck.add(myCard);
            }

        }

        int i = 0;
        while (joker && i < 2) {
            Card myCard = new StdCard("", 0);
            myDeck.add(myCard);
            i += 1;
        }
    }

    /* Deck constructor, creates an arbitrary deck of cards
     * Accepts an ArrayList<Card> as an argument
     * This is primarily used by the Deck.split method, but may be
     *   used to convert other Class types to a deck.
     */
    public StdDeck(ArrayList<Card> arrList) {
        super(arrList);
    }

    /* Deck constructor, creates an empty deck
     * Default constructor with no arguments
     */
    public StdDeck(){
        super();
    }


    // main method, for testing purposes
    public static void main(String[] args) {
        Deck jokerDeck = new StdDeck(true);


        //jokerDeck.shuffle();
        //System.out.println(jokerDeck);

        Deck splitDeck = jokerDeck.split();
        System.out.println(jokerDeck);
        System.out.println("\n-----------------------\n" + splitDeck);
    }
}