import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Cards> cards;

    public Deck() {
        cards = new ArrayList<>();
        createDeck();
    }

    private void createDeck() {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};

        for (String suit : suits) {
            for (String rank : ranks) {
                cards.add(new Cards(suit, rank));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Cards dealCard() {
        if (cards.isEmpty()) {
            return null; 
        }
        return cards.remove(0); 
    }
    
    public boolean isEmpty() {
        return cards.isEmpty();
    }
}