package org.hmis;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CocheTest {

    @Test
    void testConstructorPorDefecto() {
        Coche coche = new Coche();
        assertNull(coche.getMarca());
        assertNull(coche.getModelo());
        assertEquals(0, coche.getAnio());
        assertEquals(0, coche.getPrecio());
    }

    @Test
    void testConstructorConParametros() {
        Coche coche = new Coche("Toyota", "Corolla", 2023, 25000);
        assertEquals("Toyota", coche.getMarca());
        assertEquals("Corolla", coche.getModelo());
        assertEquals(2023, coche.getAnio());
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
        coche.setAnio(2024);
        assertEquals(2024, coche.getAnio());
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
        assertFalse(coche.equals(null));
    }

    @Test
    void testEqualsDistintaClase() {
        Coche coche = new Coche("Toyota", "Corolla", 2023, 25000);
        assertFalse(coche.equals("un string"));
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
    void testEqualsAnioDiferenteShortCircuit() {
        Coche coche1 = new Coche("Toyota", "Corolla", 2023, 25000);
        Coche coche2 = new Coche("Toyota", "Corolla", 2020, 25000);
        assertNotEquals(coche1, coche2);
    }

    @Test
    void testEqualsMarcaNullAmbos() {
        Coche coche1 = new Coche(null, "Corolla", 2023, 25000);
        Coche coche2 = new Coche(null, "Corolla", 2023, 25000);
        assertEquals(coche1, coche2);
    }

    @Test
    void testEqualsModeloNullAmbos() {
        Coche coche1 = new Coche("Toyota", null, 2023, 25000);
        Coche coche2 = new Coche("Toyota", null, 2023, 25000);
        assertEquals(coche1, coche2);
    }

    @Test
    void testEqualsMarcaNullUno() {
        Coche coche1 = new Coche(null, "Corolla", 2023, 25000);
        Coche coche2 = new Coche("Toyota", "Corolla", 2023, 25000);
        assertNotEquals(coche1, coche2);
    }

    @Test
    void testEqualsModeloNullUno() {
        Coche coche1 = new Coche("Toyota", null, 2023, 25000);
        Coche coche2 = new Coche("Toyota", "Corolla", 2023, 25000);
        assertNotEquals(coche1, coche2);
    }

    @Test
    void testToString() {
        Coche coche = new Coche("Toyota", "Corolla", 2023, 25000);
        String expected = "Coche [marca=Toyota, modelo=Corolla, anio=2023, precio=25000]";
        assertEquals(expected, coche.toString());
    }
}
