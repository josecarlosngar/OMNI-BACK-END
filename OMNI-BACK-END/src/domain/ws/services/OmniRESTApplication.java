package domain.ws.services;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("services")
public class OmniRESTApplication extends ResourceConfig {

  public OmniRESTApplication () {
    packages("domain.ws.services");
  }

}
