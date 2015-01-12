package com.flipturnapps.kevinLibrary.net;

import java.util.ArrayList;

import com.flipturnapps.kevinLibrary.command.CharacterBrokenCommandParser;
import com.flipturnapps.kevinLibrary.command.Command;

public class NetCommandParser extends CharacterBrokenCommandParser {

	public NetCommandParser(ArrayList<Command> commands) {
		super(commands);
	}

	public NetCommandParser(Command[] commands) {
		super(commands);
	}

	@Override
	public String getSplittingCharacters() 
	{
		return "~";
	}

	@Override
	public String getStartingCharacters() {
		return "";
	}

}
