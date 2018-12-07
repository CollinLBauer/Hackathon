public class StdCard extends Card{
    private String suit;
    private int number;

    public StdCard(String mySuit, int myNum) {
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

    /* compareTo method
     * Returns the difference of the numerical values of the card's number.
     * Note that different card games may (will probably) use different
     * comparison methods.
     */
    public int compareTo(Object otherCard) {
        if (otherCard instanceof StdCard){
            StdCard temp = (StdCard) otherCard;
            return number - temp.getNumber();
        }
        else {
            return -1;
        }
    }

    public static void main(String[] args) {
        Card king = new StdCard("Diamonds", 13);
        System.out.println(king);
    }
}