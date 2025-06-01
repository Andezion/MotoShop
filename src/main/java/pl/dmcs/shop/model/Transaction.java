package pl.dmcs.shop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Data
@With
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Transaction
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Customer customer;

    @ManyToMany

    private List<Moto> motos;

    @ManyToMany
    private List<Part> parts;

    private double totalPrice;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate orderDate;
}
