package com.flipturnapps.kevinLibrary.sprite.networked;

import com.flipturnapps.kevinLibrary.sprite.PositionSprite;
import com.flipturnapps.kevinLibrary.sprite.SpritePanel;

public abstract class NetworkedSpritePanel extends SpritePanel 
{
	public static final String instructionParseSeparator = "~-~";
	public NetworkedSpritePanel()
	{
		
	}
	public void recievedUnpackedInstruction(String inst)
	{
		
	}
	public void createNewSpriteWithId(int id, String[] params) 
	{
		PositionSprite sprite = createNewSprite(params);
		sprite.setPosSpriteId(id); //this line may cause issues if ids arent synced
		this.add(sprite);
	}
	
	public abstract NetPositionSprite createNewSprite(String[] params);
	
	public abstract void sendUnpackedInstruction(String string);
}
