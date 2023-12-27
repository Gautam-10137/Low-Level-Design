import Model.Board;
import Model.Player;
import java.util.Deque;
import java.util.LinkedList;
import Model.PlayingPieceX;
import Model.PlayingPieceO;
import Model.PlayingPiece;
import java.util.Scanner;
import java.util.List;
import Model.Pair;
import Model.PieceType;
public class TicTacToeGame {

	 Board gameBoard;
	 Deque <Player> players;
	 
	 TicTacToeGame(){
		 initializeGame();
	 }
	
	 public void initializeGame() {
		 players=new LinkedList<>();
		 PlayingPieceX crossPiece=new PlayingPieceX();
		 Scanner scanner =new Scanner(System.in);
		 System.out.println("Enter name for player 1:");
		 String name1=scanner.nextLine();
		 System.out.println("Enter name for player 2:");
		 String name2=scanner.nextLine();
		 Player player1=new Player(name1,crossPiece);
		 
		 PlayingPieceO noughtPiece= new PlayingPieceO();
		 Player player2= new Player(name2,noughtPiece);
		 
		 players.add(player1);
		 players.add(player2);
		 
		 gameBoard=new Board(3);
	 }
	 
	 public String startGame() {
		 boolean noWinner=true;
		 while(noWinner) {
			 gameBoard.printBoard();
	
			 List<Pair<Integer,Integer>> freeCells=gameBoard.getFreeCells();
			 if(freeCells.isEmpty()) {
				 noWinner=false;
				 continue;
			 }
			 Player playerTurn=players.removeFirst();
			 
			 System.out.println("Turn for player:"+playerTurn.getName());
			 System.out.println("Enter position for:"+playerTurn.playingPiece.pieceType);
			 Scanner scanner= new Scanner(System.in);
			 String position= scanner.nextLine();
			 String[] values=position.split(",");
			 int inputRow=Integer.valueOf(values[0]);
			 int inputCol=Integer.valueOf(values[1]);
			 
			 boolean pieceAddedSuccessfully= gameBoard.addPiece(inputRow, inputCol, playerTurn.playingPiece);
			 
			 if(pieceAddedSuccessfully==false) {
				 System.out.println("Incorrect position chosen, try again");
				 players.addFirst(playerTurn);
				 continue;
			 }
			 players.addLast(playerTurn);
			 
			 boolean isWinner= checkWin(inputRow,inputCol,playerTurn.playingPiece.pieceType);
			 if(isWinner) {
				 return playerTurn.name;
			 } 
		 }
		 
		 return "tie";
	 }
	 private boolean checkWin(int row, int col, PieceType pieceType) {
		 boolean rowMatch=true;
		 boolean colMatch=true;
		 boolean diagonalMatch=true;
		 boolean antiDiagonalMatch=true;
//		 checking row
		 for(int i=0;i<gameBoard.size;i++) {
			 if(gameBoard.board[row][i]==null || gameBoard.board[row][i].pieceType!=pieceType) {
				 rowMatch=false;
				 break;
			 }
		 }
//		 checking col
		 for(int i=0;i<gameBoard.size;i++) {
			 if(gameBoard.board[i][col]==null || gameBoard.board[i][col].pieceType!=pieceType) {
				 colMatch=false;
				 break;
			 }
		 }
//		 diagonal check
		 for(int i=0;i<gameBoard.size;i++) {
			 if(gameBoard.board[i][i]==null || gameBoard.board[i][i].pieceType!=pieceType) {
				 diagonalMatch=false;
				 break;
			 }
		 }
//		 anti-diagonal check
		 for(int i=0;i<gameBoard.size;i++) {
			 if(gameBoard.board[i][gameBoard.size-1-i]==null || gameBoard.board[i][gameBoard.size-1-i].pieceType!=pieceType){
				 antiDiagonalMatch=false;
				 break;
				 
			 }
		 }
		 return rowMatch || colMatch || diagonalMatch || antiDiagonalMatch;
		 
	 }
}
