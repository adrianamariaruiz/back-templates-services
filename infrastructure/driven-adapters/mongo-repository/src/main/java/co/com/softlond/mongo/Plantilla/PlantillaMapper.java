package co.com.softlond.mongo.Plantilla;

import co.com.softlond.model.PlantillaModel;
import co.com.softlond.mongo.Collections.PlantillaCollections;

public class PlantillaMapper {
    
    public static PlantillaModel toModel(PlantillaCollections plantillaCollections) {
        return PlantillaModel.builder()
                .id(plantillaCollections.getId())
                .nombre(plantillaCollections.getNombre())
                .fecha(plantillaCollections.getFecha())
                .descripcion(plantillaCollections.getDescripcion())
                .fechaActualizacion(plantillaCollections.getFechaActualizacion())
                .autor(plantillaCollections.getAutor())
                .version(plantillaCollections.getVersion())
                .categoria(plantillaCollections.getCategoria())
                .activo(plantillaCollections.getActivo())
                .etiquetas(plantillaCollections.getEtiquetas())
                .build();
    }
    
    public static PlantillaCollections toCollection(PlantillaModel plantillaModel) {
        PlantillaCollections plantillaCollections = new PlantillaCollections();
        plantillaCollections.setId(plantillaModel.getId());
        plantillaCollections.setNombre(plantillaModel.getNombre());
        plantillaCollections.setFecha(plantillaModel.getFecha());
        plantillaCollections.setDescripcion(plantillaModel.getDescripcion());
        plantillaCollections.setFechaActualizacion(plantillaModel.getFechaActualizacion());
        plantillaCollections.setAutor(plantillaModel.getAutor());
        plantillaCollections.setVersion(plantillaModel.getVersion());
        plantillaCollections.setCategoria(plantillaModel.getCategoria());
        plantillaCollections.setActivo(plantillaModel.getActivo());
        plantillaCollections.setEtiquetas(plantillaModel.getEtiquetas());
        return plantillaCollections;
    }
}