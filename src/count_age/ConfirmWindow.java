package count_age;

import java.awt.BorderLayout;
import java.awt.event.*;
import java.awt.*;

import javax.swing.*;
import javax.swing.event.*;

public class ConfirmWindow extends JFrame implements ActionListener{
	public ConfirmWindow()
	{
	//set window
		setTitle("exit");
		setSize(300,200);
		setLayout(null);
		
	//Label
		JLabel confirmLabel = new JLabel("Are you want to exit??");
		confirmLabel.setSize(200,50);
		confirmLabel.setFont(new Font("新細明體",Font.BOLD,20));
		confirmLabel.setLocation(50,30);
		add(confirmLabel);
		
	//Button
		//yes button
		JButton YesButton = new JButton("Yes");
		YesButton.setSize(80,35);
		YesButton.setFont(new Font("新細明體",Font.PLAIN,18));
		YesButton.setLocation(55,90);
		YesButton.addActionListener(this);
		add(YesButton);

		//no button
		JButton NoButton = new JButton("No");
		NoButton.setSize(80,35);
		NoButton.setFont(new Font("新細明體",Font.PLAIN,18));
		NoButton.setLocation(155,90);
		NoButton.addActionListener(this);
		add(NoButton);
	}
	
	//action after click
	public void actionPerformed(ActionEvent e)
	{
		if (e.getActionCommand().equals("Yes"))
		{
			System.exit(0);
		}
		else
		{
			setVisible(false);
		}
	}

}
