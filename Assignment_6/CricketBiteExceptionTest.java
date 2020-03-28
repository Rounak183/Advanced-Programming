import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CricketBiteExceptionTest
{
	@Test(expected=CricketBiteException.class)
	public void Test_CricketBiteException() throws CricketBiteException
	{
		Cricket_Tile cricket_tile=new Cricket_Tile(1,2);
		cricket_tile.shake();
	}
}