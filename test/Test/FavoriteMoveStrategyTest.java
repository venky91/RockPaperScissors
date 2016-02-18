package Test;

import org.junit.Assert;
import org.junit.Test;

import Moves.MoveUtil;
import Players.FavoriteMoveStrategyComputer;

public class FavoriteMoveStrategyTest {

	@Test
	public void testGetOpponentsFavoriteMove() {

		// Test three way tie
		FavoriteMoveStrategyComputer computer = new FavoriteMoveStrategyComputer();
		
		computer.processEndOfRound(MoveUtil.rock);
		computer.processEndOfRound(MoveUtil.rock);
		computer.processEndOfRound(MoveUtil.rock);
		computer.processEndOfRound(MoveUtil.rock);

		computer.processEndOfRound(MoveUtil.paper);
		computer.processEndOfRound(MoveUtil.paper);	
		computer.processEndOfRound(MoveUtil.paper);
		computer.processEndOfRound(MoveUtil.paper);
		
		computer.processEndOfRound(MoveUtil.scissors);
		computer.processEndOfRound(MoveUtil.scissors);	
		computer.processEndOfRound(MoveUtil.scissors);
		computer.processEndOfRound(MoveUtil.scissors);		
		
		Assert.assertEquals(MoveUtil.rock, computer.getOpponentsFavoriteMove());
		
		
		// Test two way tie between Rock and Scissors
		computer.processEndOfRound(MoveUtil.rock);
		computer.processEndOfRound(MoveUtil.scissors);
		Assert.assertEquals(MoveUtil.rock, computer.getOpponentsFavoriteMove());
		
		
		// Test two way tie between Paper and Scissors
		computer.processEndOfRound(MoveUtil.paper);
		computer.processEndOfRound(MoveUtil.paper);
		computer.processEndOfRound(MoveUtil.scissors);
		Assert.assertEquals(MoveUtil.scissors, computer.getOpponentsFavoriteMove());
		
		
		// Test two way tie between Rock and Paper
		computer.processEndOfRound(MoveUtil.rock);
		computer.processEndOfRound(MoveUtil.rock);
		computer.processEndOfRound(MoveUtil.paper);
		Assert.assertEquals(MoveUtil.paper, computer.getOpponentsFavoriteMove());
		
	}
}
