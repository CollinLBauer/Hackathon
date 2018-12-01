public class Card{
    private String suit;
    private String number;

    public Card(String mySuit, String myNum) {
        suit = mySuit;
        number = myNum;
    }

    public String getSuit() {
        return suit;
    }

    public String getNumber() {
        return number;
    }

    public String toString() {
        return "Number: " + number + "\nSuit: " + suit;
    }

    public static void main(String[] args) {
        Card king = new Card("Diamonds", "King");
        System.out.println(king);
    }
}