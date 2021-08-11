package kodlamaio.Hrms.core.validation.concretes;

import java.util.UUID;

import kodlamaio.Hrms.core.validation.abstracts.VerificationService;

public class VerificationManager implements VerificationService {

	@Override
	public boolean SendVerificationCode(String email) {
		UUID uuid = UUID.randomUUID();
		String code=uuid.toString();
		System.out.println("verification code send to "+email);
		System.out.println("verification code: "+code);	
		return true;
	}

}
