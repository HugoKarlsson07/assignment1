import java.awt.*;

public abstract class Car implements Movable {
    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // Model of the car//

    private double x = 0;
    private double y = 0;
    private int direction = 0; // 0: North, 1:East, 2:South, #:West

    public Car(int nrDoors, double enginePower, Color color, String modelName) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        stopEngine();
    }

    // Getter methods
    public Color getColor() {
        return color;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }
    public int getNrDoors() {
        return nrDoors;
    }
    public double getEnginePower() {
        return enginePower;
    }

    // Set methods
    public void setColor(Color clr) {
        color = clr;
    }

    public void startEngine() {
        currentSpeed = 0.1;
    }

    public void stopEngine() {
        currentSpeed = 0;
    }

    //abstract method that is unique for evry sub-klass of car, because it's calculated using different math, since Saab has turbo
    public abstract double speedFactor();

    private void setCurrentSpeed(double speed) {
        if (speed < 0) {
            currentSpeed = 0;
        } else if (speed > enginePower) {
            currentSpeed = enginePower;
        } else {
            currentSpeed = speed;
        }
    }
    public void gas(double amount){
        if (amount >= 0 && amount <= 1) {
            double newSpeed = getCurrentSpeed() + speedFactor() * amount;
            setCurrentSpeed(newSpeed);
        }
    }
    public void brake(double amount) {
        if (amount >= 0 && amount <=1){
            double newSpeed = getCurrentSpeed() - speedFactor() * amount;
            setCurrentSpeed(newSpeed);
        };
    }

    // Movable implementation
    @Override
    public void move() {
        switch (direction) {
            case 0: y += currentSpeed; break; // North
            case 1: x += currentSpeed; break; // East
            case 2: y -= currentSpeed; break; // South
            case 3: x -= currentSpeed; break; // West
        }
    }

    @Override
    public void turnLeft() {
        direction = (direction + 3) % 4;
    }

    @Override
    public void turnRight() {
        direction = (direction + 1) % 4;
    }
}
