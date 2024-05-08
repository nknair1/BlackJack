import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> cards;
    // Constructor
    public Deck() {
        cards = new ArrayList<Card>();
    }
    // Creates a Deck
    public void createDeck() {
        // Suits and ranks for a standard deck of cards
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};

        // Create all 52 cards
        for (String suit : suits) {
            for (String rank : ranks) {
                cards.add(new Card(suit, rank));
            }
        }
    }
    // Gets all Cards in Deck
    public ArrayList<Card> getCards() {
        return cards;
    }
    // Shuffles Deck
    public void shuffle() {
        Collections.shuffle(cards);  // Use the built-in shuffle method
    }
    // Deals Cards. Will pass to addCard method in Hand Class to be Used In Game Class
    public Card dealCard() {
        if (cards.size() > 0) {
            return cards.remove(0); // Remove and return the top card
        } else {
            return null; // Return null if the deck is empty
        }
    }
   
}
