package falynsky.database_project.repository;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Jobs {
    private String jobId;
    private String jobTitle;
    private Long minSalary;
    private Long maxSalary;
    private Collection<Employees> employeesByJobId;
    private Collection<JobHistory> jobHistoriesByJobId;

    @Id
    @Column(name = "JOB_ID", nullable = false, length = 10)
    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    @Basic
    @Column(name = "JOB_TITLE", nullable = false, length = 35)
    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    @Basic
    @Column(name = "MIN_SALARY", nullable = true, precision = 0)
    public Long getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(Long minSalary) {
        this.minSalary = minSalary;
    }

    @Basic
    @Column(name = "MAX_SALARY", nullable = true, precision = 0)
    public Long getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(Long maxSalary) {
        this.maxSalary = maxSalary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Jobs jobs = (Jobs) o;

        if (jobId != null ? !jobId.equals(jobs.jobId) : jobs.jobId != null) return false;
        if (jobTitle != null ? !jobTitle.equals(jobs.jobTitle) : jobs.jobTitle != null) return false;
        if (minSalary != null ? !minSalary.equals(jobs.minSalary) : jobs.minSalary != null) return false;
        if (maxSalary != null ? !maxSalary.equals(jobs.maxSalary) : jobs.maxSalary != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = jobId != null ? jobId.hashCode() : 0;
        result = 31 * result + (jobTitle != null ? jobTitle.hashCode() : 0);
        result = 31 * result + (minSalary != null ? minSalary.hashCode() : 0);
        result = 31 * result + (maxSalary != null ? maxSalary.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "jobsByJobId")
    public Collection<Employees> getEmployeesByJobId() {
        return employeesByJobId;
    }

    public void setEmployeesByJobId(Collection<Employees> employeesByJobId) {
        this.employeesByJobId = employeesByJobId;
    }

    @OneToMany(mappedBy = "jobsByJobId")
    public Collection<JobHistory> getJobHistoriesByJobId() {
        return jobHistoriesByJobId;
    }

    public void setJobHistoriesByJobId(Collection<JobHistory> jobHistoriesByJobId) {
        this.jobHistoriesByJobId = jobHistoriesByJobId;
    }
}
