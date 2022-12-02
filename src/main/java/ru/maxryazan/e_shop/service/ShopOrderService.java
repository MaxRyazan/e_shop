package ru.maxryazan.e_shop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.maxryazan.e_shop.model.ShopOrder;
import ru.maxryazan.e_shop.repository.ShopOrderRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ShopOrderService {

    private final ShopOrderRepository orderRepository;

    public ShopOrder findById(long id){
        return orderRepository.findById(id);

    }

    public List<ShopOrder> findOrdersByClientId(long id) {
        return orderRepository.findOrdersByClientId(id);
    }

    public List<ShopOrder> findPaidOrdersByClientId(long id) {
        return orderRepository.findPaidOrdersByClientId(id);
    }

    public List<ShopOrder> findNotPaidOrdersByClientId(long id) {
        return orderRepository.findNotPaidOrdersByClientId(id);
    }
}
