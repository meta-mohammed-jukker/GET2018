package session9;

public class ShapeUtil
{
    /**
     * Returns distance between 2 points
     * @param point1 first point
     * @param point2 second point
     * @return distance between 2 points
     */
    double getDistance(Point point1, Point point2)
    {
        return (Math.sqrt((point1.getXCoordinate() - point2.getXCoordinate()) * 
                          (point1.getXCoordinate() - point2.getXCoordinate()) +
                          (point1.getYCoordinate() - point2.getYCoordinate()) * 
                          (point1.getYCoordinate() - point2.getYCoordinate())));
    }
}
