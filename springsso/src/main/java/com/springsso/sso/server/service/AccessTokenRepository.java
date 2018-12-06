package com.springsso.sso.server.service;

import com.springsso.sso.server.domain.AccessToken;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AccessTokenRepository extends CrudRepository<AccessToken, String> {
    //
    AccessToken findByTokenIdAndClientId(String tokenId, String clientId);

    int deleteByUserName(String userName);

    List<AccessToken> findByUserName(String userName);
}