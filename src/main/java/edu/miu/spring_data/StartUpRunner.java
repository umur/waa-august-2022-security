package edu.miu.spring_data;

import edu.miu.spring_data.entity.*;
import edu.miu.spring_data.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Arrays;

@Component
@AllArgsConstructor
public class StartUpRunner implements CommandLineRunner {

    private final UserRepository userRepository;
    private final ReviewRepository reviewRepository;
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final AddressRepository addressRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder encoder;


    @Transactional
    public void run(String... args) throws Exception {

        //PasswordEncoder encoder = new BCryptPasswordEncoder();

        Role adminRole = new Role("ADMIN");
        Role userRole = new Role("USER");



        Address a1 = new Address("1000 4th Street" , 52557 , "Fair Field");
        Address a2 = new Address("King George Street" , 67897 , "Addis Ababa");
        User user1 = new User("admin@gmail.com" , encoder.encode("1234") , "Hanna" , "Kedir");
        user1.setAddress(a1);
        user1.setRoles(Arrays.asList(adminRole));
        User user2 = new User("user@gmail.com" , encoder.encode("1234") , "Alemu" , "Bekele");
        user2.setAddress(a2);
        user2.setRoles(Arrays.asList(userRole));

        Review review1 = new Review("True to size");
        review1.setUser(user1);
        Review review2 = new Review("Amazing");
        review2.setUser(user1);
        Review review3 = new Review("Poor");
        review3.setUser(user2);
        Review review4 = new Review("Excellent product");
        review4.setUser(user2);
        user1.setReviews(Arrays.asList(review1 , review2));
        user2.setReviews(Arrays.asList(review3 , review4));

        Category category1 = new Category("Electronics");
        Category category2 = new Category("Fabric");

        Product product1 = new Product("TV" , 6786 , 3.5);
        product1.setCategory(category1);
        Product product2 = new Product("AirPod" , 210 , 4.5);
        product2.setCategory(category1);
        Product product3 = new Product("T-Shirt" , 25 , 2.5);
        product3.setCategory(category2);
        Product product4 = new Product("Shorts" , 12 , 5.0);
        product4.setCategory(category2);

        category1.setProducts(Arrays.asList(product1 , product2));
        category2.setProducts(Arrays.asList(product3 , product4));

        user1.setProducts(Arrays.asList(product1 , product2));
        user2.setProducts(Arrays.asList(product3 , product4));

        review1.setProduct(product1);
        review2.setProduct(product2);
        review3.setProduct(product3);
        review4.setProduct(product4);


        product1.setUser(user1);
        product2.setUser(user1);
        product3.setUser(user2);
        product4.setUser(user2);



        addressRepository.save(a1);
        addressRepository.save(a2);

        categoryRepository.save(category1);
        categoryRepository.save(category2);

//        userRepository.save(user1);
//        userRepository.save(user2);

        reviewRepository.save(review1);
        reviewRepository.save(review2);
        reviewRepository.save(review3);
        reviewRepository.save(review4);


        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);
        productRepository.save(product3);

        //userRepository.delete(user1);


    }
}
