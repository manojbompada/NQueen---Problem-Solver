/*
 * This class maintains the position of a queen in the chess board
 */

public class QueenState {
	private int queenRow;
	private int queenCol;

	public QueenState(int qrow, int qcol){
		queenRow = qrow;
		queenCol = qcol;
	}

	/*
	 * This method checks if there is any conflict between any two queens of the chess board.
	 * It checks conflicts in rows, columns and also diagonally 
	 */
	public boolean isConflicting(QueenState q1,QueenState q2){
		boolean conflicts=false;

		if(q1.getqueenRow()==q2.getqueenRow() || q1.getqueenCol()==q2.getqueenCol())
			conflicts=true;
		else if(Math.abs(q1.getqueenCol()-q2.getqueenCol()) == Math.abs(q1.getqueenRow()-q2.getqueenRow()))
			conflicts=true;

		return conflicts;
	}

	/*
	 * This method changes the position of a queen in a column of the board depending on the shift value.
	 * Also the queens will be shifted only downwards for a column
	 */
	public void shiftQueen(int shift, int queens){
		int qCount = queens;
		queenRow+=shift;

		if(queenRow>(qCount-1) && queenRow%(qCount-1)!=0){
			queenRow=(queenRow%(qCount-1)-1);
		}
		else if(queenRow>(qCount-1) && queenRow%(qCount-1)==0){
			queenRow=(qCount-1);
		}
	}

	public void setqueenRow(int qRow){
		queenRow = qRow;
	}


	public int getqueenRow(){
		return queenRow;
	}

	public void setqueenCol(int qCol){
		queenCol = qCol;
	}


	public int getqueenCol(){
		return queenCol;
	}

	public String toString(){
		return "("+queenRow+", "+queenCol+")";
	}

}
