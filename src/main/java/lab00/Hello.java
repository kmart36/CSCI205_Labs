/* *****************************************
* CSCI205 - Software Engineering and Design
* Fall 2021
* Instructor: Brian King
* Section: 02 - 9:50am
*
* Name: Katy Martinson
* Date: 9/2/2021
*
* Lab / Assignment: lab00
*
* Description:
* A "Hello world" java program.
* *****************************************/

package lab00;

public class Hello {
    public static void main( String[] args ) {
      long start = System.nanoTime();
      System.out.println("Programming is not a spectator sport!");
      System.out.printf("Time to execute: %.4f ms", (System.nanoTime() - start) / 1e+6);
      System.exit(0);
    }
}
