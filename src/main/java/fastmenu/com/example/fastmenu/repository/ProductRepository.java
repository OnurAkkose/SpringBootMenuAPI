package fastmenu.com.example.fastmenu.repository;

import fastmenu.com.example.fastmenu.dto.Category;
import fastmenu.com.example.fastmenu.dto.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}

