package springbootapplication.girahuunhan.role.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import springbootapplication.girahuunhan.role.model.GiraRole;

@SpringBootTest
@Transactional
public class GiraRoleRepositoryTest {
	@Autowired
	private GiraRoleRepository repository;
	
	@Test
	public void shouldNotInsertRole() {
		GiraRole role = GiraRole.builder()
								.code("Admin role")
								.description("admin tran huu nhan dep trai ahihi")
								.build();
		assertDoesNotThrow(() -> repository.save(role));
	}
	
}
