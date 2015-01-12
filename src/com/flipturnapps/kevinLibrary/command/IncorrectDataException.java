package com.flipturnapps.kevinLibrary.command;

public class IncorrectDataException extends Exception {

	private String commandName;
	private String[] params;
	private Object objectData;
	private int errorType;
	public IncorrectDataException(String _commandName, String[] _params, Object _objectData, int _errorType) {
		commandName = _commandName;
		params = _params;
		objectData = _objectData;
		setErrorType(_errorType);
	}
	public String getCommandName() {
		return commandName;
	}
	public void setCommandName(String commandName) {
		this.commandName = commandName;
	}
	public String[] getParams() {
		return params;
	}
	public void setParams(String[] params) {
		this.params = params;
	}
	public Object getObjectData() {
		return objectData;
	}
	public void setObjectData(Object objectData) {
		this.objectData = objectData;
	}
	public int getErrorType() {
		return errorType;
	}
	public String getErrorTypeText()
	{
		if(errorType == Command.DATA_INCORRECT)
			return "data";
		if(errorType == Command.NAME_INCORRECT)
			return "name";
		if(errorType == Command.PARAMS_INCORRECT)
			return "params";
		if(errorType == Command.PERMISSIONS_INCORRECT)
			return "perms";
		return null;
		
	}
	public void setErrorType(int errorType) {
		this.errorType = errorType;
	}

	

}
