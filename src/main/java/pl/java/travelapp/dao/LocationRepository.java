package pl.java.travelapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.java.travelapp.model.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
}
