package ie.gmit.dip;

import java.util.*;
/**
 *@author Jakub Leszczynski
 *@version 1.0
 *@since 1.8
 *
 *The Runner class that initiates the start of the application.
 *
 */
public class Runner {
	/**
	 * 
	 * @param args
	 * @throws Exception if an Exception is thrown
	 */
	public static void main(String[] args)throws Exception {
		
		Scanner in = new Scanner(System.in);
		String choice = "";
		String end = "quitt";
		QueryParser book;
		boolean keepRunning = false;
		
		choice = chooseTheBook(in, choice);
		
		book = new QueryParser(choice);
	
		enterTheWord(in, end, book, keepRunning);
		}
	/**
	 * Method enterTheWord takes input from a user and stores the value in a local variable
	 * 
	 * @param in the input from a user
	 * @param end the key word to escape the loop
	 * @param book the query from a user
	 * @param keepRunning loop condition variable
	 */
	private static void enterTheWord(Scanner in, String end, QueryParser book, boolean keepRunning) {
		String word;

		do{	
			System.out.println("Which word are you looking for: ");
			System.out.println("Enter quitt to close");
			word = in.nextLine().toUpperCase();
			if(word.equalsIgnoreCase(end)){
				keepRunning=true;
			}	
			else{
				System.out.println(book.getWord(word));
				
			}
		}while(!keepRunning);
	}
	/**
	 * Method chooseTheBook asks a user to choose a book.
	 * 
	 * @param in the input from a user
	 * @param choice the choices that a user can choose from
	 * @return returns the choice selected by the user
	 */
	private static String chooseTheBook(Scanner in, String choice) {
		int select;
		do{
			System.out.print("Please choose which book you would like to parse \nEnter : \n1 - War And Peace \n2 - De Bello Gallico \n3 - Poblacht NaH Eireann"
					+ " \n4 - Divine Comedy \n5 - Happy Prince \n6 - Picture Of DorianGray \n7 - The Prince");	
			select = in.nextInt();
			switch(select){
			case 1:
				choice = "WarAndPeace-Tolstoy.txt";
				break;
			case 2:
				choice = "DeBelloGallico-Caesar.txt";
				break;
			case 3:
				choice = "PoblachtNaHEireann.txt";
				break;
			case 4:
				choice = "DivineComedy-Dante.txt";
				break;
			case 5:
				choice = "HappyPrince-Wilde.txt";
				break;
			case 6:
				choice = "PictureOfDorianGray-Wilde.txt";
				break;
			case 7:
				choice = "ThePrince-Machiavelli.txt";
				break;
			}
		}while(select < 1 || select > 8);
		return choice;
	}

}