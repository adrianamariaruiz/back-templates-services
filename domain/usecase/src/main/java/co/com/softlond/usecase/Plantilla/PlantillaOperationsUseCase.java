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
// import reactor.util.Logger;
// import reactor.util.Loggers;

@Service
public class PlantillaOperationsUseCase  {
    
    private final PlantillaGateways plantillaGateways;
    private final HistorialOperationsUseCase historialOperationsUseCase;
    // private final Logger log = Loggers.getLogger(PlantillaOperationsUseCase.class);

    public PlantillaOperationsUseCase(PlantillaGateways plantillaGateways, HistorialOperationsUseCase historialOperationsUseCase) {
        this.plantillaGateways = plantillaGateways;
        this.historialOperationsUseCase = historialOperationsUseCase;
    }

    public Mono<PlantillaModel> savePlantilla(PlantillaModel plantilla) {
        // log.info("Guardando plantilla");
        // log.error("Error guardando plantilla");

        /* lOGICA DE NEGOCIO */
        plantilla.setFechaActualizacion(new Date(System.currentTimeMillis()));

        return plantillaGateways.savePlantilla(plantilla)
            .doOnSuccess(savedPlantilla -> 
                historialOperationsUseCase.getHistorial()
                .defaultIfEmpty(new HistorialModel())
                .flatMap(historial -> {
                    // verificar si es el mismo id que no sume el contador
                    if (plantilla.getId() == null) {
                        historial.setCounter(historial.getCounter() == null ? 1 : historial.getCounter() + 1);
                    }    
                   
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