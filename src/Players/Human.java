package Players;
import java.util.Scanner;

import Moves.Move;
import Moves.MoveUtil;


public class Human {

	private Move currentMove;
	Scanner sc = new Scanner(System.in);
		
	public Move getCurrentMove() {
		return currentMove;
	}
	
	public boolean move() {
		boolean ret = false;
		String input = sc.nextLine();
		if (input != null && input.length() == 1) {
			char c = input.charAt(0);
			if (c == 'r') {
				currentMove = MoveUtil.rock;
				ret = true;
			} else if (c == 'p') {
				currentMove = MoveUtil.paper;
				ret = true;
			} else if (c == 's') {
				currentMove = MoveUtil.scissors;
				ret = true;
			}
		}
		return ret;
	}
}
