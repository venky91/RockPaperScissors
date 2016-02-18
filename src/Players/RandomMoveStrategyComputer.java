package Players;

import java.util.Random;

import Moves.Move;
import Moves.MoveUtil;

public class RandomMoveStrategyComputer extends Computer {

	Move[] moveArray = new Move[3];
	Random random = new Random();
	
	public RandomMoveStrategyComputer() {
		moveArray[0]  = MoveUtil.rock;
		moveArray[1] = MoveUtil.paper;
		moveArray[2] = MoveUtil.scissors;
	}
	
	@Override
	public void move() {
		setCurrentMove(moveArray[random.nextInt(moveArray.length)]);
	}

	@Override
	public void processEndOfRound(Move move) {		
	}

}
