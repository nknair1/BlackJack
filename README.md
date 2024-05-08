# BlackJack
Introduction
My motivation for doing this project was to use my Java skills and have fun making a project of something that I like. Though we learned a lot throughout the semester and had tons of labs that utilized various knowledge we learned, the labs for me were more assignments rather than practical ideas that put my newly gained knowledge into perspective. By making a game like BlackJack, which is one of my favorite card games due to its simplicity but also high ‘fun factor’ I was able to have fun with the result of something I made. Not only was it difficult, requiring multiple files, and a lot of different classes and knowledge of object-oriented programming, but it was also something I enjoyed making. 
The aim of the project was to make a single-player BlackJack game with a scoreboard that accumulated points throughout multiple games. The dealer and the player would get a hand, and getting to 21 or the closest to 21 is the game's goal and how to win. 

Requirements
Basic Requirements as outlined by the requirement paper: 
Utilize a significant amount of the material we are learning in the course, including:
Object Oriented programming concepts like:
o Encapsulation &amp; Data Hiding
o Composition
o Inheritance &amp; Polymorphism
o Interfaces
o Abstract Classes
Data Structures like:
o Linked Lists
o Stacks &amp; Queues
o Binary Search Trees
Algorithms like
o Quicksort &amp; Merge sort
o Other sorting algorithms
o Binary search, Quick search &amp; other search algorithms
Algorithmic Analysis
o Big - O
And Requirements to turn in: 
Project Proposal
2. Two progress reports
progress in the project
3. A final report (5 to 10 pages) containing the following sections:
a. Introduction: Explain your motivation for doing this project. Explain the aim of the project
b. Requirements: Clearly state the requirements for this project (what should be done).
c. Design: Provide your final design, including class diagram and a UML class diagram.
d. Implementation: Code with comments. The code should be published on a git account.
e. Testing: Automated unit tests with sample test data.
f. User manual: instruction on how to use the program.
g. Conclusion: Comment on the outcome of the project. Log time spent for each activity (research,
requirements, design, implementation, testing, reporting). Comment on steps for future effort, what minor bugs are left out or any new features can you recommend be added.
h. References: Any resources used as a reference
4. Presentation
Testing
Test Class: 
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





Results: 
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
Cards dealt!
Your hand: 5 of Hearts, 2 of Spades Value: 7
Game Started...
All Results Matched. 

Sample Playthrough Results
Cards dealt!
Your hand: 9 of Hearts, 3 of Spades Value: 12
Hit or Stand? (Enter H or S): 
h
Your hand: 9 of Hearts, 3 of Spades, Jack of Clubs Value: 22
Dealer's turn...
Dealer's hand: 6 of Diamonds, 2 of Diamonds, Ace of Clubs Value: 19
You bust! Dealer wins.
Your hand: 9 of Hearts, 3 of Spades, Jack of Clubs Value: 22
Dealer's hand: 6 of Diamonds, 2 of Diamonds, Ace of Clubs Value: 19
Player Score: 0
Dealer Score: 1

Play again? (Y/N): 
y
Cards dealt!
Your hand: 9 of Spades, 7 of Diamonds Value: 16
Hit or Stand? (Enter H or S): 
h
Your hand: 9 of Spades, 7 of Diamonds, Jack of Hearts Value: 26
Dealer's turn...
Dealer's hand: 3 of Hearts, 8 of Hearts, 4 of Spades Value: 15
Dealer's hand: 3 of Hearts, 8 of Hearts, 4 of Spades, 5 of Clubs Value: 20
You bust! Dealer wins.
Your hand: 9 of Spades, 7 of Diamonds, Jack of Hearts Value: 26
Dealer's hand: 3 of Hearts, 8 of Hearts, 4 of Spades, 5 of Clubs Value: 20
Player Score: 0
Dealer Score: 2

Play again? (Y/N): 
y
Cards dealt!
Your hand: 6 of Spades, 4 of Spades Value: 10
Hit or Stand? (Enter H or S): 
h
Your hand: 6 of Spades, 4 of Spades, 6 of Hearts Value: 16
Hit or Stand? (Enter H or S): 
h
Your hand: 6 of Spades, 4 of Spades, 6 of Hearts, 2 of Clubs Value: 18
Hit or Stand? (Enter H or S): 
s
You stand.
Dealer's turn...
Dealer's hand: 6 of Clubs, 3 of Hearts, 2 of Hearts Value: 11
Dealer's hand: 6 of Clubs, 3 of Hearts, 2 of Hearts, 8 of Hearts Value: 19
Dealer wins!
Your hand: 6 of Spades, 4 of Spades, 6 of Hearts, 2 of Clubs Value: 18
Dealer's hand: 6 of Clubs, 3 of Hearts, 2 of Hearts, 8 of Hearts Value: 19
Player Score: 0
Dealer Score: 3

Play again? (Y/N): 
y
Cards dealt!
Your hand: Ace of Spades, 4 of Clubs Value: 15
Hit or Stand? (Enter H or S): 
h
Your hand: Ace of Spades, 4 of Clubs, Queen of Diamonds Value: 15
Hit or Stand? (Enter H or S): 
h
Your hand: Ace of Spades, 4 of Clubs, Queen of Diamonds, Ace of Diamonds Value: 16
Hit or Stand? (Enter H or S): 
h
Your hand: Ace of Spades, 4 of Clubs, Queen of Diamonds, Ace of Diamonds, 6 of Diamonds Value: 22
Dealer's turn...
You bust! Dealer wins.
Your hand: Ace of Spades, 4 of Clubs, Queen of Diamonds, Ace of Diamonds, 6 of Diamonds Value: 22
Dealer's hand: 10 of Hearts, 7 of Diamonds Value: 17
Player Score: 0
Dealer Score: 4

Play again? (Y/N): 
n
Thanks for playing!
Accurate Value and Score Incrementation

Manual(How to Play):
Follows the rules of BlackJack. Simply hit or stand, and try and get close to 21 without going over it. It is based on luck. Ace is usually 11 but will become 1 if you go over 21. The faces are all 10s. 

Conclusion
The project was a success, and I could utilize many of the skills I learned to make a fun game throughout the creation process. It was also challenging with many bugs encountered throughout it, but even these bugs were fun going through and figuring out. At the end of the project, not only did I feel accomplished, I felt satisfied with how I made the game, and the fact that I myself could now play it and use it when I want to. 




Log Time
Research on BlackJack and Programming: 2 hr
Design: 30 - 1.5 hrs
Implementation: 6 - 8 hrs(alltogether)
Bug Fixing/Testing: 2 hrs(all together)

Future Ideas
Currently, I have an unimplemented clearHand in comments because I realized my startGame could make a new Hand each time, instead of implementing clearHand. Though this is fine for now, it could cause long-term memory issues, if this game becomes more memory intensive. I want to connect this game to card assets to see it being played instead of just having text on the screen. 

References
LucidChart
VSCode
https://www.venetianlasvegas.com/casino/table-games/how-to-play-blackjack.html#:~:text=Players%20receive%20all%20cards%20face,and%2010s%20count%20as%2010.
https://books.trinket.io/thinkjava/chapter12.html
