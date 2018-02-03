package AI;
import.Utilities

public class AIPlayer {

    private int color = 0;
    private int maxdepth = 8;

    //Contructor
    public AIPlayer(int color) {
    	this.color = color;
    }
    /*private int moveMax(){

    }

    private int moveMin(){

    }*/
    private int minMax(Board board, int depth) {
    	Array<int> values;
    	//Check possible moves
    	Board localBoard = board;
    	ArrayList<Board.Coordinates> moves = possibleMoves(this.color);

    	//If we have reached the maximum depth, then we are in a min. Check all possible moves and return the minimum 
    	if(depth == this.maxdepth) {
    		for(Board.Coordinates nextMove : moves) {
    			localBoard = board;
    			localBoard.Move(nextMove);
    			values.add(euristic(localBoard));
    		}
    		return values.min();
    	}
    	
    	//If we are not in a maximum depth, do every move and call corresponding function. Then check all the values and decide
    	for(Board.Coordinates nextMove : moves){
    		localBoard = board;
    		localBoard.Move(nextMove);
    		values.add(minMax(localBoard));
    	}

		//We start with depth of 0 (as a convention) , which is max
		depth % 2? return values.min() : return values.max();
    	
    	
    	
    }
    
    private int euristic(Board board) {
    	int whites;
    	int blacks;
    	for(int iterator : board) {
    		if(iterator == board.White)
    			whites++;
    		if(iterator == board.Black)
    			blacks++;
    	}
    
    	if(this.color = board.White)
    		return whites - blacks;
    	else
    		return blacks - whites;
    }
    
    public Board chosenMove(Board board) {
    	//Here I need to initialize the algorithm. This means that I need to get all the values from the 
    	//just previous levels and return either the board or the chosen move. As values are organized in 
    	//relationship with the moves, it should not be hard.
    }
}
