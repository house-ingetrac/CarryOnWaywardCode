public class MagnetosHand extends Burger{
    public MagnetosHand(Woo playperson){
	super(playperson);
	price = 20;
    }

    public boolean eat(){
if (quantity > 0){
	    quantity -= 1;
	    System.out.println("Magneto's Hand activated!");
	    return true;
	}
	else{
	    System.out.println("You don't have any burgers to eat!");
	    return false;
	}
    }
}
