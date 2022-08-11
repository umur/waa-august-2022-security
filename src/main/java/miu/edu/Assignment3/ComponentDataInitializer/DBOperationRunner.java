package miu.edu.Assignment3.ComponentDataInitializer;

import lombok.RequiredArgsConstructor;
import miu.edu.Assignment3.Entities.BusinessLogicEntity.Address;
import miu.edu.Assignment3.Entities.BusinessLogicEntity.Category;
import miu.edu.Assignment3.Entities.BusinessLogicEntity.Product;
import miu.edu.Assignment3.Entities.BusinessLogicEntity.Review;
import miu.edu.Assignment3.Exceptions.User;
import miu.edu.Assignment3.Repositories.BusinessLogicRepository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Transactional
@Component
@RequiredArgsConstructor
public class DBOperationRunner implements CommandLineRunner {


    private final AddressRepository addressRepository;

    private final UserRepository userRepository;

    private final CategoryRepository categoryRepository;

    private final ProductRepository productRepository;


    private final ReviewRepository reviewRepository;


    @Override
    public void run(String... args) throws Exception {

        User user1 = new User("Osama","Kamel","username","password");
        Address address1 = new Address("1000N street","123456","Fairfield");

        User user2 = new User("David","Hana","username","password");
        Address address2 = new Address("1002N street","123456","Fairfield");

        Review review1 = new Review("Good Fruit");
        Review review2 = new Review("Bad Coka Cola");
        List<Review> reviewList = Arrays.asList(review1,review2);

        Review review3 = new Review("Good Fruit");
        Review review4 = new Review("Good Milk");
        List<Review> reviewList2 = Arrays.asList(review3,review4);

        reviewRepository.saveAll(reviewList);
        reviewRepository.saveAll(reviewList2);
        addressRepository.saveAll(Arrays.asList(address1,address2));

        user1.setUserReviews(reviewList);
        user2.setUserReviews(reviewList2);
        user1.setAddress(address1);
        user2.setAddress(address2);
        userRepository.saveAll(Arrays.asList(user1,user2));

        Product product1 = new Product("Apple",2.4,3.9);
        Product product2 = new Product("Banana",1.4,4.5);
        Product product3 = new Product("Strawberry",4.4,5);
        List<Product> productsList1 = Arrays.asList(product1,product2,product3);


        Product product4 = new Product("Milk",2.4,3.9);
        Product product5 = new Product("Cola",1.4,4.5);
        Product product6 = new Product("Water",4.4,5);
        List<Product> productsList2 = Arrays.asList(product4,product5,product6);

        productRepository.saveAll(productsList1);
        productRepository.saveAll(productsList2);

        Category category1 = new Category("Fruits");
        category1.setProductList(productsList1);
        Category category2 = new Category("Drinks");
        category2.setProductList(productsList2);
        categoryRepository.save(category1);
        categoryRepository.save(category2);
    }
}
