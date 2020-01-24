package falynsky.database_project.repository;

import org.springframework.data.repository.CrudRepository;

public interface EmployeesRepository extends CrudRepository<Employees,Integer> {

    Employees findById(int id);

}
