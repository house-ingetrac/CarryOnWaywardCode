package cs1;
import java.io.*;
import java.util.*;

public class Utils{
    public static int readInt(){
        if ( Keyboard.readInt() == Integer.MIN_VALUE){
	    System.out.println("Try again!");
	    readInt();
	}
	else
	    return Keyboard.readInt();
	    }
    
    public static String readInput(){
	InputStreamReader input = new InputStreamReader(System.in);
	return "";
	}

    public static void readEnter(){
	BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	return "";
    }
}
