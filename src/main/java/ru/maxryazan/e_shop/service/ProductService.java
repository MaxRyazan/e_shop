package ru.maxryazan.e_shop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.maxryazan.e_shop.model.Product;
import ru.maxryazan.e_shop.repository.ProductRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> showAllProductsByCategory(String category) {
        return productRepository.showAllProductsByCategory(category);
    }

    public List<Product> showAllAvailableProductsByCategory(String category) {
        return productRepository.showAllAvailableProductsByCategory(category);
    }
}
