package com.trabajopractico.sistema.interfaces;

import java.util.List;

public interface GenericAbm <T>{
    public T add(T object);
    public void remove(int id);
    public T modify(int id, T object);
    public T get(int id);
    public List<T> getAll();
}
