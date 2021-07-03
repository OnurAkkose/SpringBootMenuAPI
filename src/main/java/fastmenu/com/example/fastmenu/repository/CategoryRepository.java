package fastmenu.com.example.fastmenu.repository;

import fastmenu.com.example.fastmenu.dto.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

   // @Query("SELECT c from Category c WHERE c.name = ?1")
    Optional<Category> findCategoryByName(String name);
}
