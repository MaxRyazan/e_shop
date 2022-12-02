package ru.maxryazan.e_shop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.maxryazan.e_shop.model.Client;
import ru.maxryazan.e_shop.model.ShopOrder;
import ru.maxryazan.e_shop.repository.ClientRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;


    public Client findById(long id){
        return clientRepository.findById(id);
    }

}
