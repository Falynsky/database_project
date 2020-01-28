package falynsky.database_project.service;

import falynsky.database_project.repository.Departments;
import falynsky.database_project.repository.DepartmentsRepository;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DepartmentService {

    private final DepartmentsRepository departmentsRepository;

    public DepartmentService(DepartmentsRepository departmentsRepository) {
        this.departmentsRepository = departmentsRepository;
    }

    public List<Departments> findAll() {
        List<Departments> departments = new ArrayList<>();
        for (Departments department : departmentsRepository.findAll()) {
            departments.add(department);
        }
        return departments;
    }

    public void save(Departments department) {
        departmentsRepository.save(department);
    }

    public Departments findDepartmentById(String id) throws NotFoundException {
        Long longId = Long.valueOf(id);
        Optional<Departments> department = findDepartment(longId);
        if(department.isEmpty()){
            throw new NotFoundException("ERROR: DepartmentId:"+id+" not found");
        }
        return department.get();
    }
    public Optional<Departments> findDepartment(Long id) {
        return departmentsRepository.findById(id);
    }

    public void deleteDepartment(Long id) {
        departmentsRepository.deleteById(id);
    }
}
