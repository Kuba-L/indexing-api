package ie.gmit.dip;

import java.util.*;

public class WordDetails {
	
	private List<String> definition = new ArrayList<String>();
	private List<Integer> pages = new ArrayList<Integer>();
	
	public WordDetails(){ //constructor that creates 2 lists.
		this.definition = new ArrayList<String>();
		this.pages = new ArrayList<Integer>();
	}	
	public void setDefinition(List<String> definition) {
		this.definition = definition;
	}//set definition
	
	public List<String> getDefinition() {
		return definition;
	}//get definition
	
	public List<Integer> getPages() {
		return pages;
	}//get pages
	public void setPages(List<Integer> pages) {
		
			this.pages = pages;
	}//set pages
	
	public WordDetails(int page){ //constructor that takes in value of page
		addIndex(page);
	}
	
	public void addIndex(int page){
		this.pages.add(page);
	}//add index
	
	
	@Override
	public String toString() {
		return "definition=" + getDefinition() + "\n " +" pages=" + getPages();
	}
		
		
	
}
