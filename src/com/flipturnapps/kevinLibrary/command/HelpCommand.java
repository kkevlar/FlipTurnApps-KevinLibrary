package com.flipturnapps.kevinLibrary.command;

public abstract class HelpCommand extends OutputSimpleCommand {


	private int listSize;
	private boolean disabled;
	public HelpCommand(CommandOutput output) {
		super(output);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "help";
	}
	

	@Override
	public int getMaximumParams() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public int getMinimumParams() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean willInterceptCommand(Command command, String[] params) {
		return false;
	}

	@Override
	public void interceptCommand(Command command, String[] params) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getInterceptPriority() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String[] getAliases() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object execute(String commandName, String[] params, Object data) {
		
		if(params.length > 0)
		{
		String[] helpParams = new String[params.length - 1];
		for (int i = 0; i < params.length - 1; i++) {
			helpParams[i] = params[i+1];
		}
		Command help;
		try {
			help = this.getCommandExecutor().getCommand(params[0], helpParams);
		} catch (NonExistentCommandException e) {
			this.getCommandOutput().println("Command \"" + params[0] + "\" does not exist." );
			return data;
		}
		this.getCommandOutput().println(help.getHelpText());
		}
		else
		{
			this.getCommandOutput().println(this.getCommandList().toString());
		}
		return data;
	}

	@Override
	public boolean objectDataOK(Object data) {
		// TODO Auto-generated method stub
		return true;
	}

	public int getListSize() {
		return listSize;
	}

	public void setListSize(int listSize) {
		this.listSize = listSize;
	}

	public boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

	@Override
	public int canExecute(String commandName, String[] params,
			CommandSpeaker speaker, Object data) {
		// TODO Auto-generated method stub
		return 0;
	}


}
