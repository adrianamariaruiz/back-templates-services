package co.com.softlond.mongo.Plantilla;

import co.com.softlond.mongo.Collections.PlantillaCollections;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReactivePlantillaMongoRepository extends ReactiveMongoRepository<PlantillaCollections, String> {
    
}
