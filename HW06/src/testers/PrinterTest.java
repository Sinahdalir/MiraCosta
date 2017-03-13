package testers;
import edu.miracosta.cs113.ArrayQueue;
import edu.miracosta.cs113.PrintJob;
import static org.junit.Assert.*;

import org.junit.Test;
import edu.miracosta.cs113.Printer;

public class PrinterTest {

	Printer printer = new Printer("Printer", 0 , 10);
	
	@Test
	public void testPrinter() {
		Printer printer1 = new Printer();
		assertEquals(printer1.getUpper(), 0);
	}

	@Test
	public void testPrinterStringIntInt() {
		Printer printer2 = new Printer("Printer", 0 , 10);
		assertEquals(printer2.getUpper(), 10);
	}

	@Test
	public void testGetName() {
		assertEquals(printer.getName(), "Printer");
	}

	@Test
	public void testSetName() {
		printer.setName("Printer2");
		assertEquals(printer.getName(), "Printer2");
	}

	@Test
	public void testGetJobs() {
		PrintJob job = new PrintJob(10, 10);
		printer.addJob(job);
		ArrayQueue<PrintJob> object = printer.getJobs();
		assertEquals(object.peek(), job);
	}

	@Test
	public void testGetLower() {
		assertEquals(printer.getLower(), 0);
	}

	@Test
	public void testSetLower() {
		printer.setLower(10);
		assertEquals(printer.getLower(), 10);
	}

	@Test
	public void testGetUpper() {
		assertEquals(printer.getUpper(), 10);
	}

	@Test
	public void testSetUpper() {
		printer.setUpper(20);
		assertEquals(printer.getUpper(), 20);
	}

	@Test
	public void testAddJob() {
		PrintJob job = new PrintJob(10, 10);
		printer.addJob(job);
		ArrayQueue<PrintJob> object = printer.getJobs();
		assertEquals(object.peek(), job);
	}


	@Test
	public void testUpdateTime() {
		Printer.updateTime();
		assertEquals(Printer.getCurrentTime(), 1);
	}

	@Test
	public void testGetCurrentTime() {
		Printer.updateTime();
		assertEquals(Printer.getCurrentTime(), 1);
	}

}
