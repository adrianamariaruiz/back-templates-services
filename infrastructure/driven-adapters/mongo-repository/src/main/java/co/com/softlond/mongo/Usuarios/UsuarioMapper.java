package co.com.softlond.mongo.Usuarios;

import co.com.softlond.model.UsuarioModel;
import co.com.softlond.mongo.Collections.UsuarioCollections;

public class UsuarioMapper {
  public static UsuarioModel toModel(UsuarioCollections usuarioCollections){
    return UsuarioModel.builder()
      .id(usuarioCollections.getId())
      .userName(usuarioCollections.getUserName())
      .email(usuarioCollections.getEmail())
      .password(usuarioCollections.getPassword())
      .roles(usuarioCollections.getRoles())
      .build();
  }

  public static UsuarioCollections toCollection(UsuarioModel usuarioModel){
    UsuarioCollections usuarioCollections = new UsuarioCollections();
    usuarioCollections.setId(usuarioModel.getId());
    usuarioCollections.setUserName(usuarioModel.getUserName());
    usuarioCollections.setEmail(usuarioModel.getEmail());
    usuarioCollections.setPassword(usuarioModel.getPassword());
    usuarioCollections.setRoles(usuarioModel.getRoles());
    return usuarioCollections;
  }
}
