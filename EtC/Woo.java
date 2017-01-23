import cs1.Keyboard;
public class Woo{
    public int money = 100;

    public boolean slotsKill = false;
    public boolean rouletteKill = false;
    public boolean blackjackKill = false;
    public boolean allKill = false;
    public int burgerBought = 0;
    
    private int counter = 0;

    //amount can be negative
    public void alterMoney(int amount){
	money += amount;
    }

    public int getMoney(){
	return money;
    }

    public boolean aK(){
	if(slotsKill == true && rouletteKill == true && blackjackKill == true){
	    allKill = true;
	}
    }

    public static void main(String[] args){
	Woo Driverman = new Woo();
	Burger FS = new FutureSight(Driverman);
	Burger ST = new SlowTime(Driverman);
	Burger MH = new MagnetosHand(Driverman);
	UserInterface Slotman = new Slots(Driverman, ST);
	UserInterface Rouletteman = new Roulette();
	//UserInterface Blackjackman = new Blackjack();
	UserInterface Foodman = new FoodCourt(FS, ST, MH);

	Driverman.aK();
	
	while (Driverman.money > 0 && ! Driverman.allKill){
	    
	//opening cutscene
	//to be added
	
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
	    s += "5. Quit\n";
	    System.out.println(s);

	    //can only play game before you beat the boss
	    int result = Keyboard.readInt();
	    if (result == 1 && ! Driverman.slotsKill){
		Slotman.play();
		Driverman.counter += 1;
	    }
	    else if (result == 1){
		System.out.println("Already beat boss.");
		return;
	    }

	    if (result == 2 && ! Driverman.rouletteKill){
		Rouletteman.play();
		Driverman.counter += 1;
	    }
	    else if (result == 2){
		System.out.println("Already beat boss.");
		return;
	    }
	    
	    if (result == 3 && ! Driverman.blackjackKill){
		//Blackjackman.play();
		Driverman.counter += 1;
	        
	    }
	    else if (result == 3){
		System.out.println("Already beat boss.");
		return;
	    }
	    
	    if (result == 4)
	        Foodman.play();
	    if (result == 5)
		return;
	}

	if(Driverman.aK()){
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
