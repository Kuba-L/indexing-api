package ie.gmit.dip;

import java.io.*;
import java.util.*;
/**
 *@author Jakub Leszczynski
 *@version 1.0
 *@since 1.8
 *
 *Class QueryParser parses the book selected by the user.
 *
 */
public class QueryParser implements Parse{
	
	private DictionaryParser dictionary = new DictionaryParser("dictionary.csv");
	private ParseStopWords ignore =  new ParseStopWords("stopwords.txt");
	private Map<String, WordDetails> theMap = new HashMap<String, WordDetails>();
	private List <String> define;
	private int page=1, lineNumber=0;
	private String [] words;
	private String line;
	private WordDetails details;
	
	/**
	 * Constructor QueryParser takes in the name of the book selected by the user.
	 * 
	 * @param name the name of the book to be parsed.
	 * @throws Exception if an Exception is thrown.
	 */
	public QueryParser(String name) throws Exception{
		this.theMap = new HashMap<String, WordDetails>();
		parser(name);

	}
	
	/**
	 * Method proces checks for ignored words, 
	 * checks if theMap contains a mapping for the word, 
	 * gets the value for the word and adds the page number to the index,
	 * if the word is not mapped it creates new Object, sets and gets the definition and puts into the map.
	 */
	private void proces() {
			for(String s: words) {
				if(ignore.ignore(s)){
					continue;
				}
				if (theMap.containsKey(s.toUpperCase())){ //O(n)
					details = theMap.get(s.toUpperCase());
					details.addIndex(page);
				}
				else {
					details = new WordDetails(page);
					details.setDefinition((define = dictionary.getDefinition(s)));
					theMap.put(s.toUpperCase(), details);
				}
			}
			
		}
	/**
	 * Methd getWord gets the value of the word mapped to it,
	 * checks for it and returns the result.
	 * 
	 * @param word reads the word passed
	 * @return returns the result.
	 */
	public String getWord(String word){
		
		WordDetails details = theMap.get(word.toUpperCase());
		String result;
		
		if(details != null){
			result =  details.toString();
		} else {
			result = "Not Found";
		}
		return result;
	}//get key
	/**
	 * Method getPage gets the value.
	 * @param v checks for this value.
	 * @return 
	 * @return returns the value of the word
	 */
	public WordDetails getValue(String v){
		return theMap.get(v);
	}
	/**
	 * Method getPage returns the page number.
	 * 
	 * @return returns the page number.
	 */
	public int getPage(){
		return this.page;
	}
	/**
	 * Method getLine gets the line number.
	 * 
	 * @return returns the line number.
	 */
	public int getLine(){
		return this.lineNumber;
	}//get line	
	
	/**
	 * Method parser is an inherited method from Interface Parse.
	 * It Parses the book selected by the user.
	 */
	@Override
	public void parser(String string) throws Exception {
		BufferedReader br = InputFactory.bufferedReader(string);
		
		br.readLine();
		while((line = br.readLine()) != null){
			lineNumber++;
			if(lineNumber % 40 == 0){
				page++;
			}			
			words = line.split(" ");//Regex	
			proces();
		}
		br.close();
 	}	
	
}
