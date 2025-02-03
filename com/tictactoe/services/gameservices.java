package com.tictactoe.services;
import tictoe.gamestatus;
import java.util.*;

import com.tictactoe.models.board;
import com.tictactoe.models.players;
public class gameservices
{
	players player1;
	players player2;
  gamestatus gamestatus;
  private players currplayer;
  private board board;
  
  public gameservices(players player1,players player2,int size)
  {
	  this.player1=player1;
	  this.player2=player2;
	  board=new board(3);
	  this.currplayer=player1;
	  this.gamestatus=gamestatus.ONGOING;
  }
  public void startgame()
  {	  	  
	  Scanner sc=new Scanner(System.in);
	  board.printboard();
	  while(gamestatus==gamestatus.ONGOING)
	  {
		  
		  System.out.println(currplayer.getname()+"'s turn Enter row and column(0-"+(board.getsize()-1)+"):");
		  int row=sc.nextInt();
		  int col=sc.nextInt();
		  
		  if(board.placemark(row,col,currplayer.getmark()))
		  {
			  if(board.checkwin(currplayer.getmark()))
			  {
				  gamestatus=gamestatus.WON;
				  board.printboard();
				  System.out.println(currplayer.getname()+" Wins!!");
			  }
			  else if(board.isfull())
			  {
				  gamestatus=gamestatus.DRAW;
				  board.printboard();
				  System.out.println(currplayer.getname()+" Its Draw ");				  
			  }
			  else
			  {
				  board.printboard();				  
				  currplayer=(currplayer==player1)?player2:player1;				  
			  }
		  }			  
			  else
			  {
				  System.out.println("INVALID MOVE Try again!!");
			  }	  		  
		  }
	  sc.close();		  
	  }
  }

  

