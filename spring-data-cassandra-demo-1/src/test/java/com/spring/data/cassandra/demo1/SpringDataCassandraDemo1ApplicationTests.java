package com.spring.data.cassandra.demo1;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.repository.support.BasicMapId;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring.data.cassandra.demo1.entity.Persona;
import com.spring.data.cassandra.demo1.repository.PersonaRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringDataCassandraDemo1ApplicationTests {
	
	@Autowired
	private CassandraOperations cassandraOperations;
	
	@Autowired
	private PersonaRepository personaRepository;

	@Test
	@Ignore
	public void test1() {
		Persona usuario = new Persona();
		usuario.setId(1);
		usuario.setNombres("Pepito");
		usuario.setApellidos("Alvarez Gomez");
		usuario = cassandraOperations.insert(usuario);
//		List<Usuario> usuarios = cassandraOperations.select("select * from usuarios where userid=2", Usuario.class);
//		for(Usuario usuario : usuarios){
//			System.out.println(usuario.toString());
//		}
	}

	@Test
	public void test2(){
		Map<String, Serializable> map = new LinkedHashMap<>();
		map.put("id", new Integer(1));
		Persona persona = personaRepository.findOne(new BasicMapId(map));
		System.out.println(persona.toString());
	}
}
