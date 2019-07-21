import java.util.ArrayList;

public class Tree {
    public void recure(Board board, boolean turn, int deepness){
        char[][] initialState = board.getState();
        ArrayList<Coordinates> possibleTurns = board.getPossibleTurns();
        for (Coordinates possibleTurn : possibleTurns) {
            Board transientBoard = new Board(initialState);
            transientBoard.makeMove(turn, possibleTurn.getX(), possibleTurn.getO());
            if (transientBoard.isWon()){
                if(turn){
                    Counter.wonX++;
                }
                else{
                    Counter.wonO++;
                }
            }
            if(transientBoard.isDraw()){
                Counter.draws++;
            }
            if (!transientBoard.isDraw() && !transientBoard.isWon()){
                int newDeepness =deepness+1;
                recure(transientBoard, !turn, newDeepness);
            }
        }

    }
}
