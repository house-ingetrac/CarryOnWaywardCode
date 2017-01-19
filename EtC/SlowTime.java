public class SlowTime extends Burger{
    public SlowTime(Driver playperson){
	super(playperson);
	price = 40;
    }

    public boolean eat(){
	if (quantity > 0){
	    quantity -= 1;
	    System.out.println("Slow Time activated!");
	    return true;
	}
	else{
	    System.out.println("You don't have any burgers to eat!");
	    return false;
	}
    }
}
