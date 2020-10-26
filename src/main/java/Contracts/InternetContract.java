package Contracts;

public class InternetContract extends Contract{
    private double connectionSpeed;

    public double getConnectionSpeed() {
        return connectionSpeed;
    }

    public void setConnectionSpeed(double connectionSpeed) {
        this.connectionSpeed = connectionSpeed;
    }
}
