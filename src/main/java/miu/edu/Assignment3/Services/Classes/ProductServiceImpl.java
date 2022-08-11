package miu.edu.Assignment3.Services.Classes;

import miu.edu.Assignment3.DTOs.BuisnessLogicDTO.ProductDTO;
import miu.edu.Assignment3.Entities.BusinessLogicEntity.Product;
import miu.edu.Assignment3.Repositories.BusinessLogicRepository.ProductRepository;
import miu.edu.Assignment3.Services.Interfaces.BusnissLogic.ProductService;
import miu.edu.Assignment3.UtilityClasses.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public void save(ProductDTO productDTO) {
        Product product = new Product();
        product = Mapper.ConvertDTOToProduct(productDTO);
        productRepository.save(product);
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public ProductDTO getById(Long id) {
        var productEntity = productRepository.findById(id);
        ProductDTO productDTO = new ProductDTO();
        productDTO = Mapper.ConvertProductToDTO(productEntity.get());
        return productDTO;
    }

    @Override
    public List<ProductDTO> getAll() {
        var ListOfProductEntity = productRepository.findAll();
        List<ProductDTO>ProductDTOList = ListOfProductEntity.stream().map(Entity ->Mapper.ConvertProductToDTO(Entity)).collect(Collectors.toList());
         return ProductDTOList;
    }

    @Override
    public void update(ProductDTO productDTONewValue, long id) {
        Product currentEntityValue = productRepository.findById(id).get();
        var newEntityValue = Mapper .ConvertDTOToProduct(productDTONewValue);
        currentEntityValue.setName(newEntityValue.getName());
        currentEntityValue.setPrice(newEntityValue.getPrice());
        currentEntityValue.setRating(newEntityValue.getRating());

        productRepository.save(currentEntityValue);
    }
}
