package session9;

import java.time.*;
import java.util.*;

public class SortByTimestamp implements Comparator<Shape>
{
    
    /**
     * Compares timestamp of 2 shapes
     */
    public int compare(Shape shape1, Shape shape2)
    {
        LocalDate timestamp1 = shape1.getTimestamp();
        LocalDate timestamp2 = shape2.getTimestamp();
        return timestamp1.compareTo(timestamp2);
    }

}
