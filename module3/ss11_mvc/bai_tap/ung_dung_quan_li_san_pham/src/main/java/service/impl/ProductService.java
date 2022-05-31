package service.impl;

import model.Product;
import repository.IProductRepository;
import repository.impl.ProductRepository;
import service.IProductService;

import java.util.List;

public class ProductService implements IProductService {
    private IProductRepository iProductRepository = new ProductRepository();

    @Override
    public List<Product> getAll() {
        return iProductRepository.getAll();
    }

    @Override
    public void save(Product product) {
        this.iProductRepository.save(product);
    }

    @Override
    public Product findByName(String name) {
        return null;
    }

    @Override
    public void update(int iD, Product product) {
        iProductRepository.update(iD, product);
    }

    @Override
    public void remove(int iD) {
        iProductRepository.remove(iD);
    }

    @Override
    public Product findByID(int iD) {
        return iProductRepository.findByID(iD);
    }
}
