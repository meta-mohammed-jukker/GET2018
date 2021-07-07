package databaseConnectionThroughJDBC;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class MysqlQueriesTest
{
    MysqlQueries msq = new MysqlQueries();
    
    @Test
    public void testGetAllOrdersByState()
    {
        List<Orders> orderList= msq.getAllOrdersByState(2, "shipped");
        
        int[] expectedOutput = {2, 1};
        int i =0;
        for(Orders order: orderList)
        {
            int actualOutput = order.getID();
            assertEquals(expectedOutput[i], actualOutput);
            i++;
        }
    }

    @Test
    public void testAddImagesWithListOfProductImage()
    {
        ProductImage image1 = new ProductImage(2, "www.abc.com", "jdbc test image 1");
        ProductImage image2 = new ProductImage(2, "www.def.com", "jdbc test image 2");
        ProductImage image3 = new ProductImage(2, "www.ghi.com", "jdbc test image 3");
        List<ProductImage> imageList = new ArrayList<ProductImage>();
        imageList.add(image1);
        imageList.add(image2);
        imageList.add(image3);
        
        int expectedOutput = 3;
        int actualOutput = msq.addImages(imageList);
        
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testAddImagesWithListOfProductImageAndProductID()
    {
        ProductImage image1 = new ProductImage("www.abc.com", "jdbc test image 1");
        ProductImage image2 = new ProductImage("www.def.com", "jdbc test image 2");
        ProductImage image3 = new ProductImage("www.ghi.com", "jdbc test image 3");
        List<ProductImage> imageList = new ArrayList<ProductImage>();
        imageList.add(image1);
        imageList.add(image2);
        imageList.add(image3);
        
        int expectedOutput = 3;
        int actualOutput = msq.addImages(imageList, 1);
        
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testUpdateStatusOfProduct()
    {
        int expectedOutput = 0;
        int actualOutput = msq.updateStatusOfProduct();
        
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testGetTopCategoryWithChildrenCount()
    {
        List<Category> categoryList = msq.getTopCategoryWithChildrenCount();
        
        String[] expectedOutput = {"electronics 4",
                                   "fashion 0"};
        int i = 0;
        for(Category category: categoryList)
        {
            String actualOutput = category.getName() + " " + category.getSubCategoryCount();
            
            assertEquals(expectedOutput[i], actualOutput);
            i++;
        }
    }

    @Test
    public void testCountSubCategories()
    {
        int expectedOutput = 4;
        int actualOutput = msq.countSubCategories(1);
        
        assertEquals(expectedOutput, actualOutput);
    }

}
