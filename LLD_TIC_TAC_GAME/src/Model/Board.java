package Model;

import java.util.ArrayList;
import java.util.List;

public class Board {
    public int board_size;
    public PlayingPiece[][] board;
    public Board(int board_size){
        this.board_size=board_size;
        board=new PlayingPiece[board_size][board_size];
    }
    public boolean addPiece(int row, int col, PlayingPiece playingPiece){
        if(board[row][col]!=null){
            return false;
        }
        board[row][col]=playingPiece;
        return true;
    }
    public List<Pair<Integer,Integer>> getFreeCells(){
        List<Pair<Integer,Integer>> freeCell= new ArrayList<>();
        for(int i=0;i<board_size;i++){
            for (int j=0;j<board_size;j++){
                if(board[i][j]==null){
                    Pair<Integer, Integer> rowCol=new Pair<>(i,j);
                    freeCell.add(rowCol);
                }
            }
        }
        return freeCell;
    }
    public void printBoard(){
        for (int i = 0; i < board_size; i++) {
            for (int j = 0; j < board_size; j++) {
                if(board[i][j]!=null){
                    System.out.print(board[i][j].pieceType.name()+"  ");
                }
                else {
                    System.out.print("  ");
                }
                System.out.print(" | ");
            }
            System.out.println();

        }
    }
}
