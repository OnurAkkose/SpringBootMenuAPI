package fastmenu.com.example.fastmenu.service;


import fastmenu.com.example.fastmenu.dto.Category;
import fastmenu.com.example.fastmenu.dto.Product;
import fastmenu.com.example.fastmenu.exception.ProductException;
import fastmenu.com.example.fastmenu.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product saveProduct(@RequestBody Product product) {
    try {
        if(product.getName().isEmpty() || product.getName().length() == 0){
                throw new ProductException("601","Please give a product name!");
        }
        productRepository.save(product);
        return product;
    }
    catch (IllegalArgumentException ex){
        throw  new ProductException("602","Given product is null" + ex.getMessage());
    }
    catch (Exception ex){
        throw new ProductException("603","Something went go wrong in Service layer" + ex.getMessage());
    }

    }


    public boolean deleteProduct(long id) {
        boolean exists = productRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Product id was not found!");
        }
        productRepository.deleteById(id);
        return true;
    }

    public Product updateProduct(Long id,String name, String description, String image, int price){
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        "product with id " + id + "does not exist"
                ));
        if (name != null && name.length() > 0 && !Objects.equals(product.getName(), name)){
            product.setName(name);
        }
        product.setDescription(description);
        product.setImage(image);
        product.setPrice(price);
        return product;
    }
}
