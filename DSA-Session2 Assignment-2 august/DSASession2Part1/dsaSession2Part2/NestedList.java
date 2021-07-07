package dsaSession2Part2;

public interface NestedList
{
    public int sum(Object object) throws NestedListException;
    public int getLargestValue(Object object) throws NestedListException;
    public boolean isPresent(Object object, int value) throws NestedListException;
    public void add(Object object) throws NestedListException;
}
