package fastmenu.com.example.fastmenu.controller;
import fastmenu.com.example.fastmenu.dto.Category;
import fastmenu.com.example.fastmenu.dto.Product;
import fastmenu.com.example.fastmenu.service.CategoryService;

import fastmenu.com.example.fastmenu.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/products")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping
    public List<Product> getProducts(){
        return productService.getProducts();
    }
    @PostMapping
    public Product saveProduct(Product product){
        return  productService.saveProduct(product);
    }
    @DeleteMapping
    public boolean deleteProduct(long id){
        return productService.deleteProduct(id);
    }
    @PutMapping(path = "{productId}")
    public Product updateProduct(@PathVariable("productId") Long id,
                                   @RequestParam(required = false) String name,
                                   @RequestParam(required = false) String description,
                                   @RequestParam(required = false) int Price,
                                   @RequestParam(required = false) String image
    ){
        return productService.updateProduct(id, name, description, image, Price);
    }
}
