package testers;
import edu.miracosta.cs113.PrintJob;

import static org.junit.Assert.*;

import org.junit.Test;

public class PrintJobTest {
	PrintJob object = new PrintJob(10, 10);
	@Test
	public void testPrintJob() {
		PrintJob object1 = new PrintJob();
		assertEquals(object1.getStartTime(), 0);
	}

	@Test
	public void testPrintJobIntInt() {
		PrintJob object1 = new PrintJob(5, 5);
		assertEquals(object1.getStartTime(), 5);
		assertEquals(object1.getNumberPapers(), 5);
	}

	@Test
	public void testGetNumberPapers() {
		assertEquals(object.getNumberPapers(), 10);
	}

	@Test
	public void testSetNumberPapers() {
		object.setNumberPapers(20);
		assertEquals(object.getNumberPapers(), 20);
	}

	@Test
	public void testGetStartTime() {
		assertEquals(object.getStartTime(), 10);
	}

	@Test
	public void testSetStartTime() {
		object.setStartTime(20);
		assertEquals(object.getStartTime(), 20);
	}

	@Test
	public void testGetTimeToPrint() {
		object.setNumberPapers(20);
		assertEquals(object.getTimeToPrint(), 2 + object.getStartTime());
	}


}
