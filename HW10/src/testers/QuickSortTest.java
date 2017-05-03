package testers;
import edu.miracosta.cs113.QuickSort;
import static org.junit.Assert.*;

import org.junit.Test;

public class QuickSortTest 
{

	private Integer[] list = new Integer[10];
	private void addItems()
	{
		list[0] = 15;
		list[1] = 10;
		list[2] = 40;
		list[3] = 6;
		list[4] = 1;
		list[5] = 35;
		list[6] = 2;
		list[7] = 13;
		list[8] = 8;
		list[9] = 9;
	}
	@Test
	public void testSort() {
		addItems();
		QuickSort.sort(list);
		assertEquals(list[0], new Integer(1));
		assertEquals(list[1], new Integer(2));
		assertEquals(list[2], new Integer(6));
		assertEquals(list[3], new Integer(8));
		assertEquals(list[4], new Integer(9));
		assertEquals(list[5], new Integer(10));
		assertEquals(list[6], new Integer(13));
		assertEquals(list[7], new Integer(15));
		assertEquals(list[8], new Integer(35));
		assertEquals(list[9], new Integer(40));
	}

}
