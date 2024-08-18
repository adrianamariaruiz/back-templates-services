package co.com.softlond.model;

import java.util.Date;

import co.com.softlond.model.PlantillaEnums.CategoriaEnum;
import co.com.softlond.model.PlantillaEnums.EstadoEnum;
import co.com.softlond.model.PlantillaEnums.EtiquetaEnum;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
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

    @NotBlank(message = "Debe ingresar un autor")
    private String autor;

    private int version;

    private CategoriaEnum categoria;
    
    private EstadoEnum activo;
    
    private EtiquetaEnum etiquetas;
    // completado, en progreso, rechazo, pendiente

    private Date fecha;

    @NotBlank(message = "La descripción es obligatoria")
    private String descripcion;
    
    @FutureOrPresent(message = "La fecha de actualización no puede ser anterior a la actual")
    private Date fechaActualizacion;
}
