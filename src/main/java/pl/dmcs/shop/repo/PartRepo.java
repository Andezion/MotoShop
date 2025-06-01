package pl.dmcs.shop.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.dmcs.shop.model.Part;

@Repository
public interface PartRepo extends JpaRepository<Part, Integer>
{

}
