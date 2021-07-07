package session9;

import java.time.*;

public class Rectangle implements Shape
{
    int shapeID;
    Point origin;
    double height;
    double width;
    ShapeType shapeType;
    LocalDate timestamp;
    
    /**
     * Initializes rectangle
     * @param origin bottom leftmost point of rectangle
     * @param height height of rectangle
     * @param width width of rectangle
     */
    Rectangle(Point origin, double height, double width)
    {
        this.origin = origin;
        this.height = height;
        this.width = width;
        this.shapeType = ShapeType.RECTANGLE;
    }

    /**
     * Returns area of rectangle
     */
    @Override
    public double getArea()
    {
        return (height * width);
    }

    /**
     * Returns perimeter of rectangle
     */
    @Override
    public double getPerimeter()
    {
        return (2 * (height + width));
    }

    /**
     * Returns origin of the rectangle
     */
    @Override
    public Point getOrigin()
    {
        return origin;
    }

    /**
     * Checks if point lies in the triangle
     */
    @Override
    public boolean isPointEnclosed(Point point)
    {
        if(point.getXCoordinate() >= origin.getXCoordinate() 
                && point.getXCoordinate() <= (origin.getXCoordinate() + width)
                    && point.getYCoordinate() >= origin.getYCoordinate() 
                        && point.getYCoordinate() <= (origin.getYCoordinate() + height))
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
