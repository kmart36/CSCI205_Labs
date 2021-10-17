/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2021
 * Instructor: Prof. Brian King
 *
 * Name: Katy Martinson and Phil Morgan
 * Section: 9:30am
 * Date: 10/13/2021
 * Time: 9:58 AM
 *
 * Project: csci205_labs
 * Package: lab07
 * Class: Car
 *
 * Description:
 *
 * ****************************************
 */
package lab07;

import java.util.Scanner;

public class Car {
    private double mpg;
    private int cylinders;
    private double displacement;
    private double horsepower;
    private double weight;
    private double accel;
    private int modelYear;
    private int origin;
    private String carName;

    public Car(String csvRecord) {
        Scanner stringScnr = new Scanner(csvRecord).useDelimiter(",");
        mpg = stringScnr.nextDouble();
        cylinders = stringScnr.nextInt();
        displacement = stringScnr.nextDouble();
        String temp = stringScnr.next();
        if (temp.equals("?")) {
            horsepower = 0.0;
        }
        else {
            horsepower = Double.parseDouble(temp);
        }
        weight = stringScnr.nextDouble();
        accel = stringScnr.nextDouble();
        modelYear = stringScnr.nextInt();
        origin = stringScnr.nextInt();
        carName = stringScnr.next();
    }

    public double getMpg() { return mpg; }

    public int getCylinders() { return cylinders; }

    public double getDisplacement() { return displacement; }

    public double getHorsepower() { return horsepower; }

    public double getWeight() { return weight; }

    public int getModelYear() { return modelYear; }

    public int getOrigin() { return origin; }

    public String getCarName() { return carName; }
}