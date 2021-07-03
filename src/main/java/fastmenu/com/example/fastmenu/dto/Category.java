package fastmenu.com.example.fastmenu.dto;

import javax.persistence.*;

@Entity
@Table
public class Category {
    @Id
    @SequenceGenerator(
            name = "category_sequence",
            sequenceName = "category_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "category_sequence"
    )
    private Long id;
    private String name;
    private boolean isActive;
    private Long parentId;

    public Category() {
    }

    public Category(Long id, String name, boolean isActive, Long parentId) {
        this.id = id;
        this.name = name;
        this.isActive = isActive;
        this.parentId = parentId;
    }

    public Category(String name, boolean isActive, Long parentId) {
        this.name = name;
        this.isActive = isActive;
        this.parentId = parentId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isActive=" + isActive +
                ", parentId=" + parentId +
                '}';
    }
}
