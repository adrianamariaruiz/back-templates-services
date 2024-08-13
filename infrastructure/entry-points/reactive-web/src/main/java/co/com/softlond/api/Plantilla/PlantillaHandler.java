package co.com.softlond.api.Plantilla;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import co.com.softlond.api.validation.ObjectValidator;
import co.com.softlond.model.PlantillaModel;
import co.com.softlond.usecase.Plantilla.PlantillaOperationsUseCase;
import reactor.core.publisher.Mono;

@Service
public class PlantillaHandler {
    
    private final PlantillaOperationsUseCase plantillaOperationsUseCase; 
    private final ObjectValidator objectValidator;  

    public PlantillaHandler(PlantillaOperationsUseCase plantillaOperationsUseCase, ObjectValidator objectValidator) {
        this.plantillaOperationsUseCase = plantillaOperationsUseCase;
        this.objectValidator = objectValidator;
    }

    public Mono<ServerResponse> savePlantilla(ServerRequest request) {
        return request.bodyToMono(PlantillaModel.class)
            .doOnNext(objectValidator::validate)
            .flatMap(plantillaOperationsUseCase::savePlantilla)
            .flatMap(plantilla -> ServerResponse.ok().bodyValue("Plantilla guardada"))
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

    public Mono<ServerResponse> deletePlantilla(ServerRequest request){
        String id = request.pathVariable("id");
        return plantillaOperationsUseCase.deletePlantilla(id)
        .then(ServerResponse.ok().bodyValue("plantilla eliminada"))
        .switchIfEmpty(ServerResponse.noContent().build())
        .onErrorResume(error -> ServerResponse.badRequest().bodyValue(error.getMessage()));
    }
}

