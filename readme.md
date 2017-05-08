
# How to Run this example

Run below command to run the web app.

```
gradle bootRun
```

Go to http://localhost:8080

# What this example demonstrates?

This example is companion for blog - http://polyglotdeveloper.com/iam/2017-05-06-create-saml2-SP-Initiated-authnrequest-using-java/

It demonstrates example of create SAML2 SP-Initiated authnrequest using java openSAML library.

# Testing

I created a preview account in Okta to test end to end functionality. You can test with your IDP.

Be sure to change the property in application.properties.

Here are the properties you have to change in application.properties if you want to play with this example.

IDP_SSO_URL=https://dev-552077.oktapreview.com/app/demodev552077_saml2app_1/exka9jbh72o7D4REL0h7/sso/saml
IDP_ISSUER_ID=http://www.okta.com/exka9jbh72o7D4REL0h7
ACS_URL=https://login.company.com/ssorequest/idp/okta
RELAYSTATE_BASE_URL=http://app1.company.com


# Notes

You can change the RelayState in LoginController to make it dynamic.


