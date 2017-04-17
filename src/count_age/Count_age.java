package count_age;

import java.io.FileInputStream;
import java.util.Scanner;
import java.io.FileNotFoundException;

import java.io.FileOutputStream;
import java.io.PrintWriter;

import java.io.File;
import java.io.IOException;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.util.Calendar;

	
public class Count_age {

//input on main window
	public static String inputAddress = "";
	public static String endingTime = "";
	public static String colInput = "";
	public static String singleSolution = "等待輸入...";
	public static int[] brithdate = new int[3];
	
//input information
	public static int length = 0;
	public static String lastThreeWord = "";
	
//input field on main window
	//public static JTextField inputText = new JTextField(50);
	public static JTextField inputText = new JTextField(50);
	public static JTextField monthInput = new JTextField(50);
	public static JTextField colChoose = new JTextField(50);
	public static JLabel showSolution = new JLabel(singleSolution);
	public static JFrame frame = new JFrame();
	
//select mode radio
	//public static JRadioButton[] radio = new JRadioButton[3];
	public static JRadioButton radio1 = new JRadioButton("學分模式",true);
	public static JRadioButton radio2 = new JRadioButton("喜好模式");
	public static JRadioButton radio3 = new JRadioButton("涼修模式");
	
	
//main
	public static void main(String[] args)
	{
	
	//base setting
		frame.setSize(800, 600);
		frame.setTitle("Conut Age");
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.addWindowListener(new CheckOnPress());
		//words font
		Font fontTitle = new Font("新細明體",Font.BOLD,16);
		Font fontText = new Font("新細明體",Font.PLAIN,18);
		Font fontComment = new Font("新細明體",Font.PLAIN,14);
		Font radioFont = new Font("新細明體",Font.BOLD,18);
		
	//Button
		//enter button
		JButton enterButton = new JButton("Enter");
		enterButton.setSize(200,50);
		enterButton.setFont(fontText);
		enterButton.setLocation(530,480);
		enterButtonListener btListener = new enterButtonListener();
		enterButton.addActionListener(btListener);
		
		//exit button
		JButton exitButton = new JButton("Exit");
		exitButton.setSize(200,50);
		exitButton.setFont(fontText);
		exitButton.setLocation(310,480);
		exitButton.addActionListener(btListener);
		
		//browse file button
		JButton browseFile = new JButton("瀏覽檔案");
		browseFile.setSize(150,50);
		browseFile.setLocation(550,80);
		browseFile.setFont(fontText);
		browseFile.addActionListener(btListener);
		
		//radio button
		radio1.setSize(150,50);
		radio1.setLocation(150,200);
		radio1.setFont(radioFont);
		radio2.setSize(150,50);
		radio2.setLocation(150,250);
		radio2.setFont(radioFont);
		radio3.setSize(150,50);
		radio3.setLocation(150,300);
		radio3.setFont(radioFont);
		radio1.setActionCommand("mode1");
		radio2.setActionCommand("mode2");
		radio3.setActionCommand("mode3");
		//group button
		ButtonGroup group = new ButtonGroup();
		group.add(radio1);
		group.add(radio2);
		group.add(radio3);
		radio1.addActionListener(btListener);
		radio2.addActionListener(btListener);
		radio3.addActionListener(btListener);
		frame.add(radio1);
		frame.add(radio2);
		frame.add(radio3);
		
		
		
		frame.setLayout(null);
		frame.add(enterButton);
		frame.add(exitButton);
		frame.add(browseFile);
		
	//TextField
		//input text field
		inputText.setSize(400,30);
		inputText.setLocation(120,80);
		//inputText.setFont(fontText);
		//inputText.setSize(inputText.getPreferredSize());
		inputText.setText(" <輸入檔案位置>");
		//inputText.addActionListener(btListener);
		frame.add(inputText);
	/*	
		//text field of ending date
		monthInput.setSize(200,30);
		monthInput.setLocation(120,200);
		monthInput.setText(" <輸入結束年份月份>");
		frame.add(monthInput);
		
		//text field of column number of data in excel
		colChoose.setSize(100,30);
		colChoose.setLocation(120,300);
		colChoose.setText(" <輸入在第幾欄>");
		frame.add(colChoose);

	//Label
		//input title
		JLabel inputTitle = new JLabel("1. 輸入檔案或出生日期 :");
		inputTitle.setSize(200,50);
		inputTitle.setFont(fontTitle);
		inputTitle.setLocation(100,40);
		frame.add(inputTitle);
		
		//ending date title
		JLabel endingTimeInputTitle = new JLabel("2. 輸入要結束的日期 :");
		endingTimeInputTitle.setSize(200,50);
		endingTimeInputTitle.setFont(fontTitle);
		endingTimeInputTitle.setLocation(100,160);
		frame.add(endingTimeInputTitle);
		
		//title of column number of data in excel
		JLabel colInputTitle = new JLabel("3. 輸入開始資料在第幾欄 :");
		colInputTitle.setSize(200,50);
		colInputTitle.setFont(fontTitle);
		colInputTitle.setLocation(100,260);
		frame.add(colInputTitle);
		
		//solution title
		JLabel solutionTitle = new JLabel("4. 計算結果 : ");
		solutionTitle.setSize(200,50);
		solutionTitle.setFont(fontTitle);
		solutionTitle.setLocation(100,360);
		frame.add(solutionTitle);
		
		//instruction
		JLabel instruction = new JLabel("<html>step 1 : 輸入檔案位置<br>step 2 : 輸入要計算的結束日期<br>step 3 : 輸入資料再execl的哪一欄位<br>step 4 : 確認有關閉檔案後再按下Enter鍵 </html>");
		instruction.setSize(360,300);
		instruction.setFont(new Font("微軟正黑體",Font.PLAIN,20));
		instruction.setLocation(380,150);
		frame.add(instruction);
		*/
		
		//input example1
		JLabel modleInputFile = new JLabel("( 範例: C:/Users/USER/workspace/count_age/test.txt )");
		modleInputFile.setSize(400,50);
		modleInputFile.setFont(fontComment);
		modleInputFile.setLocation(120,100);
		frame.add(modleInputFile);
		
		/*
		//input example2
		JLabel modleInputDate = new JLabel("( 範例: 1995/01/01 )");
		modleInputDate.setSize(400,50);
		modleInputDate.setFont(fontComment);
		modleInputDate.setLocation(120,120);
		frame.add(modleInputDate);
		
		//ending date example
		JLabel modleMonth = new JLabel("( 範例: 1995/01/01 )");
		modleMonth.setSize(200,50);
		modleMonth.setFont(fontComment);
		modleMonth.setLocation(120,220);
		frame.add(modleMonth);
		
		//column number example
		JLabel modleCol = new JLabel("( 範例: A )");
		modleCol.setSize(200,50);
		modleCol.setFont(fontComment);
		modleCol.setLocation(120,320);
		frame.add(modleCol);
		*/
		
		//solution in main window
		showSolution.setSize(300,50);
		showSolution.setFont(fontText);
		showSolution.setLocation(200,410);
		frame.add(showSolution);
		
		frame.setVisible(true);
		
	}
	
//starting function
	public void Startting(String addressing)
	{
		String readingData = "";
		
		//input is the date
		if (addressing.charAt(0)>=48 && addressing.charAt(0)<58)
		{
			brithdate = calc(addressing,endingTime);
		}
		
		//input is the file
		else
		{
			//the file is excel
			if (lastThreeWord.equals("xls"))
			{
				try
				{
				//read excel
					//opening
					//Workbook workbook = Workbook.getWorkbook(new FileInputStream(addressing));
					Workbook workbook = Workbook.getWorkbook(new File(addressing));
					Sheet readSheet = workbook.getSheet(0);
					String sheetName = readSheet.getName();
					
					int rowNum = readSheet.getRows();
					int colNum = readSheet.getColumns();
					int[][] outputBuffer = new int[rowNum][3];
					String[][] excelData = new String[rowNum][colNum];
					String[][] crouseTable = new String[4][5]; //OR final project

					//get original data
					for (int i=0 ; i<rowNum ; i++)
					{
						for (int j=0 ; j<colNum ; j++)
						{
							excelData[i][j] = readSheet.getCell(j,i).getContents();
						}
					}
					
					int k=0;
					int t=0;
					String tempClassName = "";
					int classNumber = 0;
					String tempClass = "";
					//get solution  OR final project
					for (int i=170 ; i<180 ; i++)
					{
						if(readSheet.getCell(i,1).getContents().equals("1"))
						{
							tempClass = readSheet.getCell(i,0).getContents().substring(5);
							classNumber = Integer.parseInt(tempClass);
							tempClassName = readSheet.getCell(classNumber,0).getContents();
							crouseTable[t][k] = tempClassName;
							System.out.println("crouseTable: " + crouseTable[t][k]);
							t++;
							if(t==4)
							{
								k++;
								t=0;
							}
						}	
					}
					
					
					/*//get date data
					for (int i=0 ; i<(rowNum-1); i++)
					{
						//readingData = readSheet.getCell(Integer.parseInt(colInput)-1,1+i).getContents();
						readingData = readSheet.getCell((int)colInput.charAt(0)-65,1+i).getContents();
						//calculating
						brithdate = calc(readingData,endingTime);
						
						for(int n=0 ; n<3 ; n++)
						{
							outputBuffer[i][n] = brithdate[n];
						}
					}*/
					workbook.close();
					
				//write excel
					try
					{
						//opening
						//WritableWorkbook outputWorkbook = Workbook.createWorkbook(new File("C:/Users/USER/Desktop/after.xls"));
						WritableWorkbook outputWorkbook = Workbook.createWorkbook(new File(addressing));
						WritableSheet outputSheet = outputWorkbook.createSheet(sheetName,0);
						
						String[] unit = {"年","月","日"};
						
						/*//output original data
						for (int i=0 ; i<rowNum ; i++)
						{
							for (int j=0 ; j<colNum ; j++)
							{
								Label oriData = new Label(j,i,excelData[i][j]);
								outputSheet.addCell(oriData);
							}
						}*/
						
						//output data OR final project
						for(int i=0 ; i<4 ; i++)
						{
							for (int n=0 ; n<5 ; n++)
							{
								Label outputLabel = new Label(n,2*i-1,crouseTable[i][n]);
								Label outputLabe2 = new Label(n,2*i,crouseTable[i][n]);
								outputSheet.addCell(outputLabel);
								outputSheet.addCell(outputLabe2);
							}
						}
						
						/*//output processed data
						for(int i=0 ; i<rowNum-1 ; i++)
						{
							for (int n=0 ; n<3 ; n++)
							{
								//Label outputLabel = new Label((Integer.parseInt(colInput)+n),i,String.valueOf(outputBuffer[i][n])+unit[n]);
								Label outputLabel = new Label((colNum+n),i+1,String.valueOf(outputBuffer[i][n])+unit[n]);
								outputSheet.addCell(outputLabel);
							}
						}*/
						outputWorkbook.write();
						outputWorkbook.close();
					}
					catch (WriteException e)
					{
						singleSolution = "輸出失敗";
						//System.out.println("false to open file1");
						frame.add(showSolution);
					}
				}
				catch(BiffException e)
				{
					singleSolution = "開啟檔案失敗或找不到檔案";
					//System.out.println("false to open file1");
					frame.add(showSolution);
				}
				catch(IOException e)
				{
					singleSolution = "開啟檔案失敗或找不到檔案";
					//System.out.println("false to open file2");
					frame.add(showSolution);
				}
			}
			
			//the excel file is too new
			else if (lastThreeWord.equals("lsx"))
			{
				//System.out.println("in the lsx");
				singleSolution = "不支援該檔案";
				frame.add(showSolution);
			}
			
			//the file is text
			else if (lastThreeWord.equals("txt"))
			{
				try
				{
					//opening
					Scanner inputFile = new Scanner(new FileInputStream(addressing));
					PrintWriter outputFile = new PrintWriter(new FileOutputStream("C:/Users/USER/Desktop/after.txt"));

					//processing
					while(inputFile.hasNextLine())
					//for(int i=0 ; i<10 ; i++)
					{
						//read data
						readingData = inputFile.nextLine();
						
						//execute
						brithdate = calc(readingData,endingTime);
						
						//output
						outputFile.print(readingData);
						outputFile.print("\t");
						//outputFile.print(brithdate[0] + "年 " + brithdate[1] + "月 " + brithdate[2] + "日");
						outputFile.printf("%2d 年 %2d 月 %2d 日",brithdate[0],brithdate[1],brithdate[2]);
						outputFile.println();
					}
					outputFile.flush();
					outputFile.close();
					inputFile.close();
				}
				catch(FileNotFoundException e)
				{
					//System.out.println("開啟檔案失敗或找不到檔案");	
					singleSolution = "開啟檔案失敗或找不到檔案";
					frame.add(showSolution);
				}
			}
			else
			{
				singleSolution = "開啟檔案失敗或找不到檔案";
				//System.out.println("else");
				frame.add(showSolution);
			}
		}
	}	

//calculation function
	public int[] calc(String inputDate,String endingChoose)
	{
		Calendar calendar = Calendar.getInstance();
		
		int[] solution = new int[3];
		int[] notNum = {0,0};
		int j=0;
		
		//find the position of character not number
		for(int i=5 ; i<inputDate.length() ; i++)
		{
			if (inputDate.charAt(i)<48 || inputDate.charAt(i)>57)
			{
				notNum[j] = i;
				j++;
			}
		}
		
		//setting the year,month,date
		int fileYear = Integer.parseInt(inputDate.substring(0,4));
		int fileMonth = Integer.parseInt(inputDate.substring(5,notNum[0]));
		int fileDate = 0;
		if (notNum[1] == 0)
		{
			fileDate = Integer.parseInt(inputDate.substring(notNum[0]+1));
		}
		else
		{
			fileDate = Integer.parseInt(inputDate.substring(notNum[0]+1,notNum[1]));
		}

		
		
		int nowYear = 0;
		int nowMonth = 0;
		int nowDate = 0;
		
		//ending date is set
		if (endingChoose.equals(" <輸入結束年份月份>") || endingChoose.equals(""))
		{
			nowYear = calendar.get(Calendar.YEAR);
			nowMonth = calendar.get(Calendar.MONTH) +1;
			nowDate = calendar.get(Calendar.DATE);	
		}
		
		//not set ending date
		else
		{
			nowYear = Integer.parseInt(endingChoose.substring(0,4));
			nowMonth = Integer.parseInt(endingChoose.substring(5,7));
			nowDate = Integer.parseInt(endingChoose.substring(8,10));
		}
		
		//count years
		solution[0] = nowYear - fileYear;
		
		//count months
		if(nowMonth < fileMonth)
		{
			solution[1] = 12-fileMonth+nowMonth;
			
			if (solution[0] != 0)
			{
				solution[0] --;
			}
		}
		else if (nowMonth > fileMonth)
		{
			solution[1] = nowMonth - fileMonth;
		}
		else
		{
			solution[1] = 0;
		}
		
		//count dates
		if (nowDate < fileDate)
		{
			//odd month
			if(fileMonth%2 == 1)
			{
				if(fileMonth >= 7)
				{
					solution[2] = 30-fileDate+nowDate;
				}
				else
				{
					solution[2] = 31-fileDate+nowDate;
				}
			}
			
			//even month
			else
			{
				if(fileMonth == 2)
				{
					solution[2] = 28-fileDate+nowDate;
				}
				else if(fileMonth > 7)
				{
					solution[2] = 31-fileDate+nowDate;
				}
				else
				{
					solution[2] = 30-fileDate+nowDate;
				}
			}
			
			if (solution[1] == 0)
			{
				if (solution[0] != 0)
				{
					solution[1] = 11;
					solution[0]--;
				}
			}
			else 
			{
				solution[1]--;
			}
		}
		else if(nowDate > fileDate)
		{
			solution[2] = nowDate - fileDate;
		}
		else
		{
			solution[2] = 0;
		}
		
		return solution;
	}
		



}
