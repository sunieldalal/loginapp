package com.slabs.login.service.login;

public interface LoginService {

  public String getAuthNRedirectUrl(String idpAppURL, String relayState, String assertionConsumerServiceUrl,
      String issuerId);
}
