package spring.boot.actuator;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * curl localhost:9000/test
 * T_E_S_T
 *
 * Spring MVC - How to return simple String as JSON in Rest Controller
 * https://stackoverflow.com/questions/30895286/spring-mvc-how-to-return-simple-string-as-json-in-rest-controller
 */
@RestController
public class TestEndpoint
{
  // pt++ : this does NOT JSon encode the return value because it is a String, (despite of "produces").
  //        So you must do it before sending the String yourself ...
  @GetMapping( path = "test", produces = "application/json")
  public String test() throws JsonProcessingException
  {
    String carAsString = new ObjectMapper().writeValueAsString( "T_E_S_T");

    return carAsString;
  }

  // pt++ : This endpoint (though configured the same) will produce
  @GetMapping( path = "testobject", produces = "application/json")
  public ObjectReturnedByEndpoint testobject()
  {
    return new ObjectReturnedByEndpoint("T_E_S_T");
  }
}
