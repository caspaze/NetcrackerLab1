package Contracts;

public class InternetContract extends Contract{
    /**
     * Property - speed of the internet
     */
    private double connectionSpeed;
    /**
     * @return current value of the connectionSpeed
     */
    public double getConnectionSpeed() {
        return connectionSpeed;
    }
    /**
     * Changes the connectionSpeed value to the passed value
     * @param connectionSpeed - new value of the connectionSpeed
     */
    public void setConnectionSpeed(double connectionSpeed) {
        this.connectionSpeed = connectionSpeed;
    }
}
