package falynsky.database_project.service;


import falynsky.database_project.repository.Employees;
import falynsky.database_project.repository.EmployeesRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class EmployeesService {

    private final EmployeesRepository employeeRepository;

    public EmployeesService(EmployeesRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employees> findAll() {
        List<Employees> employees = new ArrayList<>();
        for (Employees employee : employeeRepository.findAll()) {
            employees.add(employee);
        }
        return employees;
    }

    public void save(Employees employee) {
        employeeRepository.save(employee);
    }

    public Employees findEmployeeById(String id) {
        Long longId = Long.valueOf(id);
        return findEmployee(longId).get();
    }

    public Optional<Employees> findEmployee(Long id) {
        return employeeRepository.findById(id);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
