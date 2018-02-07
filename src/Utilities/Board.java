package Utilities;

import java.util.*;

public class Board {

    //Board Pieces
    public static int Blank = 0;
    public static int White = 1;
    public static int Black = 2;

    //Board of reversi
    public int[][] Board;

    //Initializing Board(Constructor)

    public Board(){
        Board = new int[8][8];
    }

    //Copy constructor
    public void copyBoard(Board origBoard){
    	for(int i = 0; i < Board.length; i++){
    		for(int j = 0; j < Board.length; j++){
    	    	this.Board[i][j] = origBoard.Board[i][j];
    		}
    	}
    }

    //Probably all this flips could be split up in a check + flip function. Reusing the check function in the possible moves method
    private void flipRight(Coordinates coords, int color, int oppositeColor){

			//Iterate to find a piece of our color
			for(int i = coords.x + 1; (i < Board.length-1) && Board[i][coords.y] == oppositeColor; i++){
				if(Board[i+1][coords.y] == color){
					//If found, make all pieces in the middle of our color and stop looking for more pieces
					int max = i;
					for(i = coords.x + 1; i <= max; i++){
						Board[i][coords.y] = color;
					}
					break;
				}
			}
		
    }
    private void flipLeft(Coordinates coords, int color, int oppositeColor){

    	//Check to the left of the piece
			//Iterate to find a piece of our color
			for(int i = coords.x - 1; i > 0 && Board[i][coords.y] == oppositeColor; i--){
				if(Board[i-1][coords.y] == color){
					//If found, make all pieces in the middle of our color and stop looking for more pieces
					int min = i;
					for(i = coords.x - 1; i >= min; i--){
						Board[i][coords.y] = color;
					}
					break;
				}
			}
		
    }
    private void flipUp(Coordinates coords, int color, int oppositeColor){

    	//Check upper
			//Iterate to find a piece of our color
			for(int i = coords.y + 1; i < (Board.length-1) && Board[coords.x][i] == oppositeColor; i++){
				if(Board[coords.x][i+1] == color){
					//If found, make all pieces in the middle of our color and stop looking for more pieces
					int max = i;
					for(i = coords.y + 1; i <= max; i++){
						Board[coords.x][i] = color;
					}
					break;
				}
			}
		
    }
    private void flipDown(Coordinates coords, int color, int oppositeColor){

			//Iterate to find a piece of our color
			for(int i = coords.y - 1; i > 0 && Board[coords.x][i] == oppositeColor; i--){
				if(Board[coords.x][i-1] == color){
					//If found, make all pieces in the middle of our color and stop looking for more pieces
					int min = i;
					for(i = coords.y - 1; i >= min; i--){
						Board[coords.x][i] = color;
					}
					break;
				}
			}
		
    }
    private void flipUpRight(Coordinates coords, int color, int oppositeColor){
    	//Check upper right corner
			//Iterate to find a piece of our color
			for(int i = coords.x + 1,j = coords.y + 1; (i < (Board.length - 1)) && (j < (Board.length-1)) && Board[i][j] == oppositeColor; i++,j++){
				if(Board[i+1][j+1] == color){
					//If found, make all pieces in the middle of our color and stop looking for more pieces
					int max = i;
					for(i = coords.x + 1,j = coords.y + 1; i <= max; i++,j++){
						Board[i][j] = color;
					}
					break;
				}
			}
		
    }
    private void flipUpLeft(Coordinates coords, int color, int oppositeColor){

			//Iterate to find a piece of our color
			for(int i = coords.x - 1,j = coords.y + 1; (i > 0) && (j < Board.length - 1) && Board[i][j] == oppositeColor; i--,j++){
				if(Board[i-1][j+1] == color){
					//If found, make all pieces in the middle of our color and stop looking for more pieces
					int min = i;
					for(i = coords.x - 1,j = coords.y + 1; i >= min; i--,j++){
						Board[i][j] = color;
					}
					break;
				}
			}
		
    }
    private void flipDownRight(Coordinates coords, int color, int oppositeColor){

			//Iterate to find a piece of our color
			for(int i = coords.x + 1,j = coords.y - 1; (i < Board.length - 1) && (j > 0) && Board[i][j] == oppositeColor; i++,j--){
				if(Board[i+1][j-1] == color){
					//If found, make all pieces in the middle of our color and stop looking for more pieces
					int max = i;
					for(i = coords.x + 1,j = coords.y - 1; i <= max; i++,j--){
						Board[i][j] = color;
					}
					break;
				}
			}
		}
    
    private void flipDownLeft(Coordinates coords, int color, int oppositeColor){

			//Iterate to find a piece of our color
			for(int i = coords.x - 1,j = coords.y - 1; (i > 0) && (j > 0) && Board[i][j] == oppositeColor; i--,j--){
				if(Board[i-1][j-1] == color){
					//If found, make all pieces in the middle of our color and stop looking for more pieces
					int min = i;
					for(i = coords.x - 1,j = coords.y - 1; i >= min; i--,j--){
						Board[i][j] = color;
					}
					break;
				}
			}
		
    }

    public void move(Coordinates coords, int color){
 
    	Board[coords.x][coords.y] = color;

    	int oppositeColor;
    	if(color == White){
    		oppositeColor = Black;
    	}
    	else
    		oppositeColor = White;


    	if(coords.x < (Board.length-2)){
        	flipRight(coords, color, oppositeColor);
    	}
    	if(coords.x > 1){
    		flipLeft(coords, color, oppositeColor);
    	}
    	if(coords.y < (Board.length - 2)){
    		flipUp(coords, color, oppositeColor);
    	}
    	if(coords.y > 1){
    		flipDown(coords, color, oppositeColor);
    	}
    	if((coords.y > 1) && (coords.x > 1)){
    		flipDownLeft(coords, color, oppositeColor);
    	}
    	if((coords.y > 1) && (coords.x < (Board.length - 2))){
    		flipDownRight(coords, color, oppositeColor);
    	}
    	if((coords.y < (Board.length - 2)) && (coords.x > 1)){
    		flipUpLeft(coords, color, oppositeColor);
    	}
    	if((coords.y < (Board.length -2)) && (coords.x < (Board.length - 2))){
    		flipUpRight(coords, color, oppositeColor);
    	}
    }

    /*private ArrayList<Coordinates> p2Pieces(int player){

        int player2;
        if (player == Black){
            player2 = White;
        } else{
            player2 = Black;
        }

        ArrayList<Coordinates> p2pieces = new ArrayList<Coordinates>();

        for(int i=0; i< Board.length;i++){
            for(int j=0; j < Board.length;j++) {
                if(Board[i][j] == player2){
                    p2pieces.add(new Coordinates(i,j));
                }
            }

        }
        return p2pieces;

    }*/

    private ArrayList<Coordinates> pieces(int player){
        ArrayList<Coordinates> p1pieces = new ArrayList<Coordinates>();

        for(int i=0; i< Board.length;i++){
            for(int j=0; j < Board.length;j++) {
                if(Board[i][j] == player){
                    p1pieces.add(new Coordinates(i,j));
                }
            }
        }
        return p1pieces;
    }

    public ArrayList<Coordinates> possibleMoves(int player){

        int player2;
        if (player == Black){
            player2 = White;
        } else{
            player2 = Black;
        }

        ArrayList<Coordinates> p1 = new ArrayList<Coordinates>();
        p1 = pieces(player);
        Set<Coordinates> p1Available = new HashSet<Coordinates>();
        Coordinates check = new Coordinates();
        Iterator<Coordinates> it = p1.iterator();

        //It checks every one of its pieces and the blank spaces surrounding them, if it is Blank it adds it to
        //the array with all the possible moves

        while(it.hasNext()){
            check = it.next();
        //Check if there is a possible move under the piece
        //If there is a piece of the other player under yours it checks if the next space is blank
        //The first if is checking there is at least 2 spaces in under the piece cos that is the minimum requiered to make a move, the other player piece
        //and the space to put yours to eat that piece
            if(check.y >= 2){
                for(int i = check.y - 1; (Board[check.x][i] == player2) && (i > 0); i--){
                    if ((Board[check.x][i-1] == Blank)) {
                        p1Available.add(new Coordinates(check.x,i-1));
                    }
                }
            }

            if(check.x >=2){
                for(int i = check.x - 1; (Board[i][check.y] == player2) && (i > 0); i--){
                    if (Board[i-1][check.y] == Blank) {
                        p1Available.add(new Coordinates(i-1, check.y));
                    }
                }
            }

            if(check.y <= 5) {
                for(int i = check.y + 1; (Board[check.x][i] == player2) && (i < Board.length - 1); i++){
                    if ((Board[check.x][i+1] == Blank)) {
                        p1Available.add(new Coordinates(check.x,i + 1));
                    }
                }
            }
            if(check.x <= 5){
                for(int i = check.x + 1; (Board[i][check.y] == player2) && (i < Board.length - 1); i++){
                    if ((Board[i+1][check.y] == Blank)) {
                        p1Available.add(new Coordinates(i+1, check.y));
                        break;
                    }
                }
            }

            if(check.x >=2 && check.y >=2){
                for(int i = check.x-1, j = check.y-1; (Board[i][j] == player2) && (i > 0 && j > 0); i--,j--){
                    if (Board[i-1][j-1] == Blank) {
                        p1Available.add(new Coordinates(i-1,j-1));
                    }
                }
            }

            if(check.x <=5 && check.y >=2){
                for(int i = check.x+1, j = check.y-1; (Board[i][j] == player2) && (i < (Board.length - 1) && j > 0); i++,j--){
                    if (Board[i+1][j-1] == Blank) {
                        p1Available.add(new Coordinates(i+1,j-1));
                    }
                }
            }

            if(check.x >=2 && check.y<=5){
                for(int i = check.x-1, j = check.y+1; (Board[i][j] == player2) && (i > 0 && j < (Board.length - 1)); i--,j++){
                    if(Board[i-1][j+1] == Blank) {
                        p1Available.add(new Coordinates(i-1,j+1));
                    }
                }
            }

            if(check.x <=5 && check.y <=5){
                for(int i = check.x+1, j = check.y+1; (Board[i][j] == player2) && (i <(Board.length - 1) && j < (Board.length - 1)); i++,j++){
                    if(Board[i+1][j+1] == Blank) {
                        p1Available.add(new Coordinates(i+1,j+1));
                    }
                }
            }

        }
        return new ArrayList<Coordinates>(p1Available);
    }
    /*private boolean isInside(Coordinates coord) {

        if(coord.x > 7 || coord.y > 7 || coord.x < 0 || coord.y < 0) {
            return false;
        }
        return true;
    }*/


    public boolean isThereMoves(){
        for(int i = 0; i < Board.length; i++) {
            for (int j = 0; j < Board[i].length; j++) {
                if (Board[i][j] == Blank) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean isThereMoves(int color) {
    	ArrayList<Coordinates> moves = possibleMoves(color);
    	if(moves.isEmpty()) {
    		return false;
    	} else {
    		return true;
    	}
    }
    
   public void startGame() {
	   for(int i=0;i<8;i++){
           for(int j=0;j<8;j++){
              if(i == 3 && j == 3) {
                  this.Board[i][j] = Black;
              }else if(i == 4 && j == 4) {
                  this.Board[i][j] = Black;
              }else if(i == 3 && j == 4) {
                  this.Board[i][j] = White;
              }else if(i == 4 && j == 3) {
                  this.Board[i][j] = White;
              }else  {
                  this.Board[i][j] = Blank;
              }
           }
       }
   }
}