package com.dao;

import java.util.List;

public interface BaseDAO<T>
{
    public boolean add(T t);
    
    public List<T> getAll();
    
    public boolean updateName(String oldName, String newName);
    
    public boolean delete(int id);
}
