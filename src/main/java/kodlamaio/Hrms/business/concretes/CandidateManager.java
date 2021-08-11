package kodlamaio.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.CandidateService;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.Hrms.core.utilities.results.SuccessResult;
import kodlamaio.Hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.Hrms.entities.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService {

	private CandidateDao candidatedao;
	
	
	@Autowired
	public CandidateManager(CandidateDao candidatedao) {
		super();
		this.candidatedao = candidatedao;
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
	
		return new SuccessDataResult<List<Candidate>>(this.candidatedao.findAll());
	}

	@Override
	public Result add(Candidate candidate) {
		this.candidatedao.save(candidate);
		return new SuccessResult("added to database");
	}

	@Override
	public DataResult<Candidate> getByIdentityNumber(String identitynumber) {
		
		return new SuccessDataResult<Candidate>(this.candidatedao.findByIdentityNumber(identitynumber));
	}

	

}
