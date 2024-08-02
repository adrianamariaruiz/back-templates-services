package co.com.softlond.mongo.Historial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.com.softlond.model.HistorialModel;
import co.com.softlond.model.gateways.HistorialGateways;
import reactor.core.publisher.Mono;

@Repository
public class HistorialGatewaysImpl implements HistorialGateways {
  @Autowired 
  private ReactiveHistorialMongoRepository reactiveHistorialMongoRepository;

  @Override
    public Mono<HistorialModel> getHistorial(){
        return reactiveHistorialMongoRepository.findAll()
          .next() /*trae la ultima plantilla creada en mongo */
          .map(HistorialEntity -> HistorialMapper.toModel(HistorialEntity));
    }

  @Override
  public Mono<HistorialModel> saveHistorial(HistorialModel historial){
    return reactiveHistorialMongoRepository.save(HistorialMapper.toCollection(historial))
      .map(HistorialEntity -> HistorialMapper.toModel(HistorialEntity));
  }

  @Override
  public Mono<HistorialModel> getHistorialById(String id){
    return reactiveHistorialMongoRepository.findPlantillaById(id)
      .map(historialEntity -> HistorialMapper.toModel(historialEntity));
  }

}
