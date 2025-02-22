package co.com.softlond.mongo.Historial;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import co.com.softlond.mongo.Collections.HistorialCollections;

@Repository
public interface ReactiveHistorialMongoRepository extends ReactiveMongoRepository<HistorialCollections, String> {
    
}