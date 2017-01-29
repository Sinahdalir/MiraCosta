/**
 * DetectiveJill.java : Least possible guess solver for the Clue problem
 * 
 * @author Sina Dalir
 * @version 1.0
 *
 */

/**
 * ALGORITHM:
 * DECLARE int asnwerSet, solution, murder, weapon, location
 * DECLARE And INITIALIZE Scanner 
 * INITIALIZE answer
 * DECLARE AssistantJack jack
 * PRINT "Which theory would like you like to test? (1, 2, 3[random]): "
 * ASSIGN answer =  keyboard.nextInt() 
 * CALL keyboard.close()
 * INITIALIZE murder
 * INITIALIZE location
 * INITIALIZE weapon
 * ASSIGN jack = new AssistantJack(answerSet)
 * DECLARE & INITIALIZE random = new Random();
 * DO
 * 		ASSIGN solution = jack.checkAnswer(weapon, location, murder)
 * 		SWITCH
 * 				Case 1 ASSIGN weapon
 * 				Case 2 ASSIGN location
 *  			Case 3 ASSIGN murder
 *  			default
 *  WHILE 
 *  ASSIGN answer = new Theory(weapon, location, murder)
 *  CALL jack.getTimesAsked() & PRINT answer
 *  IF
 *  	PRINT "FAILED!! You're a horrible Detective..."
 *  ELSE IF
 *  	PRINT "WOW! You might as well be called Batman!"
 **/
package edu.miracosta.cs113;
import hw01.Files.AssistantJack;
import hw01.Files.Theory;

import java.util.Scanner;

public class DetectiveJill {

	/**
	 * Tester for random assistant theory checker
	 * 
	 * @param args
	 *            command line arguments (unnused)
	 */
	public static void main(String[] args) {
		int answerSet, solution, murder, weapon, location;
		Scanner keyboard = new Scanner(System.in);
		Theory answer = null;
		AssistantJack jack;

		System.out.print("Which theory would like you like to test? (1, 2, 3[random]): ");
		answerSet = keyboard.nextInt();
		keyboard.close();
		murder = 6;
		weapon = 6;
		location = 10;
		jack = new AssistantJack(answerSet);

		

		do {
			
			solution = jack.checkAnswer(weapon, location, murder);
			switch (solution) {
            case 1:  weapon = weapon - 1;
                     break;
            case 2:  location = location - 1;
                     break;
            case 3:  murder = murder - 1;
                     break;
            default: ;
            break;
			}

		} while (solution != 0);
		answer = new Theory(weapon, location, murder);
		System.out.println("Total Checks = " + jack.getTimesAsked() + ", Solution = " + answer);

		if (jack.getTimesAsked() > 20) {
			System.out.println("FAILED!! You're a horrible Detective...");
		} else {
			System.out.println("WOW! You might as well be called Batman!");
		}

	}

}


