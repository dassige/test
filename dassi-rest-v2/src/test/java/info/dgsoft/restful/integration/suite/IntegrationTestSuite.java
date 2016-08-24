package info.dgsoft.restful.integration.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import info.dgsoft.restful.integration.controller.rest.AuthenticationControllerTest;
import info.dgsoft.restful.integration.controller.rest.ProtectedControllerTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
  AuthenticationControllerTest.class,
  ProtectedControllerTest.class
})
public class IntegrationTestSuite {

}
