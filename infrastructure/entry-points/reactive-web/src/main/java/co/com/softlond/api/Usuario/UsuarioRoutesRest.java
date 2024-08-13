package co.com.softlond.api.Usuario;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class UsuarioRoutesRest {

  @Bean
  public RouterFunction<ServerResponse> usuarioRoutes(UsuarioHandler usuarioHandler){
    return RouterFunctions.route()
      .POST("/api/usuario/save", usuarioHandler::saveUsuario)
      .build();
  }
}
