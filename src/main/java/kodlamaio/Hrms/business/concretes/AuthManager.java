package kodlamaio.Hrms.business.concretes;





import java.util.regex.Pattern;

import kodlamaio.Hrms.business.abstracts.AuthService;
import kodlamaio.Hrms.business.abstracts.CandidateService;

import kodlamaio.Hrms.business.abstracts.EmployerService;
import kodlamaio.Hrms.business.abstracts.UserService;
import kodlamaio.Hrms.core.adapter.abstracts.CandidateCheckService;
import kodlamaio.Hrms.core.utilities.results.ErrorResult;
import kodlamaio.Hrms.core.utilities.results.Result;

import kodlamaio.Hrms.core.utilities.results.SuccessResult;
import kodlamaio.Hrms.core.validation.abstracts.VerificationService;

import kodlamaio.Hrms.entities.concretes.Candidate;
import kodlamaio.Hrms.entities.concretes.Employer;


public class AuthManager implements AuthService {
	
	private UserService userservice;
	private CandidateService candidateservice;
	private EmployerService employerservice;
	private CandidateCheckService candidatecheckservice;
	private VerificationService verificationservice;
	

	public AuthManager( UserService userservice,CandidateService candidateservice, 
			EmployerService employerservice, 
			CandidateCheckService candidatecheckservice) {
		super();
		this.userservice=userservice;
		this.candidateservice = candidateservice;
		this.employerservice = employerservice;
		this.candidatecheckservice = candidatecheckservice;
		
	}

	@Override
	public Result RegisterCandidate(Candidate candidate, String Repeatpassword) {
		if(!checkEmail(candidate.getEmail())) {
			return new ErrorResult("Invalid email address");
		}
		if(!this.candidatecheckservice.CheckIfRealCandidate(candidate)) {
			return new ErrorResult("could not be verified");
		}
		if(!checkIfNullForCandidate(candidate)) {
			return new ErrorResult("Registration information is not left blank.");
		}
		if(!checkIfPasswordsMatch(candidate.getEmail(),Repeatpassword)) {
			return new ErrorResult("Passwords do not match");
		}
		if(!checkIdentityNumber(candidate.getIdentitynumber()) && !checkEmailIfUser(candidate.getEmail())) {
			return new ErrorResult("Previously registered email or identity number");
		}
		
		var result=this.candidateservice.add(candidate);
		
		if(result.isSuccess()) {
			if(this.verificationservice.SendVerificationCode(candidate.getEmail())) {
						
				return new SuccessResult(candidate.getFirstname()+" registered");
			}
			
		}
			return new ErrorResult();
	}
		

	@Override
	public Result RegisterEmployer(Employer employer, String Repeatpassword) {
		if(!checkEmail(employer.getEmail())) {
			return new ErrorResult("Invalid email address");
		}
		if(!checkIfEqualEmailAndDomain(employer.getEmail(),employer.getWebadress())) {
			return new ErrorResult("email address extension did not match the web address");
		}
		if(!checkIfNullForEmployer(employer)) {
			return new ErrorResult("Registration information is not left blank.");
		}
		if(!checkIfPasswordsMatch(employer.getEmail(),Repeatpassword)) {
			return new ErrorResult("Passwords do not match");
		}
		if(!checkEmailIfUser(employer.getEmail())) {
			return new ErrorResult("Previously registered email");
		}
		
		var result = this.employerservice.add(employer);
		if(result.isSuccess()) {
			if(this.verificationservice.SendVerificationCode(employer.getEmail())) {
				return new SuccessResult(employer.getCompanyname()+" registered");
			}
			
		}
		return new ErrorResult();
	}
	
	public boolean checkIfNullForCandidate(Candidate candidate ) {
		
		if(candidate.getFirstname()!=null && candidate.getLastname()!=null && candidate.getPassword()!=null && candidate.getEmail()!=null
				&& candidate.getIdentitynumber()!=null ) {
			return true;
			
		}
		else {
			return false;
		}
	}
	
	public boolean checkIdentityNumber(String identitynumber) {
		if(this.candidateservice.getByIdentityNumber(identitynumber).getData()==null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean checkEmailIfUser(String email) {
		if(this.userservice.findUserByEmail(email).getData()==null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	
	public boolean checkEmail(String email) {
		
		Pattern p = Pattern.compile("[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", Pattern.CASE_INSENSITIVE);
		    		
		    return p.matcher(email).matches();
		}
	
	public boolean checkIfPasswordsMatch(String password, String confirmPassword) {

		boolean result = false;

		if (password.equals(confirmPassword)) {
			result = true;
		}

		return result;
	}
	public boolean checkIfNullForEmployer(Employer employer) {
		
		if(employer.getCompanyname()!=null && employer.getWebadress()!=null && employer.getPassword()!=null && employer.getPhone_number()!=null && employer.getEmail()!=null) {
			return true;
		}
		else {
			return false;
		}
	
	
	
	}
	
	public boolean checkIfEqualEmailAndDomain(String email, String website) {
		String[] emailArr = email.split("@", 2);
		String domain = website.substring(4, website.length());

		if (emailArr[1].equals(domain)) {

			return true;
		}

		return false;
	}
}

	

	
	
	



