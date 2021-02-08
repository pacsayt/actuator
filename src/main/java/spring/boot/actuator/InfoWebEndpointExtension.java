package spring.boot.actuator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.web.annotation.EndpointWebExtension;
import org.springframework.boot.actuate.info.InfoEndpoint;
import org.springframework.boot.actuate.endpoint.web.WebEndpointResponse;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@EndpointWebExtension( endpoint = InfoEndpoint.class)
public class InfoWebEndpointExtension
{
  private static final Logger LOGGER = LoggerFactory.getLogger( InfoWebEndpointExtension.class);

  @Autowired
  private InfoEndpoint delegate;

  @ReadOperation
  public WebEndpointResponse<Map> info()
  {
    LOGGER.info( "InfoWebEndpointExtension::info() : ++++++++++");
    Map<String, Object> info = delegate.info();

//    info.put( "INFO_1", "INFO_1_VALUE"); // Collections$UnmodifiableMap.put() -> UnsupportedOperationException

    Integer status = getStatus(info);
    return new WebEndpointResponse<>(info, status);
  }

  private Integer getStatus(Map<String, Object> info)
  {
    LOGGER.info( "InfoWebEndpointExtension::getStatus() : -> " + info + " ++++++++++");

    // Return code must be one of WebEndpointResponse.STATUS_OK..STATUS_SERVICE_UNAVAILABLE or else exception will be thrown
    LOGGER.info( "InfoWebEndpointExtension::getStatus() : -> " + WebEndpointResponse.STATUS_OK + " ++++++++++");

    return WebEndpointResponse.STATUS_OK;
  }
}