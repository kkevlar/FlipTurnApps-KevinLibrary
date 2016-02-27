package com.flipturnapps.kevinLibrary.sprite.networked;

import com.flipturnapps.kevinLibrary.sprite.PositionSprite;
import com.flipturnapps.kevinLibrary.sprite.SpritePanel;

public abstract class NetworkedSpritePanel extends SpritePanel 
{
	public static final String instructionParseSeparator = "~-~";
	private NetworkedSpritePanelOutput output;
	public NetworkedSpritePanel(NetworkedSpritePanelOutput output)
	{
		this.output = output;
	}
	public void recievedUnpackedInstruction(String inst)
	{
		
	}
	public interface NetworkedSpritePanelOutput
	{
		public void sendUnpackedInstrution(String inst);
	}
	public void createNewSpriteWithId(int id, String[] params) 
	{
		PositionSprite sprite = createNewSprite(params);
		sprite.setPosSpriteId(id); //this line may cause issues if ids arent synced
		this.add(sprite);
	}
	
	public abstract PositionSprite createNewSprite(String[] params);
}
