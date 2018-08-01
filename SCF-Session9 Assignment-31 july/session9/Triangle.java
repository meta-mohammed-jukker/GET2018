package session9;

import java.time.*;

public class Triangle implements Shape
{
    int shapeID;
    Point origin;
    double height;
    double base;
    double sideWithPositiveSlope;
    double sideWithNegetiveSlope;
    ShapeType shapeType;
    LocalDate timestamp;
    
    /**
     * Initializes triangle
     * @param origin bottom leftmost point of triangle
     * @param height height  of triangle
     * @param base base of triangle
     * @param sideWithPositiveSlope side of triangle with positive slope 
     * @param sideWithNegetiveSlope side of triangle with negative slope
     */
    Triangle(Point origin, double height, double base, 
            double sideWithPositiveSlope, double sideWithNegetiveSlope)
    {
        this.origin = origin;
        this.height = height;
        this.base = base;
        this.sideWithPositiveSlope = sideWithPositiveSlope;
        this.sideWithNegetiveSlope = sideWithNegetiveSlope;
        this.shapeType = ShapeType.TRIANGLE;
    }

    /**
     * Returns area of triangle
     */
    @Override
    public double getArea()
    {
        return (0.5 * base * height);
    }

    /**
     * Returns perimeter of triangle
     */
    @Override
    public double getPerimeter()
    {
        return (base + sideWithPositiveSlope + sideWithNegetiveSlope);
    }

    /**
     * Returns origin of the triangle
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
        Point firstVertex = getFirstPoint();
        Point secondVertex = getSecondPoint();
        if(getArea() == (getAreaWithVertices(point, origin, firstVertex) +
                         getAreaWithVertices(point, origin, secondVertex) +
                         getAreaWithVertices(point, firstVertex, secondVertex)))
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
    
    Point getFirstPoint()
    {
        double yCoordinate = origin.yCoordinate + height;
        
        double xCoordinate =
                Math.sqrt(Math.pow(sideWithPositiveSlope, 2) - Math.pow(height, 2));
        
        return new Point(xCoordinate, yCoordinate);
        
    }
    
    Point getSecondPoint()
    {
        return new Point((origin.getXCoordinate() + base), origin.getYCoordinate());
    }
    
    double getAreaWithVertices(Point point1, Point point2, Point point3)
    {
        double area;
        area = Math.abs(
                (point1.getXCoordinate() * (point2.getYCoordinate() - point3.getYCoordinate()) +
                 point2.getXCoordinate() * (point3.getYCoordinate() - point1.getYCoordinate()) +
                 point3.getXCoordinate() * (point1.getYCoordinate() - point2.getYCoordinate()))
                 / 2);
        return area;
    }
    

}
