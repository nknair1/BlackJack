import java.util.LinkedList;

public class Hand {
    private LinkedList<Card> cards;
    // Constructor
    public Hand() {
        cards = new LinkedList<>(); 
    }
    
    public void addCard(Card card) {
        cards.add(card);
    }
    
    public int calculateValue() {
        int totalValue = 0;
        int aceCount = 0; 
    
        // First, calculate the total value assuming Aces are 11
        for (Card card : cards) {
            int cardValue = card.getValue();
            if (cardValue == 11) { // Check for Ace (originally valued at 11)
                aceCount++;
            } 
            totalValue += cardValue;
        }
    
        // Adjust for Aces being 1 if the total value exceeds 21
        while (totalValue > 21 && aceCount > 0) {
            totalValue -= 10; // Change Ace value from 11 to 1
            aceCount--;
        }
    
        return totalValue;
    }

    public Card getCard(int index) {
        if (index >= 0 && index < cards.size()) {
            return cards.get(index);
        } else {
            return null; // or throw an exception for invalid index
        }
    }
    @Override
    public String toString() {
        String handString = "";
        for (Card card : cards) {
            handString += card + ", "; // Add each card's string representation
        }
        // Remove the last comma and space
        if (!handString.isEmpty()) {
            handString = handString.substring(0, handString.length() - 2);
        }
        return handString;
    }
    /* Not Necessary due to Current Implimentation
    public void clearHand() {
        cards.clear();
    }
    */
}
