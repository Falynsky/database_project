package falynsky.database_project.controller;

import falynsky.database_project.repository.Employees;
import falynsky.database_project.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SampleRestController {

    @Autowired
    private EmployeesService employeesService;

    @GetMapping("/hello")
    public String hello(){
        return "Hello World!!!";
    }
/*    @GetMapping("/all-employees")
    public String allEmployees(){
        return employeesService.findAll().toString();
    }

    @GetMapping("/save-employee")
    public String saveEmployee(@RequestParam String first_name, @RequestParam String last_name){
        Employees employee = new Employees(first_name,last_name);
        employeesService.save(employee);
        return "Task saved!";
    }*/
}
