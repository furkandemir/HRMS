package kodlamaio.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.VerificationCodeService;
import kodlamaio.Hrms.dataAccess.abstracts.VerificationCodeDao;
import kodlamaio.Hrms.entities.concretes.VerificationCode;

@Service
public class VerificationCodeManager implements VerificationCodeService {

	private VerificationCodeDao verificationcodedao;
	
	@Autowired
	public VerificationCodeManager(VerificationCodeDao verificationcodedao) {
		super();
		this.verificationcodedao = verificationcodedao;
	}


	@Override
	public List<VerificationCode> getAll() {
		// TODO Auto-generated method stub
		return this.verificationcodedao.findAll();
				
	}

}
