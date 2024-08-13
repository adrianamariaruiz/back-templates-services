package co.com.softlond.mongo.Collections;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "usuario")
public class UsuarioCollections {

  @Id
  private String id;
  private String userName;
  public String email;
  private String password;
  private String roles;

}
