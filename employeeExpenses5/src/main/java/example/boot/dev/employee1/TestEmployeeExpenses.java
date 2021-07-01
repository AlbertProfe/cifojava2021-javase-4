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
	private ExpenseRepository expenseRepository;
	@Autowired
	private HolidaysRepository holidaysRepository;
	@Autowired
	private CertificateRepository certificateRepository;
	@Autowired
	private EnrollmentRepository enrollmenRepository;
	@Autowired
	private CourseRepository courseRepository;

	public void run(String... args) throws Exception {

		Employee isa = new Employee("Isabel", "GoogleLand", 25, "@isa", 1500.00, "11234");
		Employee joan = new Employee("Joan", "PreGoogleLand", 25, "@joan", 1200.00, "14");
		Employee dimitry = new Employee("Dimitry", "Paskin", 23, "@dimitry", 1100.00, "1564");

		employeeRepository.save(isa);
		employeeRepository.save(joan);
		employeeRepository.save(dimitry);

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

		Holidays holidays1 = new Holidays(2019, 28);
		Holidays holidays2 = new Holidays(2020, 26);
		Holidays holidays3 = new Holidays(2021, 25);

		holidays1.setEmployee(joan);

		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
		String dateInString = "2019-10-15";
		holidays1.addHolidays(formater.parse(dateInString));
		dateInString = "2019-09-01";
		holidays1.addHolidays(formater.parse(dateInString));
		dateInString = "2019-04-25";
		holidays1.addHolidays(formater.parse(dateInString));

		holidays2.setEmployee(joan);
		dateInString = "2020-11-25";
		holidays2.addHolidays(formater.parse(dateInString));
		dateInString = "2020-08-11";
		holidays2.addHolidays(formater.parse(dateInString));
		dateInString = "2020-01-15";
		holidays2.addHolidays(formater.parse(dateInString));

		holidays3.setEmployee(joan);
		dateInString = "2021-01-25";
		holidays3.addHolidays(formater.parse(dateInString));
		dateInString = "2021-01-11";
		holidays3.addHolidays(formater.parse(dateInString));
		dateInString = "2021-01-15";
		holidays3.addHolidays(formater.parse(dateInString));
		dateInString = "2021-02-14";
		holidays3.addHolidays(formater.parse(dateInString));
		dateInString = "2021-02-15";
		holidays3.addHolidays(formater.parse(dateInString));
		dateInString = "2021-02-16";
		holidays3.addHolidays(formater.parse(dateInString));
		dateInString = "2021-02-17";
		holidays3.addHolidays(formater.parse(dateInString));
		dateInString = "2021-02-18";
		holidays3.addHolidays(formater.parse(dateInString));
		dateInString = "2021-02-19";
		holidays3.addHolidays(formater.parse(dateInString));

		holidaysRepository.save(holidays1);
		holidaysRepository.save(holidays2);
		holidaysRepository.save(holidays3);

		Certificate javacourse = new Certificate("JAVA", "IFCD", 500, 3, true);
		certificateRepository.save(javacourse);
		Certificate jpa = new Certificate("JPA", "IFCD", 250, 3, true);
		certificateRepository.save(jpa);
		Certificate rest = new Certificate("REST", "IFCD", 400, 3, true);
		certificateRepository.save(rest);
		Certificate th = new Certificate("TH", "IFCD", 600, 3, true);
		certificateRepository.save(th);
		Certificate spring = new Certificate("SPRING", "IFCD", 450, 3, true);
		certificateRepository.save(th);

		Course java2019 = new Course("room106C", false, formater.parse("2019-10-01"), formater.parse("2019-12-01"),
				"morning", 2526.23, "Albert");
		Course java2020 = new Course("room106C", false, formater.parse("2020-10-01"), formater.parse("2020-12-01"),
				"afternoon", 2526.23, "Laia");
		Course jpa2021 = new Course("room10", false, formater.parse("2021-03-01"), formater.parse("2021-06-01"),
				"morning", 2526.23, "Josep");
		
		java2019.setCertificate(javacourse);
		java2020.setCertificate(javacourse);
		jpa2021.setCertificate(jpa);

		
		courseRepository.save(java2019);
		courseRepository.save(java2020);
		courseRepository.save(jpa2021);
	
		Enrollment enroll01 = new Enrollment(formater.parse("2019-10-01"), 10, true);
		Enrollment enroll02 = new Enrollment(formater.parse("2019-10-01"), 10, true);
		Enrollment enroll03 = new Enrollment(formater.parse("2019-10-01"), 10, true);
		Enrollment enroll04 = new Enrollment(formater.parse("2019-10-01"), 10, true);
		Enrollment enroll05 = new Enrollment(formater.parse("2019-10-01"), 10, true);
		
		enroll01.setCourse(java2019);
		enroll01.setEmployee(isa);
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
