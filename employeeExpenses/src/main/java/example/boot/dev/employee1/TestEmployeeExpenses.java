package example.boot.dev.employee1;

import java.util.Date;
import java.util.Random;
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
	private ExpenseRepository expenseRepository;

	public void run(String... args) throws Exception {
		
		Employee isa = new Employee ("Isabel", "GoogleLand", 25, "@isa", 1000.00,"11234");
		Employee joan = new Employee ("Joan", "PreGoogleLand", 25, "@joan", 1000.00,"14");
		
		employeeRepository.save(isa);
		employeeRepository.save(joan);
		
		Expense festa = new Expense ("festa", new Date(), 15.25);
		
		expenseRepository.save(festa);
		
		isa.addExpense(festa);
		//joan.addExpense(festa);
		
		employeeRepository.save(isa);
		
		Expense festa2 = new Expense ("festa", new Date(), 15.25, isa);
		Expense festa3 = new Expense ("festa", new Date(), 15.25, joan);
		
		expenseRepository.save(festa2);
		expenseRepository.save(festa3);

	}
	
	
	public static int createIntRandom(int top) {

		Random rand = new Random();

		// Generate random integers in range 0 to top, if top=10 random 0 to 9
		int intRandom = rand.nextInt(top);
		return intRandom;

	}

}
