package com.flipturnapps.kevinLibrary.command;

import java.util.ArrayList;

public class BasicCommandParser extends CharacterBrokenCommandParser {

	public BasicCommandParser(ArrayList<Command> commands) {
		super(commands);
		 
	}

	public BasicCommandParser(Command[] commands) {
		super(commands);
		 
	}

	@Override
	public String getSplittingCharacters() {
		
		return " ";
	}

	@Override
	public String getStartingCharacters() {
		return "";
	}

}
