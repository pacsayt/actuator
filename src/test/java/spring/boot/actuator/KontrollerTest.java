package spring.boot.actuator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest( controllers = Kontroller.class)
public class KontrollerTest
{
  @Autowired
  private MockMvc mockMvc;

  @Test
  public void testProbaReturnsExpectedValueOk() throws Exception
  {
    mockMvc.perform( get( "/proba?name=nev").contentType( MediaType.APPLICATION_JSON)).
            andExpect( status().isOk()).
            andExpect( ResponseBodyMatchers.createResponseBodyMatcher().containsObjectAsJson( "AAAAAAAAAAAAAAAA", String.class));
  }
}
