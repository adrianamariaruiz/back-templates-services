package co.com.softlond.mongo.Plantilla;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.com.softlond.model.PlantillaModel;
import co.com.softlond.model.gateways.PlantillaGateways;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class PlantillaGatewaysImpl implements PlantillaGateways {    

    @Autowired
    private ReactivePlantillaMongoRepository reactivePlantillaMongoRepository;

    @Override
    public Mono<PlantillaModel> savePlantilla(PlantillaModel plantilla) {
        return reactivePlantillaMongoRepository.save(PlantillaMapper.toCollection(plantilla))
                .map(plantillaEntity -> PlantillaMapper.toModel(plantillaEntity));
    }

    @Override
    public Mono<PlantillaModel> getPlantillaById(String id){
        return reactivePlantillaMongoRepository.findById(id)
            .map(plantillaEntity -> PlantillaMapper.toModel(plantillaEntity));
    }

    @Override
    public Flux<PlantillaModel> getAllDataPlantilla(){
        return reactivePlantillaMongoRepository.findAll()
            .map(plantillaEntity -> PlantillaMapper.toModel(plantillaEntity));
    }

    @Override
    public Mono<Void> deletePlantilla(String id){
        return reactivePlantillaMongoRepository.deleteById(id);
    }
    
}
