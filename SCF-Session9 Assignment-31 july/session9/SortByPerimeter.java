package session9;

import java.util.*;

public class SortByPerimeter implements Comparator<Shape>
{

    /**
     * Compares perimeter of 2 shapes
     */
    public int compare(Shape shape1, Shape shape2)
    {
        return Double.compare(shape1.getPerimeter(), shape2.getPerimeter());
    }

}
