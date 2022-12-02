package ru.maxryazan.e_shop.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

    @Column(name = "category")
    @Enumerated(value = EnumType.STRING)
    private ProductCategory category;

    @Column(name = "product_price")
    private BigDecimal productPrice;

    @ManyToMany(mappedBy = "products")
    @JsonBackReference
    private List<ShopOrder> orders;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "product_status")
    private ProductStatus productStatus;
}
