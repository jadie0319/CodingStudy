package com.springsso.sso.server.service;

import com.springsso.sso.server.domain.AccessToken;

public interface SsoService {
    //
    AccessToken getAccessToken(String token, String clientId);

    String logoutAllClients(String clientId, String userName);
}
