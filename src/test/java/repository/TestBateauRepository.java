package repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class TestBateauRepository {

	@Test
	void test() {
		List<String> res = BateauRepo.findAll();
		System.out.println(res);
	}

}
