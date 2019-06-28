package session2;

public interface Calculator
{
    String add(String number1, String number2);
    String subtract(String number1, String number2);
    String multiply(String number1, String number2);
    String divide(String number1, String number2);
    boolean equalTo(String number1, String number2);
    boolean greaterThan(String number1, String number2);
    boolean lessThan(String number1, String number2);
}
