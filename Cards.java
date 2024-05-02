public class Cards {
    private String suit;
    private String rank;

    public Cards(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public String getSuit() {
        return suit;
    }

    public String getRank() {
        return rank;
    }

    public int getValue() {
        int value;
        try {
            value = Integer.parseInt(rank); 
        } catch (NumberFormatException e) {
            switch (rank) {
                case "Ace":   value = 11; break;
                case "Jack":  
                case "Queen": 
                case "King":  value = 10; break;
                default:       value = 0; break; 
            }
        }
        return value;
    }
    
    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}