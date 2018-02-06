package Utilities;

import java.util.*;
import java.io.*;

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
		char Y;
		String aux;
		boolean check = true;
		
		System.out.println("Write where to place your piece");
		
		
		do{
			System.out.print("Your possible moves are: ");
			ArrayList<Board.Coordinates> playerMoves = board.possibleMoves(this.color);
			for(Board.Coordinates move: playerMoves) {
				System.out.printf("%c%c ",move.getX(),move.getY());
			}
			System.out.println();
			
			aux = reader.next();
			X = aux.charAt(0); 
			Y = aux.charAt(1);
			for(Board.Coordinates move: playerMoves) {
				if((move.getX() == X) && (move.getY() == Y)) {
					board.move(board.new Coordinates(X,Y), this.color);
					check = false;
				}
				
			}
		}while(check);
    }

}
