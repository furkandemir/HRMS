package kodlamaio.Hrms.business.abstracts;

import java.util.List;

import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.concretes.JobTitle;

public interface JobTitleService {
	
	List<JobTitle> getAll();
	Result add(JobTitle jobtitle);
	DataResult<JobTitle> getByTitle(String title);

}
