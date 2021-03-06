package spring.boot.actuator;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * https://spring.io/guides/gs/actuator-service/
 */
@WebMvcTest( controllers = TestEndpoint.class) // --> MockMvc works, using TestRestTemplate will result
                                               //     in a plethora of ununderstandable error messages
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestEndpointTest
{
  // This (TestRestTemplate) fails with with :@WebMvcTest( controllers = TestEndpoint.class)

//  @LocalServerPort
//  private int portNumber; // pt++ : annotated primitive type ...

  // This fails with with : @WebMvcTest
//  @Autowired
//  private TestRestTemplate testRestTemplate;

//  @Test
//  public void testTestEndpointReturnValueAndCode()
//  {
//    String returnedString = testRestTemplate.getForObject( "http://localhost:" + portNumber + "/test", String.class);
//
//    assertEquals( "T_E_S_T", returnedString);
//  }

  // This fails with with : @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;

  @Test
  public void testTestEndpointReturnValueAndCodeMvc() throws Exception
  {
    mockMvc.perform( get( "/test").
            contentType( MediaType.APPLICATION_JSON)).
            andExpect( status().isOk()). // pt++ : should I need the value returned : andReturn().
            andExpect( ResponseBodyMatchers.createResponseBodyMatcher().containsObjectAsJson( "T_E_S_T", String.class));
  }

  @Test
  public void testTestEndpointReturnObjectAndCodeMvc() throws Exception
  {
    ObjectReturnedByEndpoint objectReturnedByEndpoint = new ObjectReturnedByEndpoint("T_E_S_T");

    mockMvc.perform( get( "/testobject").
                     contentType( MediaType.APPLICATION_JSON)).
            andExpect( status().isOk()).
            andExpect( ResponseBodyMatchers.createResponseBodyMatcher().containsObjectAsJson( objectReturnedByEndpoint,
                                                                                              ObjectReturnedByEndpoint.class));
  }
}
