package example.boot.dev.employee1;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/webapi")
public class EmployeeRestController {

	@Autowired
	EmployeeRepository employeeRepository;

	@GetMapping("/allEmployees")
	public Iterable<Employee> getAllEnployees() {

		return employeeRepository.findAll();
	}

	@GetMapping("/getEmployee/{id}")
	public Employee findById(@PathVariable int id) {

		Optional<Employee> employeeFound = employeeRepository.findById(id);

		if (employeeFound.isPresent()) {

			return employeeFound.get();
		}

		return null;
	}

	@DeleteMapping("/deleteEmployee/{id}")
	public void deleteEmployee(@PathVariable int id) {

		employeeRepository.deleteById(id);
	}

	@PostMapping(path = "/addEmployee", consumes = "application/json")
	public void insertEmployee(@RequestBody Employee employee) {

		// System.out.println(book);
		employeeRepository.save(employee);
	}

	@PutMapping("/updateEmployee/{id}")
	public void upadateEmployee(@RequestBody Employee employee, @PathVariable int id) {

		Optional<Employee> employeeFound = employeeRepository.findById(id);

		if (employeeFound.isPresent()) {

			if (!employee.getName().equals(employeeFound.get().getName()))
				employeeFound.get().setName(employee.getName());
			
			if (!employee.getSurname().equals(employeeFound.get().getSurname()))
				employeeFound.get().setSurname(employee.getSurname());

			if (employee.getAge() != employeeFound.get().getAge())
				employeeFound.get().setAge(employee.getAge());

			if (!employee.getEmail().equals(employeeFound.get().getEmail()))
				employeeFound.get().setEmail(employee.getEmail());

			if (employee.getMonthSalary() != employeeFound.get().getMonthSalary())
				employeeFound.get().setMonthSalary(employee.getMonthSalary());

			if (!employee.getPassword().equals(employeeFound.get().getPassword()))
				employeeFound.get().setPassword(employee.getPassword());

			employeeRepository.save(employeeFound.get());
		}
	}

}
