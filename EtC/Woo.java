import cs1.Keyboard;
public class Woo{
    private int money = 100;

    public boolean slotsKill = false;
    public boolean rouletteKill = false;
    public boolean blackjackKill = false;
    public boolean allKill = false;
    public static int burgerBought = 0;
    
    private int counter = 0;

    //amount can be negative
    public void alterMoney(int amount){
	money += amount;
    }

    public int getMoney(){
	return money;
    }
    
    public void aK(){
	if (slotsKill == true && rouletteKill == true && blackjackKill == true){
	    allKill = true;
	}//checks if all bosses defeated
    }

    public void counterAdd(){
	counter += 1;
    }
    
    public static void main(String[] args){
	Woo Driverman = new Woo();
	Burger FS = new FutureSight(Driverman);
	Burger ST = new SlowTime(Driverman);
	Burger MH = new MagnetosHand(Driverman);
	UserInterface Slotman = new Slots(Driverman, ST);
	UserInterface Rouletteman = new Roulette(Driverman, MH);
	UserInterface Blackjackman = new Blackjack(Driverman);
	UserInterface Foodman = new FoodCourt(FS, ST, MH);
	
	
	while (Driverman.getMoney() > 0 && (! Driverman.allKill)){

	    Driverman.aK();
	    
	    if(Driverman.counter == 0){
		Cutscenes.start();
	    }
	
	//main game
	    String ascii = " \n";
	    ascii += "         Welcome To:\n";
	    ascii += " \n";
	    ascii += "         ESCAPE THE\n";
	    ascii += "  ___  _  __ __  _  _ ___ _\n";
	    ascii += " / __\\/ \\/ _|_ _| \\| /   | | \n";
	    ascii += "| (__/ ^ \\_ \\| ||  `|  O |_|\n";
	    ascii += " \\__/_---/__|___|_|\\_\\___(_)\n";
	    ascii += "    _____________________\n";
	    ascii += "   //////////777\\\\\\\\\\\\\\\\\\\\ \n";
	    ascii += "  |    *-------------*    |\n";
	    ascii += "  |    | |2| |5| |3| |    |\n";
	    ascii += "  |    |-|7| |7| |7|-|    |\n";
	    ascii += "  |    | |8| |1| |5| | O  |\n";
	    ascii += "  |    *-------------*/   |\n";
	    ascii += "  |      LUCKY SEVEN /    |\n";
	    ascii += "  |                 ||    |\n";
	    ascii += " \n";
	    
	    if(Driverman.counter == 0){
		System.out.println(ascii);
	    }

	    if(Driverman.counter == 0){
		System.out.print("Welcome to Escape the Casino!\nYou start with $100");
	    }
	    String s = "\n";
	    s += "Please choose from the following selection:\n";
	    s += "1. Slots\n";
	    s += "2. Roulette\n";
	    s += "3. BlackJack\n";
	    s += "4. Food Court\n";
	    s += "5. Attempt Escape\n";
	    s += "6. Quit\n";
	    System.out.println(s);

	    //can only play game before you beat the boss
	    int result = Keyboard.readInt();
	    if (result == 1 && ! Driverman.slotsKill){
		Slotman.play();
		Driverman.counter += 1;
	    }
	    else if (result == 1){
		System.out.println("Already beat boss.");
	    }

	    if (result == 2 && ! Driverman.rouletteKill){
		Rouletteman.play();
		Driverman.counter += 1;
	    }
	    else if (result == 2){
		System.out.println("Already beat boss.");
	    }
	    
	    if (result == 3 && ! Driverman.blackjackKill){
		Blackjackman.play();
		Driverman.counter += 1;
	        
	    }
	    else if (result == 3){
		System.out.println("Already beat boss.");
	    }
	    
	    if (result == 4){
		Driverman.counterAdd();
	        Foodman.play();
	    }

	    if (result == 5){
		Driverman.counterAdd();
		if(! Driverman.allKill){
		    System.out.println("Not yet sir.");
		}
	    }
	    
	    if (result == 6)
		return;
	}

	if(Driverman.allKill){
	    if(Driverman.burgerBought == 0){
		Cutscenes.endingB();
		return;
	    }
	    else{
		Cutscenes.endingW();
		return;
	    }
	}

	//bad ending (default)
	Cutscenes.endingL();
	    return;
	
    }
}
