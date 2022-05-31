package repository;

import model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> getAll();

    void save(Product product);

    Product findByName(String name);

    void update(int iD, Product product);

    void remove(int iD);
}
