package falynsky.database_project.service;

import falynsky.database_project.repository.Jobs;
import falynsky.database_project.repository.JobsRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class JobsService {

    private final JobsRepository jobsRepository;

    public JobsService(JobsRepository jobsRepository) {
        this.jobsRepository = jobsRepository;
    }

    public Optional<Jobs> findJob(String id) {
        return jobsRepository.findById(id);
    }

}
