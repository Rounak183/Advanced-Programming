import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TrampolineExceptionTest
{
	@Test(expected=TrampolineException.class)
	public void Test_TrampolineException() throws TrampolineException
	{
		Trampoline_Tile trampoline_tile=new Trampoline_Tile(1,2);
		trampoline_tile.shake();
	}
}