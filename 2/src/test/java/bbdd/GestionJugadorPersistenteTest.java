package bbdd;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import bbdd.*;

public class GestionJugadorPersistenteTest {

    @Test
    public void testAddJugador() {
        GestionJugadorPersistente gestor = new GestionJugadorPersistente();
        JugadorPersistente j = new JugadorPersistente(1, "Leo", 34, 10);
        assertTrue(gestor.add(j));
        assertFalse(gestor.add(j)); // ya existe
    }

    @Test
    public void testReplaceJugador() {
        GestionJugadorPersistente gestor = new GestionJugadorPersistente();
        gestor.add(new JugadorPersistente(2, "Iniesta", 30, 5));
        assertTrue(gestor.replace(new JugadorPersistente(2, "Iniesta", 31, 5)));
        assertEquals(31, gestor.getById(2).getEdad());
    }

    @Test
    public void testRemoveJugador() {
        GestionJugadorPersistente gestor = new GestionJugadorPersistente();
        gestor.add(new JugadorPersistente(3, "Xavi", 33, 8));
        assertTrue(gestor.remove(3));
        assertFalse(gestor.remove(3));
    }
}
