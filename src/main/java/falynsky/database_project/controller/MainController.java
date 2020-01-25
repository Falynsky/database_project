package falynsky.database_project.controller;

import falynsky.database_project.repository.Employees;
import falynsky.database_project.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {

    @Autowired
    private EmployeesService employeesService;

    @GetMapping("/")
    public String home(HttpServletRequest request) {
        request.setAttribute("mode","MODE_HOME");
        return "index";
    }

    @GetMapping("/all-employees")
    public String allEmployees(HttpServletRequest request) {
        request.setAttribute("employees",employeesService.findAll());
        request.setAttribute("mode","MODE_EMPLOYEES");
        return "index";
    }

    @GetMapping("/new-employee")
    public String newEmployee(HttpServletRequest request) {
        request.setAttribute("mode","MODE_NEW");
        return "index";
    }

    @PostMapping("/save-employee")
    public String saveEmployee(@ModelAttribute Employees employee, BindingResult bindingResult, HttpServletRequest request) {
        employeesService.save(employee);
        request.setAttribute("employee", employeesService.findAll());
        request.setAttribute("mode","MODE_EMPLOYEES");
        return "index";
    }

    @GetMapping("/update-employee")
    public String updateEmployee(@RequestParam Long id, HttpServletRequest request) {
        request.setAttribute("employee", employeesService.findEmployee(id));
        request.setAttribute("mode","MODE_UPDATE");
        return "index";
    }
    @GetMapping("/delete-employee")
    public String deleteEmployee(@RequestParam Long id, HttpServletRequest request) {
        employeesService.deleteEmployee(id);
        request.setAttribute("employee", employeesService.findAll());
        request.setAttribute("mode","MODE_EMPLOYEES");
        return "index";
    }
}
