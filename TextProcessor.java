/*
TextProcessor.java
Miro K.
21.05.2021
*/
import javax.swing.*;
public class TextProcessor
{
//variables
	private String paragraph;
	private String firstLast="Ma";
	private StringBuffer [] sorted;
	private int questionCounter;
	private char [] delim = new char []{' ','.','.','!','?'};
	private char [] vowels= new char []{'a','o','e','i','u'};
	private char [] vowels1= new char []{'A','O','E','I','U'};
	StringBuffer finalSb;
	private String [] words;
	private int wordCounter;

//default constructor all unutilised variables initialised to default values
	public TextProcessor(){}
//setters & getters
	public void setDelim(char[] a)
	{
		this.delim=a;
	}
	public void setVowels(char[] a)
	{
		this.vowels=a;
	}
	public void setVowels1(char[] a)
	{
		this.vowels1=a;
	}
	public void setFirstLast(String a)
	{
		this.firstLast=a;
	}
	public void setParagraph(String a)
	{
			this.paragraph=a;
	}
	public StringBuffer getFinalSb()
	{
		return finalSb;
	}
//compute
	public  void compute()
	{	if(paragraph!=null)
		{
//in case user inputs paragraph using setMethod()
			computeWithoutJ();
		}else
		{
//endless loop to enable multiple paragraph encoding
			while(true){
				questionCounter=0;
				paragraph=JOptionPane.showInputDialog(null, "Please input the paragraph you want to encode or NO to exit:");
				while(true){
//if cancel is chosen
				if(paragraph==null)
				{
					paragraph=JOptionPane.showInputDialog(null, "Please input the paragraph you want to encode or NO to exit:");
				}else
					{
						break;
					}
				}
//to exit encoding method
				if(paragraph.equalsIgnoreCase("no")){break;}
//initialise array to maximum length
				sorted=new StringBuffer[paragraph.length()];
//create temporary SB
				StringBuffer temp=new StringBuffer();
				for(int i =0;i<paragraph.length();i++)

				{
//to prevent appending same char twice
					boolean flag=true;
//to check number of interrogative sentences
					if(paragraph.charAt(i)=='?')questionCounter++;
					for(int j=0;j<vowels.length;j++)
					{
//check for vowels
						if(paragraph.charAt(i)==vowels[j]||paragraph.charAt(i)==vowels1[j])
						{
//every char has to be appended
							temp.append(paragraph.charAt(i));
//if vowel then encoded
							temp.append(firstLast);
//add to array of SBs
							sorted[i]=temp;
//to prevent appending same char twice
							flag=false;
						}
					}
					for(int j=0;j<delim.length;j++)
					{
						if(paragraph.charAt(i)==delim[j]&flag)
						{
//every char has to be appended
							temp.append(paragraph.charAt(i));
//add to array of SBs
						   sorted[i]=temp;
//to prevent appending same char twice
						   flag=false;
						}
					}
					if(flag)
					{
						temp.append(paragraph.charAt(i));
						sorted[i]=temp;
					}
//every char has to be appended
					temp=new StringBuffer();
//reset temp SB
				}//loop outer

				String s=String.valueOf(questionCounter);
				finalSb=new StringBuffer(s);
//to start with number of interrogative sentences
				for(int i=0;i<sorted.length;i++)
				{
					if(sorted[i]!=null)
					{
						finalSb.append(sorted[i]);
//finalise output SB by adding array of encoded SBs
					}
				}
				JOptionPane.showMessageDialog(null, "Your paragraph encoded looks like this:\n "+finalSb);
				String so=JOptionPane.showInputDialog(null, "Do you want to encode one more paragraph, yes or no?");
				if(so!=null && so.equalsIgnoreCase("no")){break;}
			}//while
		}
	}//compute
	public void computeWithoutJ()//in case user inputs paragraph using setMethod()
	{
						sorted=new StringBuffer[paragraph.length()];//initialise array to maximum length
						StringBuffer temp=new StringBuffer();//create temporary SB
						for(int i =0;i<paragraph.length();i++)

						{
							boolean flag=true;//to prevent appending same char twice
							if(paragraph.charAt(i)=='?')questionCounter++;//to check number of interrogative sentences
							for(int j=0;j<vowels.length;j++)
							{
								if(paragraph.charAt(i)==vowels[j]||paragraph.charAt(i)==vowels1[j])//check for vowels
								{
									temp.append(paragraph.charAt(i));//every char has to be appended
									temp.append(firstLast);//if vowel then encoded
									sorted[i]=temp;//add to array of SBs
									flag=false;//to prevent appending same char twice
								}
							}
							for(int j=0;j<delim.length;j++)
							{
								if(paragraph.charAt(i)==delim[j]&flag)
								{
									temp.append(paragraph.charAt(i));//every char has to be appended
								   sorted[i]=temp;//add to array of SBs
								   flag=false;//to prevent appending same char twice
								}
							}
							if(flag)
							{
								temp.append(paragraph.charAt(i));
								sorted[i]=temp;
							}//every char has to be appended
							temp=new StringBuffer();//reset temp SB
						}//loop outer

						String s=String.valueOf(questionCounter);
						finalSb=new StringBuffer(s);//to start with number of interrogative sentences
						for(int i=0;i<sorted.length;i++)
						{
							if(sorted[i]!=null)
							{
								finalSb.append(sorted[i]);//finalise output SB by adding array of encoded SBs
							}
						}
						JOptionPane.showMessageDialog(null, "Your paragraph encoded looks like this:\n "+finalSb);
	}//compute without JoptionPane

	public void shortWord(String[] a)//takes array parameter
	{
		int length=10000;
		for(int i=0;i<a.length;i++)//find shortest word
		{
			if(a[i].length()<length)
				{
					length=a[i].length();
				}
		}
		int counter=0;
		for(int i=0;i<a.length;i++)//how many short words of same length
		{
			if(a[i].length()==length){counter++;}
		}
		words=new String[counter];
		for(int i=0;i<a.length;i++)//add short words into array
		{
			if(a[i].length()==length)
			{
			if(counter>-1)words[--counter]=a[i];
			}
		}
		String temp="";
		for(String str:words){if(str!=null)temp+=" "+str;}
		JOptionPane.showMessageDialog(null, "Your shortest word/s:\n"+temp);//display shortest words or word
	}//shortWord

	public void wordCounting(int a)
	{
		String[] words=new String[a];
		String word=null;
		for(int i=0;i<a;i++)
		{
		word=JOptionPane.showInputDialog(null, "Please input word:");//asking user for input int a times

		if(word!=null){words[i]=word;}

		}
		if(words[0]!=null){shortWord(words);
		}else{wordCounting(a);}//once all the words are in, passed to wordCounting(String[]a)

	}//word counting
}//class