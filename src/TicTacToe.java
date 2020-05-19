public class TicTacToe {
    //my class which will have the entire logic.
    protected char[] board;//this is the 3x3 board
    protected char userMarker;//user can have X or O
    protected char aiMarker;//similar to user, but will choose opposite to user
    protected char winner;//is X the winner or O
    protected char currentMarker;//it tells us who is the current player. If its X then user is currently playing

    public TicTacToe(char userMarker, char aiMarker) {
        this.userMarker = userMarker;// during initialization itself it gets decided that who gets what
        this.aiMarker = aiMarker;
        this.winner = '-';// Initialzation doesn't have any winner yet
        this.board = setBoard();//setting a new board with all values set to '-'
        this.currentMarker = userMarker;
    }

    public static char[] setBoard() {
        char[] board = new char[9];
        for(int i = 0; i < 9; i++) {
            board[i] = '-';
        }
        return board;
    }

    //playing turn of anyone is if valid move, then do the move on board and switch the current marker to next person's turn
    public boolean playTurn (int spot) {
        boolean isValid = withinRange(spot) && !isSpotTaken(spot);
        if (isValid) {
            board[spot - 1] = currentMarker;
            currentMarker = (currentMarker == userMarker) ? aiMarker : userMarker;
        }
        return isValid;
    }

    //check if spot is taken
    private boolean isSpotTaken(int spot) {
        return board[spot - 1] != '-';
    }

    //check if spot is in range
    private boolean withinRange(int spot) {
        return spot > 0 && spot < board.length + 1;
    }

    public void printBoard() {
        //attempting to create this board..
        //  | - | - | -
        // -------------
        //  | - | - | -
        // -------------
        //  | - | - | -
        System.out.println();
        for (int i = 0; i < board.length; i++) {
            if (i % 3 == 0) {
                System.out.println();
                System.out.println("-------------");
            }
            System.out.print("| " + board[i] + " ");
        }
        System.out.println();
    }

    //this is the board that will be shown to user to let them know how are slots designed
    public static void printIndexBoard() {
        //  | 1 | 2 | 3
        // -------------
        //  | 4 | 5 | 6
        // -------------
        //  | 7 | 8 | 9
        System.out.println();
        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0) {
                System.out.println();
                System.out.println("-------------");
            }
            System.out.print("| " + (i + 1) + " ");
        }
        System.out.println();
    }

    public boolean isThereAWinner() {
        //
        boolean diagonalsAndMiddles = (principalDiag() || otherDiag() || middleRow() || middleCol()) && board[4] != '-';
        boolean topAndLeft = (topRow() || firstCol()) && board[0] != '-';
        boolean bottomAndRight = (bottomRow() || lastCol()) && board[8] != '-';
        if (diagonalsAndMiddles) {
            this.winner = board[4];
        }
        else if (topAndLeft) {
            this.winner = board[0];
        }
        else if (bottomAndRight) {
            this.winner = board[8];
        }
        return diagonalsAndMiddles || topAndLeft || bottomAndRight;
    }

    public boolean lastCol() {
        return (board[2] == board[5]) && (board[5] == board[8]);
    }

    public boolean bottomRow() {
        return (board[6] == board[7]) && (board[7] == board[8]);
    }

    public boolean firstCol() {
        return (board[0] == board[3]) && (board[3] == board[6]);
    }

    public boolean topRow() {
        return (board[0] == board[1]) && (board[1] == board[2]);
    }

    public boolean middleCol() {
        return (board[1] == board[4]) && (board[4] == board[7]);
    }

    public boolean middleRow() {
        return (board[3] == board[4]) && (board[4] == board[5]);
    }

    public boolean otherDiag() {
        return (board[2] == board[4]) && (board[4] == board[6]);
    }

    public boolean principalDiag() {
        return (board[0] == board[4]) && (board[4] == board[8]);
    }
    public boolean isTheBoardFilled() {
        for (int i = 0; i < board.length; i++) {
            if (board[i] == '-') {
                return false;
            }
        }
        return true;
    }

    public String gameOver() {
        boolean didSomeoneWin = isThereAWinner();
        if (didSomeoneWin) {
            return "The winner is: " + this.winner;
        }
        else if (isTheBoardFilled()) {
            return "Draw: Game Over!";
        }
        else {
            return "not Over";
        }
    }
}
