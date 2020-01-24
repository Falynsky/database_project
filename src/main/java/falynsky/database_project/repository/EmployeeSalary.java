package falynsky.database_project.repository;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "EMPLOYEE_SALARY", schema = "ZIIBD23", catalog = "")
public class EmployeeSalary {
    private Long id;
    private Time dop;
    private Long oldSalary;
    private Long newSalary;
    private Employees employeesByEmployeeId;

    @Id
    @Column(name = "ID", nullable = false, precision = 0)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "DOP", nullable = true)
    public Time getDop() {
        return dop;
    }

    public void setDop(Time dop) {
        this.dop = dop;
    }

    @Basic
    @Column(name = "OLD_SALARY", nullable = true, precision = 2)
    public Long getOldSalary() {
        return oldSalary;
    }

    public void setOldSalary(Long oldSalary) {
        this.oldSalary = oldSalary;
    }

    @Basic
    @Column(name = "NEW_SALARY", nullable = true, precision = 2)
    public Long getNewSalary() {
        return newSalary;
    }

    public void setNewSalary(Long newSalary) {
        this.newSalary = newSalary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployeeSalary that = (EmployeeSalary) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (dop != null ? !dop.equals(that.dop) : that.dop != null) return false;
        if (oldSalary != null ? !oldSalary.equals(that.oldSalary) : that.oldSalary != null) return false;
        if (newSalary != null ? !newSalary.equals(that.newSalary) : that.newSalary != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (dop != null ? dop.hashCode() : 0);
        result = 31 * result + (oldSalary != null ? oldSalary.hashCode() : 0);
        result = 31 * result + (newSalary != null ? newSalary.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "EMPLOYEE_ID", referencedColumnName = "EMPLOYEE_ID")
    public Employees getEmployeesByEmployeeId() {
        return employeesByEmployeeId;
    }

    public void setEmployeesByEmployeeId(Employees employeesByEmployeeId) {
        this.employeesByEmployeeId = employeesByEmployeeId;
    }
}
