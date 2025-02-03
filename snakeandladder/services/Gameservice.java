package snakeandladder.services;
import snakeandladder.models.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import snakeandladder.driver.*;
import snakeandladder.driver.*;
public class Gameservice
{
   private board board;
   private Queue<player> players;
   private Gamestatus status;
   
   public Gameservice(board board,Queue<player> players)
   {
	   this.board=board;
	   this.players=players;
	   this.status=Gamestatus.ONGOING;	   
   }
   
   public Gameservice(com.tictactoe.models.board board2, Queue<player> players2) {
	// TODO Auto-generated constructor stub
}

public void playgame()
   {
	   Random dice=new Random();
	   while(status==Gamestatus.ONGOING)
	   {
		   player currplayer=players.poll();
		   
		   if (currplayer == null) {
			    System.out.println("No players remaining in the queue.");
			    break; // or handle appropriately
			}
		   int diceroll=dice.nextInt(6)+1;
		   
		   int newposition=currplayer.getposition()+diceroll;
		   
		   
		   // Check if the new position is beyond the board size
		   if(newposition>board.getsize())
		   {
			   players.offer(currplayer);
			   continue;//remove player from front and add in back
		   }
		   
		// Check for snakes or ladders
		   if(board.getsnakes().containsKey(newposition))
		   {
			   newposition=board.getsnakes().get(newposition);
		   }
		   else if(board.getladders().containsKey(newposition))
		   {
			   newposition=board.getladders().get(newposition);
		   }
		   currplayer.setposition(newposition);
		   
		   System.out.println(currplayer.getName() + " rolled a " + diceroll + " and moved to " + newposition);
		   
		// Check for winning condition
		   if(newposition==board.getsize())
		   {
			   System.out.print(currplayer.getName()+"has won the game!");
			   status=Gamestatus.COMPLETED;
			   break;
		   }
		   players.offer(currplayer);
		   
	   }
   }
}
