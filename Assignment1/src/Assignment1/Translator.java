/*Your Header goes here */

package Assignment1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Translator 
{
	
	public static void main (String args[]) 
	{ 
		if (args.length != 1) 
		{
			System.err.println ("Error: Incorrect number of command line arguments");
			System.exit(-1);
		}
		processLinesInFile (args[0]);
		
	}

	/******************************************************************************
	* Method Name: processLinesInFile                                             *
	* Purpose: Opens the file specified in String filename, reads each line in it *
	*          Invokes translate () on each line in the file, and prints out the  *
	*          translated piglatin string.                                        *
	* Returns: None                                                               *
	******************************************************************************/
	public static void processLinesInFile (String filename) 
	{ 

		Translator translator = new Translator(); 
		try 
		{
			FileReader freader = new FileReader(filename);
			BufferedReader reader = new BufferedReader(freader);
			
			for (String s = reader.readLine(); s != null; s = reader.readLine()) 
			{
				String pigLatin = translator.translate(s);
				System.out.println(pigLatin);
			}
		} 
		catch (FileNotFoundException e) 
		{
			System.err.println ("Error: File not found. Exiting...");
			e.printStackTrace();
			System.exit(-1);
		} catch (IOException e) 
		{
			System.err.println ("Error: IO exception. Exiting...");
			e.printStackTrace();
			System.exit(-1);
		}
	}
	
	/******************************************************************************
	* Method Name: translate                                                      *
	* Purpose: Converts String inputString into piglatin based on rules specified *
	*          in your assignment write-up.                                       *
	* Returns: String object containing the piglatin translation of               *
	*          String inputString                                                 *
	******************************************************************************/
	
	public String translate (String inputString) 
	{ 
		// modify the following code. Add/delete anything after this point.
		String tempString1;
		String tempString2;
		String tempString3;
		String restString;
		String outputString = "";
		int realIndexVowel;
		int indexVowela;
		int indexVowele;
		int indexVoweli;
		int indexVowelo;
		int indexVowelu;
		int indexVowelA;
		int indexVowelE;
		int indexVowelI;
		int indexVowelO;
		int indexVowelU;
		int indexApos;
		int indexPunc;
		int indexSpace;
		int j = 0;
		restString = new String(inputString);
		while(j == 0){
			if (restString.length() == 0){
				return outputString;
			}
			if (Character.isLetter(restString.charAt(0))){
				indexVowela = restString.indexOf("a");
				indexVowele = restString.indexOf("e");
				indexVoweli = restString.indexOf("i");
				indexVowelo = restString.indexOf("o");
				indexVowelu = restString.indexOf("u");
				indexVowelA = restString.indexOf("A");
				indexVowelE = restString.indexOf("E");
				indexVowelI = restString.indexOf("I");
				indexVowelO = restString.indexOf("O");
				indexVowelU = restString.indexOf("U");
				indexApos = restString.indexOf("\'");
				if (indexVowela == -1)
					indexVowela = 999999999;
				if (indexVowele == -1)
					indexVowele = 999999999;
				if (indexVoweli == -1)
					indexVoweli = 999999999;
				if (indexVowelo == -1)
					indexVowelo = 999999999;
				if (indexVowelu == -1)
					indexVowelu = 999999999;
				if (indexVowelA == -1)
					indexVowelA = 999999999;
				if (indexVowelE == -1)
					indexVowelE = 999999999;
				if (indexVowelI == -1)
					indexVowelI = 999999999;
				if (indexVowelO == -1)
					indexVowelO = 999999999;
				if (indexVowelU == -1)
					indexVowelU = 999999999;
				if (indexApos == -1)
					indexApos = 999999999;
				if(indexVowela<indexVowele && indexVowela<indexVoweli && indexVowela<indexVowelo && indexVowela<indexVowelu)
				    realIndexVowel = indexVowela;
				else if(indexVowele<indexVowela && indexVowele<indexVoweli && indexVowele<indexVowelo && indexVowele<indexVowelu)
					realIndexVowel = indexVowele;
				else if(indexVoweli<indexVowela && indexVoweli<indexVowele && indexVoweli<indexVowelo && indexVoweli<indexVowelu)
					realIndexVowel = indexVoweli;
				else if(indexVowelo<indexVowela && indexVowelo<indexVowele && indexVowelo<indexVoweli && indexVowelo<indexVowelu)
					realIndexVowel = indexVowelo;
				else
					realIndexVowel = indexVowelu;
				if(realIndexVowel > indexVowelA)
					realIndexVowel = indexVowelA;
				if(realIndexVowel > indexVowelE)
					realIndexVowel = indexVowelE;
				if(realIndexVowel > indexVowelI)
					realIndexVowel = indexVowelI;
				if(realIndexVowel > indexVowelO)
					realIndexVowel = indexVowelO;
				if(realIndexVowel > indexVowelU)
					realIndexVowel = indexVowelU;
				if(realIndexVowel > indexApos)
					realIndexVowel = indexApos;
				int a = 0;
				while(Character.isLetter(restString.charAt(a)) == true || restString.charAt(a) == '\''){
					a++;
					if (restString.length() == a)
						break;
				}
				indexPunc = a;
				tempString1 = restString.substring(0,indexPunc);
				restString = restString.substring(indexPunc);
				if(realIndexVowel == 0)
					tempString1 = tempString1 + "yay";
				else if (realIndexVowel < indexPunc){
					tempString2 = tempString1.substring(realIndexVowel);
					tempString3 = tempString1.substring(0, realIndexVowel);
					tempString1 = tempString2 + tempString3 + "ay";
				}
				else{
					tempString1 = tempString1 + "yay";
				}
				outputString = outputString + tempString1;
				}
			else{
				if(restString.charAt(0) == '1' || restString.charAt(0) == '2' || restString.charAt(0) == '3' || restString.charAt(0) == '4' || restString.charAt(0) == '5' || restString.charAt(0) == '6' || restString.charAt(0) == '7' || restString.charAt(0) == '8' || restString.charAt(0) == '9' || restString.charAt(0) == '0'){
					indexSpace = restString.indexOf(' ');
					if(indexSpace == -1){
						tempString1 = restString.substring(0,1);
						restString = restString.substring(1);
						outputString = outputString + tempString1;
					}
					else{
						tempString1 = restString.substring(0,indexSpace);
						restString = restString.substring(indexSpace);
						outputString = outputString + tempString1;
					}
				}
				else {
					tempString1 = restString.substring(0,1);
					restString = restString.substring(1);
					outputString = outputString + tempString1;
				}
			}
		}
		
		//String outputString = new String(inputString); // Copies input to output and prints it. 
		return outputString;
	}

	private String substring(int i) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
