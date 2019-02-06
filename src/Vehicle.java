/* Vehicle.java
 * 2019-01-31
 */

import java.awt.*;


/**
 *  This is an abstract representation of a functional vehicle that can move around in 2D-space.
 *  This abstract class implements the <tt>Movable</tt> interface in order to move and turn
 *  the vehicle.
 *
 * @see Saab95
 * @see Volvo240
 * @see Movable
 *
 * @author Seif Bourogaa
 * @author Andreas Palmqvist
 * @author Simon Lindeberg Skoglund
 */
public abstract class Vehicle implements Movable {
    /**
     *  The x-coordinate of the vehicle.
     */
    protected double x;
    /**
     *  The y-coordinate of the vehicle.
     */
    protected double y;
    /**
     *  The direction in which the vehicle is facing, measured using radians.
     */
    protected double direction;
    /**
     *  Current speed of the vehicle.
     */
    protected double currentSpeed;
    /**
     *  Number of doors on the vehicle.
     */
    protected int nrDoors;
    /**
     *  Engine power of the vehicle.
     */
    protected double enginePower;
    /**
     * Color of the vehicle.
     */
    protected Color color;
    /**
     *  Model name of the vehicle.
     */
    protected String modelName;


    /**
     *  Constructs a vehicle with a number of doors, engine power, color and model name specified.
     *  Sets the vehicle default position to (0, 0) and its direction to 0.
     *
     * @param nrDoors is the number of doors on the vehicle
     *
     * @param enginePower is the horsepower on the vehicle
     *
     * @param color is the color of the vehicle
     *
     * @param modelName is the model name of the vehicle
     */
    public Vehicle(int nrDoors, double enginePower, Color color, String modelName){
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
     * Returns the directing the vehicle is facing, in radians.
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
     * Returns the number of doors on the vehicle.
     *
     * @return  the number of doors on the vehicle
     */
    public int getNrDoors(){
        return nrDoors;
    }

    /**
     * Returns the engine power of the vehicle.
     *
     * @return  the engine power of the vehicle
     */
    public double getEnginePower(){
        return enginePower;
    }


    /**
     * Returns the color of the vehicle.
     *
     * @return  the color of the vehicle
     */
    public Color getColor(){
        return color;
    }

    /**
     * Returns the model name of the vehicle.
     *
     * @return  the model name of the vehicle
     */
    public String getModelName(){
        return  modelName;
    }

    /**
     * Set the vehicle to a specified color.
     *
     * @param color the new vehicle color
     */
    public void setColor(Color color){
        this.color = color;
    }

    /**
     * Starts the engine by setting the current vehicle speed to 0.1.
     */
    public void startEngine(){
        currentSpeed = 0.1;
    }

    /**
     *  Stops the engine by setting the current vehicle speed to 0.0.
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
     * resulting coordinates are added to position of the vehicle.
     *
     */
    public void move(){
        x += Math.cos(direction) * currentSpeed;
        y += Math.sin(direction) * currentSpeed;
    }

    /**
     * Increases the direction of the vehicle by a specified angle, simulating a left turn in 2D-space.
     *
     * @param angle the angle by which to turn the vehicle left, the unit for the angle is radians.
     */
    public void turnLeft(double angle) {

        if(currentSpeed > 0){
            direction += angle;
        }
    }

    /**
     * Increases the direction of the vehicle by a specified angle, simulating a right turn in 2D-space.
     *
     * @param angle the angle by which to turn the vehicle right, the unit for the angle is radians.
     */
    public void turnRight(double angle){
        if(currentSpeed > 0){
            direction -= angle;
        }
    }

}