package Test;

import org.junit.Assert;
import org.junit.Test;

import Moves.MoveUtil;
import Moves.Paper;
import Moves.Rock;
import Moves.Scissors;

public class MoveUtilTest {

	@Test
	public void testGetMoveToBeat() {
		Rock rock = MoveUtil.rock;
		Paper paper = MoveUtil.paper;
		Scissors scissors = MoveUtil.scissors;
		
		Assert.assertEquals(scissors, MoveUtil.getMoveToBeat(paper));
		Assert.assertEquals(paper, MoveUtil.getMoveToBeat(rock));
		Assert.assertEquals(rock, MoveUtil.getMoveToBeat(scissors));
	}
}
