package br.com.xy.inc.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.xy.inc.model.CarFleet;

public interface CarRepository extends CrudRepository<CarFleet, Long>{}
