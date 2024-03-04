package zerobase.wether;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@EnableTransactionManagement
@EnableScheduling // 스케줄링 기능 활성화
class WetherApplicationTests {

	@Test
	void equalsTest() {
		assertEquals(1, 1);
	}
	@Test
	void nullTest() {
	    assertNull(null);
	}

	@Test
	void trueTest() {
		assertTrue(1 == 1);
	}


}
