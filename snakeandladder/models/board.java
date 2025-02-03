package snakeandladder.models;

import java.util.HashMap;
import java.util.Map;

public class board
{
  private int size;
  private HashMap<Integer,Integer> snake;
  private HashMap<Integer,Integer> ladder;
  
  public board(int size)
  {
	  this.size=size;
	  this.snake=new HashMap<>();
	  this.ladder=new HashMap<>();
  }


public Map<Integer,Integer> getsnakes()
{
	return snake;
}

public Map<Integer,Integer> getladders() {
	// TODO Auto-generated method stub
	return ladder;
}

public int getsize()
{
	return size;
}


public void addSnake(int i, int j) {
	snake.put(i, j);
	
}


public void addLadder(int i, int j) {
	// TODO Auto-generated method stub
	
}





}
  

