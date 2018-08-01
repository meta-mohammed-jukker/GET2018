package session9;

import java.time.*;

public class Square implements Shape
{
    int shapeID;
    Point origin;
    double side;
    ShapeType shapeType;
    LocalDate timestamp;
    
    /**
     * Initializes square
     * @param origin bottom leftmost point of square
     * @param side side of square
     */
    Square(Point origin, double side)
    {
        this.origin = origin;
        this.side = side;
        shapeType = ShapeType.SQUARE;
    }

    /**
     * Returns area of square
     */
    @Override
    public double getArea()
    {
        return (side*side);
    }

    /**
     * Returns perimeter of square
     */
    @Override
    public double getPerimeter()
    {
        return (4*side);
    }

    /**
     * Returns origin of the square
     */
    @Override
    public Point getOrigin()
    {
        return origin;
    }

    /**
     * Checks if point lies in the square
     */
    @Override
    public boolean isPointEnclosed(Point point)
    {
        if(point.getXCoordinate() >= origin.getXCoordinate() 
                && point.getXCoordinate() <= (origin.getXCoordinate() + side)
                    && point.getYCoordinate() >= origin.getYCoordinate() 
                        && point.getYCoordinate() <= (origin.getYCoordinate() + side))
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
