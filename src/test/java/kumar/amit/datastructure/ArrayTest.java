package kumar.amit.datastructure;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import kumar.amit.datastructure.array.Array;

/**
 * Unit test for simple App.
 */
@DisplayName("Array Data Structure Test")
//@RunWith(JUnitPlatform.class)
public class ArrayTest

{

	private Array<Integer> arr = new Array();

	@Test
	public void testInitialLength() {
		assertSame(0, arr.length);
		arr.add(5);
		assertEquals(1, arr.length);
		assertEquals(5, arr.get(0));
	}

	@Test
	public void testClear() {
		arr.add(5);
		arr.clear();
		assertEquals(0, arr.length);
	}

	@Test
	public void testIsEmpty() {
		arr = new Array<>();
		assertTrue(arr.isEmpty());
		arr.add(5);
		assertFalse(arr.isEmpty());
	}

	@Test
	public void testArrayContent() {
		arr = new Array<>();
		arr.add(5);
		arr.add(12);
		arr.add(1);
		Integer[] a = new Integer[] { 5, 12, 1 };
		assertArrayEquals(a, arr.toArray());
	}

	@Test
	public void testremoveArray() {
		arr = new Array<>();
		arr.add(5);
		arr.add(12);
		arr.add(1);
		arr.remove(12);
		Integer[] a = new Integer[] { 5, 1 };
		assertArrayEquals(a, arr.toArray());

		assertFalse(arr.remove(100));
	}

	@Test
	public void testremoveAtArray() {
		arr = new Array<>();
		arr.add(5);
		arr.add(12);
		arr.add(1);
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			arr.removeAt(100);
		});
		arr.removeAt(1);
		Integer[] a = new Integer[] { 5, 1 };
		assertArrayEquals(a, arr.toArray());
	}

	@Test
	public void testInitialCapacity() {
		assertSame(16, arr.capacity);
		int oldCapacity = arr.capacity;
		for (int i = 0; i < oldCapacity; i++) {
			arr.add(i);
		}
		assertEquals(oldCapacity * 2, arr.capacity);
	}

	@Test
	public void testToString() {
		arr = new Array<>();
		assertEquals("[]", arr.toString());
		arr.add(5);
		arr.add(12);
		arr.add(1);
		System.out.println(arr.toString());
		assertEquals("[ 5, 12, 1 ]", arr.toString());
	}

}
