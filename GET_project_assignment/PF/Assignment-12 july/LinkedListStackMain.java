// Java Program to Implement Stack using Linked List
 
import java.util.*;
 
class Node
{
    int data;
    Node link;
 
    Node()
    {
        link = null;
        data = 0;
    }    
    
    Node(int d,Node n)
    {
        data = d;
        link = n;
    }
    
    
    void setLink(Node n)
    {
        link = n;
    }    
    
    void setData(int d)
    {
        data = d;
    }    
    
    Node getLink()
    {
        return link;
    }    
    
    int getData()
    {
        return data;
    }
}
 

class LinkedListStack
{
    Node top ;
    int size ;
 
    LinkedListStack()
    {
        top = null;
        size = 0;
    }    
    
    boolean isEmpty()
    {
        return top == null;
    }    
    
    int getSize()
    {
        return size;
    }    
    
    void push(int data)
    {
        Node nptr = new Node (data, null);
        if (top == null)
            top = nptr;
        else
        {
            nptr.setLink(top);
            top = nptr;
        }
        size++ ;
    }    
    
    int pop()
    {
        if (isEmpty() )
            throw new NoSuchElementException("Underflow Exception") ;
        Node ptr = top;
        top = ptr.getLink();
        size-- ;
        return ptr.getData();
    }    
    
    int top()
    {
        if (isEmpty() )
            throw new NoSuchElementException("Underflow Exception") ;
        return top.getData();
    }    
    
    void display()
    {
        System.out.print("Stack = ");
        if (size == 0) 
        {
            System.out.print("Empty\n");
            return ;
        }
        Node ptr = top;
        while (ptr != null)
        {
            System.out.print(ptr.getData()+" ");
            ptr = ptr.getLink();
        }
        System.out.println();        
    }
}
 
 
public class LinkedListStackMain
{    
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);   
        LinkedListStack ls = new LinkedListStack();          
        /* Perform Stack Operations */       
        while(true) 
        {
            System.out.println("Enter the operation to be performed on stack.");
            System.out.println("1. push");
            System.out.println("2. pop");
            System.out.println("3. check empty");
            System.out.println("4. top");
            System.out.println("5. exit");            
            int choice = sc.nextInt();
            switch (choice) 
            {
            case 1 :
                System.out.println("Enter the item to be pushed:");
                ls.push(sc.nextInt()); 
                break;                         
                
            case 2 : 
                try
                {
                    System.out.println("Popped Element = "+ ls.pop());
                }
                catch (Exception e)
                {
                    System.out.println("Error : " + e.getMessage());
                }    
                break;                         
                
            case 3 :
                System.out.println("Empty status = "+ ls.isEmpty());
                break;                         
                
            case 4 : 
                try
                {
                    System.out.println("Top Element = "+ ls.top());
                }
                catch (Exception e)
                {
                    System.out.println("Error : " + e.getMessage());
                }
                break; 
                
            case 5 : 
                System.exit(0);
                break;                                        
                
            default : 
                System.out.println("Wrong Entry");
                break;
            }           
            ls.display();
            System.out.println("Stack Size: "+ ls.getSize());
        }                 
    }
}