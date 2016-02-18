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
			Move moveToBeat = MoveUtil.getMoveToBeat(opponentsLastMove);
			setCurrentMove(moveToBeat);
		}		
	}

	@Override
	public void processEndOfRound(Move move) {
		opponentsLastMove = move;	
	}
	
}
