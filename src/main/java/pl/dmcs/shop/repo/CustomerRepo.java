package pl.dmcs.shop.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.dmcs.shop.model.Customer;

import java.util.List;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long>
{
    List<Customer> findAll(); // Возвращает всех клиентов

    List<Customer> findByFirstName(String firstName);
    List<Customer> findByLastName(String lastName);
    List<Customer> findByEmail(String email);
}
