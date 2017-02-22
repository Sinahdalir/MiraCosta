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
 * *		ELSE IF
 *			CALL list.removeLast();
 *		ELSE IF
 *			PRINT"Please enter student number"
 *			ASSIGN temp = keyboard.nextLine();
 *			ASSING int j = Integer.parseInt(temp)
 *			CALL list.remove(j);
 * 		ELSE IF
 *			PRINT"Please enter student info"
 *			CAll getInfo()
 *			CALL list.remove(student);
 *		ELSE IF
 *			FOR
 *				PRINT list.get(i)
 * 		ELSE IF
 *				CALL list.Clear()
 * 		ELSE IF
 *				PRINT list.size()
 *		ELSE IF
 *			PRINT"Please enter student info"
 * 			ASSIGN temp = keyboard.nextLine();
 *			ASSING int j = Integer.parseInt(temp)
 *			CAll getInfo()
 *			CALL list.set(j, student);
 *		ELSE IF
 *			PRINT"Please enter student info"
 * 			ASSIGN temp = keyboard.nextLine();
 *			CAll getInfo()
 *			CALL list.indexOf(student);
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

//Tested DoubleLinkedList's methods with this tester and all worked well 
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
		if(command > 12 || command <= 0)
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
				list.removeLast();
			}
			else if(command == 5)
			{
				int i;
				System.out.println("Please enter student number on list");
				temp = keyboard.nextLine();
				i = Integer.parseInt(temp);
				list.remove(i - 1);
			}
			else if(command == 6)
			{
				System.out.println("Please enter student info to remove");
				Student student = getInfo(keyboard);				
				list.remove(student);
			}
			else if(command == 7)
			{
				for(int i = 0; i < list.size() ; i++)
				{
					System.out.println(list.get(i));
				}
			}
			else if(command == 8)
			{
				list.clear();
			}
			else if(command == 9)
			{
				System.out.println("The size of list is " + list.size());
			}
			else if(command == 10)
			{
				System.out.println("Please enter student list number to change");
				temp = keyboard.nextLine();
				int j = Integer.parseInt(temp);
				Student student = getInfo(keyboard);				
				list.set(j - 1, student);
			}
			else if(command == 11)
			{
				if(list.isEmpty())
				{
					System.out.println("The list is empty!");
				}
				else 
				{
					System.out.println("The list is NOT empty!");
				}
			}
			else if(command == 12)
			{
				System.out.println("Please enter student info to find number on list");
				Student student = getInfo(keyboard);				
				if(list.indexOf(student) >= 0)
				{
					System.out.println("The numbe of stundent on list is " + (list.indexOf(student) + 1));
				}
				else
				{
					System.out.println("Student not on list");
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
			if(command > 12 || command <= 0)
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
		System.out.println("4. Remove from the end of the list");
		System.out.println("5. Remove by number on list");
		System.out.println("6. Remove by student info");
		System.out.println("7. View all students");
		System.out.println("8. Clear list");
		System.out.println("9. Get size");
		System.out.println("10. Change Info");
		System.out.println("11. Is list empty");
		System.out.println("12. Number of  a student on list");
		System.out.println("13. End program");
		
		
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
