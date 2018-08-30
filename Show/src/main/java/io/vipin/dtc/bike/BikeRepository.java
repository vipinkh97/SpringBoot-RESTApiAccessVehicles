package io.vipin.dtc.bike;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface BikeRepository extends CrudRepository<Bike,String> {
	
}
