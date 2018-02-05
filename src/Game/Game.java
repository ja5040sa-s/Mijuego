package Game;
import java.util.Scanner;
import Utilities.*;
import AI.*;

public class Game {
	public static int player1;
	public static int player2;
	
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		String color;
		AIPlayer machine;
		Player human;
		
		System.out.println("Welcome to Reversi game!");
		do{
			System.out.println("Choose your color[White]/[Black]");
			color = reader.next();
		} while(!(color.equals("White") || color.equals("Black")));
		
		if(color.equals("White")) {
			human = new Player(Board.White);
			machine =  new AIPlayer(Board.Black);
		} else {
			human = new Player(Board.Black);
			machine = new AIPlayer(Board.White);
		}
		
		Board reversi = new Board();
			 
		while(reversi.isThereMoves()) {//This needs to be fixed
			for (int i = 0; i < reversi.Board.length; i++) {
			    for (int j = 0; j < reversi.Board.length; j++) {
			        System.out.print(reversi.Board[i][j] + " ");
			    }
			    System.out.println();
			}
			
			if(player1 == Board.Black) {
				
			}
			
			
		}
	}





}
