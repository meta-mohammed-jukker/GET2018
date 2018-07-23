package session3;

public class Area
{
    /**
     * Find the area of triangle.
     * @param width width of base of triangle
     * @param height height of triangle
     * @return area of triangle
     */
     double areaTriangle(double width, double height) throws ArithmeticException
     {
         if(width <= 0 || height <= 0)
         {
             throw new ArithmeticException("Illegal dimentions");
         }
         return (0.5 * width * height);
     }
     
     /**
     * Find the area of rectangle.
     * @param width width of rectangle
     * @param height height of rectangle
     * @return area of rectangle
     */
     double areaRectangle(double width, double height) throws ArithmeticException
     {
         if(width <= 0 || height <= 0)
         {
             throw new ArithmeticException("Illegal dimentions");
         }
         return (width * height);
     }
     
     /**
     * Find the area of square.
     * @param side side of square
     * @return area of square
     */
     double areaSquare(double side) throws ArithmeticException
     {
         if(side <= 0)
         {
             throw new ArithmeticException("Illegal dimentions");
         }
         return (side * side);
     }
     
     /**
     * Find the area of circle.
     * @param radius radius of circle
     * @return area of circle
     */
     double areaCircle(double radius) throws ArithmeticException
     {
         if(radius <= 0)
         {
             throw new ArithmeticException("Illegal dimentions");
         }
         return (3.14 * radius * radius);
     }
}
