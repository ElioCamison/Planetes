package com.esliceu.dao;

import java.util.List;

public interface DAO<T, k> {

    public void insert(T p);

    public void update(T p);

    public void delete(T p);

    public List<T> getAll();

    public  T getOne(k id);
}
