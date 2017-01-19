import cs1.Keyboard;
public class Driver{
    private int money = 100;

    public boolean slotsKill = false;
    public boolean rouletteKill = false;
    public boolean blackjackKill = false;

    //amount can be negative
    public void alterMoney(int amount){
	money += amount;
    }

    public int getMoney(){
	return money;
    }

    public static void main(String[] args){
	Driver Driverman = new Driver();
	UserInterface Slotman = new Slots();
	UserInterface Rouletteman = new Roulette();
	Burger FS = new FutureSight(Driverman);
	Burger ST = new SlowTime(Driverman);
	Burger MH = new MagnetosHand(Driverman);
	UserInterface Foodman = new FoodCourt(FS, ST, MH);

	while (Driverman.money > 0){
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
	    System.out.println(ascii);

	    String s = "Welcome to Escape the Casino's MVP!\n";
	    s += "(So basically just a Casino)\n";
	    s += "Your money is currently " + Driverman.money + "\n";
	    s += "Please choose from the following selection:\n";
	    s += "1. Slots\n";
	    s += "2. Roulette\n";
	    //s += "3. BlackJack\n";
	    s += "3. Food Court\n";
	    s += "4. Quit\n";
	    System.out.println(s);

	    int result = Keyboard.readInt();
	    if (result == 1)
		Slotman.play();
	    if(result == 2)
		Rouletteman.play();
	    if (result == 3)
	        Foodman.play();
	    if (result == 4)
		return;
	}

	System.out.println("GAME OVER");
    }
}
