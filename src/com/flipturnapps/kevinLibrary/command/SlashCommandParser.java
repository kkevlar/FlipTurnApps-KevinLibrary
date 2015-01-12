package com.flipturnapps.kevinLibrary.command;

import java.util.ArrayList;

public class SlashCommandParser extends CharacterBrokenCommandParser {

	public SlashCommandParser(ArrayList<Command> commands) {
		super(commands);
		// TODO Auto-generated constructor stub
	}

	public SlashCommandParser(Command[] commands) {
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
		return "/";
	}

}
