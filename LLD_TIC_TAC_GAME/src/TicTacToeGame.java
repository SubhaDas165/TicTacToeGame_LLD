import Model.*;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TicTacToeGame {
    Deque<Player> players;
    Board board;
    public void initializedGame(){
        players=new LinkedList<>();
        PlayingPieceTypeX cross_Piece=new PlayingPieceTypeX();
        Player player1=new Player("player1", cross_Piece);

        PlayingPieceTypeO zero_Piece= new PlayingPieceTypeO();
        Player player2= new Player("player2", zero_Piece);

        players.add(player1);
        players.add(player2);
        board =new Board(3);

    }
    public String startGame(){
        boolean noWinner=true;
        while(noWinner){
            Player playerTurn =players.removeFirst();
            board.printBoard();
            List<Pair<Integer,Integer>> freeSpaces=board.getFreeCells();
            if(freeSpaces.isEmpty()){
                noWinner=false;
                continue;
            }
            System.out.println("Player: "+playerTurn.player_name +"Enter row and column");
            Scanner sc=new Scanner((System.in));
            String s=sc.nextLine();
            String [] vales= s.split(",");
            int inputRow=Integer.valueOf(vales[0]);
            int inputCol=Integer.valueOf(vales[1]);

            boolean pieceAddedSuccessfully=board.addPiece(inputRow,inputCol,playerTurn.playingPiece);
            if(!pieceAddedSuccessfully){
                System.out.println("Incorrect Position , please try again");
                players.add(playerTurn);
                continue;
            }
            players.add(playerTurn);
            boolean winner= isTheWinner(inputRow, inputCol, playerTurn.playingPiece.pieceType);
            if(winner){
                return playerTurn.player_name;
            }

        }
        return "Tie";
    }
    public boolean isTheWinner(int inputRow, int inputCol, PieceType pieceType){
        boolean rowMatch=true;
        boolean colMatch=true;
        boolean diagonalMatch=true;
        boolean antidiagonalMatch=true;

        for (int i = 0; i < board.board_size; i++) {
            if(board.board[inputRow][i]==null || board.board[inputRow][i].pieceType!=pieceType){
                rowMatch= false;
            }
        }
        for (int i = 0; i < board.board_size; i++) {
            if(board.board[i][inputCol]==null || board.board[i][inputCol].pieceType!=pieceType){
                colMatch= false;
            }
        }
        for (int i = 0, j=0; i < board.board_size ; i++, j++) {
            if(board.board[i][j]==null || board.board[i][j].pieceType!=pieceType){
                diagonalMatch= false;
            }
        }
        for (int i = 0, j=board.board_size-1; i < board.board_size ; i++, j--) {
            if(board.board[i][j]==null || board.board[i][j].pieceType!=pieceType){
                antidiagonalMatch= false;
            }
        }
        return rowMatch || colMatch || diagonalMatch || antidiagonalMatch;

    }
}
