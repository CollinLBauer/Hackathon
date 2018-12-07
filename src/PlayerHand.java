
import java.util.LinkedList;

public class PlayerHand {

    //instance variables
    private LinkedList<Card> hand = new LinkedList<Card>();
    private String playerName;


    public PlayerHand(String name, int initDraws, Deck deck) {
        playerName = name;
        for (int i = 0; i < initDraws; i++)
            draw(deck);
    }

    public String getPlayerName(){
        return playerName;
    }

    public void draw(Deck deck) {
        hand.add(deck.getTopCard());
    }

    public Card checkCard(int index) {
        return hand.get(index);
    }

    public Card playCard(int index) {
        Card temp = hand.get(index);
        hand.remove(index);
        return temp;
    }


    public void showHand() {
        for (Card card : hand) {
            System.out.println(card);
        }
    }

    public void addCard(Card e) {
        hand.add(e);
    }

    public static void main(String[] args) {
        Deck myDeck = new StdDeck(false);
        myDeck.shuffle();
        PlayerHand myHand = new PlayerHand("Player 1", 7, myDeck);
        myHand.showHand();
    }
}