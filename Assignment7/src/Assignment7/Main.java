//Atreya Misra am73676
//Connor White
package Assignment7;

import java.util.Scanner;

public class Main {
	public static void main (String[] args){
		boolean debug = false;
		if(args.length > 0 && args[0].equals("debug"))
			debug = true;

		Scanner in = new Scanner(System.in);

		boolean repeat = true;
		while(repeat){
			Game game = new Game();
			System.out.print(game.getOpeningMessage());
			if(in.nextLine().toUpperCase().equals("Y"))
				repeat = true;
			else
				repeat = false;
			while(game.getMoves() != 0){
				if(debug)
					System.out.println(game.getCode());
				System.out.print("GUESS (" + game.getColors() + "): ");
				System.out.println(game.guess(in.nextLine()));
			}
			System.out.println("Are you ready for another game (Y/N): ");
			if(in.nextLine().toUpperCase().equals("Y"))
				repeat = true;
			else
				repeat = false;
		}
	}
}