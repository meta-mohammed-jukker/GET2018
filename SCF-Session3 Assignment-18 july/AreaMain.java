import java.util.*;

class Area
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

class AreaMain
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        Area area = new Area();
        while(true)
		{
			System.out.println("Find area of:");
            System.out.println("1. Triangle");
            System.out.println("2. Rectangle");
            System.out.println("3. Square");
            System.out.println("4. Circle");
            System.out.println("5. exit");
            int choice = scan.nextInt();
            switch(choice)
            {
                case 1:
                    System.out.println("Enter width: ");
                    double width1 = scan.nextDouble(); 
                    System.out.println("Enter height: ");
                    double height1 = scan.nextDouble();
                    try
                    {
                        System.out.println("Area of triangle: " + area.areaTriangle(width1, height1));
                    }
                    catch(ArithmeticException arithmeticException)
                    {
                        System.out.println("Error : " + arithmeticException.getMessage());
                    }
                    break;
                case 2:
                    System.out.println("Enter width: ");
                    double width2 = scan.nextDouble(); 
                    System.out.println("Enter height: ");
                    double height2 = scan.nextDouble();
                    try
                    {
                        System.out.println("Area of rectangle: " + area.areaRectangle(width2, height2));
                    }
                    catch(ArithmeticException arithmeticException)
                    {
                        System.out.println("Error : " + arithmeticException.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("Enter side: ");
                    double side = scan.nextDouble(); 
                    try
                    {
                        System.out.println("Area of square: " + area.areaSquare(side));
                    }
                    catch(ArithmeticException arithmeticException)
                    {
                        System.out.println("Error : " + arithmeticException.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("Enter radius: ");
                    double radius = scan.nextDouble(); 
                    try
                    {
                        System.out.println("Area of circle: " + area.areaCircle(radius));
                    }
                    catch(ArithmeticException arithmeticException)
                    {
                        System.out.println("Error : " + arithmeticException.getMessage());
                    }
                    break;
                case 5:
                    System.exit(0);
					break;  
				default:
					System.out.println("Wrong Entry");
					break;
            }
        }
    }
}
    