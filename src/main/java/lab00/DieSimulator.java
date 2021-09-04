/* *****************************************
* CSCI205 - Software Engineering and Design
* Fall 2021
* Instructor: Brian King
* Section: 02 - 9:50am
*
* Name: Katy Martinson
* Date: 9/4/2021
*
* Lab / Assignment: lab00
*
* Description:
* A Dice simulation program.
* *****************************************/

package lab00;

import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class DieSimulator {

  public static Random rng;
  public static final int MAX_ROLLS = 1000000;

  private static int askUserForBiasedFaceValue(Scanner scnr) {
    System.out.println("Which face value is biased?");
    int value = scnr.nextInt();
    while (value < 1 || value > 6) {
      System.out.println("Enter a value 1-6 only!\nWhich face value is biased?");
      value = scnr.nextInt();
    }
    return value;
  }

  private static double askUserForProbability(Scanner scnr) {
    System.out.println("Probability of this value: ");
    double prob = scnr.nextDouble();
    while (prob < 0 || prob > 1) {
      System.out.println("Enter a value between 0.0 and 1.0!\nProbability of this value: ");
      prob = scnr.nextDouble();
    }
    return prob;
  }

  public static void main(String[] args) {
    rng = new Random(1000);
    Scanner scnr = new Scanner(System.in);
    // Ask the user for the face value of the die to be biased
    int biasedFaceValue = askUserForBiasedFaceValue(scnr);
    // Ask the user for the probability of that face value
    double probability = askUserForProbability(scnr);
    // Now, write the loop to simulate rolling MAX_ROLLS times!
    long total = 0;
    double probRoll;
    double avg = 0;
    int[] otherVals = new int[5];
    for (int i = 1; i < 6; ++i) {
      if (i < biasedFaceValue || i == 1) {
        otherVals[i - 1] = i;
      }
      else if (i + 1 > biasedFaceValue) {
        otherVals[i - 2] = i + 1;
      }
    }
    for (int i = 0; i < MAX_ROLLS; ++i) {
      probRoll = rng.nextDouble();
      if (probRoll < probability) {
        total += biasedFaceValue;
      }
      else {
        total += otherVals[rng.nextInt(5)];
      }
    }
    avg = (double)total / (double)MAX_ROLLS;
    System.out.println("Average = " + avg);
    //for (i = 0; i < MAX_ROLLS; ++i) {
      //probRoll = rng.nextDouble();

      //}
  }

}
