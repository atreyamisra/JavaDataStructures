/*
     Andrew Ferrari - acf2282
Atreya Misra - am73676 
 */

package assignment4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;



// do not change class name or interface it implements
public class WordLadderSolver implements Assignment4Interface
{
    // delcare class members here.

    // add a constructor for this object. HINT: it would be a good idea to set up the dictionary there

    // do not change signature of the method implemented from the interface
    //@Override
	//returns the number of index differences between two strings
    static int numDifferences(String one, String two){
    	int	diff = 0;
    	int length = one.length();
    	for (int i=0;i<length;i++ ){
    		if (one.charAt(i)!=two.charAt(i)){diff++;}
    	}
    	return diff;
    }
    
    //returns a list of Strings next to "word" sorted by differences with "start"
    static ArrayList<String> neighborList(List<String> list, String word, String start){
    	List<String> neighbors = findNeighbor(list,word);
    	return sortDifferences(neighbors,start);
    }
    
    //returns a list of Strings next to "word"
    static ArrayList<String> findNeighbor(List<String> list, String word){
    	ArrayList<String> result = new ArrayList<String>();
    	for(int i =0; i< list.size(); i++){
    		if (isNeighbor(word,list.get(i))){
    			result.add(list.get(i));
    		}
    	}   	
    	return result;   	
    }
    
    //returns true if a and b have 5 letters
    static boolean fiveLetters(String a, String b){
    	if(a.length()!=b.length() || a.length() != 5){ return false;}
    	return true;
    }
    
    //returns sorted list by differences with "start"
    static ArrayList<String> sortDifferences(List<String> original, String start){
    	ArrayList<String> list = new ArrayList<String>(original); 	
    	for(int i =0; i< list.size(); i++){
        	for(int x =0; x< list.size(); x++){
	    		if(numDifferences(list.get(i),start)< numDifferences(list.get(x),start)){
	    			String temp = list.get(i);
	    			list.set(i,list.get(x));
	    			list.set(x,temp);
	    		}
    		}
    	}
    	return list;   	
    }
    
    //returns true if Strings differ by exactly 1 index
    static boolean isNeighbor(String a, String b){
    	int i = a.length();
    	int letterCount = 0;
    	for (int j=0; j < i; j++){
    		if ( a.charAt(j) == b.charAt(j) ){
    			letterCount++;
    		}
    	}
    	if (i == letterCount+1){return true;}
    	else return false;
    }
	public static ArrayList<String> computeLadder(String startWord, String endWord, ArrayList<String> dictionary) throws NoSuchLadderException 
    {
		ArrayList<String> finalList = new ArrayList<String>();
		if(fiveLetters(startWord, endWord) == true){
        	int found = 0;
        	int currentIndex = -1;
        	ArrayList<Integer> parentList = new ArrayList<Integer>();
        	parentList.add(currentIndex);
            String currentWord;
            ArrayList<String> arrayChecked = new ArrayList<String>();
            ArrayList<String> queue = new ArrayList<String>();
            queue.add(startWord);
            while(queue.isEmpty() == false){
            	currentWord = queue.get(queue.size() - 1);
            	queue.remove(queue.size() - 1);
            	int checker = 0;
            	if(arrayChecked.contains(currentWord) == false){
            		currentIndex++;
            		arrayChecked.add(currentWord);
            		ArrayList<String> childWord = new ArrayList<String>();
            		childWord = neighborList(dictionary, currentWord, endWord);
            		for(checker = 0; checker < childWord.size(); checker++){
            			parentList.add(currentIndex);
            			if(childWord.get(checker).equals(endWord)){
            				found = 1;
            				break;
            			}
            			if(arrayChecked.contains(childWord.get(checker)) == false){
            				queue.add(childWord.get(checker));
            			}
            		}
            		
            	}
            	if(found == 1){
        			break;
        		}
            }
            if(found == 0){
            	System.out.println("There is no word ladder between " + startWord + " and "+ endWord +"!");
            }
            else{
            	System.out.println("For the input words "+startWord + " and "+ endWord+ " the following word ladder was found: " );
            	
            	while(currentIndex != -1){
            		System.out.println(endWord);
            		System.out.println(arrayChecked.get(currentIndex));
            		finalList.add(arrayChecked.get(currentIndex));
            		currentIndex = parentList.get(currentIndex);
            		if(currentIndex == -1)
            			break;
            	}
            	return finalList;
            	
            }
        }
        else{
        	System.out.println("At least one of the words ryan and joe are not legitimate 5-letter words from the dictionary");
        }
		return finalList;
    }
//    public void breadthFirstSearch(String lastWord, String endWord){    	
//    }

    //@Override
    public boolean validateResult(String startWord, String endWord, ArrayList<String> wordLadder) 
    {
        throw new UnsupportedOperationException("Not implemented yet!");
    }
    public static void processLinesInFile (String filename){
    	try 
        {
        	FileReader freader = new FileReader(filename);
       		BufferedReader reader = new BufferedReader(freader);
       		List<String> list = new ArrayList<String>();   		
       		for (String s = reader.readLine(); s != null; s = reader.readLine()) 
       		{
       			String newString = s.substring(0,6);
       			if(newString.charAt(0)!='*'){
       				list.add(newString);
       			}
       		}	   		
       	}
       	catch (FileNotFoundException e) 
       	{
       		System.err.println("Error: File not found. Exiting...");
       		e.printStackTrace();
       		System.exit(-1);
       	}
        	catch (IOException e) 
       	{
       		System.err.println("Error: IO exception. Exiting...");
       		e.printStackTrace();
       		System.exit(-1);
       	}
    }
    public static void main(String[] args) {
    	ArrayList<String> list = new ArrayList<String>();
    	String firstWord = "";
    	String secondWord = "";
    	try 
        {
    		FileReader freader = new FileReader(args[0]);
       		BufferedReader reader = new BufferedReader(freader); 		
       		for (String s = reader.readLine(); s != null; s = reader.readLine()) 
       		{
       			String newString = s.substring(0,5);
       			if(newString.charAt(0)!='*'){
       				list.add(newString);
       			}
       		}	   		
       	}
       	catch (FileNotFoundException e) 
       	{
       		System.err.println("Error: File not found. Exiting...");
       		e.printStackTrace();
       		System.exit(-1);
       	}
        	catch (IOException e) 
       	{
       		System.err.println("Error: IO exception. Exiting...");
       		e.printStackTrace();
       		System.exit(-1);
       	}
    	try 
        {
        	FileReader freader = new FileReader(args[1]);
       		BufferedReader reader = new BufferedReader(freader); 		
       		for (String s = reader.readLine(); s != null; s = reader.readLine()) 
       		{
       			String[] inputs = s.split("\\s+");
       			firstWord = inputs[0];
       			secondWord = inputs[1];
       		}	   	
       		
       	}
       	catch (FileNotFoundException e) 
       	{
       		System.err.println("Error: File not found. Exiting...");
       		e.printStackTrace();
       		System.exit(-1);
       	}
        	catch (IOException e) 
       	{
       		System.err.println("Error: IO exception. Exiting...");
       		e.printStackTrace();
       		System.exit(-1);
       	}
    try {
		computeLadder(firstWord, secondWord, list);
	} catch (NoSuchLadderException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }

	public List<String> computeLadder(String startWord, String endWord) throws NoSuchLadderException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean validateResult(String startWord, String endWord, List<String> wordLadder) {
		// TODO Auto-generated method stub
		return false;
	}
  }