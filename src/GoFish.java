import java.util.ArrayList;
import java.util.Scanner;

public abstract class GoFish {
    private static Hand playerHand;
    private static ArrayList<Hand> aiHands;
    private static Deck theDeck;
    private static int playerScore;
    private static ArrayList<Integer> aiScores;
    private static int aiScore;
    private static Scanner keyboard = new Scanner(System.in);

    public static void initGame(int numPlayers) {
        theDeck = new Deck(false);
        theDeck.shuffle();
        playerHand  = new Hand(5, theDeck);
        for (int i = 0; i < numPlayers - 1; i++) {
            aiHands.add(Hand(5, theDeck));
            aiScores.add(0);
        }
        playerScore = 0;
    }

    public static void ask() {
        System.out.print("Which player would you like to ask? ");
        System.out.print("Enter ");
        for (int i = 0; i < aiHands.size(); i++) {
            System.out.print(" " + i + ", ");
        }
        int aiHandIndex = keyboard.nextInt();
        Hand theAi = aiHands.get(aiHandIndex);

        System.out.println("Enter the card number you want to ask them for");
        int cardNumber = keyboard.nextInt();

        boolean cardFound = false;
        int i = 0;
        do {
            
            cardFound = theAi.seeCard(i).getNumber() == cardNumber;
            i += 1;
        } while (!cardFound && i < aiHands.get(aiHandIndex).length);

        if (cardFound) {
            System.out.println("I do have that card!");
            playerHand.addToHand(theAi.remove(i-1));
            System.out.println("You just got the card " + playerHand.seeCard(playerHand.length-1));
        }

        else {
            System.out.println("Go FISH!");
            playerHand.draw(theDeck);
        }

    }

    private static boolean equals(Card card1, Card card2) {
        return card1.getNumber() == card2.getNumber();

    }


}