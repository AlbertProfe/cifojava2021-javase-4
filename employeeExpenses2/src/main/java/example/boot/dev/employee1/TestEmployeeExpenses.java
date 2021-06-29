package example.boot.dev.employee1;

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
	private ExpenseRepository expenseRepository;
	@Autowired
	private HolidaysRepository holidaysRepository;

	public void run(String... args) throws Exception {

		Employee isa = new Employee("Isabel", "GoogleLand", 25, "@isa", 1000.00, "11234");
		Employee joan = new Employee("Joan", "PreGoogleLand", 25, "@joan", 1000.00, "14");

		employeeRepository.save(isa);
		employeeRepository.save(joan);

		printTable(employeeRepository);

		Expense festa1 = new Expense("festa1", new Date(), 15.25);
		Expense festa2 = new Expense("festa2", new Date(), 15.25);
		Expense festa3 = new Expense("festa3", new Date(), 15.25);

		expenseRepository.save(festa1);
		expenseRepository.save(festa2);
		expenseRepository.save(festa3);
		
		
		isa.addExpense(festa3);
		joan.addExpense(festa1);
		joan.addExpense(festa2);
		
		employeeRepository.save(joan);
		employeeRepository.save(isa);
		
		printTable(employeeRepository);
		
		Holidays holidays1 = new Holidays(2020, 26); 
		
		holidays1.setEmployee(joan);
		holidays1.addHolidays(new Date());
		holidays1.addHolidays(new Date());
		holidays1.addHolidays(new Date());
		
		holidaysRepository.save(holidays1);
		
		
	}

	public static int createIntRandom(int top) {

		Random rand = new Random();

		// Generate random integers in range 0 to top, if top=10 random 0 to 9
		int intRandom = rand.nextInt(top);
		return intRandom;

	}

	public static void printTable(EmployeeRepository employeeRepository) {

		logger.info("Employee table");
		employeeRepository.findAll().forEach((employee) -> {
			logger.info("{}", employee);
		});
		logger.info("--------------------------------------------------");
	}

	public static void printTable(ExpenseRepository expenseRepository) {

		logger.info("Expense table");
		expenseRepository.findAll().forEach((expense) -> {
			logger.info("{}", expense);
		});
		logger.info("--------------------------------------------------");
	}
}
