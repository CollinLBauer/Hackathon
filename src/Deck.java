import java.util.ArrayList;
import java.util.Random;

public class Deck {
    protected ArrayList<Card> myDeck;

    /* Deck constructor; creates a standard deck of cards
     * Accepts a boolean as an argument, which specifies whether the deck has jokers.
     * Creates cards Ace through King in each of the four sets,
     *   and adds them to the deck.
     * If the deck has jokers, it adds two jokers.
     */
    public Deck(boolean joker) {
        myDeck = new ArrayList<Card>();
        String[] suits = {"Diamonds", "Hearts", "Spades", "Clubs"};

        for (int i =0; i < suits.length; i++) {
            
            for (int j = 1; j < 14; j ++) {
                Card myCard = new Card(suits[i],j);
                myDeck.add(myCard);
            }

        }

        int i = 0;
        while (joker && i < 2) {
            Card myCard = new Card("N/A", 0);
            myDeck.add(myCard);
            i += 1;
        }
    }

    /* Deck constructor, creates an arbitrary deck of cards
     * Accepts an ArrayList<Card> as an argument
     * This is primarily used by the Deck.split method, but may be
     *   used to convert other Class types to a deck.
     */
    public Deck(ArrayList<Card> arrList) {
        myDeck = arrList;
    }

    /* Deck constructor, creates an empty deck
     * Default constructor with no arguments
     */
    public Deck(){
        myDeck = new ArrayList<Card>();
    }


    // Removes the top half of a deck and returns it as a new deck
    public Deck split() {
        int halfSize = myDeck.size()/2;
        ArrayList<Card> halfDeck = new ArrayList<Card>();
        for (int i = 0; i < halfSize; i++){
            halfDeck.add(this.getTopCard());
        }

        return new Deck(halfDeck);
    }

    // returns the string representation of the deck
    public String toString() {
        String theString = "";
        for (int i = 0; i < myDeck.size() - 1; i++) {
            theString += myDeck.get(i) + "\n\n";
        }
        theString += myDeck.get(myDeck.size() - 1);

        return theString;
    }

    // removes and returns the top card of the deck
    public Card getTopCard() {
        Card temp = myDeck.get(0);
        myDeck.remove(0);
        return temp;
    }

    // returns the size of a deck
    public int getSize() {
        return myDeck.size();
    }


    // adds a card to the top of the deck
    public void addCard(Card newCard) {
        myDeck.add(newCard);
    }



    // shuffles the deck
    public void shuffle() {
        Random rand = new Random();
        for (int i = 0; i < myDeck.size(); i++) {
            int myInt = rand.nextInt(myDeck.size());
            Card temp = myDeck.get(i);
            myDeck.set(i, myDeck.get(myInt));
            myDeck.set(myInt, temp);
        }
        for (int i = 0; i < myDeck.size(); i++) {
            int myInt = rand.nextInt(myDeck.size());
            Card temp = myDeck.get(i);
            myDeck.set(i, myDeck.get(myInt));
            myDeck.set(myInt, temp);
        }
    }

    public static void main(String[] args) {
        Deck jokerDeck = new Deck(true);


        //jokerDeck.shuffle();
        //System.out.println(jokerDeck);

        Deck splitDeck = jokerDeck.split();
        System.out.println(jokerDeck);
        System.out.println("\n-----------------------\n" + splitDeck);
    }
}