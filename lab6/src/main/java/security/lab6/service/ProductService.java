package security.lab6.service;



import security.lab6.dto.ProductDTO;
import security.lab6.entity.Product;

import java.util.List;

public interface ProductService {

    void save(ProductDTO p) throws Exception;

    void delete(int id);

    ProductDTO getById(int id);

    List<ProductDTO> getAll();
}
