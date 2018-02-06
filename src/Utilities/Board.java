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
        int i = 0;
        int j = 0;

        for(i=0;i<8;i++){
            for(j=0;j<8;j++){
               if(i == 3 && j == 3) {
                   Board[i][j] = White;
               }else if(i == 4 && j == 4) {
                   Board[i][j] = White;
               }else if(i == 3 && j == 4) {
                   Board[i][j] = Black;
               }else if(i == 4 && j == 3) {
                   Board[i][j] = Black;
               }else  {
                   Board[i][j] = Blank;
               }
            }
        }
    }

    //Copy constructor
    public void copyBoard(Board origBoard){
    	for(int i = 0; i < Board.length; i++){
    		for(int j = 0; j < Board.length; j++){
    	    	this.Board[i][j] = origBoard.Board[i][j];
    		}
    	}
    }

    public class Coordinates {

        //Coordinates
        int x = 0;
        int y = 0;

        //Constructor
        public Coordinates(char x, char y) {
            this.x = ((int) x) - ((int) 'a');
            this.y = ((int) y) - ((int) '1');
        }

        public Coordinates(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Coordinates() {
            x = 0;
            y = 0;
        }
        
        public char getX() {
        	return ((char) (((int) 'a') + x));
        }
        
        public char getY() {
        	return ((char) (((int) '1') + y));
        }
    }

    //Probably all this flips could be split up in a check + flip function. Reusing the check function in the possible moves method
    private void flipRight(Coordinates coords, int color, int oppositeColor){

		if(Board[coords.x+1][coords.y] == oppositeColor){
			//Iterate to find a piece of our color
			for(int i = coords.x + 2; i < Board.length; i++){
				if(Board[i][coords.y] == color){
					//If found, make all pieces in the middle of our color and stop looking for more pieces
					int max = i;
					for(i = coords.x + 1; i < max; i++){
						Board[i][coords.y] = color;
					}
					break;
				}
			}
		}
    }
    private void flipLeft(Coordinates coords, int color, int oppositeColor){

    	//Check to the left of the piece
		if(Board[coords.x-1][coords.y] == oppositeColor){
			//Iterate to find a piece of our color
			for(int i = coords.x - 2; i >= 0; i--){
				if(Board[i][coords.y] == color){
					//If found, make all pieces in the middle of our color and stop looking for more pieces
					int min = i;
					for(i = coords.x - 1; i > min; i--){
						Board[i][coords.y] = color;
					}
					break;
				}
			}
		}
    }
    private void flipUp(Coordinates coords, int color, int oppositeColor){

    	//Check upper
		if(Board[coords.x][coords.y+1] == oppositeColor){
			//Iterate to find a piece of our color
			for(int i = coords.y + 2; i < Board.length; i++){
				if(Board[coords.x][i] == color){
					//If found, make all pieces in the middle of our color and stop looking for more pieces
					int max = i;
					for(i = coords.y + 1; i < max; i++){
						Board[coords.x][i] = color;
					}
					break;
				}
			}
		}
    }
    private void flipDown(Coordinates coords, int color, int oppositeColor){

		if(Board[coords.x][coords.y-1] == oppositeColor){
			//Iterate to find a piece of our color
			for(int i = coords.y - 2; i >= 0; i--){
				if(Board[coords.x][i] == color){
					//If found, make all pieces in the middle of our color and stop looking for more pieces
					int min = i;
					for(i = coords.y - 1; i > min; i--){
						Board[coords.x][i] = color;
					}
					break;
				}
			}
		}
    }
    private void flipUpRight(Coordinates coords, int color, int oppositeColor){
    	//Check upper right corner
		if(Board[coords.x+1][coords.y+1] == oppositeColor){
			//Iterate to find a piece of our color
			for(int i = coords.x + 2,j = coords.y + 2; (i < Board.length) && (j < Board.length) ; i++,j++){
				if(Board[i][j] == color){
					//If found, make all pieces in the middle of our color and stop looking for more pieces
					int max = i;
					for(i = coords.x + 1,j = coords.y + 1; i < max; i++,j++){
						Board[i][j] = color;
					}
					break;
				}
			}
		}
    }
    private void flipUpLeft(Coordinates coords, int color, int oppositeColor){

    	if(Board[coords.x-1][coords.y+1] == oppositeColor){
			//Iterate to find a piece of our color
			for(int i = coords.x - 2,j = coords.y + 2; (i >= 0) && (j < Board.length) ; i--,j++){
				if(Board[i][j] == color){
					//If found, make all pieces in the middle of our color and stop looking for more pieces
					int min = i;
					for(i = coords.x - 1,j = coords.y + 1; i > min; i--,j++){
						Board[i][j] = color;
					}
					break;
				}
			}
		}
    }
    private void flipDownRight(Coordinates coords, int color, int oppositeColor){

    	if(Board[coords.x+1][coords.y-1] == oppositeColor){
			//Iterate to find a piece of our color
			for(int i = coords.x + 2,j = coords.y - 2; (i < Board.length) && (j >= 0) ; i++,j--){
				if(Board[i][j] == color){
					//If found, make all pieces in the middle of our color and stop looking for more pieces
					int max = i;
					for(i = coords.x + 1,j = coords.y - 1; i < max; i++,j--){
						Board[i][j] = color;
					}
					break;
				}
			}
		}
    }
    private void flipDownLeft(Coordinates coords, int color, int oppositeColor){

    	if(Board[coords.x-1][coords.y-1] == oppositeColor){
			//Iterate to find a piece of our color
			for(int i = coords.x - 2,j = coords.y - 2; (i >= 0) && (j >= 0) ; i--,j--){
				if(Board[i][j] == color){
					//If found, make all pieces in the middle of our color and stop looking for more pieces
					int min = i;
					for(i = coords.x - 1,j = coords.y - 1; i > min; i--,j--){
						Board[i][j] = color;
					}
					break;
				}
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

    private ArrayList<Coordinates> p2Pieces(int player){

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

    }

    private ArrayList<Coordinates> p1Pieces(int player){
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
        p1 = p1Pieces(player);
        ArrayList<Coordinates> p1Available = new ArrayList<Coordinates>();
        Coordinates check = new Coordinates();
        Iterator<Coordinates> it = p1.iterator();

        //It checks every one of its pieces and the blank spaces surrounding them, if it is Blank it adds it to
        //the array with all the possible moves

        while(it.hasNext()){
            check = it.next();
            if(isInside(Board[check.x][check.y-1]) && (Board[check.x][check.y-1] == player2)) {
                if(isInside(Board[check.x][check.y - 2]) && (Board[check.x][check.y - 2]== Blank))   {
                    p1Available.add(new Coordinates(check.x, check.y - 2));
                }
            }
            if(isInside(Board[check.x-1][check.y]) &&(Board[check.x-1][check.y] == player2)) {
                if(isInside(Board[check.x-2][check.y]) && (Board[check.x-2][check.y] == Blank)) {
                    p1Available.add(new Coordinates(check.x-2, check.y));
                }
            }
            if(isInside(Board[check.x][check.y+1]) &&(Board[check.x][check.y+1] == player2)) {
                if(isInside(Board[check.x][check.y + 2]) && (Board[check.x][check.y + 2] == Blank)) {
                    p1Available.add(new Coordinates(check.x, check.y + 2));
                }
            }
            if(isInside(Board[check.x+1][check.y]) &&(Board[check.x+1][check.y] == player2)) {
                if(isInside(Board[check.x+2][check.y] ) && (Board[check.x+2][check.y]== Blank)) {
                    p1Available.add(new Coordinates(check.x+2, check.y));
                }
            }
            if(isInside(Board[check.x-1][check.y-1]) &&(Board[check.x-1][check.y-1] == player2)) {
                if(isInside(Board[check.x-2][check.y - 2]) && (Board[check.x-2][check.y - 2] == Blank)) {
                    p1Available.add(new Coordinates(check.x, check.y - 2));
                }
            }
            if(isInside(Board[check.x+1][check.y-1]) &&(Board[check.x+1][check.y-1] == player2)) {
                if(isInside(Board[check.x+2][check.y - 2]) && (Board[check.x+2][check.y - 2] == Blank)) {
                    p1Available.add(new Coordinates(check.x+2, check.y - 2));
                }
            }
            if(isInside(Board[check.x-1][check.y+1]) &&(Board[check.x-1][check.y+1] == player2)) {
                if(isInside(Board[check.x-2][check.y + 2]) && (Board[check.x-2][check.y + 2] == Blank)) {
                    p1Available.add(new Coordinates(check.x-2, check.y + 2));
                }
            }
            if(isInside(Board[check.x+1][check.y+1]) &&(Board[check.x+1][check.y+1] == player2)) {
                if(isInside(Board[check.x+2][check.y + 2] == Blank) && (Board[check.x+2][check.y + 2] == Blank)) {
                    p1Available.add(new Coordinates(check.x+2, check.y + 2));
                }
            }

        }
        return p1Available;
    }
    private boolean isInside(Coordinates coord) {

        if(coord.X > 7 | coord.Y > 7 | coord.X < 0 | coord.y < 0) {
            return false;
        }
        return true;
    }


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
}