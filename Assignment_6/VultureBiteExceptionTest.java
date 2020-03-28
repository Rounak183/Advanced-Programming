import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class VultureBiteExceptionTest
{
	@Test(expected=VultureBiteException.class)
	public void Test_VultureBiteException() throws VultureBiteException
	{
		Vulture_Tile vulture_tile=new Vulture_Tile(1,2);
		vulture_tile.shake();
	}
}