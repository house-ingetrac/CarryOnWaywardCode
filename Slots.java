import cs1.Keyboard;
import cs1.Utils;

public class Slots extends Minigames{
    //instance variables
    private final String[][] machine = { {"7", "cherry", "pear", "zebra", "unicorn", "piccolo"},
				   {"7", "cherry", "pear", "zebra", "unicorn", "piccolo"},
				   {"7", "cherry", "pear", "zebra", "unicorn", "piccolo"}, };
    private int[] display = new int[3];
    
    private Woo player;// for money
    private Burger ST; //for SlowTime
    private boolean slow = false; //for SlowTime
    public boolean wall = true; //for SlowTime

    public Slots(){
	betAmount = 0;
	multiplier = 1;
	player = new Woo();
	ST = new SlowTime(player);
    }

    public Slots(Woo playman, Burger st){
	betAmount = 0;
	multiplier = 1;
	player = playman;
	ST = st;
    }

    /* To be invoked in Woo.
       Private methods built on top of this method which can be returned to 
    get back into Woo -- the main hub. */
    public void play(){
	while (true){
	    if (player.getMoney() <= 0){
		System.out.println("You've run out of money!");
	    }
	    
	    String s = "Welcome to Slots!\n";
	    s += "1. Play Game\n";
	    s += "2. Eat Burger\n";
	    s += "3. Fight Security man\n";
	    s += "4. Go Back\n";
	    System.out.print(s);
	    
	    int response = Utils.readInt();

	    if (response == 4) return;

	    if (response == 2){
		eatBurger();
	    }
	    
	    if (response == 1 || response == 2){
	        s = "Place your bet!\n";
		System.out.print(s);
		bet();

		System.out.println("You look at the slot machine. It currently reads:");
		showDisplay(2);

		/*goes through the  three indexes of machine using display to indicate
		  which image is currently active*/
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
		slow = false;
	    }

	    if (response == 3){
		RPGBattle();
		return;
	    }
	}
    }

    private void pull(int index){
	String s = "";
	int start = display[index];
	int end = 0;
	int x = 0;
	
	if (! slow){
	    int help = (int) (System.nanoTime() / Math.pow(10.0, 9.0));
	    s = "The images whirl by, your eye unable to catch them.\n";
	    s += "Enter any key to pull the lever:";
	    System.out.print(s);
	    Keyboard.readString();

	    System.out.println();
	    end = ((int) (System.nanoTime() / Math.pow(10.0, 9.0))) - help;
	    System.out.println("You pull the lever, making one of the columns slow down before it comes to a halt:\n");
	    x = 0;
	}

	else{
	    s = "The world is tinged blue.\n";
	    s += "The slot machine before you reveals its images before your eyes.\n";
	    s += "Your hand reaches for the lever, waiting for just the right moment to pull:\n";
	    System.out.println(s);

	    x = 0;

	    Thread input = new Thread(new SlotsHelper(this));
	    input.start();
	    while (wall) {
		x += 1;
		System.out.print(machine[index][(start + x) % 6] + " ");
		try{
		    Thread.sleep(500);
		}
		
		catch(Exception e) { }

		if (x % 5 == 0)
		    System.out.println();
	    }
	    wall = true;
	}
	
	int i = 0;
	while (i < 10){
	    System.out.print(machine[index][(start + end + i + x) % 6] + " ");
	    i += 1;
	    try{
	    Thread.sleep(500);
	    }
	    catch(Exception e) { }
	}
	
	System.out.println();
	System.out.println();
	s = "You manage to pull a " + machine[index][(start + end + i + x) % 6]
	    + " in the " + (index + 1) + " slot!\n";
        System.out.println(s);

	display[index] = (start + end + i + x) % 6;
    }

    private void showDisplay(int lim){
	for (int i = 0; i <= lim; i++){
	    System.out.print(machine[i][display[i]] + " ");
	}

	System.out.println();
    }

    private void bet(){
        int holder = Utils.readInt();
	
	if (holder > player.getMoney()){
	    System.out.println("Amount greater than what you have on hand. Try again:");
	    bet();
	}
	if (holder < 0){
	    System.out.println("Nice try, but do it for real this time.");
	    bet();
	}

	else{
	    betAmount = holder;
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
	if (! machine[1][display[1]].equals("7"))
	    trip7 = false;
	if (! machine[2][display[2]].equals("7"))
	    trip7 = false;
	
	if (matches == 0)
	    return 0;
	if (matches == 1)
	    return (int) (betAmount * 1.5);
	if (matches == 2)
	    return (int) (betAmount * 1.5);
	if (matches == 3 && trip7)
	    return betAmount * 5;
	if (matches == 3)
	    return (betAmount * 3);
	else{
	    return 3;
	}
    }

    private void RPGBattle(){
	//<<<<<<< HEAD
        //for later dev
	//=======
	String s = "Do you want to fight the security man?\n";
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
		player.slotsKill = true;
		String msgW = "";
		msgW += "Your shots collide at quasi-relativistic speeds (5 m/s) with the security man.\n";
		msgW += "He falls to the floor, unconscious, and you leave victorious.";
		System.out.println(msgW);
	    }
	    else{
		String msgL = "";
		msgL += "You realize too late that you do not have enough chips in the gun to do anything useful.\n";
		msgL += "The security man throws his plastic toy badge at you and you walk away in shame.";
		System.out.println(msgL);
	    }
	}
	
	//>>>>>>> de209d8bfea10bb52bf9a2315b122836fba9f487
    }
    
    private void eatBurger(){
        if (ST.eat()) slow = true;
    }
}
