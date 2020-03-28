import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class SnakeBiteExceptionTest
{
	@Test(expected=SnakeBiteException.class)
	public void Test_SnakeBiteException() throws SnakeBiteException
	{
		Snake_Tile snake_tile=new Snake_Tile(1,2);
		snake_tile.shake();
	}
}