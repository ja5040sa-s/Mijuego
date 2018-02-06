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
		
		System.out.println("Colors have been chosen");
		if(color.equals("White")) {
			human = new Player(Board.White);
			machine =  new AIPlayer(Board.Black);
		} else {
			human = new Player(Board.Black);
			machine = new AIPlayer(Board.White);
		}
		
		Board reversi = new Board();

		while(reversi.isThereMoves()) {//This needs to be fixed

			for (int j = (reversi.Board.length - 1); j >= 0; j--) {
				for (int i = 0; i < reversi.Board.length ; i++) {

			        System.out.print(reversi.Board[i][j] + " ");
			    }
			    System.out.println();
			}
			
			if(human.getColor() == Board.Black) {
				human.move(reversi);
			} else {
				machine.move(reversi);
			}
			
			for (int j = 0; j < reversi.Board.length; j++) {
				for (int i = (reversi.Board.length - 1); i >= 0; i--) {
			        System.out.print(reversi.Board[i][j] + " ");
			    }
			    System.out.println();
			}
			
			if(human.getColor() == Board.Black) {
				machine.move(reversi);
			} else {
				human.move(reversi);
			}
			
		}
	}





}
