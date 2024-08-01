package co.com.softlond.usecase.Plantilla;

import java.sql.Date;

import org.springframework.stereotype.Service;

import co.com.softlond.model.PlantillaModel;
import co.com.softlond.model.gateways.PlantillaGateways;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PlantillaOperationsUseCase  {
    
    private final PlantillaGateways plantillaGateways;

    public PlantillaOperationsUseCase(PlantillaGateways plantillaGateways) {
        this.plantillaGateways = plantillaGateways;
    }

    public Mono<PlantillaModel> savePlantilla(PlantillaModel plantilla) {
        /* lOGICA DE NEGOCIO */
        plantilla.setFechaActualizacion(new Date(System.currentTimeMillis()));

        // revisar si hay historial y si hay se trae, seteo el contador +1 y con la descripcion
        //  si no hay historial se guarda por primera vez, setea contador +1

        return plantillaGateways.savePlantilla(plantilla);
    }

    public Mono<PlantillaModel> getPlantillaById(String id){
        return plantillaGateways.getPlantillaById(id);
    };

    public Flux<PlantillaModel> getAllDataPlantilla(){
        return plantillaGateways.getAllDataPlantilla();
    }

}
