package repository.impl;

import model.Product;
import repository.IProductRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepository implements IProductRepository {

    static Map<Integer,Product> products=new HashMap<>();
    static {
        products.put(1,new Product(1,"Bap","40000","good","Famer"));
        products.put(2,new Product(2,"San","40000","good","Famer"));
        products.put(3,new Product(3,"Mobile","40000","good","Engineer"));
        products.put(4,new Product(4,"Laptop","40000","good","Asus"));
        products.put(5,new Product(5,"Coffee","40000","good","Famer"));
    }

    @Override
    public List<Product> getAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getID(), product);
    }

    @Override
    public Product findByName(String name) {
        return null;
    }


    @Override
    public void update(int iD, Product product) {
        products.put(iD,product);
    }

    @Override
    public void remove(int iD) {
        products.remove(iD);
    }

    @Override
    public Product findByID(int iD) {
        return products.get(iD);
    }
}
