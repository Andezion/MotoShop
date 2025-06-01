package pl.dmcs.shop.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.dmcs.shop.model.Transaction;

@Repository
public interface TransactionRepo extends JpaRepository<Transaction, Integer>
{

}
