package co.com.softlond.usecase.Historial;

import org.springframework.stereotype.Service;

import co.com.softlond.model.HistorialModel;
import co.com.softlond.model.gateways.HistorialGateways;
import reactor.core.publisher.Mono;

@Service
public class HistorialOperationsUseCase {
  private final HistorialGateways historialGateways;

  public HistorialOperationsUseCase(HistorialGateways historialGateways){
    this.historialGateways = historialGateways;
  }

    // private Mono<HistorialModel> createHistorial(String descripcion) {
    //   HistorialModel newHistorial = HistorialModel.builder()
    //     .counter(1)
    //     .lastDescription(descripcion)
    //     .build();
    //   return historialGateways.saveHistorial(newHistorial);
    // }

    public Mono<HistorialModel> saveHistorial(HistorialModel historial){
      return historialGateways.saveHistorial(historial);
        // .defaultIfEmpty(new HistorialModel())
        // .flatMap(historial -> {
        //     historial.setCounter(historial.getCounter() + 1);
        //     historial.setLastDescription(descripcion);
        //     return historialGateways.saveHistorial(historial);
        // });
    }

    public Mono<HistorialModel> getHistorial(){
      return historialGateways.getHistorial();
    }

    public Mono<HistorialModel> getHistorialById(String id){
      return historialGateways.getHistorialById(id);
    }


}
