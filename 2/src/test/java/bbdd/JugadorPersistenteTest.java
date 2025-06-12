package bbdd;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import bbdd.JugadorPersistente;

public class JugadorPersistenteTest {

    @Test
    public void testJugadorValido() {
        JugadorPersistente j = new JugadorPersistente(1, "Messi", 35, 10);
        assertEquals("Messi", j.getNombre());
        assertEquals(35, j.getEdad());
        assertEquals(10, j.getEquipoId());
    }

    @Test
    public void testNombreVacioLanzaExcepcion() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new JugadorPersistente(2, "", 25, 1);
        });
        assertEquals("El nombre no puede estar vacío.", ex.getMessage());
    }

    @Test
    public void testEdadNegativaLanzaExcepcion() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new JugadorPersistente(3, "Juan", -5, 1);
        });
        assertEquals("La edad debe ser mayor que cero.", ex.getMessage());
    }

    @Test
    public void testEquipoIdCeroLanzaExcepcion() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new JugadorPersistente(4, "Pedro", 20, 0);
        });
        assertEquals("El equipoId debe ser mayor que cero.", ex.getMessage());
    }
}
