package count_age;

import java.awt.event.*;

public class CheckOnPress implements WindowListener{
	
	public void windowOpened(WindowEvent e){}
	
	//when window is closing
	public void windowClosing(WindowEvent e)
	{
		ConfirmWindow checker = new ConfirmWindow();
		System.out.println("in check on Press");
		checker.setVisible(true);
	}
	public void windowClosed(WindowEvent e){}
	public void windowIconified(WindowEvent e){}
	public void windowDeiconified(WindowEvent e){}
	public void windowActivated(WindowEvent e){}
	public void windowDeactivated(WindowEvent e){}

}
