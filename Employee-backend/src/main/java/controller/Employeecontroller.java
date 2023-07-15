package controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Employee;
import service.EmployeeService;
@RestController
@RequestMapping("/employee")
@CrossOrigin("*")
public class Employeecontroller {
	  @Autowired
	    private EmployeeService employeeService; //we are bringing in Employee Service instance

	    /**This is a post Request, here we are gonna ba saving an employee*/
	    @PostMapping
	    public Employee saveEmployee(@RequestBody Employee employee){
	        return employeeService.saveEmployee(employee);
	    }
	        /** Here, we are getting all employee*/
	    @GetMapping
	    public List<Employee> getAllEmployee(){
	        return employeeService.getAllEmployee();
	    }
	     /**here, we are geting one empployee*/
	    @GetMapping("/{id}")
	    public Optional<Employee> getEmployeeById(@PathVariable int id){
	        return employeeService.getEmployeeById(id);
	    }
	        /**here, we get gonna be updating an employee*/
	    @PutMapping("/{id}")
	    public Employee updateEmployee(@PathVariable int id, @RequestBody Employee employee){
	        return employeeService.updateEmployee(id,employee);
	    }
	      /**Here, we are gonna be deleting an employee*/
	    @DeleteMapping("/{id}")
	    public void deleteEmployee(@PathVariable int id){
	        employeeService.deleteEmployee(id);
	    }

}
