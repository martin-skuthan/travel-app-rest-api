package pl.java.travelapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import pl.java.travelapp.model.TravelAttraction;

@Repository
public interface TravelAttractionRepository extends JpaRepository<TravelAttraction, Long> {
}
