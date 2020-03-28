import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Ser_Des
{
	@Test(timeout = 2000)
	public void Test_Ser_Des()
	{
		RaceTrack[] a = Assignment.deserializeUser("Test1", 1);
		assertEquals(a[0], a[1]);


	}
}