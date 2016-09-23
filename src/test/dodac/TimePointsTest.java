package dodac;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class TimePointsTest {
	
	Row row = new Row(new Integer[] {2,4,9,6,5,10,11,3,7,0,8,1});

	@Test
	public void testGetPoints() {
		assertTrue(Arrays.equals(row.getTimePoints().getPoints(), new int[] {0,2,7,16,27,32,33,37,41,46,54,59}));
	}

	@Test
	public void testGetDurations() {
		assertTrue(Arrays.equals(row.getTimePoints().getDurations(), new int[] {2,5,9,11,5,1,4,4,5,8,5,1}));

	}

	@Test
	public void testToString() {
		assertEquals("0(2)	2(5)	7(9)	16(11)	27(5)	32(1)	33(4)	37(4)	41(5)	46(8)	54(5)	59(1)	(tot: 60)", row.getTimePoints().toString());
	}

}
