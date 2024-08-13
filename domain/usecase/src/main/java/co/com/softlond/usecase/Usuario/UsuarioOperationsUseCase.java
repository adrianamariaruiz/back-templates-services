package co.com.softlond.usecase.Usuario;

import org.springframework.stereotype.Service;

import co.com.softlond.model.UsuarioModel;
import co.com.softlond.model.gateways.UsuarioGateways;
import reactor.core.publisher.Mono;

@Service
public class UsuarioOperationsUseCase {

  private final UsuarioGateways usuarioGateways;

  public UsuarioOperationsUseCase(UsuarioGateways usuarioGateways){
    this.usuarioGateways = usuarioGateways;
  }

  public Mono<UsuarioModel> saveUsuario(UsuarioModel usuario){
    return usuarioGateways.saveUsuario(usuario);
  }

}
