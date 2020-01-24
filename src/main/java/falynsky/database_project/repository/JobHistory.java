package falynsky.database_project.repository;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "JOB_HISTORY", schema = "ZIIBD23", catalog = "")
@IdClass(JobHistoryPK.class)
public class JobHistory {

    private Long employeeId;
    private Time startDate;
    private Time endDate;
    private Employees employeesByEmployeeId;
    private Jobs jobsByJobId;
    private Departments departmentsByDepartmentId;

    @Id
    @Column(name = "EMPLOYEE_ID", nullable = false, precision = 0,insertable = false, updatable = false)
    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    @Id
    @Column(name = "START_DATE", nullable = false)
    public Time getStartDate() {
        return startDate;
    }

    public void setStartDate(Time startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Column(name = "END_DATE", nullable = false)
    public Time getEndDate() {
        return endDate;
    }

    public void setEndDate(Time endDate) {
        this.endDate = endDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JobHistory that = (JobHistory) o;

        if (employeeId != null ? !employeeId.equals(that.employeeId) : that.employeeId != null) return false;
        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) return false;
        if (endDate != null ? !endDate.equals(that.endDate) : that.endDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = employeeId != null ? employeeId.hashCode() : 0;
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "EMPLOYEE_ID", referencedColumnName = "EMPLOYEE_ID", nullable = false, insertable = false, updatable = false)
    public Employees getEmployeesByEmployeeId() {
        return employeesByEmployeeId;
    }

    public void setEmployeesByEmployeeId(Employees employeesByEmployeeId) {
        this.employeesByEmployeeId = employeesByEmployeeId;
    }

    @ManyToOne
    @JoinColumn(name = "JOB_ID", referencedColumnName = "JOB_ID", nullable = false)
    public Jobs getJobsByJobId() {
        return jobsByJobId;
    }

    public void setJobsByJobId(Jobs jobsByJobId) {
        this.jobsByJobId = jobsByJobId;
    }

    @ManyToOne
    @JoinColumn(name = "DEPARTMENT_ID", referencedColumnName = "DEPARTMENT_ID")
    public Departments getDepartmentsByDepartmentId() {
        return departmentsByDepartmentId;
    }

    public void setDepartmentsByDepartmentId(Departments departmentsByDepartmentId) {
        this.departmentsByDepartmentId = departmentsByDepartmentId;
    }
}
