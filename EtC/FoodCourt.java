import cs1.Utils;

public class FoodCourt implements UserInterface{
    private Burger FS;
    private Burger ST;
    private Burger MH;

    public FoodCourt(Burger fs, Burger st, Burger mh){
	FS = fs;
	ST = st;
	MH = mh;
    }

    public void play(){
	while (true){
	    String s = "Ayy waddup\n";
	    s += "1. Buy Future Sight ($20)\n";
	    s += "2. Buy Slow Time ($40)\n";
	    s += "3. Buy Magneto's Hand ($30)\n";
	    s += "4. Leave\n";
	    System.out.print(s);
	    int response = Utils.readInt();

	    if (response == 1){
		System.out.println("How many?");
		int quan = Utils.readInt();
		FS.buy(quan);
	    }
	    else if (response == 2){
		System.out.println("How many?");
		int quan = Utils.readInt();
		ST.buy(quan);
	    }
	    
	    else if (response == 3){
		System.out.println("How many?");
		int quan = Utils.readInt();
		MH.buy(quan);
	    }

	    else if (response == 4){
		return;
	    }
	}
    }
}
