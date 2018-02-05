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

    public Board.Coordinates move(Board board) {
		Scanner reader = new Scanner(System.in);
		
		System.out.println("Write where to place your piece");
		System.out.print("Your possible moves are: ");
		ArrayList<Board.Coordinates> playerMoves = board.possibleMoves(this.color);
		for(Board.Coordinates move: playerMoves) {
			System.out.print(move.getX() + move.getY() + " ");
		}
		System.out.println();
		
		reader.next()
    }

}
