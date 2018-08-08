package viratProblem;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class MatchTest
{

	Match match = null;
	
	@Before
	public void Initialize()
	{
		match = new Match();
		match.addBowler(8, "mj");
		match.addBowler(3, "cj");
		match.addBowler(1, "dj");
	}
	
	@Test
	public void testGetMaxBowlBolwer1() 
	{
		
		
		match.totalBowl();
		List<Bowler> names = match.getViratMinimumRun();
		List<Bowler>  result = new ArrayList<Bowler>();
		result.add(new Bowler(6, "mj"));
		result.add(new Bowler(1, "cj"));
		result.add(new Bowler(1, "mj"));
		result.add(new Bowler(1, "cj"));
		result.add(new Bowler(1, "mj"));
		result.add(new Bowler(1, "cj"));
		result.add(new Bowler(1, "dj"));
		for(int i = 0; i < result.size(); i++) 
		{
			assertEquals(names.get(i).getBowl(), result.get(i).getBowl());
			assertEquals(names.get(i).getName(), result.get(i).getName());
		}
	}

	@Test
	public void testGetMaxBowlBolwer2() throws NullPointerException 
	{
		match.addBowler(4, "bobby");
		
		match.totalBowl();
		List<Bowler> names = match.getViratMinimumRun();
		List<Bowler>  result = new ArrayList<Bowler>();
		result.add(new Bowler(5, "mj"));
		result.add(new Bowler(1, "bobby"));
		result.add(new Bowler(1, "mj"));
		result.add(new Bowler(1, "cj"));
		result.add(new Bowler(1, "bobby"));
		result.add(new Bowler(1, "mj"));
		result.add(new Bowler(1, "cj"));
		result.add(new Bowler(1, "bobby"));
		result.add(new Bowler(1, "mj"));
		result.add(new Bowler(1, "cj"));
		result.add(new Bowler(1, "dj"));
		result.add(new Bowler(1, "bobby"));
		for(int i = 0; i < result.size(); i++) 
		{
			assertEquals(names.get(i).getBowl(), result.get(i).getBowl());
			assertEquals(names.get(i).getName(), result.get(i).getName());
		}
	}
	
	@Test(expected = NullPointerException.class)
	public void bowlerWithZeroBall() 
	{
			match.addBowler(0, "dj");

	}
	
	@Test(expected = NullPointerException.class)
	public void bowlerWithNullName()
	{
			match.addBowler(1, null);
	}
}
