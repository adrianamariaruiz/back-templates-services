package co.com.softlond.api.Usuario;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import co.com.softlond.model.UsuarioModel;
import co.com.softlond.usecase.Usuario.UsuarioOperationsUseCase;
import reactor.core.publisher.Mono;

@Service
public class UsuarioHandler {
  private final UsuarioOperationsUseCase usuarioOperationUseCase;

  public UsuarioHandler(UsuarioOperationsUseCase usuarioOperationUseCase){
    this.usuarioOperationUseCase = usuarioOperationUseCase;
  }

  public Mono<ServerResponse> saveUsuario(ServerRequest request){
    return request.bodyToMono(UsuarioModel.class)
      .flatMap(usuarioOperationUseCase::saveUsuario)
      .flatMap(usuario -> ServerResponse.ok().bodyValue("Usuario creado"))
      .switchIfEmpty(ServerResponse.noContent().build())
      .onErrorResume(error -> ServerResponse.badRequest().bodyValue(error.getMessage()));
  }

}
