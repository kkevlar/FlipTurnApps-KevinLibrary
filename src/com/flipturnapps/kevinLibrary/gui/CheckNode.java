package com.flipturnapps.kevinLibrary.gui;

import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;

class CheckNode extends DefaultMutableTreeNode {

	private static ArrayList<CheckNode> all = new ArrayList<CheckNode>();
	private long lastStateChange;
	private boolean lastSelected;
	private CheckNode checkparent;
	private ArrayList<CheckNode> checkchildren = new ArrayList<CheckNode>();
	private JTree tree;
	public CheckNode(Object userObject, JTree tree) {
		super(userObject);
		all.add(this);
		this.tree = tree;
	}
	private void refreshBuddies()
	{
		for(int i = 0; i < all.size(); i++)
		{
			if(all.get(i).tree == tree)
			{
				all.get(i).spotlight();
			}
		}
	}
	public ArrayList<CheckNode> getCheckChildren()
	{
		return checkchildren;
	}
	@Override
	public void add (MutableTreeNode node)
	{
		if(node instanceof CheckNode)
		{
			checkchildren.add((CheckNode) node);
		}
		super.add(node);
	}
	public void calculateSelected()
	{
		for(int x=0 ; x <10; x++)
		{
			if(checkparent != null)
			{
				boolean moreRelevant = (this.lastStateChange > checkparent.lastStateChange);

				if(!moreRelevant)
				{
					if(checkparent != null)
						if(checkparent.isSelected())
						{
							this.setSelected(true);
						}
						else
						{
							this.setSelected(false);
						}
				}
				else
				{
					if(this.isSelected())
					{
						if(checkparent != null)
							checkparent.setSelected(true);

					}
					else
					{
						if(checkparent != null)
						{
							ArrayList<CheckNode> brothers = checkparent.getBrothers(this);
							boolean brotherSelected = false;
							for(int i = 0; i < brothers.size(); i++)
							{
								if(brotherSelected == false)
									brotherSelected = brothers.get(i).isSelected();
							}
							boolean shouldDeselectParent = !(brotherSelected || this.isSelected());
							if(shouldDeselectParent)
							{
								checkparent.setSelected(false);
							}
						}
					}
				}
			}
		}

	}
	private void setSelected(boolean sel) 
	{
		((JCheckBox)this.getUserObject()).setSelected(sel);

	}

	private boolean isSelected() {
		return ((JCheckBox)this.getUserObject()).isSelected();
	}
	public void setCheckParent(CheckNode l_checkparent)
	{
		checkparent = l_checkparent;
	}
	public void spotlight()
	{
		for(int i = 0; i < checkchildren.size(); i++)
		{
			checkchildren.get(i).setCheckParent(this);
		}
		if(lastSelected != this.isSelected())
		{
			lastSelected = this.isSelected();
			this.lastStateChange = System.currentTimeMillis();
		}
		this.calculateSelected();
	}
	private ArrayList<CheckNode> getBrothers(CheckNode audioBox) 
	{
		ArrayList<CheckNode> chBrothers = new ArrayList<CheckNode>();
		for(int i = 0; i < children.size() ; i++)
		{
			if(!(children.get(i)==this))
				chBrothers.add(checkchildren.get(i));
		}
		return chBrothers;
	}
	public long getLastStateChange() 
	{
		return lastStateChange;
	}


}
