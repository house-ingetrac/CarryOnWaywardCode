public abstract class Burger{
    protected int quantity;
    protected Woo player;
    protected int price;
    
    public Burger(){
	quantity = 0;
	player = new Woo();
	price = 0;
    }

    public Burger(Woo playperson){
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
