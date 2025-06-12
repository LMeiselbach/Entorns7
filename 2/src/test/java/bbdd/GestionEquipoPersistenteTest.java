package bbdd;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import bbdd.*;

public class GestionEquipoPersistenteTest {

    @Test
    public void testAddEquipo() {
        GestionEquipoPersistente gestor = new GestionEquipoPersistente();
        assertTrue(gestor.add(new EquipoPersistente(1, "Barça", "Barcelona")));
        assertFalse(gestor.add(new EquipoPersistente(1, "Barça", "Barcelona")));
    }

    @Test
    public void testReplaceEquipo() {
        GestionEquipoPersistente gestor = new GestionEquipoPersistente();
        gestor.add(new EquipoPersistente(2, "Madrid", "Madrid"));
        assertTrue(gestor.replace(new EquipoPersistente(2, "Real Madrid", "Madrid")));
        assertEquals("Real Madrid", gestor.getById(2).getNombre());
    }

    @Test
    public void testRemoveEquipo() {
        GestionEquipoPersistente gestor = new GestionEquipoPersistente();
        gestor.add(new EquipoPersistente(3, "Sevilla", "Sevilla"));
        assertTrue(gestor.remove(3));
        assertFalse(gestor.remove(3));
    }
}
