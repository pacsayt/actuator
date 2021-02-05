package com.sb.actuator;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * curl localhost:9000/test
 * T_E_S_T
 */
@RestController
public class TestEndpoint
{
  @RequestMapping( path = "test")
  public String test()
  {
    return "T_E_S_T";
  }
}
