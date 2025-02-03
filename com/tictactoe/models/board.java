package com.tictactoe.models;

public class board
{
	int size;
	private char[][] board;
	
	public board(int size)
	{
		this.size=size;
		board=new char[size][size];
		initializeboard(size);
	}    
    
    
    public void initializeboard(int size)
    {
    	for(int i=0;i<size;i++)
    	{
    		for(int j=0;j<size;j++)
    		{
    			board[i][j]='-';
    		}
    	}
    }
    
    
    public boolean placemark(int row,int col,char mark)
    {
    	if(row>=0 && row<size && col>=0 && col<size && board[row][col]=='-')
    	{
    		board[row][col]=mark;
    		return true;
    	}
    	return false;
    }
    
    
    public boolean checkwin(char mark)
    {
    	for(int i=0;i<size;i++)
    	{
    	  if(checkrow(i,mark)|| checkcol(i,mark))
    	  return true;
    	}
    	return checkdiagonal(mark);
    }
    
    private boolean checkdiagonal(char mark)
    {
    	boolean diagonal=true,diagonal2=true;
    	
		for(int i=0;i<size;i++)
		{			
			if(board[i][i]!=mark)diagonal=false;
			if(board[i][size-i-1]!=mark)diagonal2=false;
		}
		return diagonal ||diagonal2;
	}



	public boolean checkcol(int col,char mark)
    {
    	for(int k=0;k<size;k++)
    	{
    		if(board[k][col]!=mark)
    			return false;    		
    	}
		return true;    	
    }
	
	
    public boolean checkrow(int row,char mark)
    {
    	for(int k=0;k<size;k++)
    	{
    		if(board[row][k]!=mark)
    			return false;    		
    	}
		return true;     	
    }
    
    
    public void printboard()
    {
    	for(int i=0;i<size;i++)
    	{
    		for(int j=0;j<size;j++)
    		{
    			System.out.print(board[i][j]+" ");
    		}
    		System.out.println();
    	}    	
    }
    public boolean isfull()
    {
    	for(int i=0;i<size;i++)
    	{
    		for(int j=0;j<size;j++)
    			if(board[i][j]=='-')return false;
    	}
    	return true;
    }


	public int getsize() {
		// TODO Auto-generated method stub
		return 0;
	}
    
    
    
    
}
