package cs1;
import java.io.*;
import java.util.*;

public class Utils{
    public static int readInt(){
	int data = Keyboard.readInt();
        if ( data == Integer.MIN_VALUE ){
	    System.out.println("Try again!");
	    return Utils.readInt();
	}
	else{
	    return data;
	}
    }
}
