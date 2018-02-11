package com.spring.data.cassandra.demo1.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;

import com.spring.data.cassandra.demo1.entity.Persona;

public interface PersonaRepository extends CassandraRepository<Persona> {

}
