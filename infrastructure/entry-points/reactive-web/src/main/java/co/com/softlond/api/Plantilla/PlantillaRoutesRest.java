package co.com.softlond.api.Plantilla;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;


@Configuration
public class PlantillaRoutesRest {
    
    @Bean
    public RouterFunction<ServerResponse> plantillaRoutes(PlantillaHandler plantillaHandler) {
        return RouterFunctions.route()
            .GET("/api/plantillas", plantillaHandler::getAllPlantillas)
            .GET("/api/plantilla/{id}", plantillaHandler::getPlantilla)
            .POST("/api/plantilla/save", plantillaHandler::savePlantilla)
            .PUT("/api/plantilla/{id}", plantillaHandler::updatePlantilla)
            .DELETE("/api/plantilla/{id}", plantillaHandler::deletePlantilla)
            .build();
        
    }
    
}
