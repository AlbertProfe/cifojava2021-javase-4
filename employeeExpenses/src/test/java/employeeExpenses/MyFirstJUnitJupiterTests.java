package employeeExpenses;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import example.boot.dev.employee1.Employee;
import example.boot.dev.employee1.EmployeeRepository;

@SpringBootApplication 
@RunWith(SpringRunner.class)
@Import(Employee.class)
class MyFirstJUnitJupiterTests {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Test
	@DisplayName("Create two employye")
	void saveEmployee() {
		Employee isa = new Employee("Isabel", "GoogleLand", 25, "@isa", 1000.00, "11234");
		Employee joan = new Employee("Joan", "PreGoogleLand", 25, "@joan", 1000.00, "14");

		employeeRepository.save(isa);
		employeeRepository.save(joan);

		//Iterable<Employee> employeeFound = employeeRepository.findByAge(25);
		
		assertEquals(2, employeeRepository.count());
	}

}