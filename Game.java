import java.util.Scanner;

public class Game {
    private Deck deck;
    private Hand playerHand;
    private Hand dealerHand;
    private int playerScore = 0;
    private int dealerScore = 0;

    public void startGame() {
        deck = new Deck();
        deck.createDeck();
        deck.shuffle();

        playerHand = new Hand();
        dealerHand = new Hand();

        // Deal initial cards (two to each)
        playerHand.addCard(deck.dealCard());
        dealerHand.addCard(deck.dealCard());
        playerHand.addCard(deck.dealCard());
        dealerHand.addCard(deck.dealCard());

        System.out.println("Cards dealt!");
        System.out.println("Your hand: " + playerHand + " Value: " + playerHand.calculateValue());
        System.out.println("Dealer's hand: " + dealerHand.getCard(0) + " and [Hidden Card]");
    }

    public void playerTurn(Scanner scanner) { // Accepts Scanner as a parameter
        while (true) {
            System.out.println("Hit or Stand? (Enter H or S): ");
            String input = scanner.nextLine().toUpperCase();
            playerHand.calculateValue();
            if (input.equals("H")) {
                playerHand.addCard(deck.dealCard());
                playerHand.calculateValue();
                System.out.println("Your hand: " + playerHand + " Value: " + playerHand.calculateValue());
                if (playerHand.calculateValue() > 21) {
                    return; 
                }
            } else if (input.equals("S")) {
                playerHand.calculateValue();
                System.out.println("You stand.");
                return; 
            } else {
                System.out.println("Invalid input. Please enter H or S.");
            }
        }
    }

    public void dealerTurn() {
        System.out.println("Dealer's turn...");
        while (dealerHand.calculateValue() < 17) { 
            dealerHand.addCard(deck.dealCard());
            dealerHand.calculateValue();
            System.out.println("Dealer's hand: " + dealerHand + " Value: " + dealerHand.calculateValue());
        }
    }

    public void determineWinner() {
        int playerValue = playerHand.calculateValue();
        int dealerValue = dealerHand.calculateValue();
    
        if (playerValue > 21) {
            System.out.println("You bust! Dealer wins.");
            dealerScore++;
        } else {  // Only check other conditions if the player hasn't busted
            if (dealerValue > 21) {
                System.out.println("Dealer busts! You win.");
                playerScore++;
            } else if (playerValue > dealerValue) {
                System.out.println("You win!");
                playerScore++;
            } else if (dealerValue > playerValue) {
                System.out.println("Dealer wins!");
                dealerScore++;
            } else {
                System.out.println("It's a tie!");
            }
        }
    }

    public void displayCards() {
        System.out.println("Your hand: " + playerHand.toString() + " Value: " + playerHand.calculateValue());
        System.out.println("Dealer's hand: " + dealerHand.toString() + " Value: " + dealerHand.calculateValue());
        System.out.println("Player Score: " + playerScore);
        System.out.println("Dealer Score: " + dealerScore);
    }
}
