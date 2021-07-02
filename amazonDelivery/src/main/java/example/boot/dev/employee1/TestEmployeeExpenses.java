package example.boot.dev.employee1;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.github.javafaker.Faker;

@Component
public class TestEmployeeExpenses implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(TestEmployeeExpenses.class);

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
		


		
		
	}

	
}
