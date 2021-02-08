package spring.boot.actuator;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * http://localhost:9000/proba?name=nev
 */

@RestController
public class Kontroller
{
  private static final Logger LOGGER = LoggerFactory.getLogger( Kontroller.class);

  @GetMapping( value = "/proba", produces = "application/json")
  public String getProba( @RequestParam( "name") String name) throws JsonProcessingException
  {
    LOGGER.info( "Kontroller::getProba( " + name + ") ++++++++++");
    return new ObjectMapper().writeValueAsString( "AAAAAAAAAAAAAAAA");
  }
}