package ie.gmit.dip;

import java.io.*;
import java.util.*;
/**
 *@author Jakub Leszczynski
 *@version 1.0
 *@since 1.8
 *
 *The ParseStopWord class parses the stop words.
 *
 */
public class ParseStopWords implements Parse {
	
	Set<String> stop = new TreeSet<String>();
	

	/**
	 * Constructor ParseStopWord takes in the name of the file of the stop words.
	 * 
	 * @param theFile  the name of the file to be parsed.
	 * @throws Exception if an Exception is thrown
	 */
	public ParseStopWords(String theFile) throws Exception {
				parser(theFile);
	}
	/**
	 * Method getStopWord returns the stop words.
	 * 
	 * @return returns the stop words.
	 */
	public Set<String> getStopWords(){
		return stop;	
	}
	
	/**
	 * Method igonore checks if the word passed is on the stop word list.
	 * 
	 * @param takes in a word to be checked.
	 * @return ignored returns true or false depending if the word is on the stop word list.
	 */
	public boolean ignore(String ignored){
		return ignored.contains(ignored.toUpperCase());
	}
	/**
	 * Method parser is an inherited method from Interface Parse.
	 * It Parses the stop words file.
	 */
	@Override
	public void parser(String string) throws Exception {
		try {
			BufferedReader br = InputFactory.bufferedReader(string);
		
		
		String line = null;
		
		while ((line = br.readLine()) != null){
			stop.add(line); //O(log(n))
		}
		
		br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}