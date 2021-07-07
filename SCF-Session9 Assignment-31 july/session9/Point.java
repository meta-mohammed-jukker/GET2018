package session9;

public class Point
{
    double xCoordinate;
    double yCoordinate;
    
    /**
     * Creates a point with x and y coordinates
     * @param xCoordinate x coordinate
     * @param yCoordinate y coordinate
     */
    Point(double xCoordinate, double yCoordinate)
    {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }
    
    /**
     * Returns x coordinate
     * @return x coordinate
     */
    double getXCoordinate()
    {
        return xCoordinate;
    }
    
    /**
     * Returns y coordinate
     * @return y coordinate
     */
    double getYCoordinate()
    {
        return yCoordinate;
    }
}
