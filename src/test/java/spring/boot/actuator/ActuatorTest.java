package com.sb.actuator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest( webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource( properties = {"management.port=0"})
public class ActuatorTest
{
  @LocalServerPort
  private int port;

  @Value("${local.management.port}")
  private int managementPort;

  @Autowired
  private TestRestTemplate testRestTemplate;

  @Test
  public void shouldReturn200WhenSendingRequestToManagementEndpoint() throws Exception
  {
//    @SuppressWarnings("rawtypes")
    ResponseEntity<Map> entity = testRestTemplate.getForEntity("http://localhost:" + managementPort + "/actuator/health", Map.class);
    assertEquals( HttpStatus.OK, entity.getStatusCode());

    String statusValue = (String)entity.getBody().get( "status");
    assertEquals( "UP", statusValue);
  }
}
