package edu.miu.lab6.service;

import edu.miu.lab6.dto.ProductDto;
import edu.miu.lab6.entity.Product;

import java.util.List;

public interface ProductService {

    public List<Product> findAllProducts();
    //public Product findProductById(int id);
    public Product createProduct(ProductDto productDto) throws Exception;
    //public Product updateProduct(Product product);
    public void deleteProductById(int id);

}
