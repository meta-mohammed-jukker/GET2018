package session9;
import java.util.*;

public class ShapeFactory
{
    /**
     * 
     * @param shapeType type of shape
     * @param point origin/center point
     * @param dimensions list storing all relevant dimensions of the shape 
     * @return shape object 
     */
    static Shape create(ShapeType shapeType, Point point, List<Double> dimensions)
    {
        Shape shape = null;
        switch(shapeType)
        {
        case SQUARE:
            shape = new Square(point, dimensions.get(0));
            break;
        case RECTANGLE:
            shape = new Rectangle(point, dimensions.get(0), dimensions.get(1));
            break;
        case CIRCLE:
            shape = new Circle(point, dimensions.get(0));
            break;
        case TRIANGLE:
            shape = new Triangle(point, 
                    dimensions.get(0), dimensions.get(1), dimensions.get(2), dimensions.get(3));
            break;
        }
        return shape;
    }
}
