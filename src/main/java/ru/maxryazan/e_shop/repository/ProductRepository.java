package ru.maxryazan.e_shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.maxryazan.e_shop.model.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "select * from product pr where pr.category = ?1", nativeQuery = true)
    List<Product> showAllProductsByCategory(String category);

    @Query(value = "select * from product pr where pr.category =?1 AND pr.product_status = 'AVAILABLE'", nativeQuery = true)
    List<Product> showAllAvailableProductsByCategory(String category);

    @Query(value = "select * from product pr where pr.discount = 1", nativeQuery = true)
    List<Product> showAllDiscountProducts();

}
