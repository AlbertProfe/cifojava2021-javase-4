package example.boot.dev.employee1;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/webapi")
public class EmployeeRestController {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@GetMapping("/allEmployees")
	public  Iterable<Employee> getAllEnployees () {
		
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
	
	
	

}
