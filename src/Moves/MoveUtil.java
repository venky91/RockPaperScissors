package Moves;

public class MoveUtil {
	
	public static Rock rock = new Rock();
	public static Paper paper = new Paper();
	public static Scissors scissors = new Scissors();
	
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
