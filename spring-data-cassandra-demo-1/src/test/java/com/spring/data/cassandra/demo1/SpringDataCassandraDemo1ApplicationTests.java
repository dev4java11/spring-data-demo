package com.spring.data.cassandra.demo1;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring.data.cassandra.demo1.entity.Usuario;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringDataCassandraDemo1ApplicationTests {
	
	@Autowired
	private CassandraOperations cassandraOperations;

	@Test
	public void contextLoads() {
//		Usuario usuario = new Usuario();
//		usuario.setId(2);
//		usuario.setNombres("Pepito");
//		usuario.setApellidos("Alvarez Gomez");
//		usuario = cassandraOperations.insert(usuario);
		List<Usuario> usuarios = cassandraOperations.select("select * from usuarios where userid=2", Usuario.class);
		for(Usuario usuario : usuarios){
			System.out.println(usuario.toString());
		}
	}

}
