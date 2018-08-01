package session9;

import java.util.*;

public class SortByOriginDistance implements Comparator<Shape>
{
    /**
     * Compares distance between origin of screen and shape,  of 2 shapes
     */
    public int compare(Shape shape1, Shape shape2)
    {
        ShapeUtil shapeUtil = new ShapeUtil();
        Point originScreen = new Point(0, 0);
        double distance1 = shapeUtil.getDistance(originScreen, shape1.getOrigin());
        double distance2 = shapeUtil.getDistance(originScreen, shape2.getOrigin());
        return Double.compare(distance1, distance2);
    }
}
