package pl.dmcs.shop.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.dmcs.shop.model.Moto;

import java.time.LocalDate;
import java.util.List;

public interface MotoRepo extends JpaRepository<Moto, Integer>
{
    List<Moto> findAllMotoByDateBetween(LocalDate from, LocalDate to);

    long countAllMotoByDateBetween(LocalDate from, LocalDate to);
    double countAllMotoPriceByDateBetween(LocalDate from, LocalDate to);
}
