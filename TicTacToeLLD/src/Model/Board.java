package Model;

import java.util.List;
import java.util.ArrayList;
public class Board {
        public int size;
        public PlayingPiece[][] board;
        
        public Board(int size) {
        	this.size=size;
        	board= new PlayingPiece[size][size];
        }
        
        public boolean addPiece(int row, int col,PlayingPiece playingPiece) {
        	if(board[row][col]!=null) {
        		return false;
        	}
        	board[row][col]=playingPiece;
        	return true;
        }
        public void printBoard() {
        	for(int row=0;row<size;row++) {
				 for(int col=0;col<size;col++) {
					 PlayingPiece piece=board[row][col];
					 if(piece==null) {
						 System.out.print(" |");
					 }
					 else {
						 System.out.print(piece.pieceType+"|");
					 }
				 }
				 System.out.println("");
			 }
        }
        public List<Pair<Integer,Integer>> getFreeCells(){
        	List<Pair<Integer,Integer>> freeCells=new ArrayList<>();
        	for(int row=0;row<size;row++) {
        		for(int col=0;col<size;col++) {
        			if(board[row][col]==null) {
        				Pair<Integer,Integer> rowColumns=new Pair<>(row,col);
        				freeCells.add(rowColumns);
        			}
        		}
        	}
        	return freeCells;
        }
        	
}