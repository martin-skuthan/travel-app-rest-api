package pl.java.travelapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.java.travelapp.dao.LocationRepository;
import pl.java.travelapp.dao.TravelAttractionRepository;
import pl.java.travelapp.model.Location;
import pl.java.travelapp.model.TravelAttraction;
import pl.java.travelapp.model.enums.AttractionType;

import java.util.List;
import java.util.Optional;

@Service
public class TravelAttractionService {

    private TravelAttractionRepository repository;
    private LocationRepository locationRepository;

    @Autowired
    public TravelAttractionService(TravelAttractionRepository repository, LocationRepository locationRepository) {
        this.repository = repository;
        this.locationRepository = locationRepository;
    }

    public List<TravelAttraction> readAll() {
        return repository.findAll();
    }

    public Optional<TravelAttraction> readById(Long id) {
        return repository.findById(id);
    }

    public TravelAttraction createTravelAttraction(TravelAttraction travelAttraction) {
        if (travelAttraction.getLocation().getId() != null) {
            if (locationRepository.existsById(travelAttraction.getLocation().getId())) {
                travelAttraction.setLocation(locationRepository.findById(travelAttraction.getLocation().getId()).get());
            }
        }
        travelAttraction.setType(AttractionType.valueOf(travelAttraction.getAttractionTypeString()));
        return repository.save(travelAttraction);
    }

    public TravelAttraction updateTravelAttraction(TravelAttraction travelAttraction) {
        return repository.save(travelAttraction);
    }

    public void deleteTravelAttraction(Long id) {
        repository.deleteById(id);
    }
}
