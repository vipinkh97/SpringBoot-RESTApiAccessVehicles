package io.vipin.dtc.scooter;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface ScooterRepository extends CrudRepository<Scooter,String> {
	
}
