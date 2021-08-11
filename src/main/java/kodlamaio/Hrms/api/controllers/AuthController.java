package kodlamaio.Hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.Hrms.business.abstracts.AuthService;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.concretes.Candidate;
import kodlamaio.Hrms.entities.concretes.Employer;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	private AuthService authservice;

	@Autowired
	public AuthController(AuthService authservice) {
		super();
		this.authservice = authservice;
	}
	
	@PostMapping("/registerCandidate")
	public Result RegisterCandidate(@RequestBody Candidate candidate, String Repeatpassword) {
		return authservice.RegisterCandidate(candidate, Repeatpassword);
	}
	
	@PostMapping("/registerEmployer")
	public Result RegisterEmployer(@RequestBody Employer employer,String Repeatpassword) {
		return authservice.RegisterEmployer(employer, Repeatpassword);
	}
	

}
