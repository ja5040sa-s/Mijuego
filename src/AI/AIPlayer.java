package AI;
import java.util.ArrayList;
import java.util.Collections;

import Utilities.*;

public class AIPlayer {

    private int color = 0;
    private int maxdepth = 8;

    //Constructor
    public AIPlayer(int color) {
    	this.color = color;
    }
    
    public int getColor() {
    	return this.color;
    }
    /*private int moveMax(){

    }

    private int moveMin(){

    }*/
    private int minMax(Board board, int depth) {
    	ArrayList<Integer> values = new ArrayList<Integer>();
    	//Check possible moves
    	ArrayList<Board.Coordinates> moves = board.possibleMoves(this.color);

    	//If we have reached the maximum depth, then we are in a min. Check all possible moves and return the minimum 
    	if(depth == this.maxdepth) {
    		for(Board.Coordinates nextMove : moves) {
        		Board localBoard = new Board(board);
    			localBoard.move(nextMove,color);
    			values.add(euristic(localBoard));
    		}
    		return Collections.min(values);
    	}
    	
    	//If we are not in a maximum depth, do every move and call corresponding function. Then check all the values and decide
    	for(Board.Coordinates nextMove : moves){
    		Board localBoard = new Board(board);
    		localBoard.move(nextMove,color);
    		values.add(minMax(localBoard,depth + 1));
    	}

		//We start with depth of 1 (as a convention) , which is min
		if((depth % 2) == 1)
			return Collections.min(values);
		else
			return Collections.max(values);
    	
    	
    	
    }
    
    private int euristic(Board board) {
    	int whites = 0;
    	int blacks = 0;
    	
    	for(int i = 0; i < board.Board.length; i++){
    		for(int j = 0; j < board.Board.length; j++){
	    		if(board.Board[i][j] == Board.White)
	    			whites = whites + 1;
	    		if(board.Board[i][j] == Board.Black)
	    			blacks = blacks + 1;
    		}
    	}
    
    	if(this.color == Board.White)
    		return whites - blacks;
    	else
    		return blacks - whites;
    }
    
    public Board.Coordinates chosenMove(Board board) {
    	int depth = 0;
    	ArrayList<Board.Coordinates> moves = board.possibleMoves(this.color);
    	ArrayList<Integer> values = new ArrayList<Integer>();

    	for(Board.Coordinates nextMove : moves){
    		Board localBoard = new Board(board);
    		localBoard.move(nextMove,color);
    		values.add(minMax(localBoard,depth + 1));
    	}
    	
    	Board.Coordinates bestMove = moves.get(values.indexOf(Collections.max(values)));
    	
    	return bestMove;
    	
    	//Still have to decide what this returns, if the move or the board with the move done.
    	
    	//return bestMove;
    	//return board.Move(bestMove)
    	
    	//Here I need to initialize the algorithm. This means that I need to get all the values from the 
    	//just previous levels and return either the board or the chosen move. As values are organized in 
    	//relationship with the moves, it should not be hard
    }
}
