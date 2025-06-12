package bbdd;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import bbdd.*;

public class GestionPartidoPersistenteTest {

    @Test
    public void testAddPartido() {
        GestionPartidoPersistente gestor = new GestionPartidoPersistente();
        assertTrue(gestor.add(new PartidoPersistente(1, 1, 2, "2025-06-12")));
        assertFalse(gestor.add(new PartidoPersistente(1, 1, 2, "2025-06-12")));
    }

    @Test
    public void testReplacePartido() {
        GestionPartidoPersistente gestor = new GestionPartidoPersistente();
        gestor.add(new PartidoPersistente(2, 3, 4, "2025-06-10"));
        assertTrue(gestor.replace(new PartidoPersistente(2, 3, 4, "2025-06-20")));
        assertEquals("2025-06-20", gestor.getById(2).getFecha());
    }

    @Test
    public void testRemovePartido() {
        GestionPartidoPersistente gestor = new GestionPartidoPersistente();
        gestor.add(new PartidoPersistente(3, 5, 6, "2025-06-15"));
        assertTrue(gestor.remove(3));
        assertFalse(gestor.remove(3));
    }
}
