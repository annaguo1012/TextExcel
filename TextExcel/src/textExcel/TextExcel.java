package textExcel;

import java.io.FileNotFoundException;
import java.util.Scanner;

// Update this file with your own code.

public class TextExcel
{

	public static void main(String[] args)
	{
	    // Add your command loop here
		Spreadsheet spreadSheet = new Spreadsheet();
		Scanner pCommands = new Scanner(System.in);
		
		System.out.println("Welcome to Anna's TextExcel! Enter any commands or \"quit\" to quit");
		
		//TestsALL.Helper th = new TestsALL.Helper();
		//System.out.println(spreadSheet.getGridText());
		
		
		boolean cont = true;
		while(cont)
		{
			String input = pCommands.nextLine(); //uncomment later
			//String input = "D18 = 3.14";
			if (input.equals("quit"))
			{
				cont = false;
			}
			else
			{
				
				System.out.println(spreadSheet.processCommand(input));
			}
		}

		pCommands.close();
		
	}
}
