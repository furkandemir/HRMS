package kodlamaio.Hrms.core.adapter.concretes;

import java.rmi.RemoteException;

import kodlamaio.Hrms.core.adapter.abstracts.CandidateCheckService;
import kodlamaio.Hrms.entities.concretes.Candidate;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

public class MernisServiceAdapter implements CandidateCheckService{

	
	public boolean CheckIfRealCandidate(Candidate candidate) {

		KPSPublicSoapProxy client=new KPSPublicSoapProxy() ;
		boolean result=true;
		
		try {
			result=client.TCKimlikNoDogrula(Long. parseLong(candidate.getIdentitynumber()),
					candidate.getFirstname().toUpperCase(), 
					candidate.getLastname().toUpperCase(), 
					candidate.getBirthday().getYear());
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
}
}
	


