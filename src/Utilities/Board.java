package Utilities;

import java.util.ArrayList;

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
    public Board(Board copyBoard){
    	for(int i = 0; i < Board.length; i++){
    		for(int j = 0; j < Board.length; i++){
    	    	this.Board[i][j] = copyBoard.Board[i][j];
    		}
    	}
    }

    public class Coordinates {

        //Coordinates
        char x = 'a';
        int y = 0;

        //Constructor
        public Coordinates(char x, int y) {
            this.x = x;
            this.y = y;
        }

        public Coordinates() {
            x = 'a';
            y = 0;
        }

    }
    
    private void checkRight(Coordinates coords, int color, int oppositeColor){
    	int x_integer = ((int) 'a') - ((int) coords.x);

		if(Board[x_integer+1][coords.y] == oppositeColor){
			//Iterate to find a piece of our color
			for(int i = x_integer + 2; i < Board.length; i++){
				if(Board[i][coords.y] == color){
					//If found, make all pieces in the middle of our color and stop looking for more pieces
					int max = i;
					for(i = x_integer + 1; i < max; i++){
						Board[i][coords.y] = color;
					}
					break;
				}
			}
		}
    }
    
    private void checkLeft(Coordinates coords, int color, int oppositeColor){
    	int x_integer = ((int) 'a') - ((int) coords.x);

    	//Check to the lefr of the piece
		if(Board[x_integer-1][coords.y] == oppositeColor){
			//Iterate to find a piece of our color
			for(int i = x_integer - 2; i >= 0; i--){
				if(Board[i][coords.y] == color){
					//If found, make all pieces in the middle of our color and stop looking for more pieces
					int min = i;
					for(i = x_integer - 1; i > min; i--){
						Board[i][coords.y] = color;
					}
					break;
				}
			}
		}
    }
    private void checkUp(Coordinates coords, int color, int oppositeColor){
    	int x_integer = ((int) 'a') - ((int) coords.x);

    	//Check upper
		if(Board[x_integer][coords.y+1] == oppositeColor){
			//Iterate to find a piece of our color
			for(int i = coords.y + 2; i < Board.length; i++){
				if(Board[x_integer][i] == color){
					//If found, make all pieces in the middle of our color and stop looking for more pieces
					int max = i;
					for(i = coords.y + 1; i < max; i++){
						Board[i][coords.y] = color;
					}
					break;
				}
			}
		}
    }
    private void checkDown(Coordinates coords, int color, int oppositeColor){
    	int x_integer = ((int) 'a') - ((int) coords.x);
    	
		if(Board[x_integer][coords.y-1] == oppositeColor){
			//Iterate to find a piece of our color
			for(int i = coords.y - 2; i >= 0; i--){
				if(Board[x_integer][i] == color){
					//If found, make all pieces in the middle of our color and stop looking for more pieces
					int min = i;
					for(i = coords.y - 1; i > min; i--){
						Board[i][coords.y] = color;
					}
					break;
				}
			}
		}
    }
    private void checkUpRight(Coordinates coords, int color, int oppositeColor){
    	int x_integer = ((int) 'a') - ((int) coords.x);
    	//Check upper right corner
		if(Board[x_integer+1][coords.y+1] == oppositeColor){
			//Iterate to find a piece of our color
			for(int i = x_integer + 2,j = coords.y + 2; (i < Board.length) && (j < Board.length) ; i++,j++){
				if(Board[i][j] == color){
					//If found, make all pieces in the middle of our color and stop looking for more pieces
					int max = i;
					for(i = x_integer + 1,j = coords.y + 1; i < max; i++,j++){
						Board[i][j] = color;
					}
					break;
				}
			}
		}
    }
    private void checkUpLeft(Coordinates coords, int color, int oppositeColor){
    	int x_integer = ((int) 'a') - ((int) coords.x);

    	if(Board[x_integer-1][coords.y+1] == oppositeColor){
			//Iterate to find a piece of our color
			for(int i = x_integer - 2,j = coords.y + 2; (i >= 0) && (j < Board.length) ; i--,j++){
				if(Board[i][j] == color){
					//If found, make all pieces in the middle of our color and stop looking for more pieces
					int min = i;
					for(i = x_integer - 1,j = coords.y + 1; i > min; i--,j++){
						Board[i][j] = color;
					}
					break;
				}
			}
		}
    }
    private void checkDownRight(Coordinates coords, int color, int oppositeColor){
    	int x_integer = ((int) 'a') - ((int) coords.x);
    	
    	if(Board[x_integer+1][coords.y-1] == oppositeColor){
			//Iterate to find a piece of our color
			for(int i = x_integer + 2,j = coords.y - 2; (i < Board.length) && (j >= 0) ; i++,j--){
				if(Board[i][j] == color){
					//If found, make all pieces in the middle of our color and stop looking for more pieces
					int max = i;
					for(i = x_integer + 1,j = coords.y - 1; i < max; i++,j--){
						Board[i][j] = color;
					}
					break;
				}
			}
		}
    }    
    private void checkDownLeft(Coordinates coords, int color, int oppositeColor){
    	int x_integer = ((int) 'a') - ((int) coords.x);

    	if(Board[x_integer-1][coords.y-1] == oppositeColor){
			//Iterate to find a piece of our color
			for(int i = x_integer - 2,j = coords.y - 2; (i >= 0) && (j >= 0) ; i--,j--){
				if(Board[i][j] == color){
					//If found, make all pieces in the middle of our color and stop looking for more pieces
					int min = i;
					for(i = x_integer - 1,j = coords.y - 1; i > min; i--,j--){
						Board[i][j] = color;
					}
					break;
				}
			}
		}
    }
    
    public void move(Coordinates coords, int color){
    	//I won't check if the move is valid, I assume it is. For the algorithm it is right. We have to make sure that we also do this for the other player
    	//Also assumed the coordenates are within a proper range. 
    	//We consider both coordinates to be in 0-7 range although y will be given in 1-8 range. Be careful!! Maybe modify constructor?
    	int x_integer = ((int) 'a') - ((int) coords.x);
    	Board[x_integer][coords.y] = color;
    	
    	//I will try to do here the flipping algorithm. Maybe it has to be placed inside some other method/class? Coudl this also be simplified nesting functions?
    	int oppositeColor;
    	if(color == White){
    		oppositeColor = Black;
    	}
    	else 
    		oppositeColor = White;
    	
    	
    	if(x_integer < (Board.length-2)){
        	checkRight(coords, color, oppositeColor);
    	}
    	if(x_integer > 1){
    		checkLeft(coords, color, oppositeColor);
    	}
    	if(coords.y < (Board.length - 2)){
    		checkUp(coords, color, oppositeColor);
    	}
    	if(coords.y > 1){
    		checkDown(coords, color, oppositeColor);
    	}
    	if((coords.y > 1) && (x_integer > 1)){
    		checkDownLeft(coords, color, oppositeColor);
    	}
    	if((coords.y > 1) && (x_integer < (Board.length - 2))){
    		checkDownRight(coords, color, oppositeColor);
    	}
    	if((coords.y < (Board.length - 2)) && (x_integer > 1)){
    		checkUpLeft(coords, color, oppositeColor);
    	}
    	if((coords.y < (Board.length -2)) && (x_integer < (Board.length - 2))){
    		checkUpRight(coords, color, oppositeColor);
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
            for(int j=0; j < Board.length;i++) {
                if(Board[i][j] == p2pieces){
                    p2pieces.add(new Coordinates(i,j));
                }
            }

        }

    }


    public ArrayList<Coordinates> possibleMoves(int player){

        int player2;
        if (player == Black){
            player2 = White;
        } else{
            player2 = Black;
        }





    }



    public void initBoard() {

        int i = 0;
        int j = 0;
        while(i<8){
            while(j<8){
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

}