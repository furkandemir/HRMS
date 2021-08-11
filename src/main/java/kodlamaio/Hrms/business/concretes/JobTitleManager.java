package kodlamaio.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.JobTitleService;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.ErrorResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.Hrms.core.utilities.results.SuccessResult;
import kodlamaio.Hrms.dataAccess.abstracts.JobTitleDao;
import kodlamaio.Hrms.entities.concretes.JobTitle;

@Service
public class JobTitleManager implements JobTitleService {

	private JobTitleDao jobtitledao;
	
	@Autowired
	public JobTitleManager(JobTitleDao jobtitledao) {
		super();
		this.jobtitledao = jobtitledao;
	}


	@Override
	public List<JobTitle> getAll() {
		
		return this.jobtitledao.findAll();
	}


	@Override
	public Result add(JobTitle jobtitle) {
		if(checkJobTitle(jobtitle.getTitle())) {
			return new ErrorResult("Job title registered in the system");
		}
		this.jobtitledao.save(jobtitle);
	  
	  return  new SuccessResult("Job title added");
		
		
	}
	
	public boolean checkJobTitle(String title) {
		boolean result=false;
		if(getByTitle(title).getData()==null) {
			result=true;
		}
		return result;
	}


	@Override
	public DataResult<JobTitle> getByTitle(String title) {
		
		return new SuccessDataResult<JobTitle>(this.jobtitledao.getByTitle(title));
	}

}
