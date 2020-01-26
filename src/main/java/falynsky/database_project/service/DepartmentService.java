package falynsky.database_project.service;

import falynsky.database_project.repository.Departments;
import falynsky.database_project.repository.DepartmentsRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class DepartmentService {

    private final DepartmentsRepository departmentsRepository;

    public DepartmentService(DepartmentsRepository departmentsRepository) {
        this.departmentsRepository = departmentsRepository;
    }

    public Departments findDepartmentById(String id){
        Long longId = Long.valueOf(id);
        return findDepartment(longId).get();
    }
    private Optional<Departments> findDepartment(Long id) {
        return departmentsRepository.findById(id);
    }
}