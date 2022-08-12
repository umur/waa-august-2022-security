package edu.miu.spring_data.service;

import edu.miu.spring_data.dto.AddressDto;
import edu.miu.spring_data.dto.ProductDto;
import edu.miu.spring_data.entity.Category;
import edu.miu.spring_data.entity.Product;
import edu.miu.spring_data.entity.Review;

import java.util.List;

public interface ProductService {

    List<ProductDto> findAll ();
    ProductDto getProduct(int id);
    ProductDto addProduct(ProductDto productDto);
    ProductDto updateProduct(ProductDto productDto , int id);
    void deleteProduct(int id);

    public List<Product> findByPriceGreaterThan(Double minPrice);
    List<Product> findByCategoryAndPriceLessThan(Integer category_id , Double maxPrice);
    List<Product> findByNameContains(String keyword) ;
    public List<Review> findAllReviewsOfProduct(Integer productId) ;
}
