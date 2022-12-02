package ru.maxryazan.e_shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.maxryazan.e_shop.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    Client findById(long id);
}
