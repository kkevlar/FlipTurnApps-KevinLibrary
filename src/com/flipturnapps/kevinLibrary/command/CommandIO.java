package com.flipturnapps.kevinLibrary.command;

import java.util.ArrayList;

public interface CommandIO 
{
	public ArrayList<String> getPermsOwned();
	public void print(String string);
	public void println(String string);
}
