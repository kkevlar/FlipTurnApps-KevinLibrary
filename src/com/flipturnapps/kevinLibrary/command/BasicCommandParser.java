package com.flipturnapps.kevinLibrary.command;

import java.util.ArrayList;

public class BasicCommandParser extends CharacterBrokenCommandParser {

	public BasicCommandParser(ArrayList<Command> commands) {
		super(commands);
		// TODO Auto-generated constructor stub
	}

	public BasicCommandParser(Command[] commands) {
		super(commands);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getSplittingCharacters() {
		// TODO Auto-generated method stub
		return " ";
	}

	@Override
	public String getStartingCharacters() {
		// TODO Auto-generated method stub
		return "";
	}

}
