package pl.java.travelapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.java.travelapp.dao.TravelAttractionRepository;
import pl.java.travelapp.model.TravelAttraction;

import java.util.List;
import java.util.Optional;

@Service
public class TravelAttractionService {

    private TravelAttractionRepository repository;

    @Autowired
    public TravelAttractionService(TravelAttractionRepository repository) {
        this.repository = repository;
    }

    public List<TravelAttraction> readAll() {
        return repository.findAll();
    }

    public Optional<TravelAttraction> readById(Long id) {
        return repository.findById(id);
    }

    public TravelAttraction createTravelAttraction(TravelAttraction travelAttraction) {
        return repository.save(travelAttraction);
    }

    public TravelAttraction updateTravelAttraction(TravelAttraction travelAttraction) {
        return repository.save(travelAttraction);
    }

    public void deleteTravelAttraction(Long id) {
        repository.deleteById(id);
    }
}
