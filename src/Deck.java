import java.util.ArrayList;
import java.util.Random;

public class Deck implements Comparable{
    protected ArrayList<Card> myDeck;

    /* Deck constructor, creates an empty deck
     * Default constructor with no arguments
     * Accepts any Card objects in the array
     */
    public Deck(){
        myDeck = new ArrayList<Card>();
    }

    /* Deck constructor, creates an arbitrary deck of cards
     * Accepts an ArrayList<Card> as an argument
     * This is primarily used by the Deck.split method, but may be
     *   used to convert other Class types to a deck.
     */
    public Deck(ArrayList<Card> arrList) {
        myDeck = arrList;
    }

    // returns the size of a deck
    public int getSize() {
        return myDeck.size();
    }

    // adds a card to the top of the deck
    public void addCard(Card newCard) {
        myDeck.add(newCard);
    }

    // removes and returns the top card of the deck
    public Card getTopCard() {
        Card temp = myDeck.get(0);
        myDeck.remove(0);
        return temp;
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
        String rtnStr = "";
        for (int i = 0; i < myDeck.size() - 1; i++) {
            rtnStr += myDeck.get(i) + "\n\n";
        }
        rtnStr += myDeck.get(myDeck.size() - 1);

        return rtnStr;
    }



    /* compareTo method
     * returns the difference in size of two decks
     */
    public int compareTo(Object otherDeck) {
        if (otherDeck instanceof Deck) {
            Deck temp = (Deck) otherDeck;
            return myDeck.size() - temp.getSize();
        }
        else{
            System.out.println("Warning: not of same type");
            return 0;
        }

    }
}
