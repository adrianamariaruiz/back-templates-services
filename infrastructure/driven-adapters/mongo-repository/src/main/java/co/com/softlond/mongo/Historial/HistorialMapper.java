package co.com.softlond.mongo.Historial;

import co.com.softlond.model.HistorialModel;
import co.com.softlond.mongo.Collections.HistorialCollections;

public class HistorialMapper {
   public static HistorialModel toModel(HistorialCollections historialCollections) {
        return HistorialModel.builder()
                .id(historialCollections.getId())
                .counter(historialCollections.getCounter())
                .lastDescription(historialCollections.getLastDescription())
                .build();
    }
    
    public static HistorialCollections toCollection(HistorialModel historialModel) {
        HistorialCollections historialCollections = new HistorialCollections();
        historialCollections.setId(historialModel.getId());
        historialCollections.setCounter(historialModel.getCounter());
        historialCollections.setLastDescription(historialModel.getLastDescription());
        return historialCollections;
    }
}
