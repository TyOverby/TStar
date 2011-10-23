import static org.junit.Assert.*;

import org.junit.Test;

public class TimedTest {
	@Test 
	public void testfind(){
		Point start = new Point(0,0);
		Point end = new Point(5,5);

		GameMap.start(start,end);

		GameMap.run();
	}
}
