public class Card{
    private String suit;
    private int number;

    public Card(String mySuit, int myNum) {
        suit = mySuit;
        number = myNum;
    }

    public String getSuit() {
        return suit;
    }

    public int getNumber() {
        return number;
    }

    public String toString() {
        String rtnStr = "";
        switch(number) {
            case 0:
                rtnStr += "Joker";
                break;
            case 1:
                rtnStr += "Ace";
                break;
            case 11:
                rtnStr += "Jack";
                break;
            case 12:
                rtnStr += "Queen";
                break;
            case 13:
                rtnStr += "King";
                break;
            default:
                rtnStr += number;
        }
        if (number != 0){
            rtnStr += String.format(" of %s",suit);
        }
        return rtnStr;
    }

    public static void main(String[] args) {
        Card king = new Card("Diamonds", 13);
        System.out.println(king);
    }
}