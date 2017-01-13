import cs1.Keyboard;

public class Slots extends Minigames{
    private String[][] machine = { {"7", "cherry", "pear", "zebra", "unicorn", "piccolo"},
				   {"7", "cherry", "pear", "zebra", "unicorn", "piccolo"},
				   {"7", "cherry", "pear", "zebra", "unicorn", "piccolo"}, };
    private int[] display = new int[3];
    private Driver player;

    public Slots(){
	betAmount = 0;
	multiplier = 1;
	player = new Driver();
    }

    public Slots(Driver playman){
	betAmount = 0;
	multiplier = 1;
	player = playman;
    }

    public void play(){
	while (true){
	    if (player.getMoney() <= 0){
		System.out.println("You've run out of money!");
	    }
	    
	    String s = "Welcome to Slots!\n";
	    s += "1. Play Game\n";
	    s += "2. Go Back\n";
	    System.out.print(s);
	    
	    int response = Keyboard.readInt();

	    if (response == 2) return;
	    
	    if (response == 1){
	        s = "Place your bet!\n";
		System.out.print(s);
		bet();

		System.out.println("You look at the slot machine. It currently reads:");
		showDisplay(2);

		
		for (int i = 0; i < 3; i++){
		    System.out.print("Enter any key to pull the lever:");
		    Keyboard.readString();
		    pull(i);
		    System.out.println("You look at the slot machine. It currently reads:");
		    showDisplay(i);
		}

		int winAmount = winCondition();
		player.alterMoney(winAmount);
		System.out.println("You won $" + winCondition() + "!");
	    }
	}
    }

    private void pull(int index){
        int start = (int) (System.nanoTime() / Math.pow(10.0, 9.0));
	String s = "The images whirl by, your eye unable to catch them.\n";
	s += "Enter any key to pull the lever:";
	System.out.print(s);
	Keyboard.readString();

	System.out.println();
        int end = ((int) (System.nanoTime() / Math.pow(10.0, 9.0))) - start;
        System.out.println("You pull the lever, making one of the columns slow down before it comes to a hault:\n");
	
	int i = 0;
	while (i < 10){
	    i += 1;
	    System.out.print(machine[index][(end + i) % 6] + " ");
	    try{
	    Thread.sleep(500);
	    }
	    catch(Exception e) { }
	}
	
	System.out.println();
	System.out.println();
	s = "You manage to pull a " + machine[index][(end + i) % 6]
	    + " in the " + (index + 1) + " slot!\n";
        System.out.println(s);

	display[index] = (end + i) % 6;
    }

    private void showDisplay(int lim){
	for (int i = 0; i <= lim; i++){
	    System.out.print(machine[i][display[i]] + " ");
	}

	System.out.println();
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
	int matches = 0;
	boolean trip7 = true;
	
	if (machine[0][display[0]].equals(machine[1][display[1]]))
	    matches += 1;
	if (machine[1][display[1]].equals(machine[2][display[2]]))
	    matches += 1;
	if (machine[0][display[0]].equals(machine[2][display[2]]))
	    matches += 1;

	if (! machine[0][display[0]].equals("7"))
	    trip7 = false;
	if (machine[1][display[1]].equals("7"))
	    trip7 = false;
	if (machine[2][display[2]].equals("7"))
	    trip7 = false;
	
	if (matches < 2)
	    return 0;
	if (matches == 2)
	    return (int) (betAmount * 1.5);
	if (matches == 3 && trip7)
	    return betAmount * 5;
	if (matches == 3)
	    return (betAmount * 3);
	else{
	    return 0;
	}
    }

    private void RPGBattle(){
	//for later dev
    }

    private void eatBurger(){
	//for later dev
    }

    public static void main(String[] args){
	Slots ash = new Slots();
	

	ash.play();
    }
}
