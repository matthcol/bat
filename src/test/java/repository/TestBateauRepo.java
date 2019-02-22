package repository;

import java.util.List;

import org.junit.jupiter.api.Test;

public class TestBateauRepo {

	
	@Test
	void testRepo() {
		List<String> bateaux = BateauRepo.findAll();
		System.out.println(bateaux);
	}
}
