package org.hmis;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CocheTest {

    @Test
    void testConstructorPorDefecto() {
        Coche coche = new Coche();
        assertNull(coche.getMarca());
        assertNull(coche.getModelo());
        assertEquals(0, coche.getAño());
        assertEquals(0, coche.getPrecio());
    }

    @Test
    void testConstructorConParametros() {
        Coche coche = new Coche("Toyota", "Corolla", 2023, 25000);
        assertEquals("Toyota", coche.getMarca());
        assertEquals("Corolla", coche.getModelo());
        assertEquals(2023, coche.getAño());
        assertEquals(25000, coche.getPrecio());
    }

    @Test
    void testGetSetMarca() {
        Coche coche = new Coche();
        coche.setMarca("Honda");
        assertEquals("Honda", coche.getMarca());
    }

    @Test
    void testGetSetModelo() {
        Coche coche = new Coche();
        coche.setModelo("Civic");
        assertEquals("Civic", coche.getModelo());
    }

    @Test
    void testGetSetAnio() {
        Coche coche = new Coche();
        coche.setAño(2024);
        assertEquals(2024, coche.getAño());
    }

    @Test
    void testGetSetPrecio() {
        Coche coche = new Coche();
        coche.setPrecio(30000);
        assertEquals(30000, coche.getPrecio());
    }

    @Test
    void testEqualsMismoObjeto() {
        Coche coche = new Coche("Toyota", "Corolla", 2023, 25000);
        assertEquals(coche, coche);
    }

    @Test
    void testEqualsObjetoIgual() {
        Coche coche1 = new Coche("Toyota", "Corolla", 2023, 25000);
        Coche coche2 = new Coche("Toyota", "Corolla", 2023, 25000);
        assertEquals(coche1, coche2);
    }

    @Test
    void testEqualsNull() {
        Coche coche = new Coche("Toyota", "Corolla", 2023, 25000);
        assertNotEquals(null, coche);
    }

    @Test
    void testEqualsDistintaClase() {
        Coche coche = new Coche("Toyota", "Corolla", 2023, 25000);
        assertNotEquals("un string", coche);
    }

    @Test
    void testEqualsDistintaMarca() {
        Coche coche1 = new Coche("Toyota", "Corolla", 2023, 25000);
        Coche coche2 = new Coche("Honda", "Corolla", 2023, 25000);
        assertNotEquals(coche1, coche2);
    }

    @Test
    void testEqualsDistintoModelo() {
        Coche coche1 = new Coche("Toyota", "Corolla", 2023, 25000);
        Coche coche2 = new Coche("Toyota", "Yaris", 2023, 25000);
        assertNotEquals(coche1, coche2);
    }

    @Test
    void testEqualsDistintoAnio() {
        Coche coche1 = new Coche("Toyota", "Corolla", 2023, 25000);
        Coche coche2 = new Coche("Toyota", "Corolla", 2024, 25000);
        assertNotEquals(coche1, coche2);
    }

    @Test
    void testEqualsDistintoPrecio() {
        Coche coche1 = new Coche("Toyota", "Corolla", 2023, 25000);
        Coche coche2 = new Coche("Toyota", "Corolla", 2023, 30000);
        assertNotEquals(coche1, coche2);
    }

    @Test
    void testToString() {
        Coche coche = new Coche("Toyota", "Corolla", 2023, 25000);
        String expected = "Coche [marca=Toyota, modelo=Corolla, año=2023, precio=25000]";
        assertEquals(expected, coche.toString());
    }
}
