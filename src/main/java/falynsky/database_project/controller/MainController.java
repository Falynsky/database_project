package falynsky.database_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {

    @GetMapping("/")
    public String home(HttpServletRequest request) {
        request.setAttribute("mode","MODE_HOME");
        return "index";
    }
}
