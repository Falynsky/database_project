package falynsky.database_project.repository;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.util.Collection;
import java.util.Date;

@Entity
public class Employees implements Serializable {
    private Long employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Date hireDate;
    private Long salary;
    private Long commissionPct;
    private Collection<Departments> departmentsByEmployeeId;
    private Jobs jobsByJobId;
    private Employees employeesByManagerId;
    private Collection<Employees> employeesByEmployeeId;
    private Departments departmentsByDepartmentId;
    private Collection<EmployeeSalary> employeeSalariesByEmployeeId;
    private Collection<JobHistory> jobHistoriesByEmployeeId;

    public Employees(){}

    public Employees(String first_name, String last_name) {
    }


    @Id
    @Column(name = "EMPLOYEE_ID", nullable = false, precision = 0)
    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    @Basic
    @Column(name = "FIRST_NAME", nullable = true, length = 20)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "LAST_NAME", nullable = false, length = 25)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "EMAIL", nullable = false, length = 25)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "PHONE_NUMBER", nullable = true, length = 20)
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Basic
    @Column(name = "HIRE_DATE", nullable = false)
    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    @Basic
    @Column(name = "SALARY", nullable = true, precision = 2)
    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    @Basic
    @Column(name = "COMMISSION_PCT", nullable = true, precision = 2)
    public Long getCommissionPct() {
        return commissionPct;
    }

    public void setCommissionPct(Long commissionPct) {
        this.commissionPct = commissionPct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employees employees = (Employees) o;

        if (employeeId != null ? !employeeId.equals(employees.employeeId) : employees.employeeId != null) return false;
        if (firstName != null ? !firstName.equals(employees.firstName) : employees.firstName != null) return false;
        if (lastName != null ? !lastName.equals(employees.lastName) : employees.lastName != null) return false;
        if (email != null ? !email.equals(employees.email) : employees.email != null) return false;
        if (phoneNumber != null ? !phoneNumber.equals(employees.phoneNumber) : employees.phoneNumber != null)
            return false;
        if (hireDate != null ? !hireDate.equals(employees.hireDate) : employees.hireDate != null) return false;
        if (salary != null ? !salary.equals(employees.salary) : employees.salary != null) return false;
        if (commissionPct != null ? !commissionPct.equals(employees.commissionPct) : employees.commissionPct != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = employeeId != null ? employeeId.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (hireDate != null ? hireDate.hashCode() : 0);
        result = 31 * result + (salary != null ? salary.hashCode() : 0);
        result = 31 * result + (commissionPct != null ? commissionPct.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "employeesByManagerId")
    public Collection<Departments> getDepartmentsByEmployeeId() {
        return departmentsByEmployeeId;
    }

    public void setDepartmentsByEmployeeId(Collection<Departments> departmentsByEmployeeId) {
        this.departmentsByEmployeeId = departmentsByEmployeeId;
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
    @JoinColumn(name = "MANAGER_ID", referencedColumnName = "EMPLOYEE_ID")
    public Employees getEmployeesByManagerId() {
        return employeesByManagerId;
    }

    public void setEmployeesByManagerId(Employees employeesByManagerId) {
        this.employeesByManagerId = employeesByManagerId;
    }

    @OneToMany(mappedBy = "employeesByManagerId")
    public Collection<Employees> getEmployeesByEmployeeId() {
        return employeesByEmployeeId;
    }

    public void setEmployeesByEmployeeId(Collection<Employees> employeesByEmployeeId) {
        this.employeesByEmployeeId = employeesByEmployeeId;
    }

    @ManyToOne
    @JoinColumn(name = "DEPARTMENT_ID", referencedColumnName = "DEPARTMENT_ID")
    public Departments getDepartmentsByDepartmentId() {
        return departmentsByDepartmentId;
    }

    public void setDepartmentsByDepartmentId(Departments departmentsByDepartmentId) {
        this.departmentsByDepartmentId = departmentsByDepartmentId;
    }

    @OneToMany(mappedBy = "employeesByEmployeeId")
    public Collection<EmployeeSalary> getEmployeeSalariesByEmployeeId() {
        return employeeSalariesByEmployeeId;
    }

    public void setEmployeeSalariesByEmployeeId(Collection<EmployeeSalary> employeeSalariesByEmployeeId) {
        this.employeeSalariesByEmployeeId = employeeSalariesByEmployeeId;
    }

    @OneToMany(mappedBy = "employeesByEmployeeId")
    public Collection<JobHistory> getJobHistoriesByEmployeeId() {
        return jobHistoriesByEmployeeId;
    }

    public void setJobHistoriesByEmployeeId(Collection<JobHistory> jobHistoriesByEmployeeId) {
        this.jobHistoriesByEmployeeId = jobHistoriesByEmployeeId;
    }
}
