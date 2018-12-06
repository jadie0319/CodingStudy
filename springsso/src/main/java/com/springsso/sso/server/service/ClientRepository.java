package com.springsso.sso.server.service;

import com.springsso.sso.server.domain.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client,String> {
}
