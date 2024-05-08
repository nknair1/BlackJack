import java.util.Scanner;
public class Final {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in); 
        Game game = new Game();

        while (true) {
            game.startGame();
            game.playerTurn(scanner); // Pass the scanner to playerTurn
            game.dealerTurn(); 
            game.determineWinner();
            game.displayCards();

            System.out.println("\nPlay again? (Y/N): ");
            String playAgain = scanner.nextLine().toUpperCase();
            if (!playAgain.equals("Y")) {
                break; 
            }
            
        }

        System.out.println("Thanks for playing!");
        scanner.close(); 
        
    }
    public static void test() {
        Card card1 = new Card("Hearts", "Ace");
        System.out.println("Card 1 Suit: " + card1.getSuit()); // Expected: Hearts
        System.out.println("Card 1 Rank: " + card1.getRank()); // Expected: Ace
        System.out.println("Card 1 Value: " + card1.getValue()); // Expected: 11

        Card card2 = new Card("Diamonds", "10");
        System.out.println("Card 2 Suit: " + card2.getSuit()); // Expected: Diamonds
        System.out.println("Card 2 Rank: " + card2.getRank()); // Expected: 10
        System.out.println("Card 2 Value: " + card2.getValue()); // Expected: 10

        // Test Deck Class
        Deck deck = new Deck();
        deck.createDeck();
        System.out.println("Deck Size Before Shuffle: " + deck.getCards().size()); // Expected: 52
        deck.shuffle();
        System.out.println("Deck Size After Shuffle: " + deck.getCards().size()); // Expected: 52 (still)
        Card dealtCard = deck.dealCard();
        System.out.println("Dealt Card: " + dealtCard); // Should print card from the deck

        // Test Hand Class
        Hand hand = new Hand();
        hand.addCard(card1);
        hand.addCard(card2);
        System.out.println("Hand Value: " + hand.calculateValue()); // Expected: 21 

        // Test Ace Functionality
        Card card3 = new Card("Clubs", "Ace");
        System.out.println("Card 3 Suit: " + card3.getSuit()); // Expected: Clubs
        System.out.println("Card 3 Rank: " + card3.getRank()); // Expected: Ace
        System.out.println("Card 3 Value: " + card3.getValue()); // Expected: 11
        Hand hand2 = new Hand();
        hand2.addCard(card1);
        hand2.addCard(card2);
        hand2.addCard(card3);
        System.out.println("Hand Value: " + hand2.calculateValue()); // Expected: 12

        // Test Game Class (partially, as it requires user input)
        Game game = new Game();
        game.startGame();
        System.out.println("Game Started...");
    }
}
