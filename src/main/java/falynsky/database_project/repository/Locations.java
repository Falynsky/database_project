package falynsky.database_project.repository;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Locations {
    private Long locationId;
    private String streetAddress;
    private String postalCode;
    private String city;
    private String stateProvince;
    private Collection<Departments> departmentsByLocationId;
    private Countries countriesByCountryId;

    @Id
    @Column(name = "LOCATION_ID", nullable = false, precision = 0)
    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    @Basic
    @Column(name = "STREET_ADDRESS", nullable = true, length = 40)
    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    @Basic
    @Column(name = "POSTAL_CODE", nullable = true, length = 12)
    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Basic
    @Column(name = "CITY", nullable = false, length = 30)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "STATE_PROVINCE", nullable = true, length = 25)
    public String getStateProvince() {
        return stateProvince;
    }

    public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Locations locations = (Locations) o;

        if (locationId != null ? !locationId.equals(locations.locationId) : locations.locationId != null) return false;
        if (streetAddress != null ? !streetAddress.equals(locations.streetAddress) : locations.streetAddress != null)
            return false;
        if (postalCode != null ? !postalCode.equals(locations.postalCode) : locations.postalCode != null) return false;
        if (city != null ? !city.equals(locations.city) : locations.city != null) return false;
        if (stateProvince != null ? !stateProvince.equals(locations.stateProvince) : locations.stateProvince != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = locationId != null ? locationId.hashCode() : 0;
        result = 31 * result + (streetAddress != null ? streetAddress.hashCode() : 0);
        result = 31 * result + (postalCode != null ? postalCode.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (stateProvince != null ? stateProvince.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "locationsByLocationId")
    public Collection<Departments> getDepartmentsByLocationId() {
        return departmentsByLocationId;
    }

    public void setDepartmentsByLocationId(Collection<Departments> departmentsByLocationId) {
        this.departmentsByLocationId = departmentsByLocationId;
    }

    @ManyToOne
    @JoinColumn(name = "COUNTRY_ID", referencedColumnName = "COUNTRY_ID")
    public Countries getCountriesByCountryId() {
        return countriesByCountryId;
    }

    public void setCountriesByCountryId(Countries countriesByCountryId) {
        this.countriesByCountryId = countriesByCountryId;
    }
}
