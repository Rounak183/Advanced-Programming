import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
	SnakeBiteExceptionTest.class,
	VultureBiteExceptionTest.class,
	CricketBiteExceptionTest.class,
	TrampolineExceptionTest.class,
	GameWinnerExceptionTest.class
})

public class TestSuite{}