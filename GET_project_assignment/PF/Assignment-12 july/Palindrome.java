import java.util.*;

public class Palindrome
{

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string:");
        String input = sc.nextLine().toLowerCase();
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < input.length(); i++)
        {
            stack.push(input.charAt(i));
        }
        String reverseInput = "";
        while (!stack.isEmpty())
        {
            reverseInput += stack.pop();
        }
        if (input.equals(reverseInput))
            System.out.println("String is a palindrome.");
        else
            System.out.println("String is not a palindrome.");
    }
}