package co.com.softlond.mongo.Usuarios;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import co.com.softlond.mongo.Collections.UsuarioCollections;

public interface ReactiveUsuarioMongoRepository extends ReactiveMongoRepository<UsuarioCollections, String> {

}
