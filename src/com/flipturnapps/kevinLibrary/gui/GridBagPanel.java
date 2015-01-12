package com.flipturnapps.kevinLibrary.gui;
import java.awt.*;

public class GridBagPanel extends KJPanel {

	protected TransparentPanel[][] blanks;
	public GridBagPanel(int gridWidth, int gridHeight) 
	{
		blanks = new TransparentPanel[gridWidth][gridHeight];
		this.setLayout(new GridBagLayout());
		for (int x = 0; x < gridWidth; x++)
		{
			for (int y = 0; y < gridHeight; y++)
			{
				GridBagConstraints c = new GridBagConstraints();
				c.gridx = x;
				c.gridy = y;
				c.gridwidth = 1;
				c.gridheight = 1;
				c.fill = GridBagConstraints.BOTH;
				TransparentPanel panel = new TransparentPanel();
				this.add(panel, c );
				blanks[x][y] = panel;
			}
		}
	}
	public void gridAdd(Component com, GridBagConstraints c)
	{
		for(int x = c.gridx; x < ((c.gridx + c.gridheight) - 1); x++)
		{
			for (int y = c.gridy; y< ((c.gridy + c.gridheight) - 1); y++)
			{
				this.remove(blanks[x][y]);
			}
		}
		this.add(com,c);
	}
	public void gridRemove(Component com, GridBagConstraints c)
	{
		this.remove(com);
		for(int x = c.gridx; x < ((c.gridx + c.gridheight) - 1); x++)
		{
			for (int y = c.gridy; y< ((c.gridy + c.gridheight) - 1); y++)
			{
				this.add(blanks[x][y]);
			}
		}
		
	}
	

}
