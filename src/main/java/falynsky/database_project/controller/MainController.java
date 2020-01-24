package falynsky.database_project.controller;

import falynsky.database_project.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @Autowired
    private EmployeesService employeesService;

    @GetMapping("/")
    public String home(){
        return "index";
    }
}
