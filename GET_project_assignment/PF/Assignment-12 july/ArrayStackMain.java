//class to impliment stack using arrays
import java.util.*;
class ArrayStack
{
	static final int MAX = 1000;
	int top;
	int a[] = new int[MAX]; // Maximum size of Stack
    
    ArrayStack()
	{
		top = -1;
	}
    
	boolean isEmpty()
	{
		return (top < 0);
	}

	void push(int x)
	{
		if (top >= (MAX-1))
		{
			throw new ArrayIndexOutOfBoundsException("Overflow Exception") ;
		}
		a[++top] = x;
	}

	int pop()
	{
        if (isEmpty())
            throw new NoSuchElementException("Underflow Exception") ;
		int x = a[top--];
		return x;
	}
    
    int top()
    {
        if (isEmpty())
            throw new NoSuchElementException("Underflow Exception") ;
        return a[top];
    }
    
    int getSize()
    {
        int size = top+1;
        return (size);
    }
    
    void display()
    {
        System.out.print("Stack = ");
        if (top == -1) 
        {
            System.out.println("Empty");
            return ;
        }
        for(int i=0; i<=top; i++)
        {
            System.out.print(a[i]+" ");
        }
        System.out.println("");
    }
}

//Main Class
public class ArrayStackMain
{
	public static void main(String args[])
	{
        Scanner sc = new Scanner(System.in);
		ArrayStack as = new ArrayStack();
        while(true)
        {
            System.out.println("Enter the operation to be performed on stack.");
            System.out.println("1. push");
            System.out.println("2. pop");
            System.out.println("3. check empty");
            System.out.println("4. top");
            System.out.println("5. exit");
            int choice = sc.nextInt();
            switch(choice)
            {
                case 1:
                    try
                    {
                        System.out.println("Enter the item to be pushed:");
                        int item = sc.nextInt();
                        as.push(item);
                    }
                    catch (Exception e)
                    {
                        System.out.println("Error : " + e.getMessage());
                    }
                    break;
                
                case 2:
                    try
                    {
                        System.out.println("Popped Element = "+ as.pop());
                    }
                    catch (Exception e)
                    {
                        System.out.println("Error : " + e.getMessage());
                    }
                    break;
                
                case 3:
                    System.out.println("Empty status = "+ as.isEmpty());
                    break;
                
                case 4:
                    try
                    {
                        System.out.println("Top Element = "+ as.top());
                    }
                    catch (Exception e)
                    {
                        System.out.println("Error : " + e.getMessage());
                    }
                    break;
                
                case 5:
                    System.exit(0);
                    break;
                
                default:
                    System.out.println("Wrong choice!");
            }
            as.display();
            System.out.println("Stack size: " + as.getSize());
        }
	}
}
