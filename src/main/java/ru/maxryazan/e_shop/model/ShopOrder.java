package ru.maxryazan.e_shop.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.maxryazan.e_shop.model.modelStates.OrderStatus;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "shop_order")
public class ShopOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "date_from")
    private String dateFrom;

    @Column(name = "order_price")
    private BigDecimal orderPrice;

    @Enumerated(value = EnumType.STRING)
    private OrderStatus orderStatus;

    @ManyToOne
    @JoinColumn(name = "client_id")
    @JsonBackReference
    private Client client;

    @ManyToMany
    @JsonManagedReference
    @JoinTable(
    name = "products_in_order",
    joinColumns = @JoinColumn(name = "shop_order_id"),
    inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> products;
}
