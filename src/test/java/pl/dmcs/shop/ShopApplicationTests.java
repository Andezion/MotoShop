package pl.dmcs.shop;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.dmcs.shop.model.*;
import pl.dmcs.shop.repo.CustomerRepo;
import pl.dmcs.shop.repo.MotoRepo;
import pl.dmcs.shop.repo.PartRepo;
import pl.dmcs.shop.repo.TransactionRepo;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Slf4j
@SpringBootTest
class ShopApplicationTests
{
    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private MotoRepo motoRepo;

    @Autowired
    private PartRepo partRepo;

    @Autowired
    private TransactionRepo transactionRepo;

    @Test
    void contextLoads()
    {

        Customer customer1 = createCustomer("Test1", "User1", "user_1@gmail.com");
        Customer customer2 = createCustomer("Test2", "User2", "user_2@gmail.com");
        Customer customer3 = createCustomer("Test3", "User3", "user_3@gmail.com");

        Moto moto1 = createMoto(Model.Dodge, LocalDate.of(2025, 3, 12), customer1);
        Moto moto2= createMoto(Model.Suzuki, LocalDate.of(2025, 3, 16), customer2);
        Moto moto3 = createMoto(Model.Yamaha, LocalDate.of(2025, 3, 18), customer3);

        log.info("\n------------------------------------------------------------------------------------------------------------------------------------");


        long motoCount1 = motoRepo.count();
        assertThat(motoCount1).isGreaterThan(0);
        assertThat(motoCount1).isEqualTo(3);

        motoRepo.findAll().forEach(it -> log.info("Model moto: {}", it.getModel()));
        log.info("Liczba wszystkich moto : {}", motoCount1);

        log.info("\n------------------------------------------------------------------------------------------------------------------------------------");


        long motoCount2 = motoRepo.countAllMotoByDateBetween(LocalDate.of(2025, 3, 1), LocalDate.of(2025, 3, 31));
        List<Moto> motoList1 = motoRepo.findAllMotoByDateBetween(LocalDate.of(2025, 3, 1), LocalDate.of(2025, 3, 31));

        assertThat(motoRepo.findAll().iterator().hasNext()).isTrue();
        assertThat(motoList1.size()).isEqualTo(3);

        motoRepo.findAllMotoByDateBetween(LocalDate.of(2025, 1, 1),LocalDate.of(2025, 12,31))
                .forEach(it -> log.info("Model moto : {}", it.getModel()));
        log.info("Liczba wszystkich moto w 2025 : {}", motoCount2);

        log.info("\n------------------------------------------------------------------------------------------------------------------------------------");

        Customer customer4 = createCustomer("John", "Doe", "john@example.com");
        Customer customer5 = createCustomer("Alice", "Smith", "alice@example.com");

        customerRepo.findAll().forEach(customer -> log.info(customer.toString()));

        assertThat(customerRepo.count()).isEqualTo(5);

        List<Customer> customersByFirstName = customerRepo.findByFirstName("John");
        assertThat(customersByFirstName.size()).isEqualTo(1);
        assertThat(customersByFirstName.getFirst().getLastName()).isEqualTo("Doe");

        List<Customer> customersByEmail = customerRepo.findByEmail("alice@example.com");
        assertThat(customersByEmail.size()).isEqualTo(1);
        assertThat(customersByEmail.getFirst().getFirstName()).isEqualTo("Alice");

        log.info("CustomerRepo - correct!\n");

        log.info("\n------------------------------------------------------------------------------------------------------------------------------------");

        Customer customer6 = createCustomer("Test", "User", "user@gmail.com");
        Moto moto = createMoto(Model.Yamaha, LocalDate.of(2025, 3, 12), customer6);

        List<Part> parts = List.of(
                new Part(1, Parts.Part1, "Engine", 500.0, moto),
                new Part(2, Parts.Part2, "Brakes", 200.0, moto),
                new Part(3, Parts.Part3, "Wheels", 300.0, moto),
                new Part(4, Parts.Part4, "Exhaust", 150.0, moto),
                new Part(5, Parts.Part5, "Seat", 100.0, moto)
        );

        partRepo.saveAll(parts);

        List<Part> storedParts = partRepo.findAll();
        assertThat(storedParts.size()).isEqualTo(5);
        storedParts.forEach(part -> log.info("Details: {}", part.getName()));

        log.info("\n------------------------------------------------------------------------------------------------------------------------------------");

        Customer customer7 = createCustomer("Lera", "Topchik", "kpop@example.com");

        Moto moto4 = createMoto(Model.Yamaha, LocalDate.of(2025, 5, 10), customer7);
        Moto moto5 = createMoto(Model.Suzuki, LocalDate.of(2025, 6, 15), customer7);

        Part part1 = createPart(Parts.Part1, "Part1", 1200.50);
        Part part2 = createPart(Parts.Part5, "Part2", 250.00);
        Part part3 = createPart(Parts.Part3, "Part3", 150.75);

        Transaction transaction = createTransaction(customer7, List.of(moto1, moto2), List.of(part1, part2, part3));

        log.info("\n----------------------------------------------------");
        log.info("Trans created ID: {}", transaction.getId());
        log.info("Date: {}", transaction.getOrderDate());
        log.info("Sum: {}", transaction.getTotalPrice());
        log.info("Client: {} {}", transaction.getCustomer().getFirstName(), transaction.getCustomer().getLastName());
        log.info("Number of moto: {}", transaction.getMotos().size());
        log.info("Number of details: {}", transaction.getParts().size());
        log.info("----------------------------------------------------\n");

        assertThat(transactionRepo.count()).isGreaterThan(0);
        assertThat(transaction.getTotalPrice()).isEqualTo(1601.25);
        assertThat(transaction.getCustomer()).isEqualTo(customer7);
        assertThat(transaction.getMotos().size()).isEqualTo(2);
        assertThat(transaction.getParts().size()).isEqualTo(3);
    }

    private Customer createCustomer(String firstName, String lastName, String email)
    {
        return customerRepo.save(new Customer().withFirstName(firstName).withLastName(lastName).withEmail(email));
    }

    private Moto createMoto(Model model, LocalDate date, Customer customer)
    {
        return motoRepo.save(new Moto().withModel(model).withDate(date).withCustomer(customer));
    }

    private Part createPart(Parts name, String description, double price)
    {
        return partRepo.save(new Part().withName(name).withDescription(description).withPrice(price));
    }

    private Transaction createTransaction(Customer customer, List<Moto> motos, List<Part> parts)
    {
        double totalPrice = parts.stream().mapToDouble(Part::getPrice).sum();

        return transactionRepo.save(new Transaction()
                .withCustomer(customer)
                .withMotos(motos)
                .withParts(parts)
                .withTotalPrice(totalPrice)
                .withOrderDate(LocalDate.now()));
    }
}
