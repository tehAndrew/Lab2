/* Car.java
 * 2019-01-31
 */

import java.awt.*;


/**
 *  This is an abstract representation of a functional car that can move around in 2D-space.
 *  This abstract class implements the <tt>Movable</tt> interface in order to move and turn
 *  the car.
 *
 * @see Saab95
 * @see Volvo240
 * @see Movable
 *
 * @author Seif Bourogaa
 * @author Andreas Palmqvist
 * @author Simon Lindeberg Skoglund
 */
public abstract class Car implements Movable {
    /**
     *  The x-coordinate of the car.
     */
    protected double x;
    /**
     *  The y-coordinate of the car.
     */
    protected double y;
    /**
     *  The direction in which the car is facing, measured using radians.
     */
    protected double direction;
    /**
     *  Current speed of the car.
     */
    protected double currentSpeed;
    /**
     *  Number of doors on the car.
     */
    protected int nrDoors;
    /**
     *  Engine power of the car.
     */
    protected double enginePower;
    /**
     * Color of the car.
     */
    protected Color color;
    /**
     *  Model name of the car.
     */
    protected String modelName;


    /**
     *  Constructs a car with a number of doors, engine power, color and model name specified.
     *  Sets the car default position to (0, 0) and its direction to 0.
     *
     * @param nrDoors is the number of doors on the car
     *
     * @param enginePower is the horsepower on the car
     *
     * @param color is the color of the car
     *
     * @param modelName is the model name of the car
     */
    public Car(int nrDoors, double enginePower, Color color, String modelName){
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        x = 0;
        y = 0;
        direction = 0;
        stopEngine();
    }

    /**
     * Returns the x-coordinates
     *
     * @return  the x-coordinates
     */
    public double getX(){
        return x;
    }

    /**
     * Returns the y-coordinates.
     *
     * @return  the y-coordinates
     */
    public double getY(){
        return y;
    }

    /**
     * Returns the directing the car is facing, in radians.
     *
     */
    public double getDirection(){
        return direction;
    }

    /**
     * Returns the current speed.
     *
     * @return  the current speed
     */
    public double getCurrentSpeed(){
        return currentSpeed;
    }

    /**
     * Returns the number of doors on the car.
     *
     * @return  the number of doors on the car
     */
    public int getNrDoors(){
        return nrDoors;
    }

    /**
     * Returns the engine power of the car.
     *
     * @return  the engine power of the car
     */
    public double getEnginePower(){
        return enginePower;
    }


    /**
     * Returns the color of the car.
     *
     * @return  the color of the car
     */
    public Color getColor(){
        return color;
    }

    /**
     * Returns the model name of the car.
     *
     * @return  the model name of the car
     */
    public String getModelName(){
        return  modelName;
    }

    /**
     * Set the car to a specified color.
     *
     * @param color the new car color
     */
    public void setColor(Color color){
        this.color = color;
    }

    /**
     * Starts the engine by setting the current car speed to 0.1.
     */
    public void startEngine(){
        currentSpeed = 0.1;
    }

    /**
     *  Stops the engine by setting the current car speed to 0.0.
     */
    public void stopEngine(){
        currentSpeed = 0;
    }


    /**
     * Increase the current speed with a specified amount. This method
     * is implemented in the subclasses of this class.
     *
     * @param amount the amount to increase the speed by
     * @see Volvo240
     * @see Saab95
     */

    public abstract void incrementSpeed(double amount);

    /**
     * Decrease the current speed with a specified amount. This method
     * is implemented in the subclasses of this class.
     *
     * @param amount the amount to decrease the speed by
     * @see Volvo240
     * @see Saab95
     */
    public abstract void decrementSpeed(double amount);

    /**
     * Use <tt>incrementSpeed</tt> to increase the current speed by a specified amount, as long
     * as the amount is in the interval [0, 1],
     *
     * @param amount the amount to increase the speed by
     * @see #incrementSpeed(double)
     */
    public void gas(double amount){
        incrementSpeed(Math.min(Math.max(0,amount), 1));
    }

    /**
     * Use <tt>decrementSpeed</tt> to decrease the current speed by a specified amount, as long
     * as the amount is in the interval [0, 1].
     *
     * @param amount the amount to decrease the speed by
     * @see #decrementSpeed(double)
     */
    public void brake(double amount){
        decrementSpeed(Math.min(Math.max(0, amount), 1));
    }

    /**
     * Calculate the x- and y-coordinates of the directions vector multiplied by the current speed. The
     * resulting coordinates are added to position of the car.
     *
     */
    public void move(){
        x += Math.cos(direction) * currentSpeed;
        y += Math.sin(direction) * currentSpeed;
    }

    /**
     * Increases the direction of the car by a specified angle, simulating a left turn in 2D-space.
     *
     * @param angle the angle by which to turn the car left, the unit for the angle is radians.
     */
    public void turnLeft(double angle) {

        if(currentSpeed > 0){
            direction += angle;
        }
    }

    /**
     * Increases the direction of the car by a specified angle, simulating a right turn in 2D-space.
     *
     * @param angle the angle by which to turn the car right, the unit for the angle is radians.
     */
    public void turnRight(double angle){
        if(currentSpeed > 0){
            direction -= angle;
        }
    }

}