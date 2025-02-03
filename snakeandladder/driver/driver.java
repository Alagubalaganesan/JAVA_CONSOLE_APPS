package snakeandladder.driver;

import java.util.LinkedList;
import java.util.Queue;

import snakeandladder.models.*;
import snakeandladder.services.Gameservice;

public class driver
{

	public static void main(String[] args)
	{
		board board=new board(100);
		
		//create snake and ladders
		
		board.addSnake(99, 54);
        board.addSnake(70, 55);
        board.addLadder(4, 25);
        board.addLadder(21, 82);
        
        //create players
        Queue<player> players=new LinkedList<>();
        players.add(new player("bala"));
        players.add(new player("sam"));
        
        Gameservice gameService = new Gameservice(board, players);
        gameService.playgame();      
        

	}

}
