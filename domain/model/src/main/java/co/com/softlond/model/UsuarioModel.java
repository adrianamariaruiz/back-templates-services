package co.com.softlond.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
public class UsuarioModel {
  private String id;

  @NotBlank(message = "El nombre es obligatorio")
  private String userName;

  @NotBlank(message = "El email es obligatorio")
  @Email(message = "Correo invalido")
  public String email;

  @Size(min = 8, message = "La contraseña debe tener mínimo 8 caracteres")
  private String password;

  @NotBlank(message = "Debe ingresar un rol")
  private String roles;
}
