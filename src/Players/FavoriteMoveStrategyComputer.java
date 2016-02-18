package Players;

import java.util.HashMap;

import Moves.Move;
import Moves.MoveUtil;


public class FavoriteMoveStrategyComputer extends Computer{

	private HashMap<Move,Integer> moveMap;
	boolean mapIsFilled = false;
	
	public FavoriteMoveStrategyComputer() {
		moveMap = new HashMap<Move,Integer>();
		moveMap.put(MoveUtil.rock, 0);
		moveMap.put(MoveUtil.paper, 0);
		moveMap.put(MoveUtil.scissors, 0);
	}
	
	@Override
	public void move() {
		if (!mapIsFilled) {
			// first move, let's default
			setCurrentMove(MoveUtil.rock);
			mapIsFilled = true;
		} else {
			Move favoriteMove = getOpponentsFavoriteMove();
			setCurrentMove(MoveUtil.getMoveToBeat(favoriteMove));
		}
		
	}

	@Override
	public void processEndOfRound(Move move) {
		int count = moveMap.get(move) + 1;
		moveMap.put(move, count);
		
	}
	
	public Move getOpponentsFavoriteMove() {
		Move moveToReturn = null;
		
		int rockCount = moveMap.get(MoveUtil.rock);
		int paperCount = moveMap.get(MoveUtil.paper);
		int scissorsCount = moveMap.get(MoveUtil.scissors);
		
		if (rockCount > paperCount && rockCount > scissorsCount) {
			moveToReturn = MoveUtil.rock;
		} else if (paperCount > rockCount && paperCount > scissorsCount) {
			moveToReturn = MoveUtil.paper;
		} else if (scissorsCount > rockCount && scissorsCount > paperCount) {
			moveToReturn = MoveUtil.scissors;
		}
		
		if (moveToReturn == null) {
			// we have a tie somewhere
			if (rockCount == paperCount && rockCount == scissorsCount
					&& paperCount == scissorsCount) {	
				// default to rock
				moveToReturn = MoveUtil.rock;
			} else {
				// two way tie, choose the winning move to break the tie
				if (rockCount == paperCount) {
					moveToReturn = MoveUtil.paper;
				} else if (paperCount == scissorsCount) {
					moveToReturn = MoveUtil.scissors;
				} else {
					moveToReturn = MoveUtil.rock;
				}
			}
		}
		return moveToReturn;
	}

}
