package pl.java.travelapp.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.java.travelapp.model.Location;
import pl.java.travelapp.model.TravelAttraction;
import pl.java.travelapp.model.enums.AttractionType;
import pl.java.travelapp.services.TravelAttractionService;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/attractions")
public class TravelAttractionApi {

    private TravelAttractionService service;

    @Autowired
    public TravelAttractionApi(TravelAttractionService service) {
         this.service = service;
    }

    @GetMapping
    public List<TravelAttraction> getAll() {
        return service.readAll();
    }

    @GetMapping(path = "/{id}")
    public Optional<TravelAttraction> getById(@PathVariable Long id) {
        return service.readById(id);
    }

    @PostMapping
    public TravelAttraction addTravelAttraction(@RequestBody TravelAttraction travelAttraction) {
        return service.createTravelAttraction(travelAttraction);
    }

    @PutMapping
    public TravelAttraction updateTravelAttraction(@RequestBody TravelAttraction travelAttraction) {
        return service.updateTravelAttraction(travelAttraction);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteTravelAttraction(@PathVariable Long id) {
        service.deleteTravelAttraction(id);
    }
}
