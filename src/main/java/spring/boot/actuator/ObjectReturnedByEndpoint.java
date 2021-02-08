package spring.boot.actuator;

public class ObjectReturnedByEndpoint
{
  private String payloadString;

  public ObjectReturnedByEndpoint(String iniPayloadString)
  {
    payloadString = iniPayloadString;
  };

  public ObjectReturnedByEndpoint( )
  {
  };

  public String getPayloadString()
  {
    return payloadString;
  }

  public void setPayloadString(String iniPayloadString)
  {
    payloadString = iniPayloadString;
  }

  @Override
  public boolean equals(Object o)
  {
    if ( this == o )
    {
      return true;
    }
    if ( o == null || getClass() != o.getClass() )
    {
      return false;
    }

    ObjectReturnedByEndpoint that = (ObjectReturnedByEndpoint) o;

    return payloadString != null ? payloadString.equals(that.payloadString) : that.payloadString == null;
  }

  @Override
  public int hashCode()
  {
    return payloadString != null ? payloadString.hashCode() : 0;
  }
}
