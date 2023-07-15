package service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;
import org.springframework.stereotype.Service;

import model.Employee;
import repository.EmployeeRepository;
@Service
public class EmployeeService implements EmployeeServiceInterface {
	 @Autowired
	    private EmployeeRepository employeeRepository;

	    @Override
	    public Employee saveEmployee(Employee employee) {
	        return employeeRepository.save(employee);
	    }

	    @Override
	    public Optional<Employee> getEmployeeById(int id) {
	        return employeeRepository.findById(id);
	    }

	    @Override
	    public List<Employee> getAllEmployee() {
	        return employeeRepository.findAll(org.springframework.data.domain.Sort.by(org.springframework.data.domain.Sort.Direction.DESC,"id"));
	    }

	    @Override
	    public Employee updateEmployee(int id, Employee employee) {
	        Employee employeeToUpdate = employeeRepository.findById(id).orElseThrow();
	        employeeToUpdate.setFirstName(employee.getFirstName());
	        employeeToUpdate.setLastName(employee.getLastName());
	        employeeToUpdate.setEmail(employee.getEmail());
	        return employeeRepository.save(employeeToUpdate);
	    }

	    @Override
	    public void deleteEmployee(int id) {
	        employeeRepository.deleteById(id);
	    }

}
