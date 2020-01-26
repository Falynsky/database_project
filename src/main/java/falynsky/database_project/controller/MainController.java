package falynsky.database_project.controller;

import falynsky.database_project.repository.Employees;
import falynsky.database_project.service.DepartmentService;
import falynsky.database_project.service.EmployeesService;
import falynsky.database_project.service.JobsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Optional;

@Controller
public class MainController {

    @Autowired
    private EmployeesService employeesService;

    @Autowired
    private JobsService jobsService;

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/")
    public String home(HttpServletRequest request) {
        request.setAttribute("mode","MODE_HOME");
        return "index";
    }

    @GetMapping("/all-employees")
    public String allEmployees(HttpServletRequest request) {
        request.setAttribute("employees",employeesService.findAll());
        request.setAttribute("mode","MODE_EMPLOYEES");
        return "employees";
    }

    @GetMapping("/new-employee")
    public String newEmployee(HttpServletRequest request) {
        request.setAttribute("mode","MODE_NEW");
        return "employees";
    }

    @PostMapping("/save-employee")
    public String saveEmployee(@ModelAttribute Employees employee, HttpServletRequest request) {
        employee.setJobsByJobId(jobsService.findJob(request.getParameter("jobId")).get());
        employee.setDepartmentsByDepartmentId(departmentService.findDepartmentById(request.getParameter("departmentId")));
        employee.setEmployeesByManagerId(employeesService.findEmployeeById(request.getParameter("managerId")));
        employee.setHireDate(new Date());
        employeesService.save(employee);
        request.setAttribute("mode","MODE_ADDED");
        return "employees";
    }

    @GetMapping("/update-employee")
    public String updateEmployee(@RequestParam Long id, HttpServletRequest request) {
        Optional<Employees> employee = employeesService.findEmployee(id);
        request.setAttribute("employee", employee.get());
        request.setAttribute("mode","MODE_UPDATE");
        return "employees";
    }
    @GetMapping("/delete-employee")
    public String deleteEmployee(@RequestParam Long id, HttpServletRequest request) {
        employeesService.deleteEmployee(id);
        request.setAttribute("employees",employeesService.findAll());
        request.setAttribute("mode","MODE_EMPLOYEES");
        return "employees";
    }
}
