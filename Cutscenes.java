public class Cutscenes{

    public static void start(){
	String s = "";
	s += "You awake in a dark casino. The lights fliker on and you hear a voice over the loudspeaker: \n";
	s += "Hello, and welcome to the Lucky Sevens Casino. We have kidnapped you for no reason whatsoever. \n";
	s += "It is up to you to escape. How exciting! \n";
	s += "Because we have no intention of harming you, we have even given you a tool to help you. \n";
	s += "On the table next to you you will find a ChipGun, which shoots our proprietary chips. \n";
	s += "There are several games for you to enjoy as well as a food court. \n";
	s += "I assure you that you have never had burgers quite like these ones. \n";
	s += "You will need to defeat the employees in order to escape. Good luck! \n";

	System.out.println(s);
    }
    
    public static void endingW(){
	String s = "";
	s += "You have defeated my henchmen, and I can retain you here no longer. \n";
	s += "Have a nice day, and thank you for coming to the Lucky Sevens Casino.\n";
	s += " \n";
	s += "YOU WIN";
	s += " \n";
	s += " \n";
	s += "Oh and if you could leave the ChipGun here that would be appreciated.";

	System.out.println(s);
    }

    public static void endingL(){
	String s = "";
	s += "It appears that you have run out of money.\n";
	s += "Please allow my henchmen to accompany you back to your ce- room. ";
	s += "Have a nice day, and thank you for your continued stay at the Lucky Sevens Casino.\n";
	s += " \n";
	s += "YOU LOSE";
	
	System.out.println(s);
    }

    public static void endingB(){
	String s = "";
	s += "You have defeated my henchmen, and I can retain you here no longer. \n";
	s += "Have a nice day, and thank you for coming to the Lucky Sevens Casino.\n";
	s += " \n";
	s += "YOU WIN";
	s += " \n";
	s += "*You are now outside the casino, and there is a burger that you\n";
	s += "recognize as from the food court on the ground in front of you.\n";
	s += "You take a bite.*";
	s += " \n";
	s += "*Three guys appear in front of you.*";
	s += "Hey look at that! You won without using any cheats! Congrats man.\n";
	s += "You get to keep that burger, and meet us devs. Not that that's much of a prize.";
	s += "Well anyway good job. You got the spoooky seeecret endiing.";

	System.out.println(s);
    }

}
