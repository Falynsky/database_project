package falynsky.database_project.service;

import falynsky.database_project.repository.Employees;
import falynsky.database_project.repository.Locations;
import falynsky.database_project.repository.LocationsRepository;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class LocationsService {

    private final LocationsRepository locationsRepository;

    public LocationsService(LocationsRepository locationsRepository) {
        this.locationsRepository = locationsRepository;
    }

    public List<Locations> findAll() {
        List<Locations> locations = new ArrayList<>();
        for (Locations location : locationsRepository.findAll()) {
            locations.add(location);
        }
        return locations;
    }

    public void save(Locations location) {
        locationsRepository.save(location);
    }

    public Locations findLocationById(String id) throws NotFoundException {
        Long longId = Long.valueOf(id);
        Optional<Locations> location = findLocation(longId);
        if(location.isEmpty()){
            throw new NotFoundException("ERROR: LocationId:"+id+" not found");
        }
        return location.get();
    }

    public Optional<Locations> findLocation(Long id) {
        return locationsRepository.findById(id);
    }

    public void deleteJob(Long id) {
        locationsRepository.deleteById(id);
    }
}
