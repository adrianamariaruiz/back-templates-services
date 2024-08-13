package co.com.softlond.model.gateways;

import co.com.softlond.model.UsuarioModel;
import reactor.core.publisher.Mono;

public interface UsuarioGateways {
  Mono<UsuarioModel> saveUsuario(UsuarioModel usuario);

}
