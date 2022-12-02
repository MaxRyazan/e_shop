package ru.maxryazan.e_shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.maxryazan.e_shop.model.ShopOrder;

import java.util.List;

@Repository
public interface ShopOrderRepository extends JpaRepository<ShopOrder, Long> {

    ShopOrder findById(long id);

    @Query(value = "select * from shop_order so where so.client_id =?1", nativeQuery = true)
    List<ShopOrder> findOrdersByClientId(long id);

    @Query(value = "select * from shop_order so where so.client_id =?1 and so.order_status = 'PAID'", nativeQuery = true)
    List<ShopOrder> findPaidOrdersByClientId(long id);

    @Query(value = "select * from shop_order so where so.client_id =?1 and so.order_status = 'NOT_PAID'", nativeQuery = true)
    List<ShopOrder> findNotPaidOrdersByClientId(long id);
}
