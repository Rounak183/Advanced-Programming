import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class GameWinnerExceptionTest
{
	@Test(expected=GameWinnerException.class)
	public void Test_GameWinnerException() throws GameWinnerException
	{
		Assignment.isWinner();
	}
}