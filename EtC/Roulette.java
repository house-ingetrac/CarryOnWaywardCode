import cs1.Keyboard;

public class Roulette extends Minigames{

    private Driver player;
    private int betOn;
    private int winType;
    
    public Roulette(){
	betAmount = 0;
	multiplier = 1;
	player = new Driver();
    }
    
    public Roulette(Driver playman){
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
	    s += "2. Go Back\n";
	    System.out.print(s);
	    
	    int response = Keyboard.readInt();

	    if (response == 2) return;
	    
	    if (response == 1){
	        s = "Place your bet!\n";
		System.out.print(s);
		bet();

		spin();
		
		int winAmount = betAmount * (winCondition());
		player.alterMoney(winAmount);
		System.out.println("You won $" + winCondition() + "!");
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
	    return 2;
	}
	else if(winType == 2){
	    return 40;
	}
	else if(winType == 3){
	    return 20;
	}
	else{
	    return 0;
	}
    }
	    
    
    private void RPGBattle(){
	System.out.println("Would you like to attack the dealer?");
	//not yet implemented
    }

    private void eatBurger(){
	//not yet implemented
    }

    /* public static void main(String[] args){
	Roulette ashbob = new Roulette();
	ashbob.play();
	}*/
}
