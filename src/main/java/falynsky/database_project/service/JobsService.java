package falynsky.database_project.service;

import falynsky.database_project.repository.Jobs;
import falynsky.database_project.repository.JobsRepository;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class JobsService {

    private final JobsRepository jobsRepository;

    public JobsService(JobsRepository jobsRepository) {
        this.jobsRepository = jobsRepository;
    }

    public List<Jobs> findAll() {
        List<Jobs> jobs = new ArrayList<>();
        for (Jobs job : jobsRepository.findAll()) {
            jobs.add(job);
        }
        return jobs;
    }

    public void save(Jobs job) {
        jobsRepository.save(job);
    }

    public Jobs findJobById(String id) throws NotFoundException {
        Optional<Jobs> job = findJob(id);
        if(job.isEmpty()){
            throw new NotFoundException("ERROR: JobId:"+id+" not found");
        }
        return job.get();
    }

    public Optional<Jobs> findJob(String id) {
        return jobsRepository.findById(id);
    }

    public void deleteJob(String id) {
        jobsRepository.deleteById(id);
    }
}
