package co.com.softlond.mongo.Usuarios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.com.softlond.model.UsuarioModel;
import co.com.softlond.model.gateways.UsuarioGateways;
import reactor.core.publisher.Mono;

@Repository
public class UsuariosGatewaysImpl implements UsuarioGateways {
  @Autowired
  private ReactiveUsuarioMongoRepository reactiveUsuarioMongoRepository;

  @Override
  public Mono<UsuarioModel> saveUsuario(UsuarioModel usuario){
    return reactiveUsuarioMongoRepository.save(UsuarioMapper.toCollection(usuario))
      .map(usuarioEntity -> UsuarioMapper.toModel(usuarioEntity));
  }
}
