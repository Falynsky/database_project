package falynsky.database_project.controller;

import falynsky.database_project.repository.Employees;
import falynsky.database_project.repository.Jobs;
import falynsky.database_project.repository.JobsRepository;
import falynsky.database_project.service.JobsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

import java.util.Optional;

@Controller
public class JobsController {

    @Autowired
    JobsService jobsService;

    @GetMapping("/all-jobs")
    public String allEmployees(HttpServletRequest request) {
        request.setAttribute("jobs",jobsService.findAll());
        request.setAttribute("mode","MODE_EMPLOYEES");
        return "jobs";
    }

    @GetMapping("/new-job")
    public String newEmployee(HttpServletRequest request) {
        request.setAttribute("mode","MODE_NEW");
        return "jobs";
    }

    @PostMapping("/save-job")
    public String saveEmployee(@ModelAttribute Jobs job, HttpServletRequest request) {
        jobsService.save(job);
        request.setAttribute("mode","MODE_ADDED");
        return "jobs";
    }

    @GetMapping("/update-job")
    public String updateEmployee(@RequestParam String id, HttpServletRequest request) {
        Optional<Jobs> job = jobsService.findJob(id);
        request.setAttribute("job", job.get());
        request.setAttribute("mode","MODE_UPDATE");
        return "jobs";
    }
    @GetMapping("/delete-job")
    public String deleteEmployee(@RequestParam String id, HttpServletRequest request) {
        jobsService.deleteJob(id);
        request.setAttribute("jobs",jobsService.findAll());
        request.setAttribute("mode","MODE_EMPLOYEES");
        return "jobs";
    }
}
