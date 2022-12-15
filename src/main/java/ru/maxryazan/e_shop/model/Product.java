package ru.maxryazan.e_shop.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.maxryazan.e_shop.model.modelStates.ProductCategory;
import ru.maxryazan.e_shop.model.modelStates.ProductStatus;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_description")
    private String productDescription;

    @Column(name = "product_article")
    private String productArticle;

    @Column(name = "category")
    @Enumerated(value = EnumType.STRING)
    private ProductCategory category;

    @ManyToMany
    @JoinTable(name = "product_sub_categories",
    joinColumns = {@JoinColumn(name = "product_id")},
    inverseJoinColumns = {@JoinColumn(name = "sub_category_id")}
    )
    private List<SubCategory> subCategories;

    @Column(name = "product_price")
    private BigDecimal productPrice;

    @Column(name = "photos")
    @ElementCollection
    private List<String> photos;

    @ManyToMany(mappedBy = "products")
    @JsonBackReference
    private List<ShopOrder> orders;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "product_status")
    private ProductStatus productStatus;

    @Column(name = "product_manufacturer")
    private String productManufacturer;

    @Column(name = "discount")
    private boolean discount;

    public Product(String productName, String productDescription, String productArticle,
                   ProductCategory category, BigDecimal productPrice,
                   ProductStatus productStatus, String productManufacturer) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.productArticle = productArticle;
        this.category = category;
        this.productPrice = productPrice;
        this.photos = List.of(productName.toLowerCase().replace(" ", "") + "1", productName.toLowerCase().replace(" ", "") + "2", productName.toLowerCase().replace(" ", "") + "3");
        this.productStatus = productStatus;
        this.productManufacturer = productManufacturer;
        this.discount = false;
    }
}
