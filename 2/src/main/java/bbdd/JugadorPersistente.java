package bbdd;

public class JugadorPersistente {
    private int id;
    private String nombre;
    private int edad;
    private int equipoId;

    public JugadorPersistente() {}

    public JugadorPersistente(int id, String nombre, int edad, int equipoId) {
        this.id = id;
        setNombre(nombre);
        setEdad(edad);
        setEquipoId(equipoId);
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        this.nombre = nombre;
    }

    public int getEdad() { return edad; }
    public void setEdad(int edad) {
        if (edad <= 0) {
            throw new IllegalArgumentException("La edad debe ser mayor que cero.");
        }
        this.edad = edad;
    }

    public int getEquipoId() { return equipoId; }
    public void setEquipoId(int equipoId) {
        if (equipoId <= 0) {
            throw new IllegalArgumentException("El equipoId debe ser mayor que cero.");
        }
        this.equipoId = equipoId;
    }

    @Override
    public String toString() {
        return id + ": " + nombre + " (" + edad + " años, equipo: " + equipoId + ")";
    }
}
