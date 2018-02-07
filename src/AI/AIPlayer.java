package AI;
import java.util.ArrayList;
import java.util.Collections;

import Utilities.*;

public class AIPlayer {

    private int color = 0;
    private int maxdepth = 4;
    private int oppositeColor = 0;
    private long startTime;
    private long maxTime;
    //Constructor
    public AIPlayer(int color, int time) {
    	this.color = color;
    	//We make sure that maxdepth is even, so it is congruent with our needs (starts in zero)
    	this.maxdepth = 2*this.maxdepth - 1;
    	this.maxTime = time*1000;
    	
    	if(color == Board.White){
    		oppositeColor = Board.Black;
    	}
    	else
    		oppositeColor = Board.White;
    }
    
    public int getColor() {
    	return this.color;
    }

    private int minMax(Board board, int depth) {
    	
    	if((System.nanoTime()/1000000 -  startTime) > maxTime){
    		System.out.println("The algorithm ran out of time");
    		return heruistic(board);
    	}
    	
    	int color_this_call;
    	if((depth % 2) == 1)
    		color_this_call = oppositeColor;
    	else
    		color_this_call = color;
    	
    	ArrayList<Integer> values = new ArrayList<Integer>();
    	ArrayList<Coordinates> moves = board.possibleMoves(color_this_call);
    	//Check if there are available moves
    	

    	//If we have reached the maximum depth, then we are in a min. Check all possible moves and return the minimum 
    	if(depth == this.maxdepth) {
    		if(moves.isEmpty()){
        		return heruistic(board);
        	}
    		
    		for(Coordinates nextMove : moves) {
    			Board localBoard = new Board();
            	localBoard.copyBoard(board);
    			localBoard.move(nextMove,color_this_call);
    			values.add(heruistic(localBoard));
    		}
    		return Collections.min(values);
    	}
    	
    	//If we are not in a maximum depth, do every move and call corresponding function. Then check all the values and decide
    	if(moves.isEmpty()){
    		return minMax(board,depth+1);
    	}
    	
    	for(Coordinates nextMove : moves){
    		Board localBoard = new Board();
        	localBoard.copyBoard(board);
    		localBoard.move(nextMove,color_this_call);
    		values.add(minMax(localBoard,depth + 1));
    	}

		//We start with depth of 1 (as a convention) , which is min
		if((depth % 2) == 1)
			return Collections.min(values);
		else
			return Collections.max(values);
    	
    	
    	
    }
    
    private int heruistic(Board board) {
    	int count = 0;
    	int mycolor = 0;
    	
    	for(int i = 0; i < board.Board.length; i++){
    		for(int j = 0; j < board.Board.length; j++){
	    		if(board.Board[i][j] == this.color){
	    			count++;
	    			mycolor++;
	    		}
	    		if(board.Board[i][j] == this.oppositeColor)
	    			count--;
    		}
    	}
    
    	if(count == mycolor)
    		return Integer.MAX_VALUE;
    	else
    		return count;
    }
    
    public void move(Board board) {
    	startTime = System.nanoTime()/1000000;
    	
    	int depth = 0;
    	ArrayList<Coordinates> moves = board.possibleMoves(this.color);
    	
    	if(moves.isEmpty()){
    		System.out.println("AI cannot move, human player turn again");
    	}
    	else{
    		ArrayList<Integer> values = new ArrayList<Integer>();
	    	
    		for(Coordinates nextMove : moves){
	    		Board localBoard = new Board();
	        	localBoard.copyBoard(board);
	    		localBoard.move(nextMove,color);
	    		values.add(minMax(localBoard,depth + 1));
	    	}
	    	
	    	Coordinates bestMove = moves.get(values.indexOf(Collections.max(values)));
	    	System.out.println();
	    	System.out.println("The AI move is: " + bestMove.getX() + bestMove.getY());
	    	board.move(bestMove, color);
    	}
    	
    }
}
