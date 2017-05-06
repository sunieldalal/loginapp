package com.slabs.login.service;

import org.junit.Before;
import org.junit.Test;
import org.opensaml.saml2.core.AuthnRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AuthNRequestBuilderTest {
  
  private static final Logger LOGGER = LoggerFactory.getLogger(AuthNRequestBuilderTest.class.getName());

  @Before
  public void setup() {
    //
  }

  @Test
  public void testAuthNRequestBuilderWorks(){
         
     LOGGER.info("testAuthNRequestBuilderWorks begin");

     AuthNRequestBuilder authReqBuilder = new AuthNRequestBuilder();
     AuthnRequest authNRequest = authReqBuilder.buildAuthenticationRequest("http://login.company.com/saml/sso",
         "http://www.okta.com/samlappid");
     
     assert(authNRequest!=null);
     LOGGER.info("acs=" + authNRequest.getAssertionConsumerServiceURL());
     LOGGER.info("testAuthNRequestBuilderWorks end");
  }
}
