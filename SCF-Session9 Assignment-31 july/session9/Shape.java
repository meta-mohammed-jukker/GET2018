package session9;

import java.time.*;

public interface Shape
{
    static final double PI = 3.14;
    
    double getArea();
    double getPerimeter();
    Point getOrigin();
    boolean isPointEnclosed(Point point);
    ShapeType getShapeType();
    void setTimestamp();
    LocalDate getTimestamp();
}
