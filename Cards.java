public class Card {
    private String suit; // "Hearts", "Diamonds", "Clubs", "Spades"
    private String rank; // "Ace", "2", "3", ..., "10", "Jack", "Queen", "King"
    // Class constructor
    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }
    // Gets suit of Card
    public String getSuit() {
        return suit;
    }
    // Gets rank of Card
    public String getRank() {
        return rank;
    }

    // Method to get the value of the card for Blackjack
    public int getValue() {
        if (rank.equals("Ace")) {
            return 11; // Ace can be 1 or 11, initially set to 11
        } else if (rank.equals("King") || rank.equals("Queen") || rank.equals("Jack")) {
            return 10;
        } else {
            return Integer.parseInt(rank); // Numerical ranks (2-10)
        }
    }

    // Override toString() method for easy printing
    @Override
    public String toString() {
        return rank + " of " + suit;
    }
} 
