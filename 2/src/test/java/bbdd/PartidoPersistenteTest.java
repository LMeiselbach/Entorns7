package bbdd;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import bbdd.PartidoPersistente;

public class PartidoPersistenteTest {

    @Test
    public void testPartidoValido() {
        PartidoPersistente p = new PartidoPersistente(1, 2, 3, "2025-06-12");
        assertEquals(2, p.getEquipoLocal());
        assertEquals(3, p.getEquipoVisitante());
        assertEquals("2025-06-12", p.getFecha());
    }

    @Test
    public void testEquipoLocalInvalido() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new PartidoPersistente(2, 0, 3, "2025-06-12");
        });
        assertEquals("El equipo local debe tener ID positivo.", ex.getMessage());
    }

    @Test
    public void testEquipoVisitanteInvalido() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new PartidoPersistente(3, 1, -5, "2025-06-12");
        });
        assertEquals("El equipo visitante debe tener ID positivo.", ex.getMessage());
    }

    @Test
    public void testFechaVacia() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new PartidoPersistente(4, 1, 2, "");
        });
        assertEquals("La fecha no puede estar vacía.", ex.getMessage());
    }
}
