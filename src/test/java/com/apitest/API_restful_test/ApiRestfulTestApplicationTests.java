package com.apitest.API_restful_test;

import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class ApiRestfulTestApplicationTests {

	/*@Autowired
	private IUserRepository IUserRepository;

	@Test
	void contextLoads() {
		User usuario1 = new User("Lautaro","produgraf","abc");
		User usuario2 = new User("Nahuel","profesional","abc");

		IUserRepository.save(usuario1);
		IUserRepository.save(usuario2);

		IUserRepository.flush();

		assertEquals(2, IUserRepository.findAll().size());
	}*/

}
