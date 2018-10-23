package dictionary;

import java.util.List;

@SuppressWarnings("rawtypes")
public interface Dictionary<V>
{
    public void add(String key, V value);
    public void delete(String key);
    public V get(String key);
    public List<Item> sort();
    public List<Item> sortBetween(String key1, String key2);
}
