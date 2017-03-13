/**
 * Print.java : this program prints printJobs with three different options
 * 
 * @author Sina Dalir
 * @version 1.0
 *
 */

/**
 * ALGORITHM:
 * DECLARE & INITIALIZE Scanner keyboard
 * DECLARE & INITIALIZE Scanner smallPrinter 
 * DECLARE & INITIALIZE Scanner mediumPrinter
 * DECLARE & INITIALIZE Scanner largePrinter
 * DECLARE i , printeNum, jobNum
 * PRINT "Hello Welcome to the Printer Program"
 * PRINT "Please enter the number of printer you would like (1-3 only) :"
 * CALL printerNum = keyboard.nextInt();
 * PRINT "Please enter the number of print job : "
 * CALL jobsNum = keyboard.nextInt();
 * CALL keyboard.close();
 * DECLARE & INITIALIZE int[] jobs = new int[jobsNum];
 * FOR 
 * 		DECLARE jobs[x] = (int)(Math.random() * 50 + 1);
 * END FOR
 * IF
 * 		DO
 * 			IF
 * 				DECLARE & INITIALIZE job to new PrintJob(jobs[i], Printer.getCurrentTime())
 *				CALL smallPrinter.addJob(job)
 *				PRINT "Added" + job + " to Small Printer"
 *			END IF
 *			CALL smallPrinter.tick()
 *			CALL Printer.updateTime()
 *			CALL i++
 *		END DO WHILE
 *		PRINT  Printer.getCurrentTime() , printerNum 
 * END IF
 * ELSE IF
 * 		DO
 * 			IF
 * 				DECLARE & INITIALIZE job to new PrintJob(jobs[i], Printer.getCurrentTime())
 * 				IF
 *					CALL smallPrinter.addJob(job)
 *					PRINT "Added" + job + " to Small Printer"
 *				END IF
 *				IF
 *					CALL mediumPrinter.addJob(job)
 *					PRINT "Added" + job + " to Medium Printer"
 *				END IF
 *			END IF
 *			CALL smallPrinter.tick()
 *			CALL mediumPrinter.tick()
 *			CALL Printer.updateTime()
 *			CALL i++
 *		END DO WHILE
 *		PRINT  Printer.getCurrentTime() , printerNum 
 * END IF
 * ELSE IF
 * 		DO
 * 			IF
 * 				DECLARE & INITIALIZE job to new PrintJob(jobs[i], Printer.getCurrentTime())
 * 				IF
 *					CALL smallPrinter.addJob(job)
 *					PRINT "Added" + job + " to Small Printer"
 *				END IF
 *				IF
 *					CALL mediumPrinter.addJob(job)
 *					PRINT "Added" + job + " to Medium Printer"
 *				END IF
 *				IF
 *					CALL largePrinter.addJob(job)
 *					PRINT "Added" + job + " to Large Printer"
 *				END IF
 *			END IF
 *			CALL smallPrinter.tick()
 *			CALL mediumPrinter.tick()
  *			CALL largePrinter.tick()
 *			CALL Printer.updateTime()
 *			CALL i++
 *		END DO WHILE
 *		PRINT  Printer.getCurrentTime() , printerNum 
 * END IF
 * ELSE
 * 		PRINT "Wrong number of printers!"
 **/
package edu.miracosta.cs113;
import java.util.Scanner;

public class Print 
{

	public static void main(String[] args) 
	{
		Scanner keyboard  = new Scanner(System.in);
		Printer smallPrinter = new Printer("Small Printer", 0 , 10);
		Printer mediumPrinter = new Printer("Medium Printer", 10, 20);
		Printer largePrinter = new Printer("Large Printer", 20, 1000);
		int i = 0;
		int printerNum;
		int jobsNum;
		System.out.println("Hello Welcome to the Printer Program");
		System.out.print("Please enter the number of printer you would like (1-3 only) :");
		printerNum = keyboard.nextInt();
		System.out.print("Please enter the number of print job : ");
		jobsNum = keyboard.nextInt();
		keyboard.close();
		int[] jobs = new int[jobsNum];
		for(int x  = 0 ; x < jobs.length ; x++)
		{
			jobs[x] = (int)(Math.random() * 50 + 1);
		}
		
		if(printerNum == 1)
		{
			do
			{
				if(i < jobs.length )
				{
					PrintJob job = new PrintJob(jobs[i], Printer.getCurrentTime());
					smallPrinter.addJob(job);
					System.out.println("\nAdded" + job + " to Small Printer");
				}
				
				smallPrinter.tick();
				Printer.updateTime();
				i++;
				
			}while(!smallPrinter.getJobs().isEmpty());
			

			System.out.println("All of the print jobs took " + Printer.getCurrentTime() + " with " + printerNum + " printers!");
		}
		else if(printerNum == 2)
		{
			do
			{
				if(i < jobs.length )
				{
					PrintJob job = new PrintJob(jobs[i], Printer.getCurrentTime());
					if(jobs[i] <= smallPrinter.getUpper() && jobs[i] > smallPrinter.getLower())
					{
						smallPrinter.addJob(job);
						System.out.println("\nAdded" + job + " to Small Printer");
						
					}
					else if(jobs[i] > mediumPrinter.getLower())
					{
						mediumPrinter.addJob(job);
						System.out.println("\nAdded" + job + " to Medium Printer");
					}
				}
			
				smallPrinter.tick();
				mediumPrinter.tick();
				Printer.updateTime();
				i++;
			
			}while(!smallPrinter.getJobs().isEmpty() || !mediumPrinter.getJobs().isEmpty());
		

			System.out.println("\nAll of the print jobs took " + Printer.getCurrentTime() + " with " + printerNum + " printers!");
		}
		else if(printerNum == 3)
		{
			do
			{
				if(i < jobs.length )
				{
					PrintJob job = new PrintJob(jobs[i], Printer.getCurrentTime());
					if(jobs[i] <= smallPrinter.getUpper() && jobs[i] > smallPrinter.getLower())
					{
						smallPrinter.addJob(job);
						System.out.println("\nAdded" + job + " to Small Printer");
						
					}
					else if(jobs[i] <= mediumPrinter.getUpper() && jobs[i] > mediumPrinter.getLower())
					{
						mediumPrinter.addJob(job);
						System.out.println("\nAdded" + job + " to Medium Printer");
	
					}
					else
					{
						largePrinter.addJob(job);
						System.out.println("\nAdded" + job + " to Large Printer");
					}
				}
				
				smallPrinter.tick();
				mediumPrinter.tick();
				largePrinter.tick();
				Printer.updateTime();
				i++;
				
			}while(!smallPrinter.getJobs().isEmpty() || !mediumPrinter.getJobs().isEmpty() ||!largePrinter.getJobs().isEmpty());
		

			System.out.println("\nAll of the print jobs took " + Printer.getCurrentTime());
		}
		else
		{
			System.out.println("\nWrong number of printers!");
		}
	}
		

}
