public class Tictactoe {

    private static char[][] gameState;

    public Tictactoe(Player X, Player O) {
        gameState = new char[3][3];
        for (char col='a'; col <='c'; col++) {
            for (char row = '1'; row <= '3'; row++) {
                this.set(col, row, ' ');
            }
        }
        Player[] player = new Player[2];
        player[1] = X;
        player[0] = O;
    }

    public void set(char col, char row, char move){
        gameState[Character.getNumericValue(col)-10][Character.getNumericValue(row)-1] = move;
    }
    public static char get(char col, char row){
        return gameState[Character.getNumericValue(col)-10][Character.getNumericValue(row)-1];
    }


    @Override
    public String toString() {

        StringBuilder rep = new StringBuilder();
        for(char row ='1'; row<='3'; row++){
            if (row>'1') rep.append(" -+-+-\n");
            rep.append(row);
            for (char col='a'; col <='c'; col++) {
                rep.append(Tictactoe.get(col, row));
                if (col<'c') rep.append("|");
            }
            rep.append('\n');

        }
        rep.append(" a b c\n");
        return(rep.toString());
    }


    public boolean notOver(){
        return false;
    }


    public boolean inRange(char col, char row) {
        return ('a' <= col) && (col <= 'c') && ('1' <= row) && (row <= '3');
    }
}
