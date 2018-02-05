package Utilities;

import java.util.*;

public class Player {
    private int color = 0;

    public Player(int color){
    	this.color = color;
    }
    
    public int getColor() {
    	return this.color;
    }

    public void move(Board board) {
		Scanner reader = new Scanner(System.in);
		char X;
		int Y;
		boolean check = true;
		
		System.out.println("Write where to place your piece");
		
		
		do{
			System.out.print("Your possible moves are: ");
			ArrayList<Board.Coordinates> playerMoves = board.possibleMoves(this.color);
			for(Board.Coordinates move: playerMoves) {
				System.out.print(move.getX() + move.getY() + " ");
			}
			System.out.println();
			
			X = (char) reader.nextInt();
			Y = reader.nextInt();
			for(Board.Coordinates move: playerMoves) {
				if((move.getX() == X) && (move.getY() == Y)) {
					board.move(board.new Coordinates(X,Y), this.color);
					check = false;
				}
				
			}
		}while(check);
    }

}
