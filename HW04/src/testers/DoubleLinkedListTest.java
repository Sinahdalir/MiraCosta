package testers;
import edu.miracosta.cs113.DoubleLinkedList;
import static org.junit.Assert.*;

import org.junit.Test;

public class DoubleLinkedListTest {

	DoubleLinkedList<Student> list = new DoubleLinkedList<Student>();
	Student student1 = new Student(4, "CS", "1", "Student1");
	Student student2 = new Student(4, "CS", "2", "Student2");
	Student student3 = new Student(4, "CS", "3", "Student3");
	Student student4 = new Student(4, "CS", "4", "Student4");
	
	public void addItems()
	{
		list.addFirst(student1);
		list.add(student2);
		list.add(student3);
		list.add(student4);
	}
	
	
	@Test
	public void testGet() {
		addItems();
		assertEquals(list.get(1), student2);
		
	}

	@Test
	public void testGetFirst() {
		addItems();
		assertEquals(list.get(0), student1);
	}

	@Test
	public void testGetLast() {
		addItems();
		assertEquals(list.get(3), student4);
	}

	@Test
	public void testSize() {
		addItems();
		assertEquals(list.size(), 4);
	}

	@Test
	public void testIsEmpty() {
		addItems();
		assertEquals(list.isEmpty(), false);
	}

	@Test
	public void testIndexOf() {
		addItems();
		Student newStudent = new Student(4, "CS", "4", "Student4");
		assertEquals(list.indexOf(newStudent), 3);
	}
	
	@Test
	public void testAdd() {
		addItems();
		Student newStudent = new Student(4, "CS", "5", "Student5");
		list.add(newStudent);
		assertEquals(list.get(4), newStudent);
	}
	
	@Test
	public void testRemove() {
		addItems();
		Student newStudent = new Student(4, "CS", "5", "Student5");
		list.add(newStudent);
		Student oldStudent = new Student(4, "CS", "4", "Student4");
		list.remove(oldStudent);
		assertEquals(list.get(3), newStudent);
	}
	
	@Test
	public void testClear() {
		addItems();
		list.clear();
		assertEquals(list.size(), 0);
	}
	
	@Test
	public void testSet() {
		addItems();
		Student newStudent = new Student(4, "CS", "5", "Student5");
		list.set(3 , newStudent);
		assertEquals(list.get(3), newStudent);
	}
	
	

}
