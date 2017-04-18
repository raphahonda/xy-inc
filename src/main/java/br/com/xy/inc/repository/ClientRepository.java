package br.com.xy.inc.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.xy.inc.model.Client;

public interface ClientRepository extends CrudRepository<Client, Long>{}
