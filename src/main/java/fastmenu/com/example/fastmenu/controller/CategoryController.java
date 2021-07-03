package fastmenu.com.example.fastmenu.controller;

import fastmenu.com.example.fastmenu.dto.Category;
import fastmenu.com.example.fastmenu.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/categories")
public class CategoryController {
    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> getCategories(){
        return categoryService.getCategories();
    }
    @PostMapping
    public Category saveCategory(Category category){
       return  categoryService.saveCategory(category);
    }

    @DeleteMapping
    public boolean deleteCategory(long id){
        return categoryService.deleteCategory(id);
    }
    @PutMapping(path = "{categoryId}")
    public Category updateCategory(@PathVariable("categoryId") Long id,
                                   @RequestParam(required = false) String name,
                                   @RequestParam(required = false) boolean isActive,
                                   @RequestParam(required = false) Long parentId
                                   ){
        return categoryService.updateCategory(id, name, isActive, parentId);
    }
}
