package Players;

import Moves.Move;

public abstract class Computer {

	private Move currentMove;
	public abstract void move();
	public abstract void processEndOfRound();
	
	public void setCurrentMove(Move move) {
		this.currentMove = move;
	}
	
	public Move getCurrentMove() {
		return currentMove;
	}
	
	
	
}
