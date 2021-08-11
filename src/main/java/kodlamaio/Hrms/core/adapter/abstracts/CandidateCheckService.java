package kodlamaio.Hrms.core.adapter.abstracts;

import kodlamaio.Hrms.entities.concretes.Candidate;

public interface CandidateCheckService {
	
	boolean CheckIfRealCandidate(Candidate candidate);

}
