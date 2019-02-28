package ie.gmit.dip;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
/**
 *@author Jakub Leszczynski
 *@version 1.0
 *@since 1.8
 *
 *The InputFactory class wraps BufferedReader around other readers for easy usage .
 *
 */
public class InputFactory {
	private String in;
	
	public InputFactory() {
	this.setIn(in);
	}
	/**
	 * FileInputStream obtains input bytes from a file in a file system.
	 * @param in takes in the file name.
	 * @return returns input bytes of a file.
	 * @throws Exception if an Exception is thrown
	 */
	public static FileInputStream fileStream(String in) throws Exception {
		return new FileInputStream(in);
	}
	/**
	 * InputStreamReader is a bridge from byte streams to character streams.
	 * 
	 * @param in takes the byte streams of the file.
	 * @return returns character streams of the file.
	 * @throws Exception if an Exception is thrown
	 */
    public static InputStreamReader inStreamReader(String in) throws Exception{
        return new InputStreamReader(fileStream(in));
    }
    /**
     * Reads text from a character-input stream, 
     * buffering characters so as to provide for the efficient reading of characters, arrays, and lines.
     * 
     * @param in reads text from a character-input stream.
     * @return returns buffered characters.
     * @throws Exception if an Exception is thrown
     */
    public static BufferedReader bufferedReader(String in) throws Exception{
        return new BufferedReader(inStreamReader(in));
  
	}
    /**
     * Method setIn sets the file name to the variable in.
     * @param in sets the file name.
     */
	public void setIn(String in) {
		this.in = in;
	}
    
}