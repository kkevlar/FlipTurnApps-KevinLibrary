package com.flipturnapps.kevinLibrary.gui;

import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

import com.flipturnapps.kevinLibrary.helper.FlushWriter;

public class CheckTree extends JTree {

	private DefaultMutableTreeNode rootNode = null;
	private String treeName;
	private boolean rootCheck;
	public CheckTree(String name, boolean rootCheck) {

		super();
		treeName = name;
		this.rootCheck = rootCheck;
		TreeModel model = new DefaultTreeModel(getRootNode());
		this.setModel(model);
		this.setCellEditor(new Editor());
		this.setEditable(true);
		this.setCellRenderer(new Renderer());
		this.repaint();
	}
	public JCheckBox add(JCheckBox box, String[] stringPath)
	{
		return this.add(box, stringPath, null, false);
	}
	public JCheckBox add(JCheckBox box,String[] stringPath, FlushWriter writer, boolean shouldWrite)
	{
		DefaultMutableTreeNode[] nodePath = new DefaultMutableTreeNode[stringPath.length];
		for(int a = 0; a<stringPath.length; a++)
		{
			nodePath[a] = null;
			DefaultMutableTreeNode prevNode; 
			if(a != 0)
				prevNode = nodePath[a-1];
			else
				prevNode = this.getRootNode();
			if(shouldWrite)
			{
				writer.println("Root node is null? " + (this.getRootNode() == null) + "");
				writer.println("Prevnode is null? " + (prevNode == null));
			}

			DefaultMutableTreeNode[] prevNodeChildren = new DefaultMutableTreeNode[prevNode.getChildCount()];

			for(int b1 = 0; b1 < prevNode.getChildCount(); b1++)
			{
				prevNodeChildren[b1] = ((DefaultMutableTreeNode) prevNode.getChildAt(b1));
			}
			for(int b2 = 0; b2<prevNodeChildren.length; b2++)
			{
				if(prevNodeChildren[b2].getUserObject().equals(stringPath[a]))
				{
					nodePath[a] = prevNodeChildren[b2];
					break;
				}
			}
			if(nodePath[a] == null)
			{
				DefaultMutableTreeNode addNode = new DefaultMutableTreeNode(stringPath[a]);
				prevNode.add(addNode);
				nodePath[a] = addNode;
			}

		}
		DefaultMutableTreeNode bottomNode = nodePath[nodePath.length -1];
		JCheckBox finalBox = null;
		for(int i = 0; i < bottomNode.getChildCount(); i++)
		{
			DefaultMutableTreeNode testCheckNode = (DefaultMutableTreeNode) bottomNode.getChildAt(i);
			try
			{
				if((((JCheckBox) (testCheckNode.getUserObject())).getText().equalsIgnoreCase(box.getText())))
				{
					finalBox = (JCheckBox) testCheckNode.getUserObject();
				}
			}
			catch(Exception ex)
			{

			}
		}
		if(finalBox == null)
		{
			bottomNode.add(new DefaultMutableTreeNode(box));
			finalBox = box;
		}
		return finalBox;
	}
	private DefaultMutableTreeNode getRootNode()
	{
		if(rootNode== null)
		{
			rootNode = new DefaultMutableTreeNode(this.treeName);
		}
		return rootNode;
	}

	@Override
	public boolean isPathEditable(TreePath path) 
	{

		Object comp = path.getLastPathComponent();
		if (comp instanceof DefaultMutableTreeNode) {
			DefaultMutableTreeNode node = (DefaultMutableTreeNode) comp;
			Object userObject = node.getUserObject();
			if (userObject instanceof JCheckBox) {
				return true;
			}
		}
		return false;
	}
	private class Renderer extends DefaultTreeCellRenderer 
	{

		protected JCheckBox checkBoxRenderer = new JCheckBox();

		@Override
		public Component getTreeCellRendererComponent(JTree tree, Object value,
				boolean selected, boolean expanded, boolean leaf, int row,
				boolean hasFocus) {
			if (value instanceof DefaultMutableTreeNode) {
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
				Object userObject = node.getUserObject();
				if (userObject instanceof JCheckBox) {
					checkBoxRenderer = (JCheckBox) userObject;
					return checkBoxRenderer;
				}
			}
			return super.getTreeCellRendererComponent(tree, value, selected, expanded,
					leaf, row, hasFocus);
		}

	}
	private class Editor extends DefaultCellEditor {

		protected JCheckBox nodeData;

		public Editor() {
			super(new JCheckBox());
		}

		@Override
		public Component getTreeCellEditorComponent(JTree tree, Object value,
				boolean selected, boolean expanded, boolean leaf, int row) {
			JCheckBox editor = null;
			nodeData = getBoxFromValue(value);
			if (nodeData != null) {
				editor = (JCheckBox) (super.getComponent());
				editor.setText(nodeData.getText());
				editor.setSelected(nodeData.isSelected());
			}

			return editor;
		}

		public JCheckBox getBoxFromValue(Object value) {
			if (value instanceof DefaultMutableTreeNode) {
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
				Object userObject = node.getUserObject();
				if (userObject instanceof JCheckBox) {
					return (JCheckBox) userObject;
				}
			}
			return null;
		}

		@Override
		public Object getCellEditorValue() {
			JCheckBox editor = (JCheckBox) (super.getComponent());
			nodeData.setSelected(editor.isSelected());
			return nodeData;
		}

	}


}

