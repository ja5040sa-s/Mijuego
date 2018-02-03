package Utilities;

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


    public class Coordinates{

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

    private ArrayList<Coordinates> p2Pieces(int player){

        int player2;
        if (player == Black){
            player2 == White;
        } else{
            player2 == Black;
        }

        ArrayList<Coordinates> p2pieces = new ArrayList<Coordinates>;

        for(i=0; i< Board.lenght;i++){
            for(j=0; Board.lenght;i++) {
                if(Board[i][j] == p2pieces){
                    p2pieces.add(new Coordinates(i,j));
            }

        }

    }


    public ArrayList<Coordinates> possibleMoves(int player){

        int player2;
        if (player == Black){
            player2 == White;
        } else{
            player2 == Black;
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
