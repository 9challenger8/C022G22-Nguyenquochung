package com.service.impl;

import com.model.Product;
import com.service.IProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductService implements IProductService {
    private static final Map<Integer, Product> products;

    static {

        products = new HashMap<>();
        products.put(1, new Product(1,"bike","1000","nice","Stronger"));
        products.put(2, new Product(2,"oto","2000","nice","Apple"));
        products.put(3, new Product(3,"car","3000","nice","CodeGym"));
        products.put(4, new Product(4,"motor","4000","nice","Studio"));
        products.put(5, new Product(5,"plane","5000","nice","Apple"));
        products.put(6, new Product(6,"bicycle","6000","nice","Branch"));

    }
    @Override
    public List<Product> findAll() {
       return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product customer) {
        products.put(customer.getId(),customer);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id,product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> listProduct=new ArrayList<>();
        for (Product product : products.values())
            if (product.getName().contains(name)) {
                listProduct.add(product);
            }
        return listProduct;
    }
}
