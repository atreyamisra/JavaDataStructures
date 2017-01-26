//Atreya Misra am73676
//Connor White
package Assignment7;

import java.util.Random;

public class Game {
	private int moves;
	private String colors, code;

	public Game(){
		//Set defaults
		colors = "BGOPRY";
		moves = 12;
		//Create a new code
		code = "";
		newCode(4, colors);
	}
	public Game(int l, String c, int m){
		//Init
		colors = c;
		moves = m;
		//Create a new Code
		code = "";
		newCode(l, colors);
	}
	private void newCode(int l, String c){//Creates a new code
		Random rand = new Random();
		for(int i=0; i<l; i++){
			code = code + colors.charAt(rand.nextInt(c.length()));
		}
	}
	public String getOpeningMessage(){
		return "Welcome to Mastermind.\nHere are the rules:\nThis is a text version of the classic board game Mastermind.\nThe computer will think of a secret code.\nThe code consists of 4 colored pegs.\nThe pegs may be one of six colors: blue, green, orange, purple, red, or yellow.\nA color may appear more than once in the code.\nYou try to guess what colored pegs are in the code and what order they are in.\nAfter you make a valid guess the result (feedback) will be displayed.\nThe result consists of a black peg for each peg you have guessed exactly correct (color and position) in your guess.\nFor each peg in the guess that is the correct color, but is out of position, you get a white peg.\nFor each peg, which is fully incorrect, you get no feedback.\nOnly the first letter of the color is displayed.\nB for Blue, R for Red, and so forth.\nWhen entering guesses you only need to enter the first character of each color as a capital letter.\nYou have 12 guesses to figure out the secret code or you lose the game.\nAre you ready to play? (Y/N): ";
}
	public String getCode(){
		return code;
	}
	public int getMoves(){
		return moves;
	}
	public String getColors(){
		return colors;
	}
	public String guess(String g){
		if(isValid(g)){
			moves--;
			int black = 0;
			int white = 0;
			String tempCode = code;
			for(int i=0; i<g.length(); i++){
				if(g.charAt(i) == tempCode.charAt(i)){
					black++;
					tempCode = tempCode.substring(0, i) + "-" + tempCode.substring(i+1, tempCode.length());
				}
				else if(tempCode.contains(g.substring(i,i+1))){
					white++;
					tempCode = tempCode.substring(0, tempCode.indexOf(g.charAt(i))) + "-" + tempCode.substring(tempCode.indexOf(g.charAt(i))+1, tempCode.length());
				}
			}
			if(black != 4)
				return "BLACK: " + black + " WHITE: " + white + "\nYou have " + moves + " guesses left. What is your next guess? Type in the characters for your guess and press enter.";
			else {
				moves = 0;
				return "BLACK: 4 - You win!";
			}
		}
		else
			return "INVALID GUESS";
	}
	public boolean isValid(String g){
		if(g.length() != code.length())
			return false;
		for(int i=0; i<code.length(); i++)
			if(!colors.contains(g.substring(i,i+1).toUpperCase()))
				return false;
		return true;
	}
}