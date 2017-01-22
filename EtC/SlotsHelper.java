import java.io.*;
import java.util.*;

public class SlotsHelper extends Thread{
    Scanner sc = new Scanner(System.in);
    private Slots lul;
    public SlotsHelper(){
	lul = new Slots();
    }
    public SlotsHelper(Slots slot){
	lul = slot;
    }
    @Override
    public void run()
    {
        while(! sc.hasNext())
	    {
	    }
	lul.wall = false;
    }
}
