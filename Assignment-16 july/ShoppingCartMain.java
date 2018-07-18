import java.util.*;
import java.time.*;
import java.time.format.*;

//Product class contains the properties of product(such as price, quantity, name) and their getter and setter methods
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

//ShoppingCart class contains all the operations that need to be performed on the product
class ShoppingCart
{
	Product top ;
    int size ;
    int total_bill;
    boolean promotionLimiter = false;
 
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
		Product traversingPtr = new Product(name, quantity, price, null);
        if (top == null)
            top = traversingPtr;
        else
        {
            traversingPtr.setLink(top);
            top = traversingPtr;
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
        Product traversingPtr = top;
		System.out.println("Cart Items:");
        while (traversingPtr != null)
        {
            System.out.print("Product Name: " + traversingPtr.getName() + " Product Quantity: " + traversingPtr.getQuantity() + " Product Price: " + traversingPtr.getPrice() + "\n");
            traversingPtr = traversingPtr.getLink();
        }
        System.out.println();
	}
	
	void billing()
	{
        Scanner sc = new Scanner(System.in);
        
		if (size == 0) 
        {
            System.out.print("Cart is empty\n");
            return ;
        }
        
        Product traversingPtr;
        
        System.out.println("Do you want to add promotion?(y/n)");
        char choice1 = sc.next().charAt(0);
        
        if (choice1 == 'y')
        {
            System.out.println("1. Fixed Product Promotion");
            System.out.println("2. Fixed Order Promotion");
            
            int choice2 = sc.nextInt();
            switch(choice2)
            {
                case 1:
                    System.out.println("Enter the promotion code:");
                    String fppCode = sc.next();
                    addProductPromotionCode(fppCode);
                    
                    traversingPtr = top;
                    total_bill = 0;
                    System.out.println("Cart Items:");
                    while (traversingPtr != null)
                    {
                        System.out.print("Product Name: " + traversingPtr.getName() + " Product Quantity: " + traversingPtr.getQuantity() + " Product Price: " + traversingPtr.getPrice() + " Total Product Price: " + (traversingPtr.getQuantity()*traversingPtr.getPrice()) + "\n");
                        total_bill += (traversingPtr.getQuantity()*traversingPtr.getPrice());
                        traversingPtr = traversingPtr.getLink();
                    }
                    System.out.println("Total billing price: " + total_bill);
                    break;
                    
                case 2:
                    if (promotionLimiter)
                    {
                        System.out.println("Promotion already applied");
                        break;
                    }
                    
                    Promotion fop = new FixedOrderPromotion();
                    total_bill = 0;
                    traversingPtr = top;
                    
                    while(traversingPtr != null)
                    {
                        total_bill += (traversingPtr.getQuantity()*traversingPtr.getPrice());
                        traversingPtr = traversingPtr.getLink();
                    }
                    
                    System.out.println("Enter the promotion code:");
                    String fopCode = sc.next();
                    
                    if(fop.isPromotionApplicable(fopCode))
                    {
                        System.out.println("running1");
                        fop.setFixedDiscount(3000);
                        fop.setMinimumPrice(6000);
                        
                        if (total_bill >= fop.getMinimumPrice())
                        {
                            total_bill = total_bill - fop.getFixedDiscount();
                        }
                        else
                        {
                            System.out.println("Minimum price criteria not met!");
                        }
                    }
                    
                    System.out.println("Cart Items:");
                    traversingPtr = top;
                    while (traversingPtr != null)
                    {
                        System.out.print("Product Name: " + traversingPtr.getName() + " Product Quantity: " + traversingPtr.getQuantity() + " Product Price: " + traversingPtr.getPrice() + " Total Product Price: " + (traversingPtr.getQuantity()*traversingPtr.getPrice()) + "\n");
                        traversingPtr = traversingPtr.getLink();
                    }   
                    System.out.println("Total billing price: " + total_bill);
                    promotionLimiter = true;
                    break;
            }
        }
        else
        {
            traversingPtr = top;
            total_bill = 0;
            System.out.println("Cart Items:");
            while (traversingPtr != null)
            {
                System.out.print("Product Name: " + traversingPtr.getName() + " Product Quantity: " + traversingPtr.getQuantity() + " Product Price: " + traversingPtr.getPrice() + " Total Product Price: " + (traversingPtr.getQuantity()*traversingPtr.getPrice()) + "\n");
                total_bill += (traversingPtr.getQuantity()*traversingPtr.getPrice());
                traversingPtr = traversingPtr.getLink();
            }
            System.out.println("Total billing price: " + total_bill);
        }
	}
	
    void addProductPromotionCode(String code)
    {
        if (promotionLimiter)
        {
            System.out.println("Promotion already applied");
            return;
        }
        Scanner sc = new Scanner(System.in);
        Promotion fpp = new FixedProductPromotion();
        if(fpp.isPromotionApplicable(code))
        {
            fpp.setFixedDiscount(1000);
            fpp.setMinimumPrice(2000);
            Product traversingPtr = top;
            System.out.println("Enter the product: ");
            String pn = sc.next();
            while(traversingPtr != null)
            {
                if(traversingPtr.getName().equals(pn))
                {
                    if(traversingPtr.getPrice() >= fpp.getMinimumPrice())
                    {
                        traversingPtr.setPrice( traversingPtr.getPrice() - fpp.getFixedDiscount() );
                    }
                    else
                    {
                        System.out.println("Minimum price criteria not met!");
                    }
                } 
                traversingPtr = traversingPtr.getLink();
            }
        }
        promotionLimiter = true;
    }
    
	void modifyQuantity(String name, int quantity)
	{
		if (size == 0) 
        {
            System.out.print("Cart is empty\n");
            return ;
        }
		Product traversingPtr = top;
		while(traversingPtr != null)
		{
			if (traversingPtr.getName().equals(name))
			{
				traversingPtr.setQuantity(quantity);
				break;
			}				
			traversingPtr = traversingPtr.getLink();
		}
		if(traversingPtr == null)
			System.out.println("No such item found!");
	}
	
	void removeItem(String name)
	{
		if (size == 0) 
        {
            System.out.print("Cart is empty\n");
            return ;
        }
		Product traversingPtr = top;
		Product previous_item = traversingPtr;
		while(traversingPtr != null)
		{
			if(traversingPtr.getName() == name && traversingPtr == top)
			{
				Product next_item = top.getLink();
				top.setLink(null);
				top = next_item;
				return;
			}
			if(traversingPtr.getName() == name && traversingPtr.getLink() != null)
			{
				previous_item.setLink(traversingPtr.getLink());
				traversingPtr.setLink(null);
				return;
			}
			if(traversingPtr.getName() == name)
			{
				previous_item.setLink(null);
				return;
			}
			previous_item = traversingPtr;
			traversingPtr = traversingPtr.getLink();
		}
		if(traversingPtr == null)
			System.out.println("No such item found!");
	}
}

//PromotionEnum containg all the promotion codes along with their start and end date
enum PromotionEnum
{
    CODE1("07/16/2018", "08/19/2018", "FixedProductPromotion"), CODE2("07/01/2018", "08/20/2018", "FixedOrderPromotion");
    private String startDate;
    private String endDate;
    private String promotionType;
    
    private PromotionEnum(String startDate, String endDate, String promotionType)
    {
        this.startDate = startDate;
        this.endDate = endDate;
        this.promotionType = promotionType;
    }
    
    public LocalDate getStartDate()
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate dateTime = LocalDate.parse(this.startDate, formatter);
        return dateTime;
    }
    public LocalDate getEndDate()
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate dateTime = LocalDate.parse(this.endDate, formatter);
        return dateTime;
    }
    public String getPromotionType()
    {
        return promotionType;
    }
}

//Promotion interface contains all the operation that are performed on PromotionEnum
interface Promotion
{
    int getMinimumPrice();
    void setMinimumPrice(int mp);
    int getFixedDiscount();
    void setFixedDiscount(int fd);
    boolean isPromotionApplicable(String codeName);
}

//FixedProductPromotion implements Promtion for a particular product
class FixedProductPromotion implements Promotion
{
    int minimumPrice, fixedDiscount;
    public boolean isPromotionApplicable(String codeName)
    {
        PromotionEnum[] pe = PromotionEnum.values();
        LocalDate date = LocalDate.now();
        for(PromotionEnum code : pe)
        {
            if(code.name().equals(codeName) && "FixedProductPromotion".equals(code.getPromotionType()) && date.compareTo(code.getStartDate()) >= 0 && date.compareTo(code.getEndDate()) <= 0)
            {
                return true;
            }
        }
        return false;
    }
    
    public void setMinimumPrice(int mp)
    {
        minimumPrice = mp;
    }
    public int getMinimumPrice()
    {
        return minimumPrice;
    }
    public void setFixedDiscount(int fd)
    {
        fixedDiscount = fd;
    }
    public int getFixedDiscount()
    {
        return fixedDiscount;
    }
}

//FixedOrderPromotion implements Promotion for whole order
class FixedOrderPromotion implements Promotion
{
    int minimumPrice, fixedDiscount;
    public boolean isPromotionApplicable(String codeName)
    {
        PromotionEnum[] pe = PromotionEnum.values();
        LocalDate date = LocalDate.now();
        for(PromotionEnum code : pe)
        {
            if(code.name().equals(codeName) && "FixedOrderPromotion".equals(code.getPromotionType()) && date.compareTo(code.getStartDate()) >= 0 && date.compareTo(code.getEndDate()) <= 0)
            {
                return true;
            }
        }
        return false;
    }

    public void setMinimumPrice(int mp)
    {
        minimumPrice = mp;
    }
    public int getMinimumPrice()
    {
        return minimumPrice;
    }
    public void setFixedDiscount(int fd)
    {
        fixedDiscount = fd;
    }
    public int getFixedDiscount()
    {
        return fixedDiscount;
    }
}

//driver class
public class ShoppingCartMain
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		ShoppingCart sc = new ShoppingCart();
		
		while(true)
		{
            Promotion p = new FixedProductPromotion();
            Promotion q = new FixedOrderPromotion();
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
					System.out.println("Enter product price: ");
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