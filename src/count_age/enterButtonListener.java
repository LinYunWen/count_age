package count_age;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class enterButtonListener implements ActionListener{
	
	Count_age countAge = new Count_age();
	
	//click the main window
	public void actionPerformed(ActionEvent e)
	{
		if (e.getActionCommand().equals("Enter"))
		{
		
		//get input on main window
			countAge.inputAddress = countAge.inputText.getText();
			countAge.endingTime = countAge.monthInput.getText();
			countAge.colInput = countAge.colChoose.getText();
			
		//to get the input last words
			countAge.length = countAge.inputAddress.length();
			countAge.lastThreeWord = countAge.inputAddress.substring(countAge.length-3);
		//start to execute
			countAge.Startting(countAge.inputAddress);
			
		//input is the Date
			if (countAge.inputAddress.charAt(0)>=48 && countAge.inputAddress.charAt(0)<58)
			{
				countAge.singleSolution = countAge.brithdate[0]+" 年  "+countAge.brithdate[1]+" 月  "+countAge.brithdate[2]+" 日 ";
				countAge.showSolution.setText(countAge.singleSolution);
				countAge.frame.add(countAge.showSolution);

			}
		//input is the file
			else if (countAge.lastThreeWord.equals("txt") || countAge.lastThreeWord.equals("xls"))
			{
				countAge.showSolution.setText("已完成輸出於桌面  檔案名: after");
				countAge.frame.add(countAge.showSolution);
			}
		//input is illegal
			else
			{
				countAge.showSolution.setText("開啟檔案失敗或找不到檔案");
				countAge.frame.add(countAge.showSolution);
			}
			
			
		}
		
		//click exit button
		if(e.getActionCommand().equals("Exit"))
		{
			ConfirmWindow exitWindow = new ConfirmWindow();
			exitWindow.setVisible(true);
		}
		
		if (e.getActionCommand().equals("瀏覽檔案"))
		{
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setMultiSelectionEnabled(false);
			int returnValue = fileChooser.showOpenDialog(null);
			if (returnValue == JFileChooser.APPROVE_OPTION)
			{
				File selectedFile = fileChooser.getSelectedFile();
				String relativePath = "";
				
				for (int i=0 ; i<selectedFile.getAbsolutePath().length(); i++)
				{
					if (selectedFile.getAbsolutePath().charAt(i)== 92)
					{
						relativePath += "/";
					}
					else
					{
						relativePath += selectedFile.getAbsolutePath().charAt(i);
					}
				}
				
				//countAge.inputText.setText(selectedFile.getAbsolutePath());
				countAge.inputText.setText(relativePath);
			}
		}

	}

}
