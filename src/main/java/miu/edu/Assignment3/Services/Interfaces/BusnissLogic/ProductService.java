package miu.edu.Assignment3.Services.Interfaces.BusnissLogic;

import miu.edu.Assignment3.DTOs.BuisnessLogicDTO.ProductDTO;


import java.util.List;

public interface ProductService {
    void save (ProductDTO productDTO);
    void delete(Long id);
    ProductDTO getById(Long id);
    List<ProductDTO> getAll();
    void update(ProductDTO productDTO, long id);
}
