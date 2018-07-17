import java.util.*;
//product_name should be unique
class Product
{
    String product_name;
	int product_quantity;
	int product_price;
    Product link; 
 
    Product()
    {
        link = null;
        product_quantity = 0;
		product_price = 0;
		product_name = "";
    }    
    
    Product(String s, int q, int p, Product n)
    {
        link = n;
        product_quantity = q;
		product_price = p;
		product_name = s;
    }
    
    
    void setLink(Product n)
    {
        link = n;
    }    
    
	void setName(String name)
	{
		product_name = name;
	}
    void setQuantity(int q)
    {
        product_quantity = q;
    }
	
	void setPrice(int p)
	{
		product_price = p;
	}
    
    Product getLink()
    {
        return link;
    }
	String getName()
	{
		return product_name;
	}
    
    int getQuantity()
    {
        return product_quantity;
    }
	
	int getPrice()
	{
		return product_price;
	}
}

class ShoppingCart
{
	Product top ;
    int size ;
 
    ShoppingCart()
    {
        top = null;
        size = 0;
    }    
    
    boolean isEmpty()
    {
        return top == null;
    }
	
	void addProduct(String name,int quantity, int price)
	{
		Product ptr = new Product(name, quantity, price, null);
        if (top == null)
            top = ptr;
        else
        {
            ptr.setLink(top);
            top = ptr;
        }
        size++ ;
	}
	
	void display()
	{
        if (size == 0) 
        {
            System.out.print("Cart is empty\n");
            return ;
        }
        Product ptr = top;
		System.out.println("Cart Items:");
        while (ptr != null)
        {
            System.out.print("Product Name: " + ptr.getName() + " Product Quantity: " + ptr.getQuantity() + " Product Price: " + ptr.getPrice() + "\n");
            ptr = ptr.getLink();
        }
        System.out.println();
	}
	
	void billing()
	{
		if (size == 0) 
        {
            System.out.print("Cart is empty\n");
            return ;
        }
        Product ptr = top;
		int total_bill = 0;
		System.out.println("Cart Items:");
        while (ptr != null)
        {
            System.out.print("Product Name: " + ptr.getName() + " Product Quantity: " + ptr.getQuantity() + " Product Price: " + ptr.getPrice() + " Total Product Price: " + (ptr.getQuantity()*ptr.getPrice()) + "\n");
            total_bill += (ptr.getQuantity()*ptr.getPrice());
			ptr = ptr.getLink();
        }
        System.out.println("Total billing price: " + total_bill);
	}
	
	void modifyQuantity(String name, int quantity)
	{
		if (size == 0) 
        {
            System.out.print("Cart is empty\n");
            return ;
        }
		Product ptr = top;
		while(ptr != null)
		{
			if (ptr.getName() == name)
			{
				ptr.setQuantity(quantity); 
				break;
			}				
			ptr = ptr.getLink();
		}
		if(ptr == null)
			System.out.println("No such item found!");
	}
	
	void removeItem(String name)
	{
		if (size == 0) 
        {
            System.out.print("Cart is empty\n");
            return ;
        }
		Product ptr = top;
		Product previous_item = ptr;
		while(ptr != null)
		{
			if(ptr.getName() == name && ptr == top)
			{
				Product next_item = top.getLink();
				top.setLink(null);
				top = next_item;
				return;
			}
			if(ptr.getName() == name && ptr.getLink() != null)
			{
				previous_item.setLink(ptr.getLink());
				ptr.setLink(null);
				return;
			}
			if(ptr.getName() == name)
			{
				previous_item.setLink(null);
				return;
			}
			previous_item = ptr;
			ptr = ptr.getLink();
		}
		if(ptr == null)
			System.out.println("No such item found!");
	}
}

public class ShoppingCartMain
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		ShoppingCart sc = new ShoppingCart();
		
		while(true)
		{
			System.out.println("Enter the operation to be performed:");
            System.out.println("1. add item");
            System.out.println("2. remove item");
            System.out.println("3. change quantity");
            System.out.println("4. display all items");
            System.out.println("5. show bill");            
			System.out.println("6. exit");
            int choice = scan.nextInt();
			int price, quantity;
			
            switch (choice)
			{
				case 1:
					System.out.println("Enter product name: ");
					String name1 = scan.next();
					System.out.println("Enter product quantity: ");
					quantity = scan.nextInt();
					System.out.println("Enter product price");
					price = scan.nextInt();
					sc.addProduct(name1, quantity, price);
					break;
				case 2:
					System.out.println("Enter product name: ");
					String name2 = scan.next();
					sc.removeItem(name2);
					break;
				case 3:
					System.out.println("Enter product name: ");
					String name3 = scan.next();
					System.out.println("Enter quantity: ");
					quantity = scan.nextInt();
					sc.modifyQuantity(name3, quantity);
					break;
				case 4:
					sc.display();
					break;
				case 5:
					sc.billing();
					break;
				case 6:
					System.exit(0);
					break;  
				default:
					System.out.println("Wrong Entry");
					break;
			}
		}
	}
}
