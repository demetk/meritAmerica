/* File: KarelDefendsDemoncracy.java
 * Write a program that allows Karel to check which ballots have been punched
 * and remove any beepers from those ballots with a missing middle beeper.
 */

package week1;
import stanford.karel.*;

public class KarelDefendsDemocracy extends SuperKarel {

	public void run() {
		while (frontIsClear()) {
			checkBallot();
		}
	}
	
	/* Method to have Karel move into a ballot and check to see if it's been "punched"
	 * Pre-condition: Karel is to the west of the ballot, middle row, facing east
	 * Post-condition: Karel will be on the east side the ballot, middle row, facing east, 
	 * with the appropriate beepers removed.
	 */
		private void checkBallot() {
			move();
			if (!beepersPresent()) {
				clearBallot();
			} else {
				move();
			}
		}
		
		/* Method to have Karel remove all chads/beepers from ballots with
		 * no middle beeper.
		 * Pre-condition: Karol is inside the ballot, in the middle row, facing east,
		 * aware of which type of ballot we are dealing with.
		 * Post-condition: Karol is on the east side of the ballot, facing east, middle
		 * row, with all applicable beepers removed.
		 */
		private void clearBallot() {
			checkTop();
			checkBottom();
			exitBallot();
		}	
		
		/* Method to remove beepers present in the top half of the ballot
		 * Pre-condition: Karel is inside the ballot in the middle slot
		 * Post-condition: Karel will be at the top of the ballot facing north with
		 * applicable beepers removed
		 */
		private void checkTop() {
			turnLeft();
			move();
			while (beepersPresent()) {
				pickBeeper();
			} 
		}
		
		/* Method to remove beepers present in the bottom half of the ballot 
		 * Pre-condition: Karel is at the top of the ballot facing north
		 * Post-condition: Karel will be at the bottom of the ballot with all beepers
		 * removed that are supposed to be removed
		 */
		private void checkBottom() {
			turnAround();
			move();
			move();
			while (beepersPresent()) {
				pickBeeper();
			} 
		}
		
		/* Method to exit the ballot
		 * Pre-condition: Karel is at the bottom of the ballot facing south
		 * Post-condition: Karel will be on the east side of the ballot, facing east,
		 * in the same middle row that determines whether a ballot is punched or not.
		 */
		private void exitBallot() {
			turnAround();
			move();
			turnRight();
			move();
		}
	
		
}
