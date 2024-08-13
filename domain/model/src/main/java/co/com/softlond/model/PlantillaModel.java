package co.com.softlond.model;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PlantillaModel {
    private String id;

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    private Date fecha;

    @NotBlank(message = "La descripción es obligatoria")
    private String descripcion;
    
    private Date fechaActualizacion;
}
