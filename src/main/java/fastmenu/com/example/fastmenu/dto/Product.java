package fastmenu.com.example.fastmenu.dto;

import javax.persistence.*;

@Entity
@Table
public class Product {
    @Id
    @SequenceGenerator(
            name = "product_sequence",
            sequenceName = "product_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_sequence"
    )

    private Long Id;
    private String Name;
    private String Description;
    private String Image;
    private int Price;

    public Product() {
    }

    public Product(Long id, String name, String description, String image, int price) {
        Id = id;
        Name = name;
        Description = description;
        Image = image;
        Price = price;
    }

    public Product(String name, String description, String image, int price) {
        Name = name;
        Description = description;
        Image = image;
        Price = price;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                ", Description='" + Description + '\'' +
                ", Image='" + Image + '\'' +
                ", Price=" + Price +
                '}';
    }
}
