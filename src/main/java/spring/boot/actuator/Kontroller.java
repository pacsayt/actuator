package spring.boot.actuator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * http://localhost:8081/proba?name=nev
 */

@RestController()
@RequestMapping( "/")
public class Kontroller
{
  @GetMapping( "/proba")
  public String getProba( @RequestParam( "name") String name)
  {
    return "XXXXX : name=" + name;
  }
}