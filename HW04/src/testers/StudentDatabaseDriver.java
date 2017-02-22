/**
 * StudentDatabaseDriver.java : this program gives command to use a student list add, remove, view, ...etc
 * 
 * @author Sina Dalir
 * @version 1.0
 *
 */

/**
 * ALGORITHM:
 * DECLARE command , temp;
 * DECLARE & INITIALIZE loopContinue
 * DECLARE & INSTANTIATE Scanner keyboard
 * DECLARE & INSTANTIATE MySingleLinkedList<String> list
 * CALL printMenu()
 * PRINT "Please enter command"
 * ASSIGN temp
 * ASSIGN command
 * IF
 * 		ASSIGN loopContinue = false;
 * END IF
 * WHILE
 * 		IF
 * 			DECLARE & INSTANTIATE student  
 * 			CALL getInfo(keyboard);
 *			CALL list.add(Student);
 *		ELSE IF
 *			DECLARE & INSTANTIATE student  
 * 			CALL getInfo(keyboard);
 *			list.addToBeginning(Student);
 *		ELSE IF
 *			CALL list.removeFirst();
 *		ELSE IF
 *			PRINT"Please enter student name"
 *			ASSIGN temp = keyboard.nextLine();
 *			CALL list.removeStudent(temp);
 *		ELSE IF
 *			FOR
 *				PRINT list.get(i)
 *		ELSE
 *			PRINT "Thank you for using our database, have a good day!"
 * 			ASSIGN loopContinue
 * 		END IF
 * 		PRINT "Please enter command"
 * 		ASSIGN temp
 * 		ASSIGN command
 * 		IF
 * 			ASSIGN loopContinue = false;
 * 		END IF
 * END WHILE
 * 
 **/
package testers;
import java.util.Scanner;
import edu.miracosta.cs113.DoubleLinkedList;


public class StudentDatabaseDriver 
{
	/**
	 * driver for StudentDatabaseDriver
	 * 
	 * @param args
	 *            command line arguments (unnused)
	 */
	public static void main(String[] args) 
	{
		int command;
		String temp;
		Scanner keyboard = new Scanner(System.in);
		boolean loopContinue = true;
		DoubleLinkedList<Student> list = new DoubleLinkedList<Student>();
		printMenu();
		System.out.println("Please enter command");
		temp = keyboard.nextLine();
		command = Integer.parseInt(temp);
		if(command > 4 || command <= 0)
		{
			loopContinue = false;
		}
		
		while(loopContinue)
		{
			if(command == 1)
			{
				Student student  = getInfo(keyboard);
				list.add(student);
			}
			else if(command == 2)
			{
				Student student  = getInfo(keyboard);
				list.addFirst(student);
			}
			else if(command == 3)
			{
				list.removeFirst();
			}
			else if(command == 4)
			{
				System.out.println("Please enter student name");
				temp = keyboard.nextLine();
				list.remove(temp);
			}
			else if(command == 5)
			{
				for(int i = 0; i < list.size() ; i++)
				{
					System.out.println(list.get(i));
				}
			}
			else
			{
				System.out.println("Thank you for using our database, have a good day!");
				loopContinue = false;
			}
			printMenu();
			System.out.println("Please enter command");
			temp = keyboard.nextLine();
			command = Integer.parseInt(temp);
			if(command > 5 || command <= 0)
			{
				loopContinue = false;
			}
		}
		

	}
	/**
	 * printMenu prints the command menu given to the user
	 * 
	 * @return void
	 */
	public static void printMenu()
	{
		System.out.println("             Commands               ");
		System.out.println("------------------------------------");
		System.out.println("1. Add to end of the list");
		System.out.println("2. Add to the beginning of the list");
		System.out.println("3. Remove from the beginning of the list");
		System.out.println("4. Remove by name");
		System.out.println("5. View all students");
		System.out.println("6. End program");
		
	}
	/**
	 * getInfo(Scanner) gets the info of a Student object and initializes one 
	 * 
	 * @param keyboard
	 * 			Scanner object
	 * 
	 * @return Student 
	 */
	public static Student getInfo(Scanner keyboard)
	{
		Student student = new Student();
		System.out.println("Please enter student name");
		student.setName(keyboard.nextLine());
		System.out.println("Please enter student ID number");
		student.setIDNumber(keyboard.nextLine());
		System.out.println("Please enter student major");
		student.setMajor(keyboard.nextLine());
		System.out.println("Please enter student GPA (0-4.0) :");
		student.setGpa(keyboard.nextDouble());
		keyboard.nextLine();
		
		return student;
	}
	
	

}
