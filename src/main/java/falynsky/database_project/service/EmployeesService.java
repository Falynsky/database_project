package falynsky.database_project.service;


import falynsky.database_project.repository.Employees;
import falynsky.database_project.repository.EmployeesRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class EmployeesService {

    private final EmployeesRepository employeeRepository;

    public EmployeesService(EmployeesRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employees> findAll(){
        List<Employees> employees = new ArrayList<>();
        for(Employees employee: employeeRepository.findAll()){
            employees.add(employee);
        }
        return employees;
    }

    public void save(Employees employee){
        employeeRepository.save(employee);
    }

    public void delete(Employees employee){
        employeeRepository.delete(employee);
    }
}
