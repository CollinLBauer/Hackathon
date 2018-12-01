public class Card implements Comparable{
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

    public int compareTo(Object o){
        return -1;
    }

    public String toString() {
        return "Number: " + number + "\nSuit: " + suit;
    }
    public static void main(String[] args) {
        Card king = new Card("Diamonds", "K");
        System.out.println(king);
    }
}