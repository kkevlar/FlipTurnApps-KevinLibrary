package com.flipturnapps.kevinLibrary.newgui;

import java.awt.BorderLayout;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import com.flipturnapps.kevinLibrary.gui.EnterField;
import com.flipturnapps.kevinLibrary.gui.IntButton;
import com.flipturnapps.kevinLibrary.helper.ThreadHelper;

public class UserIOFrame extends JFrame {

	private JPanel contentPane;
	private JTextArea textArea;
	private JPanel southPanel;


	public UserIOFrame ()
	{
		this("",false);
	}	
	public UserIOFrame(String title, boolean icon)
	{
		super(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		contentPane.add(scrollPane, BorderLayout.CENTER);

		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		textArea.setBackground(SystemColor.control);
		scrollPane.setViewportView(textArea);

		southPanel = new JPanel();
		southPanel.setVisible(false);
		southPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		contentPane.add(southPanel, BorderLayout.SOUTH);

		if(icon)
			this.setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("icon.png")));
		
	}
	public void refreshFrame()
	{
		this.setSize(this.getSize().width + 1, this.getSize().height);
		this.repaint();
		this.setSize(this.getSize().width - 1, this.getSize().height);
	}
	public void getInputTypeNothing()
	{
		southPanel.setVisible(false);
		southPanel.removeAll();
		contentPane.remove(1);
		refreshFrame();
	}
	public String getInputTypeText()
	{
		southPanel.removeAll();
		contentPane.remove(1);
		EnterField field = new EnterField();
		String last = field.getLastText();
		contentPane.add(field,BorderLayout.SOUTH);
		southPanel.setVisible(true);
		refreshFrame();
		field.requestFocus();
		while(field.getLastText() == null || field.getLastText().equals(last)){ThreadHelper.sleep(50);}
		return field.getLastText();
	}
	public int getInputTypeButton(String...text)
	{
		southPanel.removeAll();
		contentPane.remove(1);
		for (int i = 0; i < text.length; i++)
		{
			IntButton button = new IntButton(i);
			button.setText(text[i]);
			southPanel.add(button);
		}
		contentPane.add(southPanel,BorderLayout.SOUTH);
		southPanel.setVisible(true);
		refreshFrame();
		IntButton.currId = -1;
		while(IntButton.currId == -1)
		{
			ThreadHelper.sleep(50);
		}
		return IntButton.currId;
	}

	public int getInputTypeButtonInt(String...text)
	{
		return getInputTypeButton(text);
	}

	public String getInputTypeButtonString(String...text)
	{
		return text[getInputTypeButton(text)];
	}

	public JTextArea getTextArea()
	{
		return textArea;
	}

	public JPanel getInputPanel()
	{
		return southPanel;
	}

	public void print(String s)
	{
		textArea.append(s);
	}

	public void println(String s)
	{
		textArea.append(s + "\n");
	}

	public void println()
	{
		textArea.append("\n");
	}

	public void setText(String s)
	{
		textArea.setText(s);
	}

	public void clear()
	{
		this.setText("");
	}

}
