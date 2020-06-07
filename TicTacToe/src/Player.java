import java.util.Objects;

public class Player {

    public char team;
    public String moves;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return team == player.team &&
                Objects.equals(moves, player.moves);
    }


    public Player(char team, String moves) {
        this.team=team;
        this.moves=moves;
    }


    public void Plays(String move) {
        char col = move.charAt(0);
        char row = move.charAt(1);
        //add move to moves





    }
}
