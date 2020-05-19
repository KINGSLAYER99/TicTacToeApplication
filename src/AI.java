import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class AI {
    public int pickSpot(TicTacToe game) {
        ArrayList<Integer> choices = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            //if slot not taken add it as a choice
            if (game.board[i] == '-') {
                choices.add(i + 1);
            }
        }
        Random random = new Random();
        return choices.get(Math.abs(random.nextInt() % choices.size()));
    }
}
