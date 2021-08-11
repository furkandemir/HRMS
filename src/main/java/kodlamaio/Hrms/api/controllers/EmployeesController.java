package kodlamaio.Hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.Hrms.business.abstracts.EmployeeService;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.entities.concretes.Employee;


@RestController
@RequestMapping("/api/employees")
public class EmployeesController {
	
	private EmployeeService employeeservice;
	
	@Autowired
	public EmployeesController(EmployeeService employeeservice) {
		super();
		this.employeeservice = employeeservice;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Employee>> getAll(){
		
		return this.employeeservice.getAll();
	}

}
