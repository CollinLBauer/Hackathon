import java.util.ArrayList;
public class Hand {
    ArrayList<Card> theHand = new ArrayList<Card>();
    public int length;

    public Hand(int draws, Deck theDeck) {
        length = draws;
        for (int i = 0; i < draws; i++)
            draw(theDeck);
    }

    public void draw(Deck theDeck) {
        length += 1;
        theHand.add(theDeck.getTopCard());
    }

    public Card seeCard(int index) {
        return theHand.get(index);
    }

    public Card remove(int index) {
        length -=1;
        Card temp = theHand.get(index);
        theHand.remove(index);
        return temp;
    }


    public void showHand() {
        for (Card item : theHand) {
            System.out.println(item);
        }
    }

    public addToHand(Card e) {
        length += 1;
        theHand.add(e);
    }

    public static void main(String[] args) {
        Deck myDeck = new Deck(false);
        myDeck.shuffle();
        Hand myHand = new Hand(7, myDeck);
        myHand.showHand();
    }
}