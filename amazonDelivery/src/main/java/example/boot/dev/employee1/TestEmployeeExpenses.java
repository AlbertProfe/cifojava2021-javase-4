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
	
	public void run(String... args) throws Exception {

		Employee isa = new Employee("Isabel", "GoogleLand", 25, "@isa", 1500.00, "11234");
		Employee joan = new Employee("Joan", "PreGoogleLand", 25, "@joan", 1200.00, "14");
		Employee dimitry = new Employee("Dimitry", "Paskin", 23, "@dimitry", 1100.00, "1564");

		employeeRepository.save(isa);
		employeeRepository.save(joan);
		employeeRepository.save(dimitry);
		
		Shop shop1 = new Shop ("Toys & Us", "Barcelona", "12645O", "mornings");
		Shop shop2 = new Shop ("Abacus", "Barcelona", "896235P", "mornings-afternoon");
		Shop shop3 = new Shop ("Toys & Us", "Barcelona", "457426L", "nights");
		Shop shop4 = new Shop ("Toys & Us", "Barcelona", "5465454M", "afternoons");
		
		shopRepository.save(shop1);
		shopRepository.save(shop2);
		shopRepository.save(shop3);
		shopRepository.save(shop4);
		
		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
	
		
		OrderService order1 = new OrderService (formater.parse("2021-07-01"), 3, "byHand", true);
		OrderService order2 = new OrderService (formater.parse("2021-07-01"), 3, "byHand", true);
		OrderService order3 = new OrderService (formater.parse("2021-07-01"), 3, "byHand", true);
		
		order1.setEmployee(isa);
		order1.setShop(shop1);
		
		order2.setEmployee(isa);
		order2.setShop(shop2);
		
		order3.setEmployee(joan);
		order3.setShop(shop2);
		
		
		orderRepository.save(order1);
		orderRepository.save(order2);
		orderRepository.save(order3);
		
		
	}	
}
