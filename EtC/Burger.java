public abstract class Burger{
    protected int quantity;
    protected Driver player;
    protected int price;
    
    public Burger(){
	quantity = 0;
	player = new Driver();
	price = 0;
    }

    public Burger(Driver playperson){
	quantity = 0;
	player = playperson;
	price = 0;
    }

    public abstract boolean eat();

    public void buy(int qua){
	if (player.getMoney() < (price * qua)){
	    System.out.println("Not enough cash!");
	    return;
	}
	player.alterMoney(price * -1 * qua);
	quantity += qua;
    }
}
