package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Car;
import java.util.List;
import id.ac.ui.cs.advprog.eshop.model.Product;

public interface TotalService<T> {

    public T create (T something);
    public List<T> findAll();
    T findById (String somethingId);
    public void update (String somethingId, T something);
    public void deleteTotalById (String somethingId);

}
