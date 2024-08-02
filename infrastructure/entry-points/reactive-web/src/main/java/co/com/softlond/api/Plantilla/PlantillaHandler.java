package co.com.softlond.api.Plantilla;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import co.com.softlond.model.PlantillaModel;
import co.com.softlond.usecase.Plantilla.PlantillaOperationsUseCase;
import reactor.core.publisher.Mono;

@Service
public class PlantillaHandler {
    
    private final PlantillaOperationsUseCase plantillaOperationsUseCase;
    

    public PlantillaHandler(PlantillaOperationsUseCase plantillaOperationsUseCase) {
        this.plantillaOperationsUseCase = plantillaOperationsUseCase;
    }

    public Mono<ServerResponse> savePlantilla(ServerRequest request) {
        return request.bodyToMono(PlantillaModel.class)
                .flatMap(plantillaOperationsUseCase::savePlantilla)
                .flatMap(plantilla -> ServerResponse.ok().bodyValue(plantilla))
                .switchIfEmpty(ServerResponse.noContent().build())
                .onErrorResume(error -> ServerResponse.badRequest().bodyValue(error.getMessage()));
    }

    public Mono<ServerResponse> getPlantilla(ServerRequest request){
        String id = request.pathVariable("id");
        return plantillaOperationsUseCase.getPlantillaById(id)
        .flatMap(plantilla -> ServerResponse.ok().bodyValue(plantilla))
        .switchIfEmpty(ServerResponse.noContent().build())
        .onErrorResume(error -> ServerResponse.badRequest().bodyValue(error.getMessage()));
    }

    public Mono<ServerResponse> getAllPlantillas(ServerRequest request){
        return plantillaOperationsUseCase.getAllDataPlantilla()
            .collectList()
            .flatMap(plantillas -> ServerResponse.ok().bodyValue(plantillas))
            .switchIfEmpty(ServerResponse.noContent().build())
            .onErrorResume(error -> ServerResponse.badRequest().bodyValue(error.getMessage()));
    }

    

}
