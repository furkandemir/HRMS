package kodlamaio.Hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.Hrms.business.abstracts.VerificationCodeService;
import kodlamaio.Hrms.entities.concretes.VerificationCode;


@RestController
@RequestMapping("/api/verificationcodes")
public class VerificationCodesController {
	
	private VerificationCodeService verificationcodeservice;
	
	@Autowired
	public VerificationCodesController(VerificationCodeService verificationcodeservice) {
		super();
		this.verificationcodeservice = verificationcodeservice;
	}
	
	@GetMapping("/getall")
	public List<VerificationCode> getAll(){
		
		return this.verificationcodeservice.getAll();
	}
	

}
