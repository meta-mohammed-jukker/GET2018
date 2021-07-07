package session9;

import java.util.*;
import java.time.*;

public class Screen
{
    List<Shape> shapeList;
    double minimumXCoordinate;
    double maximumXCoordinate;
    double minimumYCoordinate;
    double maximumYCoordinate;
    
    /**
     * Initializes screen
     */
    Screen()
    {
        this.shapeList = new ArrayList<Shape>();
        this.minimumXCoordinate = 0;
        this.maximumXCoordinate = 1024;
        this.minimumYCoordinate = 0;
        this.maximumYCoordinate = 768;
    }
    
    /**
     * Adds shape object to screen and add timestamp
     * @param shape shape object that need to be added 
     */
    boolean addShape(Shape shape)
    {
        if(shape.getOrigin().getXCoordinate() >= minimumXCoordinate && 
           shape.getOrigin().getXCoordinate() <= maximumXCoordinate && 
           shape.getOrigin().getYCoordinate() >= minimumYCoordinate && 
           shape.getOrigin().getYCoordinate() <= maximumYCoordinate)
        {
            shape.setTimestamp();
            shapeList.add(shape);
            return true;
        }
        return false;
    }
    
    /**
     * Removes shape object from screen
     * @param origin origin point of the shape
     * @param shapeType shapeType of the shape
     * @return true if shape object removed, else false 
     */
    boolean removeShape(Point origin, ShapeType shapeType)
    {
        for(Shape shape: shapeList)
        {
            if(shape.getOrigin() == origin && shape.getShapeType() ==  shapeType)
            {
                shapeList.remove(shape);
                return true;
            }
        }
        return false;
    }
    
    /**
     * Removes all shape with particular shape type from screen
     * @param shapeType type of shape
     */
    void removeShapeType(ShapeType shapeType)
    {
        List<Shape> temporaryList = new ArrayList<Shape>();
        for(Shape shape: shapeList)
        {
            if(shape.getShapeType() ==  shapeType)
            {
                temporaryList.add(shape);
            }
        }
        for(Shape shape: temporaryList)
        {
            shapeList.remove(shape);
        }
    }
    
    /**
     * Returns list of all shapes enclosing a particular shape
     * @param point Point object 
     * @return List of shapes
     */
    List<Shape> shapesEnclosingPoint(Point point)
    {
        List<Shape> shapesEnclosingPointList = new ArrayList<Shape>();
        for(Shape shape: shapeList)
        {
            if(shape.isPointEnclosed(point))
            {
                shapesEnclosingPointList.add(shape);
            }
        }
        return shapesEnclosingPointList;
    }
    
    /**
     * Sort all shapes on screen according to a particular value
     * @param sortBy value according to which all shapes are sorted
     * @return sorted list of shapes
     */
    List<Shape> sortShape(SortBy sortBy)
    {
        List<Shape> sortedList = shapeList;
        switch(sortBy)
        {
        case AREA:
            Collections.sort(sortedList, new SortByArea());
            break;
        case PERIMETER:
            Collections.sort(sortedList, new SortByPerimeter());
            break;
        case ORIGINDISTANCE:
            Collections.sort(sortedList, new SortByOriginDistance());
            break;
        case TIMESTAMP:
            Collections.sort(sortedList, new SortByTimestamp());
            break;
        }
        
        return sortedList;
    }
    
}
