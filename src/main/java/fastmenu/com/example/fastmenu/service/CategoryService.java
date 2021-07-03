package fastmenu.com.example.fastmenu.service;
import fastmenu.com.example.fastmenu.dto.Category;
import fastmenu.com.example.fastmenu.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    public Category saveCategory(@RequestBody Category category) {
        Optional<Category> categoryByName = categoryRepository.findCategoryByName(category.getName());
        if (categoryByName.isPresent()) {
            throw new IllegalStateException("name was taken");
        }
        categoryRepository.save(category);
        return category;
    }

    public boolean deleteCategory(long id) {
        boolean exists = categoryRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Category id was not found!");
        }
        categoryRepository.deleteById(id);
        return true;
    }

    public Category updateCategory(Long id,String name, boolean isActive, Long parentId){
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        "category with id " + id + "does not exist"
                ));
        if (name != null && name.length() > 0 && !Objects.equals(category.getName(), name)){
            category.setName(name);
        }
        category.setActive(isActive);
        if (parentId != null && parentId > 0 && !Objects.equals(category.getParentId(), parentId)){
            category.setParentId(parentId);
        }
        return category;
    }


}
