import cs1.Keyboard;

public class Roulette extends Minigames{

    private Woo player;
    private int betOn;
    private int winType;
    
    public Roulette(){
	betAmount = 0;
	multiplier = 1;
	player = new Woo();
    }
    
    public Roulette(Woo playman){
	betAmount = 0;
	multiplier = 1;
	player = playman;
    }

    public void play(){

	while (true){
	    if (player.getMoney() <= 0){
		System.out.println("You've run out of money!");
	    }
	    
	    String s = "Welcome to Roulette!\n";
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

		spin();

		winCondition();
		int winAmount = betAmount * (int)multiplier;
		player.alterMoney(winAmount);
		System.out.println("You won $" + winAmount + "!");
		
	    }

	    if (response == 3){
		RPGBattle();
		return;
	    }
	}
    }

    private void spin(){
	int result = (int)(Math.random() * 41);
	System.out.println("Enter a number 1-39, 41 for all Reds, 42 for all Blacks, or 0 for white.");
	betOn = Keyboard.readInt();
	System.out.println("The dealer spins the roulette, twisting his mustache as it slows down.");
	if(betOn == 0 && (result == 0 || result == 40)){
	    winType = 3;
	    return;
	}
	else{
	    if(result == betOn){
		winType = 2;
		return;
	    }
	    else if(result % 2 == 0 && betOn == 42){
		winType = 1;
		return;
	    }
	    else if(result % 2 == 1 && betOn == 41){
		winType = 1;
		return;
	    }
	    else{
		winType = 0;
		System.out.println("Sorry, you lose. Try again.");
	    }
	}
    }


    private void bet(){
        betAmount = Keyboard.readInt();
	
	if (betAmount > player.getMoney()){
	    System.out.println("Amount greater than what you have on hand. Try again:");
	    bet();
	}
	
	else{
	    player.alterMoney(betAmount * -1);
	    System.out.println("Bet placed. Your money is now " + player.getMoney() + ".");
	}
    }

    private int winCondition(){
	if(winType == 1){
	    multiplier = 2;
	}
	else if(winType == 2){
	    multiplier = 40;
	}
	else if(winType == 3){
	    multiplier = 20;
	}
	else{
	    multiplier = 0;
	}
	return (int)multiplier;
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
		    msgL += "The dealer throws a roulette ball at you and you walk away in shame.";
		    System.out.println(msgL);
		}
	    }
	
    }

    private void eatBurger(){
	//not yet implemented
    }

    
}
