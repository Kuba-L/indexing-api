package ie.gmit.dip;

import java.io.*;
import java.util.*;
/**
 *@author Jakub Leszczynski
 *@version 1.0
 *@since 1.8
 *
 *The DictionaryParser class parses the dictionary
 */
public class DictionaryParser implements Parse{
	private Map<String, List<String>> dictionary = new TreeMap<String, List<String>>();
	private StringBuilder builder = new StringBuilder();
	/**
	 * Constructor DictionaryParser takes in the name of the dictionary file.
	 * 
	 * @param dictionaryFileName the name of the dictionary file.
	 */
	public DictionaryParser(String dictionaryFileName) {
		try{
		parser(dictionaryFileName);
		} catch (Exception e) {
			System.out.println(":(");
			e.printStackTrace();
		}
	}
		/**
		 * Method proces returns the word from the dictionary.
		 * 
		 * @param br reads text from a character-input stream
		 * @param line returns the dictionary
		 * @return returns the word
		 * @throws IOException if an IOException is thrown
		 */
	private String proces(BufferedReader br, String line) throws IOException {
		String word = line.substring(1, line.indexOf("\"",1));
		do{
		builder.append(line + "\n");
		line = br.readLine();
		}while((line = br.readLine()) != null && line.charAt(0) != '\u0022');
		return word;
	}
	/**
	 * Method resetBuilder clears the string
	 */
	private void resetBuilder(){
		builder.setLength(0);
	}
	/**
	 * Method GetDefinition gets the definition of the word.
	 * 
	 * @param word reads in the word.
	 * @return returns the definition.
	 */
	public List<String> getDefinition(String word){
		return getDictionary().get(word.toUpperCase());
	}
	
	/**
	 * Method addWordDetail checks if the word is in the dictionary, 
	 * if the definition is in the dictionary it adds the definition to the word.
	 * 
	 * 
	 * @param word reads in the word.
	 * @param definition reads in the definition.
	 */
	public void addWordDetail(String word, String definition){
		if(getDictionary().get(word) == null){
			List<String> list = new LinkedList<String>();
			list.add(definition);
			getDictionary().put(word, list); //O(1)
		}
		else{
			getDictionary().get(word).add(definition);
		}
	}

	/**
	 * Method getDictionary returns the dictionary.
	 * 
	 * @return returns dictionary.
	 */
	public Map<String, List<String>> getDictionary() {
		return dictionary;
	}
	/**
	 * Method setDictionary sets the dictionary.
	 * 
	 * @param dictionary takes the values of dictionary.
	 */
	public void setDictionary(Map<String, List<String>> dictionary) {
		this.dictionary = dictionary;
	}
	
	/**
	 * Method parser is an inherited method from Interface Parse.
	 * It Parses the dictionary.
	 */
	@Override
	public void parser(String string) throws Exception {
		BufferedReader br = InputFactory.bufferedReader(string);
		br.readLine();
		String line = br.readLine();
		while((line = br.readLine()) != null){			
			if(line.startsWith("\"")){
				String word = proces(br, line);
				addWordDetail(word.toUpperCase(), builder.toString());
				resetBuilder();
			}	
		}
		br.close();
	}		
}
