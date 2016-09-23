package dodac;

import static org.junit.Assert.*;

import org.junit.Test;

public class RowTest {

	private static final Integer[] tones = {0,1,2,3,4,5,6,7,8,9,10,11};

	@Test
	public void testPrintNoteNames() {
		assertEquals("   C\t  C#\t   D\t  D#\t   E\t   F\t  F#\t   G\t  G#\t   A\t  Bb\t   B\t", new Row(tones).printNoteNames());
	}

	@Test
	public void testInvert() {
		assertEquals(new Row(new Integer[] {1,2,3}),new Row(new Integer[] {11,10,9}).invert());
	}

	@Test
	public void testRetrograde() {
		assertEquals(new Row(new Integer[] {1,2,3}),new Row(new Integer[] {3,2,1}).retrograde());
	}

	@Test
	public void testTransposeRow() {
		assertEquals(new Row(new Integer[] {3,4,5}), new Row(new Integer[] {1,2,3}).transposeRow(2));
	}

	@Test
	public void testToString() {
		assertEquals("   0\t   1\t   2\t   3\t   4\t   5\t   6\t   7\t   8\t   9\t  10\t  11\t", new Row(tones).toString());
	}

	@Test
	public void testLength() {
		assertEquals(3, new Row(new Integer[] {1,2,3}).length());
	}

	@Test
	public void testGetFirst() {
		assertEquals(42, new Row(new Integer[] {42,23,5,4}).getFirst());
	}
	
	@Test
	public void testEquals() {
		assertEquals( new Row(new Integer[] {1,2,3}),new Row(new Integer[] {1,2,3}));
	}

	@Test
	public void testNotEquals() {
		assertFalse( new Row(new Integer[] {1,2,3}).equals( new Row(new Integer[] {1,3,2})));
	}

	@Test
	public void testEqualsLength() {
		assertFalse( new Row(new Integer[] {1,2,3,4}).equals( new Row(new Integer[] {1,2,3})));
	}

	@Test
	public void testEqualsNull() {
		assertFalse( new Row(new Integer[] {1,2,3,4}).equals( null));
	}

}
