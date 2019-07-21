import java.util.ArrayList;

public class Board {
    private char[][] board;


    public Board() {
        board = new char[3][3];
        init(board);
    }

    public Board(char[][] arr){
        board = new char[3][3];
        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                board[i][j] = arr[i][j];
            }
        }
    }

    private void init(char[][] arr){
        for (int i=0;i<arr.length;i++){
            for (int j=0;j<arr[i].length; j++){
                arr[i][j] = '-';
            }
        }
    }

    public void showBoard(){
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[i].length; j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }


    public char[][] getState(){
        char[][] arr =new char[3][3];
        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                arr[i][j] = board[i][j];
            }
        }
        return arr;
    }

    public void makeMove(boolean turn, int x, int y){
        if(turn){
            if(isMoveValid(x,y)){
                board[x][y] = 'x';
            }
        }
        else {
            if(isMoveValid(x,y)){
                board[x][y] = 'o';
            }
        }
    }

    private boolean isMoveValid(int x, int y){
        if (x>=3 || y>=3 ) return false;
        if (board[x][y] == '-') {
            return true;
        }
        else{
            return false;
        }
    }

    public ArrayList<Coordinates> getPossibleTurns(){
        ArrayList<Coordinates> coordinates = new ArrayList<>();
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[i].length; j++){
                if (board[i][j] == '-') {
                    coordinates.add(new Coordinates(i,j));
                }
            }
        }
        return coordinates;
    }

    public boolean isWon(){
        boolean win = false;
        for (int i=0; i<3; i++){
            if ((board[i][0] == board[i][1] && board[i][0] == board[i][2]) && board[i][0]!='-'){
                win = true;
                return win;
            }
        }

        for (int i=0; i<3; i++){
            if ((board[0][i] == board[1][i] && board[0][i] == board[2][i]) && board[0][i]!='-'){
                win = true;
                return win;
            }
        }


        if ((board[0][0] == board[1][1] && board[1][1] == board[2][2]) && board[1][1]!='-'){
            win = true;
            return win;
        }

        if ((board[0][2] == board[1][1] && board[1][1] == board[2][0]) && board[1][1]!='-'){
            win = true;
            return win;
        }

        return win;
    }

    public boolean isDraw(){
        ArrayList<Coordinates> list = getPossibleTurns();
        if (list.isEmpty()){
            if (!this.isWon()){
                return true;
            }
        }
        return false;
    }



}
