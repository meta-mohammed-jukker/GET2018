package session9;

import java.util.*;
import java.time.*;
import java.time.format.*;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class ScreenTest
{
    Screen screen = new Screen();
    
    // Test cases for addShape()
    @Test
    public void testAddShapeWithRectangle()
    {
        List<Double> dimensionList;
        
        Point point = new Point(1,1);
        dimensionList = new ArrayList<Double>();
        dimensionList.add(2.0);
        dimensionList.add(1.0);
        Shape shape = ShapeFactory.create(ShapeType.RECTANGLE, point, dimensionList);
        
        boolean expectedOutput = true;
        boolean actualOutput = screen.addShape(shape);
        
        assertEquals(expectedOutput, actualOutput);
    }
    
    @Test
    public void testAddShapeWithSquare()
    {
        List<Double> dimensionList;
        
        Point point = new Point(2,3);
        dimensionList = new ArrayList<Double>();
        dimensionList.add(2.0);
        Shape shape = ShapeFactory.create(ShapeType.SQUARE, point, dimensionList);
        
        boolean expectedOutput = true;
        boolean actualOutput = screen.addShape(shape);
        
        assertEquals(expectedOutput, actualOutput);
    }
    
    @Test
    public void testAddShapeWithCoordinatesLessThanMinimumValue()
    {
        List<Double> dimensionList;
        
        Point point = new Point(-2,-3);
        dimensionList = new ArrayList<Double>();
        dimensionList.add(2.0);
        Shape shape = ShapeFactory.create(ShapeType.SQUARE, point, dimensionList);
        
        boolean expectedOutput = false;
        boolean actualOutput = screen.addShape(shape);
        
        assertEquals(expectedOutput, actualOutput);
    }
    
    @Test
    public void testAddShapeWithCoordinatesMoreThanMaximumValue()
    {
        List<Double> dimensionList;
        
        Point point = new Point(2000,769);
        dimensionList = new ArrayList<Double>();
        dimensionList.add(2.0);
        Shape shape = ShapeFactory.create(ShapeType.SQUARE, point, dimensionList);
        
        boolean expectedOutput = false;
        boolean actualOutput = screen.addShape(shape);
        
        assertEquals(expectedOutput, actualOutput);
    }
    
    
    //Test cases for removeShape()
    
    @Test
    public void testRemoveShape()
    {
        List<Double> dimensionList;
        
        Point point = new Point(2,3);
        dimensionList = new ArrayList<Double>();
        dimensionList.add(2.0);
        Shape shape = ShapeFactory.create(ShapeType.SQUARE, point, dimensionList);
        screen.addShape(shape);
        
        boolean expectedOutput = true;
        boolean actualOutput = screen.removeShape(point, ShapeType.SQUARE);
        
        assertEquals(expectedOutput, actualOutput);
    }
    
    @Test
    public void testRemoveShapeWithEmptyScreen()
    {
        List<Double> dimensionList;
        
        Point point = new Point(2,3);
        dimensionList = new ArrayList<Double>();
        dimensionList.add(2.0);
        Shape shape = ShapeFactory.create(ShapeType.SQUARE, point, dimensionList);
        
        boolean expectedOutput = false;
        boolean actualOutput = screen.removeShape(point, ShapeType.SQUARE);
        
        assertEquals(expectedOutput, actualOutput);
    }
    
    @Test
    public void testRemoveShapeWithNoMatch()
    {
        List<Double> dimensionList;
        
        Point point = new Point(2,3);
        dimensionList = new ArrayList<Double>();
        dimensionList.add(2.0);
        Shape shape = ShapeFactory.create(ShapeType.SQUARE, point, dimensionList);
        
        boolean expectedOutput = false;
        boolean actualOutput = screen.removeShape(point, ShapeType.RECTANGLE);
        
        assertEquals(expectedOutput, actualOutput);
    }
    
    
    // Test cases for sortShape()
    @Test
    public void testSortShapeWithArea()
    {
        List<Double> dimensionList;
        
        Point point1 = new Point(1,1);
        dimensionList = new ArrayList<Double>();
        dimensionList.add(2.0);
        dimensionList.add(1.0);
        Shape shape1 = ShapeFactory.create(ShapeType.RECTANGLE, point1, dimensionList);
        
        Point point2 = new Point(2,3);
        dimensionList = new ArrayList<Double>();
        dimensionList.add(2.0);
        Shape shape2 = ShapeFactory.create(ShapeType.SQUARE, point2, dimensionList);
        
        Point point3 = new Point(0,0);
        dimensionList = new ArrayList<Double>();
        dimensionList.add(2.0);
        dimensionList.add(1.0);
        dimensionList.add(1.0);
        dimensionList.add(1.0);
        Shape shape3 = ShapeFactory.create(ShapeType.TRIANGLE, point3, dimensionList);
        
        Point point4 = new Point(34,43);
        dimensionList = new ArrayList<Double>();
        dimensionList.add(5.0);
        Shape shape4 = ShapeFactory.create(ShapeType.CIRCLE, point4, dimensionList);
        
        screen.addShape(shape1);
        screen.addShape(shape2);
        screen.addShape(shape3);
        screen.addShape(shape4);
        
        List<Shape> sortedList = screen.sortShape(SortBy.AREA);
        
        double[] expectedOutput = {1.0, 2.0, 4.0, 78.5};
        
        for(int i=0; i<4; i++)
        {
            double actualOutput = sortedList.get(i).getArea();
            assertEquals(expectedOutput[i], actualOutput, 0.01);
        }
    }
    
    @Test
    public void testSortShapeWithPerimeter()
    {
        List<Double> dimensionList;
        
        Point point1 = new Point(1,1);
        dimensionList = new ArrayList<Double>();
        dimensionList.add(2.0);
        dimensionList.add(1.0);
        Shape shape1 = ShapeFactory.create(ShapeType.RECTANGLE, point1, dimensionList);
        
        Point point2 = new Point(2,3);
        dimensionList = new ArrayList<Double>();
        dimensionList.add(2.0);
        Shape shape2 = ShapeFactory.create(ShapeType.SQUARE, point2, dimensionList);
        
        Point point3 = new Point(0,0);
        dimensionList = new ArrayList<Double>();
        dimensionList.add(2.0);
        dimensionList.add(1.0);
        dimensionList.add(1.0);
        dimensionList.add(1.0);
        Shape shape3 = ShapeFactory.create(ShapeType.TRIANGLE, point3, dimensionList);
        
        Point point4 = new Point(34,43);
        dimensionList = new ArrayList<Double>();
        dimensionList.add(5.0);
        Shape shape4 = ShapeFactory.create(ShapeType.CIRCLE, point4, dimensionList);
        
        screen.addShape(shape1);
        screen.addShape(shape2);
        screen.addShape(shape3);
        screen.addShape(shape4);
        
        List<Shape> sortedList = screen.sortShape(SortBy.PERIMETER);
        
        double[] expectedOutput = {3.0, 6.0, 8.0, 31.40};
        
        for(int i=0; i<4; i++)
        {
            double actualOutput = sortedList.get(i).getPerimeter();
            assertEquals(expectedOutput[i], actualOutput, 0.01);
        }
    }
    
    @Test
    public void testSortShapeWithTimestamp()
    {
        List<Double> dimensionList;
        
        Point point1 = new Point(1,1);
        dimensionList = new ArrayList<Double>();
        dimensionList.add(2.0);
        dimensionList.add(1.0);
        Shape shape1 = ShapeFactory.create(ShapeType.RECTANGLE, point1, dimensionList);
        
        Point point2 = new Point(2,3);
        dimensionList = new ArrayList<Double>();
        dimensionList.add(2.0);
        Shape shape2 = ShapeFactory.create(ShapeType.SQUARE, point2, dimensionList);
        
        Point point3 = new Point(0,0);
        dimensionList = new ArrayList<Double>();
        dimensionList.add(2.0);
        dimensionList.add(1.0);
        dimensionList.add(1.0);
        dimensionList.add(1.0);
        Shape shape3 = ShapeFactory.create(ShapeType.TRIANGLE, point3, dimensionList);
        
        Point point4 = new Point(34,43);
        dimensionList = new ArrayList<Double>();
        dimensionList.add(5.0);
        Shape shape4 = ShapeFactory.create(ShapeType.CIRCLE, point4, dimensionList);
        
        screen.addShape(shape1);
        screen.addShape(shape2);
        screen.addShape(shape3);
        screen.addShape(shape4);
        
        List<Shape> sortedList = screen.sortShape(SortBy.TIMESTAMP);
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
        
        String[] expectedOutput = {"02 8 2018", "02 8 2018", "02 8 2018", "02 8 2018"};
        
        for(int i=0; i<4; i++)
        {
            String actualOutput = sortedList.get(i).getTimestamp().format(formatter);
            assertEquals(expectedOutput[i], actualOutput);
        }
    }
    
    @Test
    public void testSortShapeWithOriginDistance()
    {
        List<Double> dimensionList;
        
        Point point1 = new Point(1,1);
        dimensionList = new ArrayList<Double>();
        dimensionList.add(2.0);
        dimensionList.add(1.0);
        Shape shape1 = ShapeFactory.create(ShapeType.RECTANGLE, point1, dimensionList);
        
        Point point2 = new Point(2,3);
        dimensionList = new ArrayList<Double>();
        dimensionList.add(2.0);
        Shape shape2 = ShapeFactory.create(ShapeType.SQUARE, point2, dimensionList);
        
        Point point3 = new Point(0,0);
        dimensionList = new ArrayList<Double>();
        dimensionList.add(2.0);
        dimensionList.add(1.0);
        dimensionList.add(1.0);
        dimensionList.add(1.0);
        Shape shape3 = ShapeFactory.create(ShapeType.TRIANGLE, point3, dimensionList);
        
        Point point4 = new Point(34,43);
        dimensionList = new ArrayList<Double>();
        dimensionList.add(5.0);
        Shape shape4 = ShapeFactory.create(ShapeType.CIRCLE, point4, dimensionList);
        
        screen.addShape(shape1);
        screen.addShape(shape2);
        screen.addShape(shape3);
        screen.addShape(shape4);
        
        List<Shape> sortedList = screen.sortShape(SortBy.ORIGINDISTANCE);
        
        ShapeUtil shapeUtil = new ShapeUtil();
        Point screenOrigin = new Point(0, 0);
        
        double[] expectedOutput = {0.0, 1.41, 3.60, 49.81, 100.17};
        
        for(int i=0; i<4; i++)
        {
            double actualOutput = shapeUtil.getDistance(sortedList.get(i).getOrigin(), screenOrigin);
            System.out.println(actualOutput);
            assertEquals(expectedOutput[i], actualOutput, 0.01);
        }
    }
    
    

    //Test cases for shapesEnclosingPoint()
    @Test
    public void TestShapesEnclosingPointWhenPointLiesInOneShape()
    {
        List<Double> dimensionList;
        
        Point point1 = new Point(1,1);
        dimensionList = new ArrayList<Double>();
        dimensionList.add(2.0);
        dimensionList.add(1.0);
        Shape shape1 = ShapeFactory.create(ShapeType.RECTANGLE, point1, dimensionList);
        
        Point point2 = new Point(2,3);
        dimensionList = new ArrayList<Double>();
        dimensionList.add(2.0);
        Shape shape2 = ShapeFactory.create(ShapeType.SQUARE, point2, dimensionList);
        
        Point point3 = new Point(0,0);
        dimensionList = new ArrayList<Double>();
        dimensionList.add(2.0);
        dimensionList.add(1.0);
        dimensionList.add(1.0);
        dimensionList.add(1.0);
        Shape shape3 = ShapeFactory.create(ShapeType.TRIANGLE, point3, dimensionList);
        
        Point point4 = new Point(34,43);
        dimensionList = new ArrayList<Double>();
        dimensionList.add(5.0);
        Shape shape4 = ShapeFactory.create(ShapeType.CIRCLE, point4, dimensionList);
        
        screen.addShape(shape1);
        screen.addShape(shape2);
        screen.addShape(shape3);
        screen.addShape(shape4);
        
        Point point = new Point(35, 40);
        
        List<Shape> shapesEnclosingPoint = screen.shapesEnclosingPoint(point);
        
            double expectedXCoordinate = 30.89;
            double expectedYCoordinate = 39.07;
            double actualXCoordinate = shapesEnclosingPoint.get(0).getOrigin().getXCoordinate();
            double actualYCoordinate = shapesEnclosingPoint.get(0).getOrigin().getYCoordinate();
            assertEquals(expectedXCoordinate, actualXCoordinate, 0.01);
            assertEquals(expectedYCoordinate, actualYCoordinate, 0.01);
    }
    
    @Test
    public void TestShapesEnclosingPointWhenPointLiesInNoShape()
    {
        List<Double> dimensionList;
        
        Point point1 = new Point(1,1);
        dimensionList = new ArrayList<Double>();
        dimensionList.add(2.0);
        dimensionList.add(1.0);
        Shape shape1 = ShapeFactory.create(ShapeType.RECTANGLE, point1, dimensionList);
        
        Point point2 = new Point(2,3);
        dimensionList = new ArrayList<Double>();
        dimensionList.add(2.0);
        Shape shape2 = ShapeFactory.create(ShapeType.SQUARE, point2, dimensionList);
        
        Point point3 = new Point(0,0);
        dimensionList = new ArrayList<Double>();
        dimensionList.add(2.0);
        dimensionList.add(1.0);
        dimensionList.add(1.0);
        dimensionList.add(1.0);
        Shape shape3 = ShapeFactory.create(ShapeType.TRIANGLE, point3, dimensionList);
        
        Point point4 = new Point(34,43);
        dimensionList = new ArrayList<Double>();
        dimensionList.add(5.0);
        Shape shape4 = ShapeFactory.create(ShapeType.CIRCLE, point4, dimensionList);
        
        screen.addShape(shape1);
        screen.addShape(shape2);
        screen.addShape(shape3);
        screen.addShape(shape4);
        
        Point point = new Point(350, 400);
        
        List<Shape> shapesEnclosingPoint = screen.shapesEnclosingPoint(point);
        
            int expectedSize = 0;
            int actualSize = shapesEnclosingPoint.size();
            assertEquals(expectedSize, actualSize);
    }
    

}
