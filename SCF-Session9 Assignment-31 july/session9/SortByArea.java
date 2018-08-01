package session9;

import java.util.*;

public class SortByArea implements Comparator<Shape>
{
    /**
     * Compares area of 2 shapes
     */
    public int compare(Shape shape1, Shape shape2)
    {
        return Double.compare(shape1.getArea(), shape2.getArea());
    }
}
