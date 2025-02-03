package com.tictactoe.models;

public class players
{
    String playername;
    char playermark;
    public players(String name,char mark)
    {
    	this.playername=name;
    	this.playermark=mark;
    }
    public String getname()
    {
    	return playername;
    }
    public char getmark()
    {
    	return playermark;
    }
	
}
