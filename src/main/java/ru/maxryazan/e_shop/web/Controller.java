package ru.maxryazan.e_shop.web;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.maxryazan.e_shop.model.Client;
import ru.maxryazan.e_shop.model.Product;
import ru.maxryazan.e_shop.model.ShopOrder;
import ru.maxryazan.e_shop.service.ClientService;
import ru.maxryazan.e_shop.service.ProductService;
import ru.maxryazan.e_shop.service.ShopOrderService;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
public class Controller {


    private final ClientService clientService;
    private final ShopOrderService orderService;
    private final ProductService productService;

    //показать клиента(вместе с его заказами)
    @GetMapping("/client/{id}")
    public ResponseEntity<Client> findById(@PathVariable long id){
        return new ResponseEntity<>(clientService.findById(id), HttpStatus.OK);
    }

    // Показать все заказы клинта
    @GetMapping("/client/{id}/orders")
    public ResponseEntity<List<ShopOrder>> findOrdersByClientId(@PathVariable long id){
        return new ResponseEntity<>(orderService.findOrdersByClientId(id), HttpStatus.OK);
    }

    // Показать все оплаченные заказы клинта
    @GetMapping("/client/{id}/paid_orders")
    public ResponseEntity<List<ShopOrder>> findPaidOrdersByClientId(@PathVariable long id){
        return new ResponseEntity<>(orderService.findPaidOrdersByClientId(id), HttpStatus.OK);
    }

    // Показать все НЕ оплаченные заказы клинта
    @GetMapping("/client/{id}/not_paid_orders")
    public ResponseEntity<List<ShopOrder>> findNotPaidOrdersByClientId(@PathVariable long id){
        return new ResponseEntity<>(orderService.findNotPaidOrdersByClientId(id), HttpStatus.OK);
    }

    //показать заказ с номером {id}
    @GetMapping("/order/{id}")
    public ResponseEntity<ShopOrder> showOneOrderById(@PathVariable long id){
        return new ResponseEntity<>(orderService.findById(id), HttpStatus.OK);
    }

    //показать все продукты выбранной категории
    @GetMapping("/product/{category}")
    public ResponseEntity<List<Product>> showAllProductsByCategory(@PathVariable String category){
        return new ResponseEntity<>(productService.showAllProductsByCategory(category), HttpStatus.OK);
    }

    //показать все ДОСТУПНЫЕ продукты выбранной категории
    @GetMapping("/product/available/{category}")
    public ResponseEntity<List<Product>> showAllAvailableProductsByCategory(@PathVariable String category){
        return new ResponseEntity<>(productService.showAllAvailableProductsByCategory(category), HttpStatus.OK);
    }


    @GetMapping("/product/discount")
    public ResponseEntity<List<Product>> showAllDiscountProducts(){
        return new ResponseEntity<>(productService.showAllDiscountProducts(), HttpStatus.OK);
    }
}
