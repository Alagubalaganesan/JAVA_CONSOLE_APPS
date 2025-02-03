package tictoe;
import com.tictactoe.services.*;
import java.util.*;

import com.tictactoe.models.players;
public class driverclass
{
	public static void main(String[] args)
	{
	   int size=3;
	   Scanner sc=new Scanner(System.in);	
	   
	   System.out.println("enter player1 name:");	   
       String name1=sc.next();
       
	   System.out.println("enter player2 name:");	   
	   String name2=sc.next();
	   
	   players player1=new players(name1,'X');
	   players player2=new players(name2,'O'); 	
	   
	   gameservices gs=new gameservices(player1,player2,size);
	   gs.startgame();
	   
	   sc.close();   
	   

	}
}
