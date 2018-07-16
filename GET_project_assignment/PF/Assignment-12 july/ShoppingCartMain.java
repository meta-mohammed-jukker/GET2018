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
		if(ptr.getLink() == null)
			System.out.println("No such item found!");
	}
}

public class ShoppingCartMain
{
	public static void main(String[] args)
	{
		ShoppingCart sc = new ShoppingCart();
		sc.addProduct("abc", 1, 2);
		sc.addProduct("xyz", 2, 3);
		sc.display();
		sc.billing();
		sc.modifyQuantity("abc", 3);
		sc.billing();
		sc.removeItem("abc");
		sc.billing();
	}
}