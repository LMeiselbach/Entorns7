package bbdd;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import bbdd.*;

public class GestoresTest {

    private GestionJugadores gestionJugadores;
    private GestionEquipos gestionEquipos;
    private GestionPartidos gestionPartidos;

    @BeforeEach
    public void setUp() {
        gestionJugadores = new GestionJugadores();
        gestionEquipos = new GestionEquipos();
        gestionPartidos = new GestionPartidos();
    }

    // === TESTS GESTION JUGADORES ===

    @Test
    public void testAddJugador() {
        Jugador j = new Jugador(1, "Carlos", 25, 3);
        assertTrue(gestionJugadores.add(j));
        assertFalse(gestionJugadores.add(j)); // mismo ID no se añade
    }

    @Test
    public void testReplaceJugador() {
        Jugador j1 = new Jugador(1, "Ana", 22, 1);
        Jugador j2 = new Jugador(1, "Ana Modificada", 23, 1);
        gestionJugadores.add(j1);
        assertTrue(gestionJugadores.replace(j2));
        assertEquals("Ana Modificada", gestionJugadores.getById(1).getNombre());
    }

    @Test
    public void testRemoveJugador() {
        Jugador j = new Jugador(2, "Luis", 30, 2);
        gestionJugadores.add(j);
        assertTrue(gestionJugadores.remove(2));
        assertFalse(gestionJugadores.remove(2));
    }

    // === TESTS GESTION EQUIPOS ===

    @Test
    public void testAddEquipo() {
        Equipo e = new Equipo(10, "Barcelona", "Barcelona");
        assertTrue(gestionEquipos.add(e));
        assertFalse(gestionEquipos.add(e));
    }

    @Test
    public void testReplaceEquipo() {
        Equipo e1 = new Equipo(5, "Madrid", "Madrid");
        Equipo e2 = new Equipo(5, "Real Madrid", "Madrid");
        gestionEquipos.add(e1);
        assertTrue(gestionEquipos.replace(e2));
        assertEquals("Real Madrid", gestionEquipos.getById(5).getNombre());
    }

    @Test
    public void testRemoveEquipo() {
        Equipo e = new Equipo(3, "Sevilla", "Sevilla");
        gestionEquipos.add(e);
        assertTrue(gestionEquipos.remove(e));
        assertFalse(gestionEquipos.remove(e));
    }

    // === TESTS GESTION PARTIDOS ===

    @Test
    public void testAddPartido() {
        Partido p = new Partido(1, 10, 20, "2025-06-10");
        assertTrue(gestionPartidos.add(p));
        assertFalse(gestionPartidos.add(p));
    }

    @Test
    public void testReplacePartido() {
        Partido p1 = new Partido(2, 11, 21, "2025-06-11");
        Partido p2 = new Partido(2, 11, 21, "2025-06-12");
        gestionPartidos.add(p1);
        assertTrue(gestionPartidos.replace(p2));
        assertEquals("2025-06-12", gestionPartidos.getById(2).getFecha());
    }

    @Test
    public void testRemovePartido() {
        Partido p = new Partido(3, 12, 22, "2025-06-15");
        gestionPartidos.add(p);
        assertTrue(gestionPartidos.remove(p));
        assertFalse(gestionPartidos.remove(3)); // ya se ha eliminado
    }
}
