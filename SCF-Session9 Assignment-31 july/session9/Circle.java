package session9;

import java.time.*;

public class Circle implements Shape
{
    int shapeID;
    Point center;
    double radius;
    ShapeType shapeType;
    LocalDate timestamp;
    
    /**
     * Initializes circle
     * @param center coordinates of center of circle
     * @param radius length of radius of circle
     */
    Circle(Point center, double radius)
    {
        this.center = center;
        this.radius = radius;
        this.shapeType = ShapeType.CIRCLE;
    }
    
    /**
     * Returns area of circle
     */
    @Override
    public double getArea()
    {
        return (PI * radius * radius);
    }
    
    /**
     * Returns perimeter of circle
     */
    @Override
    public double getPerimeter()
    {
        return (2 * PI * radius);
    }
    
    /**
     * Returns origin of the circle
     */
    @Override
    public Point getOrigin()
    {
        ShapeUtil shapeUtil = new ShapeUtil();
        Point actualOrigin = new Point(0, 0);
        double distanceBetweenActualOriginAndCenter = shapeUtil.getDistance(center, actualOrigin);
        double originXCoordinate = center.getXCoordinate() + 
                                  (((actualOrigin.getXCoordinate() - center.getXCoordinate()) 
                                          * radius)
                                          /distanceBetweenActualOriginAndCenter);
        double originYCoordinate = center.getYCoordinate() + 
                                  (((actualOrigin.getYCoordinate() - center.getYCoordinate()) 
                                          * radius)
                                          /distanceBetweenActualOriginAndCenter);
        return new Point(originXCoordinate, originYCoordinate);
    }
    
    /**
     * Checks if point lies in the circle
     */
    @Override
    public boolean isPointEnclosed(Point point)
    {
        ShapeUtil shapeUtil = new ShapeUtil();
        if(shapeUtil.getDistance(center, point) <= radius)
        {
            return true;
        }
        return false;
    }
    
    /**
     * Returns type of the shape
     */
    @Override
    public ShapeType getShapeType()
    {
        return shapeType;
    }
    
    /**
     * Sets timestamp at which shape is added to screen
     */
    @Override
    public void setTimestamp()
    {
        timestamp = LocalDate.now();
    }
    
    /**
     * Returns timestamp at which shape is added to screen
     */
    @Override
    public LocalDate getTimestamp()
    {
        return timestamp;
    }

}
