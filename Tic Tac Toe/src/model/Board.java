package model;

public class Board {

    int size;
    Piece[][]board;

    public Board(int size) {
        this.size = size;

        this.board=new Piece[size][size];
    }

    public boolean addPiece(int x, int y, Player player) {

        if(x<0||y<0||x>=size||y>=size || !isEmptyCell(x,y)){
           return false;
        }

        board[x][y]= player.piece;
        printBoard();

        return true;

    }

    public Boolean isEmptyCell(int x, int y){
        return board[x][y]==null;
    }

    private void printBoard() {

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] != null) {
                    System.out.print(board[i][j].pieceType.name() + "   ");
                } else {
                    System.out.print("    ");

                }
                System.out.print(" | ");
            }
            System.out.println();

        }
    }




}
