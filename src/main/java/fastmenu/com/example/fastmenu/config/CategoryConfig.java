package fastmenu.com.example.fastmenu.config;

import fastmenu.com.example.fastmenu.dto.Category;
import fastmenu.com.example.fastmenu.repository.CategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CategoryConfig {

    @Bean
    CommandLineRunner commandLineRunner(CategoryRepository repository){
        return  args -> {
            Category yiyecek = new Category(
                "Yiyecekler",
                    true
                    ,null

            );
            repository.saveAll(List.of(yiyecek));

        };
    }
}
