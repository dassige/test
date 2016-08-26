package info.dgsoft.restful.unit.security;

import org.junit.Test;

import info.dgsoft.restful.auth.domain.json.AuthenticationRequest;
import info.dgsoft.restful.auth.security.TokenUtils;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class TokenUtilTest {

  private final String ENCODED = "$2a$08$lDnHPz7eUkSi6ao14Twuau08mzhWrL4kyZGGU5xfiGALO/Vxd5DOi";
  private final String PASSWORD = "admin";
/*
  @Test
  public void cgenerateEncodedPassword() {
     TokenUtils tokenUtils = new TokenUtils();
 
     String encodedPwd = tokenUtils.generateEncodedPassword(PASSWORD);
    assertThat(encodedPwd, is(ENCODED));
    System.out.println("encoded password for " + PASSWORD + " is " + encodedPwd);
  }
*/
}
