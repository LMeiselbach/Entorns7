package bbdd;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import bbdd.*;

public class EntidadTest {

    // ===== TESTS PARA JUGADOR =====

    @Test
    public void testJugadorValoresValidos() {
        Jugador j = new Jugador(1, "Carlos", 25, 3);
        assertEquals(1, j.getId());
        assertEquals("Carlos", j.getNombre());
        assertEquals(25, j.getEdad());
        assertEquals(3, j.getEquipoId());
    }

    @Test
    public void testJugadorEdadNegativa() {
        Jugador j = new Jugador(2, "Ana", -5, 1);
        assertEquals(-5, j.getEdad(), "La clase permite edad negativa, lo cual podría ser un error");
    }

    @Test
    public void testJugadorNombreVacio() {
        Jugador j = new Jugador(3, "", 20, 2);
        assertEquals("", j.getNombre(), "La clase permite nombre vacío");
    }

    @Test
    public void testJugadorEquipoIdCero() {
        Jugador j = new Jugador(4, "Luis", 22, 0);
        assertEquals(0, j.getEquipoId(), "La clase permite equipoId = 0");
    }

    // ===== TESTS PARA EQUIPO =====

    @Test
    public void testEquipoValoresValidos() {
        Equipo e = new Equipo(1, "FC Barcelona", "Barcelona");
        assertEquals(1, e.getId());
        assertEquals("FC Barcelona", e.getNombre());
        assertEquals("Barcelona", e.getCiudad());
    }

    @Test
    public void testEquipoNombreVacio() {
        Equipo e = new Equipo(2, "", "Madrid");
        assertEquals("", e.getNombre(), "La clase permite nombre vacío");
    }

    @Test
    public void testEquipoCiudadVacia() {
        Equipo e = new Equipo(3, "Real Madrid", "");
        assertEquals("", e.getCiudad(), "La clase permite ciudad vacía");
    }

    // ===== TESTS PARA PARTIDO =====

    @Test
    public void testPartidoValoresValidos() {
        Partido p = new Partido(1, 1, 2, "2025-06-01");
        assertEquals(1, p.getId());
        assertEquals(1, p.getEquipoLocal());
        assertEquals(2, p.getEquipoVisitante());
        assertEquals("2025-06-01", p.getFecha());
    }

    @Test
    public void testPartidoFechaVacia() {
        Partido p = new Partido(2, 3, 4, "");
        assertEquals("", p.getFecha(), "La clase permite fecha vacía");
    }

    @Test
    public void testPartidoEquiposIguales() {
        Partido p = new Partido(3, 5, 5, "2025-06-12");
        assertEquals(5, p.getEquipoLocal());
        assertEquals(5, p.getEquipoVisitante(), "La clase permite partido con el mismo equipo como local y visitante");
    }
}
