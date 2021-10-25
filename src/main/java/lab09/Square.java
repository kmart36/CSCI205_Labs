/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2021
 * Instructor: Prof. Brian King
 *
 * Name: Katy Martinson and Phil Morgan
 * Section: 9:30am
 * Date: 10/20/2021
 * Time: 10:36 AM
 *
 * Project: csci205_labs
 * Package: lab09
 * Class: Square
 *
 * Description:
 * A class representing a Square object used for Minesweeper
 * ****************************************
 */
package lab09;

public class Square {
    private boolean hasFlag;
    private boolean hasMine;
    private int adjMineCount;
    private Status status;

    /**
     * Constructor for the Square
     */
    public Square() {
        hasFlag = false;
        hasMine = false;
        adjMineCount = 0;
        status = Status.NEW;
    }

    public boolean isMine() { return hasMine; }

    public boolean isFlagged() { return this.hasFlag; }

    public Status getStatus() { return status; }

    /**
     * Changes the state of a Square from flagged to unflagged or vice versa
     */
    public void flag() {
        if (hasFlag)
            hasFlag = false;
        else
            hasFlag = true;
    }

    /**
     * A click method that allows a state change for the square that is clicked.
     * @return the number of adjacent bombs around the clicked square
     */
   public int click() {
        if (this.status.equals(Status.COVERED)) {
            this.status = Status.UNCOVERED;
        }
        return adjMineCount;
   }

    /**
     * Changes the Status of the Square to s
     * @param s A Status enumeration
     */
   public void changeStatus(Status s) {
        status = s;
   }

    /**
     * Increments the number of mines adjacent to the specific square
     */
   public void addToMineCount() {
        adjMineCount++;
   }

    /**
     * Tries to make a mine in the Square
     * @return int - either 1 if a mine was created in the Square or 0 if there was
     * already a mine in the Square
     */
   public int makeMine() {
        if (!hasMine) {
            hasMine = true;
            return 1;
        }
        else
            return 0;
   }
}