package Act1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TelefonoMovilTest {
    @Test
    void testAddNewContact() {
        TelefonoMovil telefono = new TelefonoMovil("666554433");
        Contacto c1 = new Contacto("Pepe", "111111111");
        Contacto c2 = new Contacto("Fran", "222222222");
        Contacto c3 = new Contacto("Pepe", "333333333");

        //Se añaden correctamente los contactos c1 y c2
        assertTrue(telefono.addNewContact(c1));
        assertTrue(telefono.addNewContact(c2));
        //Da false porque ya hay un Pepe en los contactos
        assertFalse(telefono.addNewContact(c3));
    }

    @Test
    void testUpdateContact() {
        TelefonoMovil telefono = new TelefonoMovil("666554433");
        Contacto c1 = new Contacto("Pepe1", "111111111");
        Contacto c2 = new Contacto("Pepe2", "222222222");
        Contacto c3 = new Contacto("Pepe3", "333333333");

        //Contacto con mismo nombre
        Contacto c4 = new Contacto("Pepe1", "123456789");
        //Contacto que no se añade, para forzar un assertFalse al intentar actualizar el contacto
        Contacto c5 = new Contacto("Juan", "444444444");
        Contacto c6 = new Contacto("Santiago", "111111111");
        //Contacto con mismo número que Pepe1 pero distinto nombre
        Contacto c7 = new Contacto("Alberto", "111111111");
        //Contacto completamente distinto a cualquier contacto que existe en teléfono
        Contacto c8 = new Contacto("Ximo", "666666666");

        //Se añaden a teléfono todos los contactos menos los contactos "Alberto" y "Ximo"
        assertTrue(telefono.addNewContact(c1));
        assertTrue(telefono.addNewContact(c2));
        assertTrue(telefono.addNewContact(c3));
        //No se añade el contacto 4, porque tiene el mismo número que Pepe1
        assertFalse(telefono.addNewContact(c4));
        assertTrue(telefono.addNewContact(c5));
        assertTrue(telefono.addNewContact(c6));

        //Intentar actualizar contacto Pepe1 con otro con el mismo nombre
        assertFalse(telefono.updateContact(c1, c4));

        //Se intenta actualizar el contacto Pepe1 a uno que ya existe (no pueden haber 2 contactos con el mismo nombre dentro de teléfono)
        assertFalse(telefono.updateContact(c1, c6));

        //Actualizar contacto Pepe1 a otro contacto con mismo número pero distinto nombre
        assertTrue(telefono.updateContact(c1, c7));

        //Actualizar contacto Pepe2 por otro completamente distinto (que no existe en teléfono)
        assertTrue(telefono.updateContact(c2, c8));

        //Contacto no existente, no se puede actualizar
        assertFalse(telefono.updateContact(c4, c1));

        //Intento cambiar a Pepe3 por uno que ya existe dentro de teléfono como por ejemplo "Santiago"
        assertFalse(telefono.updateContact(c3, c6));
    }

    @Test
    void testQueryContact() {
        TelefonoMovil telefono = new TelefonoMovil("666554433");
        Contacto c1 = new Contacto("Pepe1", "111111111");
        Contacto c2 = new Contacto("Pepe2", "222222222");
        Contacto c3 = new Contacto("Pepe3", "333333333");

        assertTrue(telefono.addNewContact(c1));
        assertTrue(telefono.addNewContact(c2));
        assertTrue(telefono.addNewContact(c3));

        assertEquals(c1, telefono.queryContact("Pepe1"));
        assertEquals(c2, telefono.queryContact("Pepe2"));
        assertEquals(c3, telefono.queryContact("Pepe3"));
        //No encuentra a "Pepe", por lo que devuelve un contacto null
        assertEquals(null, telefono.queryContact("Pepe"));
    }
}