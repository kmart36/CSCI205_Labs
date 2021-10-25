/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2021
 * Instructor: Prof. Brian King
 *
 * Name: Katy Martinson and Phil Morgan
 * Section: 9:30am
 * Date: 10/22/2021
 * Time: 10:38 AM
 *
 * Project: csci205_labs
 * Package: lab09
 * Class: Board
 *
 * Description:
 * Board class
 * ****************************************
 */
package lab09;

public class Board {

    private final int BOARD_SIZE = 16;
    private final int MINES = 40;
    private Square[][] board;

    /**
     * The constructor for the Board
     */
    public Board() {
        board = new Square[BOARD_SIZE][BOARD_SIZE];
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = new Square();
            }
        }
    }

    /**
     * sets the Status of every Square in the board to NEW
     * @param size the total number of Squares in the board
     */
    public void resetBoard(int size) {
        for (Square[] row : board) {
            for (Square tile : row) {
                tile.changeStatus(Status.NEW);
            }
        }
    }

    /**
     * returns the Square at place (row, col) on the Board
     * @param row the number of the row
     * @param col the number  of the column
     * @return the Square at (row, col)
     */
    public Square getSquareAt(int row, int col) {
        return board[row][col];
    }
}
    


