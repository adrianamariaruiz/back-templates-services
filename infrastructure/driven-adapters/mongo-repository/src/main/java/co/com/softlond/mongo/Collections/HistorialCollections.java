package co.com.softlond.mongo.Collections;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "historial")
public class HistorialCollections {
  @Id
  private String id;
  private String plantillaId;
  private Integer counter;
  private String lastDescription;
}
