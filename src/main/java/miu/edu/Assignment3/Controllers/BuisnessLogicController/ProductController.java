package miu.edu.Assignment3.Controllers.BuisnessLogicController;

import miu.edu.Assignment3.DTOs.BuisnessLogicDTO.ProductDTO;
import miu.edu.Assignment3.Services.Interfaces.BusnissLogic.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping()
    public List<ProductDTO> getAllProduct(){
        return productService.getAll();
    }
    @GetMapping("{id}")
    public ProductDTO getProduct(@PathVariable long id){
        return productService.getById(id);
    }

    @PostMapping()
    public void save(@RequestBody ProductDTO productDTO){
        productService.save(productDTO);
    }
    @DeleteMapping("{id}")
    public void deleteProduct(@PathVariable long id){
        productService.delete(id);
    }

    @PutMapping("{id}")
    public void update(@RequestBody ProductDTO productDTO, @PathVariable long id){
        productService.update(productDTO,id);
    }
}
