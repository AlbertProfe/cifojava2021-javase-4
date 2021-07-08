package example.boot.dev.employee1;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TestEmployeeExpenses implements CommandLineRunner {

	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private ShopRepository shopRepository;
	@Autowired
	private VehicleRepository vehicleRepository;
	@Autowired
	private ProductRepository productRepository;

	public void run(String... args) throws Exception {

		Employee isa = new Employee("Isabel", "GoogleLand", 25, "@isa", 1500.00, "11234");
		Employee joan = new Employee("Joan", "PreGoogleLand", 25, "@joan", 1200.00, "14");
		Employee dimitry = new Employee("Dimitry", "Paskin", 23, "@dimitry", 1100.00, "1564");

		employeeRepository.save(isa);
		employeeRepository.save(joan);
		employeeRepository.save(dimitry);

		Shop shop1 = new Shop("Toys & Us", "Barcelona", "12645O", "mornings");
		Shop shop2 = new Shop("Abacus", "Barcelona", "896235P", "mornings-afternoon");
		Shop shop3 = new Shop("Toys & Us", "Barcelona", "457426L", "nights");
		Shop shop4 = new Shop("Toys & Us", "Barcelona", "5465454M", "afternoons");

		shopRepository.save(shop1);
		shopRepository.save(shop2);
		shopRepository.save(shop3);
		shopRepository.save(shop4);

		Vehicle vehicle1 = new Vehicle("Mercedes Cito", "Mercedes", "5546-B", "2400 v", 7.8, true);
		Vehicle vehicle2 = new Vehicle("Mercedes Sprinter", "Mercedes", "8921-B", "1400 v", 12.3, true);
		Vehicle vehicle3 = new Vehicle("Mercedes Van 2600", "Mercedes", "1258-B", "2800 v", 8.1, true);

		vehicleRepository.save(vehicle1);
		vehicleRepository.save(vehicle2);
		vehicleRepository.save(vehicle3);

		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");

		OrderService order1 = new OrderService(formater.parse("2021-07-01"), 3, "byHand", true);
		OrderService order2 = new OrderService(formater.parse("2021-07-01"), 3, "byHand", true);
		OrderService order3 = new OrderService(formater.parse("2021-07-01"), 3, "byHand", true);

		order1.setEmployee(isa);
		order1.setShop(shop1);
		order1.setVehicle(vehicle1);

		order2.setEmployee(isa);
		order2.setShop(shop2);
		order2.setVehicle(vehicle2);

		order3.setEmployee(joan);
		order3.setShop(shop2);
		order3.setVehicle(vehicle2);

		orderRepository.save(order1);
		orderRepository.save(order2);
		orderRepository.save(order3);

		Product product1 = new Product("PC 16GB 1TB SSD", 650.25, 30, true);
		Product product2 = new Product("PC 32GB 1TB SSD", 850.25, 25, true);
		Product product3 = new Product("PC 64GB 1TB SSD", 1050.25, 35, true);
		Product product4 = new Product("PC 128GB 1TB SSD", 1250.25, 60, true);
		productRepository.save(product1);
		productRepository.save(product2);
		productRepository.save(product3);
		productRepository.save(product4);

		shop1.addProduct(product1);
		shop1.addProduct(product2);
		shop1.addProduct(product3);
		shop2.addProduct(product3);
		shop2.addProduct(product4);
		shopRepository.save(shop1);
		shopRepository.save(shop2);
		
		
		product4.addShop(shop3);
		productRepository.save(product4);
		
		
		

	}
}
