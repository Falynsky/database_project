package falynsky.database_project.repository;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Countries {
    private String countryId;
    private String countryName;
    private Regions regionsByRegionId;
    private Collection<Locations> locationsByCountryId;

    @Id
    @Column(name = "COUNTRY_ID", nullable = false, length = 2)
    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    @Basic
    @Column(name = "COUNTRY_NAME", nullable = true, length = 40)
    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Countries countries = (Countries) o;

        if (countryId != null ? !countryId.equals(countries.countryId) : countries.countryId != null) return false;
        if (countryName != null ? !countryName.equals(countries.countryName) : countries.countryName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = countryId != null ? countryId.hashCode() : 0;
        result = 31 * result + (countryName != null ? countryName.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "REGION_ID", referencedColumnName = "REGION_ID")
    public Regions getRegionsByRegionId() {
        return regionsByRegionId;
    }

    public void setRegionsByRegionId(Regions regionsByRegionId) {
        this.regionsByRegionId = regionsByRegionId;
    }

    @OneToMany(mappedBy = "countriesByCountryId")
    public Collection<Locations> getLocationsByCountryId() {
        return locationsByCountryId;
    }

    public void setLocationsByCountryId(Collection<Locations> locationsByCountryId) {
        this.locationsByCountryId = locationsByCountryId;
    }
}
