package falynsky.database_project.controller;

import falynsky.database_project.repository.Departments;
import falynsky.database_project.service.DepartmentService;
import falynsky.database_project.service.EmployeesService;
import falynsky.database_project.service.LocationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Controller
public class DepartmentsController {

    @Autowired
    DepartmentService departmentService;
    @Autowired
    EmployeesService employeesService;
    @Autowired
    LocationsService locationsService;

    @GetMapping("/all-departments")
    public String allEmployees(HttpServletRequest request) {
        request.setAttribute("departments",departmentService.findAll());
        request.setAttribute("mode","MODE_DEPARTMENTS");
        return "departments";
    }

    @GetMapping("/new-department")
    public String newDepartment(HttpServletRequest request) {
        request.setAttribute("mode","MODE_NEW");
        return "departments";
    }

    @PostMapping("/save-department")
    public String saveEmployee(@ModelAttribute Departments department, HttpServletRequest request) {
        department.setEmployeesByManagerId(employeesService.findEmployeeById(request.getParameter("managerId")));
        department.setLocationsByLocationId(locationsService.findLocationById(request.getParameter("locationId")));
        departmentService.save(department);
        request.setAttribute("mode","MODE_ADDED");
        return "index";
    }

    @GetMapping("/update-department")
    public String updateEmployee(@RequestParam Long id, HttpServletRequest request) {
        Optional<Departments> department = departmentService.findDepartment(id);
        request.setAttribute("department", department.get());
        request.setAttribute("mode","MODE_UPDATE");
        return "departments";
    }
    @GetMapping("/delete-department")
    public String deleteEmployee(@RequestParam Long id, HttpServletRequest request) {
        departmentService.deleteDepartment(id);
        request.setAttribute("departments",departmentService.findAll());
        request.setAttribute("mode","MODE_DEPARTMENTS");
        return "departments";
    }
}
