package spring.boot.actuator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.actuate.endpoint.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Endpoint(id = "features") // /actuator/features
public class FeaturesEndpoint
{
  private static final Logger LOGGER = LoggerFactory.getLogger( FeaturesEndpoint.class);

  private Map<String, Feature> features = new ConcurrentHashMap<>();

  @ReadOperation
  public Map<String, Feature> features()
  {
    Feature newFeature = new Feature( true, "Feature_" + System.currentTimeMillis());
    LOGGER.info( "features() " + newFeature + " ++++++++++");

    features.putIfAbsent( newFeature.getFeatureName(), newFeature);

    return features;
  }

  // http://localhost:9001/actuator/features/Feature_1589287044755
  @ReadOperation
  public Feature feature(@Selector String name)
  {
    LOGGER.info( "feature() ++++++++++");
    return features.get(name);
  }

  @WriteOperation
  public void configureFeature(@Selector String name, Feature feature)
  {
    LOGGER.info( "configureFeature() ++++++++++");
    features.put(name, feature);
  }

  @DeleteOperation
  public void deleteFeature(@Selector String name)
  {
    LOGGER.info( "deleteFeature() ++++++++++");
    features.remove(name);
  }

  public static class Feature
  {
    private boolean enabled;
    private String  featureName;

    // [...] getters and setters
    public Feature( boolean iniEnabled, String iniFeatureName)
    {
      enabled = iniEnabled;
      featureName = iniFeatureName;
    }

    @Override
    public boolean equals( Object o)
    {
      if ( this == o )
      {
        return true;
      }

      if ( o == null || getClass() != o.getClass() )
      {
        return false;
      }

      Feature feature = (Feature) o;
      return enabled == feature.enabled && Objects.equals(featureName, feature.featureName);
    }

    @Override
    public int hashCode()
    {
      return Objects.hash( enabled, featureName);
    }

    public boolean getEnabled()
    {
      return enabled;
    }

    public String getFeatureName()
    {
      return featureName;
    }

    @Override
    public String toString()
    {
      return "Feature{enabled=" + enabled + ", featureName='" + featureName + "'}";
    }
  }
}