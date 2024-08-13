package co.com.softlond.api.validation;

import java.util.Set;
import org.springframework.stereotype.Component;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

@Component
@RequiredArgsConstructor
public class ObjectValidator {

  @SneakyThrows
  public <T> void validate(T object){
    Set<ConstraintViolation<T>> errors = Validation.buildDefaultValidatorFactory()
      .getValidator()
      .validate(object);

    if(!errors.isEmpty()){
      
      StringBuilder errorMessage = new StringBuilder();
      for(ConstraintViolation<T> violation : errors){
        errorMessage.append(violation.getMessage()).append(" ");
      }
      throw new RuntimeException(errorMessage.toString());

    }
    
  }
}
