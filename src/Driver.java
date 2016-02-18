import Moves.Move;
import Moves.MoveUtil;
import Players.Computer;
import Players.FavoriteMoveStrategyComputer;
import Players.Human;
import Players.LastMoveStrategyComputer;


public class Driver {

	public static void main(String[] args){

		Computer computer = null;
		Human human = new Human();
		
		int humanWins = 0;
		int humanLosses = 0;
		int ties = 0;

		StringBuilder sb = new StringBuilder();
		String strategy = "lastmove"; // default the strategy
		
		if (args != null && args.length == 1) {
			String input = args[0];
			if (input.equalsIgnoreCase("favorite") || input.equalsIgnoreCase("lastmove")) {
				strategy = input;
			}
		}
		
		if (strategy.equalsIgnoreCase("lastmove")) {
			computer = new LastMoveStrategyComputer();
		} else if (strategy.equalsIgnoreCase("favorite")){
			computer = new FavoriteMoveStrategyComputer();
		}
		
		System.out.println("You are playing against strategy '" + strategy + "'");
		boolean validInput = false;
		
		// main loop
		while (true) {
			computer.move();
			while (!validInput) {
				System.out.println("Type 'r', 'p', or 's'");
				validInput = human.move();
				if (!validInput) {
					System.out.println("You have entered invalid input");
				}
			}
			
			Move computerCurrentMove = computer.getCurrentMove();
			Move humanCurrentMove = human.getCurrentMove();
			
			sb.append("I chose '").append(computerCurrentMove.getRepresentation()).append("'.");
			
			if (computerCurrentMove == humanCurrentMove) {
				ties++;
				sb.append(" It's a tie!");
				
			} else {
				Move moveToBeat = MoveUtil.getMoveToBeat(computerCurrentMove);
				if (moveToBeat == humanCurrentMove) {
					humanWins++;
					sb.append(" You win!");
				} else {
					humanLosses++;
					sb.append(" You lose!");
				}
			}
			
			// Print outcome of current round
			System.out.println(sb.toString());
			sb.setLength(0);
			
			// Print standings
			sb.append("You won ").append(humanWins).append(" times.");
			System.out.println(sb.toString());
			sb.setLength(0);
			sb.append("You lost ").append(humanLosses).append(" times.");
			System.out.println(sb.toString());
			sb.setLength(0);
			sb.append("We tied ").append(ties).append(" times");
			System.out.println(sb.toString());
			
			
			// Cleanup for next round
			validInput = false;
			sb.setLength(0);
			computer.processEndOfRound(humanCurrentMove);
			
		}
		
	}
}
