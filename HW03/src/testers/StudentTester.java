package testers;
import edu.miracosta.cs113.Student;
public class StudentTester {

	public static void main(String[] args) {
		Student student = new Student();
		student.setGpa(4.0);
		student.setIDNumber("111111");
		student.setMajor("CS");
		student.setName("John");
		
		System.out.println(student.getGpa() + "= 4.0");
		System.out.println(student.getMajor() + "= CS");
		System.out.println(student.getIDNumber() + "= 111111");
		System.out.println(student.getName() + "= John");
		
		Student student2 = new Student(4.0, "CS", "111111", "John");
		System.out.println(student.equals(student2) + " = true");
		
		

	}

}
