import model.Board;
import model.Piece;
import model.PieceType;
import model.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    List<Player> players;
    Board board;

    int[] rows;
    int[] cols;

    int diagnol;

    int antiDiagnol;


    int maxMoves;

    Player gameWinner;

    int boardSize;

    public Game() {
        initializeGame();
    }

    private void initializeGame(){
        Scanner scanner=new Scanner(System.in);

        System.out.println("Enter the name of player 1");
        String name1= scanner.nextLine();
        System.out.println("Enter the pieceType of player 1");
        String pieceType1= scanner.nextLine();

        players=new ArrayList<>();

        players.add(new Player(name1,new Piece(PieceType.valueOf(pieceType1))));

        System.out.println("Enter the name of player 2");
        String name2= scanner.nextLine();
        System.out.println("Enter the pieceType of player 2");
        String pieceType2= scanner.nextLine();

        players.add(new Player(name2,new Piece(PieceType.valueOf(pieceType2))));

        System.out.println("Enter the size of board");
        boardSize=scanner.nextInt();



        board= new Board(boardSize);
        gameWinner=null;

        rows=new int[boardSize];
        cols=new int[boardSize];
        maxMoves=boardSize*boardSize;

    }

    public void startGame() {

        int moves=0;


        Scanner scanner=new Scanner(System.in);

        while(moves!= maxMoves&&gameWinner==null){
            moveForPlayer(scanner,players.get(0));
            moves+=1;

            if(moves==maxMoves||gameWinner!=null){
                break;
            }

            moveForPlayer(scanner,players.get(1));

            moves+=1;
        }
    }

    private void moveForPlayer(Scanner scanner,Player player) {
        System.out.println("Enter the move of " + player.getName());
        int x= scanner.nextInt();
        int y= scanner.nextInt();
        while(!board.addPiece(x,y, player)){
            System.out.println("Invalid move please try again");
            x= scanner.nextInt();
            y= scanner.nextInt();
        }
        checkForWinner(x,y,player);

    }

    public Player getGameWinner(){
        return gameWinner;
    }

    private void checkForWinner(int x, int y, Player player) {
        int toAdd = player.getPiece().getPieceType() == PieceType.X ? 1 : -1;
        this.rows[x]+=toAdd;
        this.cols[y]+=toAdd;
        if(x == y)
            this.diagnol+=toAdd;
        if(x + y ==boardSize-1)
            this.antiDiagnol+=toAdd;

        if(Math.abs(rows[x]) ==boardSize|| Math.abs(cols[y]) ==boardSize||Math.abs(diagnol)==boardSize||Math.abs(antiDiagnol)==boardSize){
            gameWinner=player;
        }

    }
}
