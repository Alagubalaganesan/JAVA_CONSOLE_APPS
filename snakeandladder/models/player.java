package snakeandladder.models;

public class player
{
   private String name;
   private int position;

   public player(String name)
   {
	   this.name=name;
	   this.position=1;
   }

public int getposition() {
	// TODO Auto-generated method stub
	return position;
}

public void setposition(int newposition)
{
	this.position=newposition;	
}

public String getName() {
	// TODO Auto-generated method stub
	return name;
}






}
