package service;

import model.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAll();

    void save(Product product);

    Product findByName(String name);

    void update(int iD, Product product);

    void remove(int iD);
}
