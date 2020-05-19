import java.util.Scanner;

public class TicTacToeApplication {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        //allows for continuous game
        boolean doYouWantToPlay = true;
        while (doYouWantToPlay) {
            //setting up tokens and AI
            System.out.println("Welcome! Pick the character you want to be and for me!!!");
            System.out.println();
            System.out.println("Enter single character representing you:");
            char playerToken = sc.next().charAt(0);
            System.out.println("Enter single character representing your opponent:");
            char opponentToken = sc.next().charAt(0);
            TicTacToe game = new TicTacToe(playerToken, opponentToken);
            AI ai = new AI();
            //setting up the game
            System.out.println("Now, to play, enter number and your token shall be put in its place");
            System.out.println("The reference board is as follows:");
            TicTacToe.printIndexBoard();
            System.out.println();

            //lets play
            while (game.gameOver().equals("not Over")) {
                if(game.currentMarker == game.userMarker) {
                    System.out.println("Its ur turn! Enter a spot for your token:");
                    int spot = sc.nextInt();
                    while (!game.playTurn(spot)) {
                        System.out.println("Try again " + spot + " is already taken or out of range!");
                        System.out.println("Enter your valid spot here:");
                        spot = sc.nextInt();
                    }
                    System.out.println("You Picked " + spot + "!");
                }
                else {
                    System.out.println("It's my(AI's) turn!");
                    //pick spot
                    int aiSpot = ai.pickSpot(game);
                    //ai move is recorded into the game
                    game.playTurn(aiSpot);
                    System.out.println("I picked " + aiSpot + "!");
                }
                //print out the board
                System.out.println();
                game.printBoard();
            }
            System.out.println(game.gameOver());
            //set up a new  game depends on response
            System.out.println("Do you want to continue to play a new game(y/n)");
            char response = sc.next().charAt(0);
            doYouWantToPlay = (response == 'y' || response == 'Y');
            System.out.println();
            System.out.println();
        }
    }
}
