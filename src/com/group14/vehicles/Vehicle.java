package com.group14.vehicles;/* Vehicle.java
 * 2019-01-31
 */

import com.group14.misc.IMovable;
import com.group14.storage.IStorage;
import com.group14.storage.IStorable;

import java.awt.Color;

public abstract class Vehicle implements IMovable, IStorable {
    private double x;
    private double y;
    private double direction;
    protected double currentSpeed;
    private IStorage storedBy;
    private int nrDoors;
    private double enginePower;
    private Color color;
    private String modelName;
    private double length;
    private double width;

    public Vehicle(int nrDoors, double enginePower, Color color, String modelName, double length, double width){
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        this.length = length;
        this.width = width;
        x = 0;
        y = 0;
        direction = 0;
        storedBy = null;
        stopEngine();
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    public double getDirection(){
        return direction;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public int getNrDoors(){
        return nrDoors;
    }

    public double getEnginePower(){
        return enginePower;
    }

    public Color getColor(){
        return color;
    }

    public String getModelName(){
        return modelName;
    }

    public double getLength() { return length; }

    public double getWidth() { return width; }

    public void setX(double x) { this.x = x; }

    public void setY(double y){
        this.y = y;
    }

    public void setColor(Color color){
        this.color = color;
    }

    public void startEngine(){
        currentSpeed = 0.1;
    }

    public void stopEngine(){
        currentSpeed = 0;
    }

    public abstract void incrementSpeed(double amount);

    public abstract void decrementSpeed(double amount);

    public void gas(double amount){
        incrementSpeed(Math.min(Math.max(0,amount), 1));
    }

    public void brake(double amount){
        decrementSpeed(Math.min(Math.max(0, amount), 1));
    }

    // From IMovable

    public void move(){
        if (!isStored()) {
            x += Math.cos(direction) * currentSpeed;
            y += Math.sin(direction) * currentSpeed;
        } else if (storedBy instanceof Vehicle) {
            Vehicle vehicleStorage = (Vehicle) storedBy;
            x = vehicleStorage.getX();
            y = vehicleStorage.getY();
            direction = vehicleStorage.getDirection();
        }
    }

    public void turnLeft(double angle) {
        if(currentSpeed > 0 && !isStored()){
            direction += angle;
        }
    }

    public void turnRight(double angle){
        if(currentSpeed > 0 && !isStored()){
            direction -= angle;
        }
    }

    // From ITransportable

    public void setStorage(IStorage storage) {
        if (storage instanceof Vehicle && !isStored()) { storedBy = storage; }
    }

    public void unloadFromStorage() {
        if (isStored()) { storedBy = null; }
    }

    public boolean isStored() {
        return storedBy != null;
    }
}