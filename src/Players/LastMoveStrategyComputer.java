package Players;

import Moves.Move;
import Moves.MoveUtil;
import Moves.Paper;
import Moves.Rock;

public class LastMoveStrategyComputer extends Computer {

	private Move opponentsLastMove = null;
	
	@Override
	public void move() {
		if (opponentsLastMove == null) {
			// this is the first move so let's hardcode it
			setCurrentMove(MoveUtil.rock);
		} else {
			Move moveToBeat = getMoveToBeat(opponentsLastMove);
			setCurrentMove(moveToBeat);
		}		
	}

	@Override
	public void processEndOfRound(Move move) {
		opponentsLastMove = move;	
	}

	public static Move getMoveToBeat(Move move) {
		Move moveToReturn = null;
		
		if (move instanceof Rock) {
			moveToReturn = MoveUtil.paper;
		} else if (move instanceof Paper) {
			moveToReturn = MoveUtil.scissors;
		} else {
			moveToReturn = MoveUtil.rock;
		}
		return moveToReturn;
	}	
}
