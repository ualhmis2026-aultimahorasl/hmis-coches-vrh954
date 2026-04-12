package org.hmis;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MainTest {

	@Test
	void testMain() {
		assertDoesNotThrow(() -> Main.main(new String[]{}));
	}
}
