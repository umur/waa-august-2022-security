package security.lab6.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import security.lab6.aspect.IOffensive;
import security.lab6.dto.ProductDTO;
import security.lab6.entity.Product;
import security.lab6.entity.User;
import security.lab6.repository.CategoryRepo;
import security.lab6.repository.ProductRepo;
import security.lab6.repository.UserRepo;
import security.lab6.security.JwtHelper;
import security.lab6.security.MyUserDetails;
import security.lab6.service.ProductService;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;
    private final UserRepo userRepo;
    private final CategoryRepo catRepo;
    private final JwtHelper jwtHelper;

    @Override
    @IOffensive
    public void save(ProductDTO p) throws Exception {
        var context = SecurityContextHolder.getContext();
        var userDetails = (MyUserDetails)context.getAuthentication().getDetails();
        User user = userRepo.findByEmail(userDetails.getUsername());
        if (user == null) throw new Exception("user not found");

        productRepo.save(new Product(0, p.getName(), p.getPrice(), null, user, null));
    }

    @Override
    public void delete(int id) {
        productRepo.deleteById(id);
    }

    @Override
    public ProductDTO getById(int id) {
         productRepo.findById(id).get();
        return null;
    }

    public List<ProductDTO> getAll() {
        var result = new ArrayList<Product>();
        productRepo.findAll().forEach(result::add);
        return null;
    }
}
