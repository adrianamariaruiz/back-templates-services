package co.com.softlond.api.Historial;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class HistorialRoutesRest {
  @Bean
  public RouterFunction<ServerResponse> historialRoutes(HistorialHandler historialHandler){
    return RouterFunctions.route()
      .GET("/api/historial", historialHandler::getHistorial)
      .POST("/api/historial/save", historialHandler::saveHistorial)
      .build();
  }
}
