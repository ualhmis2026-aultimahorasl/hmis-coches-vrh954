package org.hmis;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CocheTest {

	@Test
	void testConstructorVacio() {
		Coche c = new Coche();
		assertNull(c.getMarca());
		assertNull(c.getModelo());
		assertEquals(0, c.getAño());
		assertEquals(0, c.getPrecio());
	}

	@Test
	void testConstructorParametros() {
		Coche c = new Coche("Toyota", "Corolla", 2022, 22000);
		assertEquals("Toyota", c.getMarca());
		assertEquals("Corolla", c.getModelo());
		assertEquals(2022, c.getAño());
		assertEquals(22000, c.getPrecio());
	}

	@Test
	void testSetters() {
		Coche c = new Coche();
		c.setMarca("Ford");
		c.setModelo("Focus");
		c.setAño(2020);
		c.setPrecio(18000);
		assertEquals("Ford", c.getMarca());
		assertEquals("Focus", c.getModelo());
		assertEquals(2020, c.getAño());
		assertEquals(18000, c.getPrecio());
	}

	@Test
	void testEqualsIgual() {
		Coche c1 = new Coche("Toyota", "Corolla", 2022, 22000);
		Coche c2 = new Coche("Toyota", "Corolla", 2022, 22000);
		assertTrue(c1.equals(c2));
		assertTrue(c1.equals(c1));
	}

	@Test
	void testEqualsDistinto() {
		Coche c1 = new Coche("Toyota", "Corolla", 2022, 22000);
		Coche c2 = new Coche("Ford", "Focus", 2020, 18000);
		assertFalse(c1.equals(c2));
		assertFalse(c1.equals(null));
		assertFalse(c1.equals("no es un coche"));
	}

	@Test
	void testEqualsDiferenteCampo() {
		Coche base = new Coche("Toyota", "Corolla", 2022, 22000);
		assertFalse(base.equals(new Coche("Ford", "Corolla", 2022, 22000)));
		assertFalse(base.equals(new Coche("Toyota", "Yaris", 2022, 22000)));
		assertFalse(base.equals(new Coche("Toyota", "Corolla", 2023, 22000)));
		assertFalse(base.equals(new Coche("Toyota", "Corolla", 2022, 25000)));
	}

	@Test
	void testToString() {
		Coche c = new Coche("Toyota", "Corolla", 2022, 22000);
		String s = c.toString();
		assertTrue(s.contains("Toyota"));
		assertTrue(s.contains("Corolla"));
		assertTrue(s.contains("2022"));
		assertTrue(s.contains("22000"));
	}
}
