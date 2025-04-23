# BlackJack

## Introduction

This project was created to apply Java programming skills learned during a course to a fun and engaging application. The goal was to move beyond simple lab exercises and build something more practical and enjoyable. Blackjack was chosen due to its familiarity, simple core rules, and potential for interesting programming challenges.

The primary aim was to develop a single-player, text-based Blackjack game where the player competes against a dealer. The game needed to track scores across multiple rounds and implement the standard rules of Blackjack: aiming to get a hand value as close to 21 as possible without exceeding it. The project involved implementing core game logic, card shuffling, hand evaluation (including Ace handling), and managing the game flow.

## Project Assignment Requirements

This project was developed as part of a course and aimed to fulfill the following requirements:

**Core Concepts:**

* **Object-Oriented Programming:**
    * Encapsulation & Data Hiding
    * Composition
    * Inheritance & Polymorphism
    * Interfaces
    * Abstract Classes
* **Data Structures:**
    * Linked Lists
    * Stacks & Queues
    * Binary Search Trees
* **Algorithms:**
    * Quicksort & Merge sort
    * Other sorting algorithms
    * Binary search, Quick search & other search algorithms
* **Algorithmic Analysis:**
    * Big-O notation

**Deliverables:**

1.  Project Proposal
2.  Two progress reports
3.  A final report (5-10 pages) including:
    * Introduction (Motivation, Aim)
    * Requirements
    * Design (Class diagram, UML)
    * Implementation (Commented code on Git)
    * Testing (Unit tests, sample data)
    * User manual
    * Conclusion (Outcome, time log, future steps)
    * References
4.  Presentation

## How to Play (User Manual)

The game follows standard Blackjack rules:

1.  You and the dealer are dealt two cards each.
2.  Your goal is to get a hand value closer to 21 than the dealer, without going over 21 ("busting").
3.  Card Values:
    * Number cards (2-10) are worth their face value.
    * Face cards (Jack, Queen, King) are worth 10.
    * Aces are worth 11 initially, but automatically become 1 if counting them as 11 would cause your hand to bust.
4.  Gameplay:
    * You will see your hand and its current value.
    * You'll be prompted to 'Hit' (take another card) or 'Stand' (keep your current hand). Enter 'H' to Hit or 'S' to Stand.
    * If you Hit and your hand value exceeds 21, you bust, and the dealer wins the round.
    * If you Stand, the dealer plays their turn according to standard rules (typically hitting until their hand value is 17 or more).
    * The hands are compared, and the winner is determined.
5.  The game keeps track of the player's and dealer's scores over multiple rounds.
6.  You can choose to play again after each round.

## Implementation Notes

* The game is implemented in Java.
* It utilizes Object-Oriented principles to model game components like `Card`, `Deck`, `Hand`, and `Game`.
* Standard Java collections are likely used for managing the deck and hands.

## Testing

### Unit Test Code

A simple test method was used to verify core components:

```java
public static void test() {
    // Test Card Class
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

    // Test Ace Functionality (Value changes from 11 to 1)
    Card card3 = new Card("Clubs", "Ace");
    System.out.println("Card 3 Suit: " + card3.getSuit()); // Expected: Clubs
    System.out.println("Card 3 Rank: " + card3.getRank()); // Expected: Ace
    System.out.println("Card 3 Value: " + card3.getValue()); // Expected: 11
    Hand hand2 = new Hand();
    hand2.addCard(card1); // Ace (11)
    hand2.addCard(card2); // 10 (Total 21)
    hand2.addCard(card3); // Ace (becomes 1)
    System.out.println("Hand Value: " + hand2.calculateValue()); // Expected: 12 (1 + 10 + 1)

    // Test Game Class (partially, as it requires user input)
    // Game game = new Game(); // Actual game start requires interaction
    // game.startGame();
    System.out.println("Game Start Test Point Reached..."); // Confirmation test runs
}
```

### Unit Test Results

```
Card 1 Suit: Hearts
Card 1 Rank: Ace
Card 1 Value: 11
Card 2 Suit: Diamonds
Card 2 Rank: 10
Card 2 Value: 10
Deck Size Before Shuffle: 52
Deck Size After Shuffle: 52
Dealt Card: 2 of Hearts
Hand Value: 21
Card 3 Suit: Clubs
Card 3 Rank: Ace
Card 3 Value: 11
Hand Value: 12
Game Start Test Point Reached...
```

**Result:** All tested components behaved as expected.

### Sample Gameplay / Manual Testing

Here's an example of game sessions:

```
Cards dealt!
Your hand: 9 of Hearts, 3 of Spades Value: 12
Hit or Stand? (Enter H or S): h
Your hand: 9 of Hearts, 3 of Spades, Jack of Clubs Value: 22
Dealer's turn...
Dealer's hand: 6 of Diamonds, 2 of Diamonds, Ace of Clubs Value: 19
You bust! Dealer wins.
Your hand: 9 of Hearts, 3 of Spades, Jack of Clubs Value: 22
Dealer's hand: 6 of Diamonds, 2 of Diamonds, Ace of Clubs Value: 19
Player Score: 0
Dealer Score: 1

Play again? (Y/N): y
Cards dealt!
Your hand: 9 of Spades, 7 of Diamonds Value: 16
Hit or Stand? (Enter H or S): h
Your hand: 9 of Spades, 7 of Diamonds, Jack of Hearts Value: 26
Dealer's turn...
Dealer's hand: 3 of Hearts, 8 of Hearts, 4 of Spades Value: 15
Dealer's hand: 3 of Hearts, 8 of Hearts, 4 of Spades, 5 of Clubs Value: 20
You bust! Dealer wins.
Your hand: 9 of Spades, 7 of Diamonds, Jack of Hearts Value: 26
Dealer's hand: 3 of Hearts, 8 of Hearts, 4 of Spades, 5 of Clubs Value: 20
Player Score: 0
Dealer Score: 2

Play again? (Y/N): y
Cards dealt!
Your hand: 6 of Spades, 4 of Spades Value: 10
Hit or Stand? (Enter H or S): h
Your hand: 6 of Spades, 4 of Spades, 6 of Hearts Value: 16
Hit or Stand? (Enter H or S): h
Your hand: 6 of Spades, 4 of Spades, 6 of Hearts, 2 of Clubs Value: 18
Hit or Stand? (Enter H or S): s
You stand.
Dealer's turn...
Dealer's hand: 6 of Clubs, 3 of Hearts, 2 of Hearts Value: 11
Dealer's hand: 6 of Clubs, 3 of Hearts, 2 of Hearts, 8 of Hearts Value: 19
Dealer wins!
Your hand: 6 of Spades, 4 of Spades, 6 of Hearts, 2 of Clubs Value: 18
Dealer's hand: 6 of Clubs, 3 of Hearts, 2 of Hearts, 8 of Hearts Value: 19
Player Score: 0
Dealer Score: 3

Play again? (Y/N): y
Cards dealt!
Your hand: Ace of Spades, 4 of Clubs Value: 15
Hit or Stand? (Enter H or S): h
Your hand: Ace of Spades, 4 of Clubs, Queen of Diamonds Value: 15 (Ace = 1)
Hit or Stand? (Enter H or S): h
Your hand: Ace of Spades, 4 of Clubs, Queen of Diamonds, Ace of Diamonds Value: 16 (Ace = 1, Ace = 1)
Hit or Stand? (Enter H or S): h
Your hand: Ace of Spades, 4 of Clubs, Queen of Diamonds, Ace of Diamonds, 6 of Diamonds Value: 22
Dealer's turn...
You bust! Dealer wins.
Your hand: Ace of Spades, 4 of Clubs, Queen of Diamonds, Ace of Diamonds, 6 of Diamonds Value: 22
Dealer's hand: 10 of Hearts, 7 of Diamonds Value: 17
Player Score: 0
Dealer Score: 4

Play again? (Y/N): n
Thanks for playing!
```

**Result:** Game logic, Ace handling, scoring, and round progression appear to function correctly based on sample playthroughs.

## Conclusion

The project successfully met its goal of creating a functional, text-based Blackjack game. It provided a valuable opportunity to apply learned Java concepts, particularly object-oriented design, in a practical and enjoyable context. While challenging at times, debugging and refining the game logic proved to be a rewarding learning experience. The final result is a playable game that serves as a satisfying demonstration of the skills acquired.

## Future Ideas

* **Memory Management:** Currently, a new `Hand` object might be created for each game round instead of clearing the existing one (the `clearHand` method was commented out). Implementing `clearHand` properly could improve memory efficiency, especially if the game were expanded or run for extended periods.
* **Graphical User Interface (GUI):** Replace the text-based interface with a visual one, potentially using libraries like Swing or JavaFX. Displaying actual card images would significantly enhance the user experience.
* **Advanced Features:** Implement features like splitting pairs, doubling down, or insurance bets.
* **AI Opponent:** Improve the dealer's strategy or add different AI player personalities.

## Time Log (Assignment Requirement)

* **Research (Blackjack rules, Java concepts):** 2 hours
* **Design (Class structure, logic):** 1 - 1.5 hours
* **Implementation (Coding):** 6 - 8 hours (cumulative)
* **Testing & Bug Fixing:** 2 hours (cumulative)

## References

* **Class Diagramming:** LucidChart
* **IDE:** VSCode
* **Blackjack Rules:** [The Venetian Las Vegas - How to Play Blackjack](https://www.venetianlasvegas.com/casino/table-games/how-to-play-blackjack.html#:~:text=Players%20receive%20all%20cards%20face,and%2010s%20count%20as%2010)
* **Java Concepts/Examples:** [Think Java - Chapter 12 (Objects)](https://books.trinket.io/thinkjava/chapter12.html)
