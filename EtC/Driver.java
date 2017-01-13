import cs1.Keyboard;
public class Driver{
    private int money = 100;

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

	while (Driverman.money > 0){
	    String s = "Welcome to Escape the Casino's MVP!\n";
	    s += "(So basically just a Casino)\n";
	    s += "Your money is currently" + Driverman.money + "\n";
	    s += "Please choose from the following selection:\n";
	    s += "1. BlackJack\n";
	    s += "2. Slots\n";
	    s += "3. Roulette\n";
	    s += "4. Quit\n";
	    System.out.println(s);

	    int result = Keyboard.readInt();
	    if (result == 2)
		Slotman.play();
	    if(result == 3)
		Roulette.play();
	    if (result == 4)
		return;
	}

	System.out.println("GAME OVER");
    }
}
