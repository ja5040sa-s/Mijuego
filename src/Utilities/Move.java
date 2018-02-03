package Utilities;

public class Move {
    public Board.Coordinates Position;
    public int value;



    public Move(Board.Coordinates position, int value) {
        //Position = position;
        this.value = value;
    }

    public Move() {
        Position = new Board.Coordinates();
        value = 0;
    }

    @Override
    public String toString() {
        return "Move{" + "move=" + Position + ", value=" + value + '}';
    }

}
