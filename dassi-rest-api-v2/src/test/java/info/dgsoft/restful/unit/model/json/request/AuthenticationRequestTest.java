package info.dgsoft.restful.unit.model.json.request;

import org.junit.Test;

import info.dgsoft.restful.api.auth.AuthenticationRequest;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class AuthenticationRequestTest {

  private final String USERNAME = "username";
  private final String PASSWORD = "password";

  @Test
  public void callingAuthenticationRequestConstructorWithoutParametersCreatesExpectedObject() {
    AuthenticationRequest authenticationRequest = new AuthenticationRequest();

    assertNull(authenticationRequest.getUsername());
    assertNull(authenticationRequest.getPassword());
  }

  @Test
  public void callingAuthenticationRequestConstructorWithParametersCreatesExpectedObject() {
    AuthenticationRequest authenticationRequest = new AuthenticationRequest(USERNAME, PASSWORD);

    assertThat(authenticationRequest.getUsername(), is(USERNAME));
    assertThat(authenticationRequest.getPassword(), is(PASSWORD));
  }

  @Test
  public void callingAuthenticationRequestGettersAndSettersReturnsExpectedObjects() {
    AuthenticationRequest authenticationRequest = new AuthenticationRequest();

    authenticationRequest.setUsername(USERNAME);
    authenticationRequest.setPassword(PASSWORD);

    assertThat(authenticationRequest.getUsername(), is(USERNAME));
    assertThat(authenticationRequest.getPassword(), is(PASSWORD));
  }

}
