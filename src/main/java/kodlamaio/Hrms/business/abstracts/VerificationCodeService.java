package kodlamaio.Hrms.business.abstracts;

import java.util.List;

import kodlamaio.Hrms.entities.concretes.VerificationCode;

public interface VerificationCodeService {
	
	List<VerificationCode> getAll();

}
