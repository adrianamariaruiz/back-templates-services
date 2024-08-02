package co.com.softlond.api.Historial;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import co.com.softlond.model.HistorialModel;
import co.com.softlond.usecase.Historial.HistorialOperationsUseCase;
import reactor.core.publisher.Mono;

@Service
public class HistorialHandler {

  private final HistorialOperationsUseCase historialOperationsUseCase;

  public HistorialHandler(HistorialOperationsUseCase historialOperationsUseCase){
    this.historialOperationsUseCase = historialOperationsUseCase;
  }

  public Mono<ServerResponse> getHistorial(ServerRequest request){
        return historialOperationsUseCase.getHistorial()
            .flatMap(historial -> ServerResponse.ok().bodyValue(historial))
            .switchIfEmpty(ServerResponse.noContent().build())
            .onErrorResume(error -> ServerResponse.badRequest().bodyValue(error.getMessage()));
    }
    
  public Mono<ServerResponse> saveHistorial(ServerRequest request){
      return request.bodyToMono(HistorialModel.class)
          .flatMap(historialOperationsUseCase::saveHistorial)
          .flatMap(historial -> ServerResponse.ok().bodyValue(historial))
          .switchIfEmpty(ServerResponse.noContent().build())
          .onErrorResume(error -> ServerResponse.badRequest().bodyValue(error.getMessage()));
  }

  public Mono<ServerResponse> getHistorialById(ServerRequest request){
    String id = request.pathVariable("id");
    return historialOperationsUseCase.getHistorialById(id)
    .flatMap(historial -> ServerResponse.ok().bodyValue(historial))
    .switchIfEmpty(ServerResponse.noContent().build())
    .onErrorResume(error -> ServerResponse.badRequest().bodyValue(error.getMessage()));
  }
   
}
