package co.com.softlond.usecase.Plantilla;

import java.sql.Date;

import org.springframework.stereotype.Service;

import co.com.softlond.model.HistorialModel;
import co.com.softlond.model.PlantillaModel;
import co.com.softlond.model.gateways.PlantillaGateways;
import co.com.softlond.usecase.Historial.HistorialOperationsUseCase;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Service
public class PlantillaOperationsUseCase  {
    
    private final PlantillaGateways plantillaGateways;
    private final HistorialOperationsUseCase historialOperationsUseCase;

    public PlantillaOperationsUseCase(PlantillaGateways plantillaGateways, HistorialOperationsUseCase historialOperationsUseCase) {
        this.plantillaGateways = plantillaGateways;
        this.historialOperationsUseCase = historialOperationsUseCase;
    }

    public Mono<PlantillaModel> savePlantilla(PlantillaModel plantilla) {
        /* lOGICA DE NEGOCIO */
        plantilla.setFechaActualizacion(new Date(System.currentTimeMillis()));

        // verificar si es el mismo id que no sume el contador

        return plantillaGateways.savePlantilla(plantilla)
            .doOnSuccess(savedPlantilla -> 
                historialOperationsUseCase.getHistorial()
                .defaultIfEmpty(new HistorialModel())
                .flatMap(historial -> {
                    historial.setCounter(historial.getCounter() + 1);
                    historial.setPlantillaId(savedPlantilla.getId());
                    historial.setLastDescription(savedPlantilla.getDescripcion());
                    return historialOperationsUseCase.saveHistorial(historial);
                })
                .subscribeOn(Schedulers.boundedElastic())
                .subscribe()
            );
    };

    public Mono<PlantillaModel> getPlantillaById(String id){
        return plantillaGateways.getPlantillaById(id);
    };

    public Flux<PlantillaModel> getAllDataPlantilla(){
        return plantillaGateways.getAllDataPlantilla();
    }

}
