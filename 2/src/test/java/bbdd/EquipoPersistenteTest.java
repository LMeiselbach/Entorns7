package bbdd;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import bbdd.EquipoPersistente;

public class EquipoPersistenteTest {

    @Test
    public void testEquipoValido() {
        EquipoPersistente e = new EquipoPersistente(1, "Barça", "Barcelona");
        assertEquals("Barça", e.getNombre());
        assertEquals("Barcelona", e.getCiudad());
    }

    @Test
    public void testNombreVacio() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new EquipoPersistente(2, "", "Madrid");
        });
        assertEquals("El nombre no puede estar vacío.", ex.getMessage());
    }

    @Test
    public void testCiudadVacia() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new EquipoPersistente(3, "Madrid", "");
        });
        assertEquals("La ciudad no puede estar vacía.", ex.getMessage());
    }
}
