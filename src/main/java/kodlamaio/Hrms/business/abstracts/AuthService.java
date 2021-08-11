package kodlamaio.Hrms.business.abstracts;

import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.concretes.Candidate;
import kodlamaio.Hrms.entities.concretes.Employer;

public interface AuthService {
	Result RegisterCandidate(Candidate candidate, String Repeatpassword);
	Result RegisterEmployer(Employer employer,String Repeatpassword);

}
