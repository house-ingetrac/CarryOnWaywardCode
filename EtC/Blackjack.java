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
	    s += "2. Eat Burger\n";
	    s += "3. Fight dealer\n";
	    s += "4. Go back\n";
	    System.out.print(s);
	    
	    int response = Keyboard.readInt();
	    
	    if (response == 4) return;
	    
	    if (response == 2){
		eatBurger();
	    }
	    
	    if (response == 1){
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
		    System.out.println(b);
		    System.out.println("You receive your two cards. They are:\n");
		    System.out.println(firstTwo);
		    Boolean stand = false;
		    while (totalCards <= 21 || stand == true) {
			b = "1.Hit or 2. Stand?\n";
			b += "1. Hit\n";
			b += "2. Stand";
			System.out.println(b);

			int response2 = Keyboard.readInt();

			if (response2 == 1) {
			    System.out.println("Your new card is:");
			    showCard();
			    totalCards += showCard();
			    System.out.println("Your total is now: " + totalCards);
				return;
			}
		    }
		}
		
		if (response == 3){
		    RPGBattle();
		    return;
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
	int valueOf = 0;
	for (int i : combination) {
	    if (i.substring(0,1) > 0 && (i.substring(0,1) < 10))
		valueOf = i.substring(0,1);
	    if (i == "King"){}
	}
    }

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

    private void RPGBattle(){
	String s = "Do you want to fight the dealer?\n";
	s += "1. LEEEROOOOOOY JENKIINS!!!\n";
	s += "2. Maybe later\n";
	System.out.print(s);
	
	int response = Keyboard.readInt();
	
	if (response == 2) {
	    System.out.println("You walk away in shame.");
	}
	
	if (response == 1){
	    System.out.println("You load your gun with chips and start shooting at the dealer.");
	    
	    if(player.getMoney() > 150){
		player.rouletteKill = true;
		String msgW = "";
		msgW += "Your shots collide at quasi-relativistic speeds (5 m/s) with the dealer.\n";
		msgW += "He falls to the floor, unconscious, and you leave victorious.";
		System.out.println(msgW);
	    }
	    else{
		String msgL = "";
		msgL += "You realize too late that you do not have enough chips in the gun to do anything useful.\n";
		msgL += "The dealer throws a card at you and you walk away in shame.";
		System.out.println(msgL);
	    }
	}
	
    }

    private void eatBurger(){
	//not yet implemented
    }
    
	
}
