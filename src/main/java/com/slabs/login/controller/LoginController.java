package com.slabs.login.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.slabs.login.service.login.LoginService;
import org.springframework.core.env.Environment;

@Controller
public class LoginController {

  private static Logger LOGGER = LoggerFactory.getLogger(LoginController.class.getName());

  @RequestMapping("/")
  String index(){
    return "index";
  }

  private Environment environment;
  private LoginService loginService;

  @Autowired
  public LoginController(LoginService pLoginService, Environment pEnvironment) {
    this.environment = pEnvironment;
    this.loginService = pLoginService;
  }

  @RequestMapping(value =  "ssoredirect", method = RequestMethod.GET)
  public String redirectToIDPWithAuthNRequest() {

    String redirectUrl, redirectString = null;

    String idpAppURL = environment.getProperty("IDP_SSO_URL");
    String relayState = environment.getProperty("RELAYSTATE_BASE_URL") + "?articleId=1234"; // Relaystate can be
    // dynamic
    String assertionConsumerServiceUrl = environment.getProperty("ACS_URL");
    String issuerId = environment.getProperty("IDP_ISSUER_ID");
    redirectUrl = loginService.getAuthNRedirectUrl(idpAppURL, relayState, assertionConsumerServiceUrl, issuerId);

    LOGGER.info("Redirecting to " + redirectUrl + " for applicationName:" + environment.getProperty("RELAYSTATE_BASE_URL"));

    return "redirect:" + redirectUrl;
  }
}
