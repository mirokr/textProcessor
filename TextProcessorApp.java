/*
TextProcessorApp.java
Miro K.
21.05.2021
*/
import javax.swing.*;
public class TextProcessorApp
{

	public static void main(String[]args)
	{
//menu of app
		while(true)
		{
			int i=0;
			try
			{
				 i=Integer.parseInt(JOptionPane.showInputDialog(null, "Welcome to the Text Processor Application!\nChoose from the following options:\n1. Encode the paragraph\n2. Find the shortest word/s\nPlease input number of your choice or press 9 to exit."));
			}
			catch(NumberFormatException e)
			{
				JOptionPane.showMessageDialog(null, "Please input a number of your choice or 9 to exit!");
			}
			if(i==9){break;}
			if(i==1){new TextProcessor().compute();}//option 1
			if(i==2)//option 2
			{
				while(true)
				{	int j=0;
					try
					{
						j=Integer.parseInt(JOptionPane.showInputDialog(null, "Please input number of words you want to compare or 9 to exit"));
					}catch(NumberFormatException e)
					{
						JOptionPane.showMessageDialog(null, "Please input a NUMBER of your choice or 9 to exit!");continue;
					}
					if(j==9){break;}
					else{
//calls dedicated method in TextProcessor
					new TextProcessor().wordCounting(j);}
				}
			}
		}//loop
	}//main
}//class