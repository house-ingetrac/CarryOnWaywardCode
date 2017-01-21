import cs1.Keyboard;
import java.util.Collections;
import java.util.ArrayList;

public class Blackjack extends Minigames{
    private int counter = 2;
    private Woo player;
    private String[] suits = { "of diamonds", "of clubs", "of hearts", "of spades"};
    ArrayList combination = new ArrayList();
    int totalCards;
    String firstTwo;
    String addedCards;
    
    public Blackjack() {
	betAmount = 0;
	multiplier = 1;
	player = new Woo();
	totalCards = 0;
    }
    public Blackjack(Woo playman){
	betAmount = 0;
	multiplier = 1;
	totalCards = 0;
	player = playman;
	firstTwo = combination.get(0) + " and " + combination.get(1);
	for(String suit: suits) {
	    for (int i = 0; i <= 10; i++) {
		combination.add(i+suit);
		combination.add("Jack " + suit);
		combination.add("Queen " + suit);
		combination.add("King " + suit);
		combination.add("Ace " + suit); //for now, ace = 1;	
	    }
	}
    }

    public void play() {
	Collections.shuffle(combination);
	
	while (true) {
	    if (player.getMoney() <= 0){
		System.out.println("You've run out of money!");
	    }

	    String s = "Welcome to Blackjack!\n";
	    s += "1. Play Game\n";
	    s += "2. Go Back\n";
	    System.out.print(s);

	    int response = Keyboard.readInt();

	    if (response == 2) return;

	    if (response == 1) {
		s = "Place your bet!\n";
		System.out.print(s);
		bet();

		String b = "The dealer shuffles the deck. He hands it to you to cut.\n";
		b += "1. Cut the deck\n";
		b += "2. Take the cards and use it as a weapon against the dealer.\n";
		System.out.print(s);

		int response1 = Keyboard.readInt();

		if (response1 == 2) {
		    b = "Just kidding. That's probably a bad idea.\n";
		    System.out.print(s);
		    return;
		}

		if (response1 == 1) {
		    b = "You cut the deck, and the plastic insert card is placed.\n";
		    System.out.print(b);
		    System.out.println("You receive your two cards. They are:\n");
		    System.out.println(firstTwo);
		    Boolean stand = false;
		    while (totalCards <= 21 || stand == true) {
			b = "1.Hit or 2. Stand?\n";
			b += "1. Hit\n";
			b += "2. Stand";
			System.out.print(b);

			int response2 = Keyboard.readInt();

			if (response2 == 1) {
			    System.out.println("Your new card is:");
			    showCard();
			    totalCards += showCard();
			}
		    }
		}
	    }
	}
    }
				


    /* private int showCards() {
	firstTwo = combination.get(0) + " and " + combination.get(1));
	}*/

      private int showCard() {
        return combination.get(counter);
	counter += 1;
    }

    private void readComb() {
	for (i : combination) {
	    if (i.substring(0,1) > 0 && (i.substring(0,1) < 10))
		int valueOf = i.substring(0,1);
	    if (i == "King"
       private void bet(){
        int holder = Keyboard.readInt();
	
	if (holder > player.getMoney()){
	    System.out.println("Amount greater than what you have on hand. Try again:");
	    bet();
	}

	else{
	    betAmount = holder;
	    player.alterMoney(betAmount * -1);
	    System.out.println("Bet placed. Your money is now " + player.getMoney() + ".");
	}
    }
   
}
