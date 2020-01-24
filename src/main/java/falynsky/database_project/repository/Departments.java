package falynsky.database_project.repository;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Departments {
    private Long departmentId;
    private String departmentName;
    private Employees employeesByManagerId;
    private Locations locationsByLocationId;
    private Collection<Employees> employeesByDepartmentId;
    private Collection<JobHistory> jobHistoriesByDepartmentId;

    @Id
    @Column(name = "DEPARTMENT_ID", nullable = false, precision = 0)
    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    @Basic
    @Column(name = "DEPARTMENT_NAME", nullable = false, length = 30)
    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Departments that = (Departments) o;

        if (departmentId != null ? !departmentId.equals(that.departmentId) : that.departmentId != null) return false;
        if (departmentName != null ? !departmentName.equals(that.departmentName) : that.departmentName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = departmentId != null ? departmentId.hashCode() : 0;
        result = 31 * result + (departmentName != null ? departmentName.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "MANAGER_ID", referencedColumnName = "EMPLOYEE_ID")
    public Employees getEmployeesByManagerId() {
        return employeesByManagerId;
    }

    public void setEmployeesByManagerId(Employees employeesByManagerId) {
        this.employeesByManagerId = employeesByManagerId;
    }

    @ManyToOne
    @JoinColumn(name = "LOCATION_ID", referencedColumnName = "LOCATION_ID")
    public Locations getLocationsByLocationId() {
        return locationsByLocationId;
    }

    public void setLocationsByLocationId(Locations locationsByLocationId) {
        this.locationsByLocationId = locationsByLocationId;
    }

    @OneToMany(mappedBy = "departmentsByDepartmentId")
    public Collection<Employees> getEmployeesByDepartmentId() {
        return employeesByDepartmentId;
    }

    public void setEmployeesByDepartmentId(Collection<Employees> employeesByDepartmentId) {
        this.employeesByDepartmentId = employeesByDepartmentId;
    }

    @OneToMany(mappedBy = "departmentsByDepartmentId")
    public Collection<JobHistory> getJobHistoriesByDepartmentId() {
        return jobHistoriesByDepartmentId;
    }

    public void setJobHistoriesByDepartmentId(Collection<JobHistory> jobHistoriesByDepartmentId) {
        this.jobHistoriesByDepartmentId = jobHistoriesByDepartmentId;
    }
}
