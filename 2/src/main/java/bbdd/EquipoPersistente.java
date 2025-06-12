package bbdd;

public class EquipoPersistente {
    private int id;
    private String nombre;
    private String ciudad;

    public EquipoPersistente() {}

    public EquipoPersistente(int id, String nombre, String ciudad) {
        this.id = id;
        setNombre(nombre);
        setCiudad(ciudad);
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

    public String getCiudad() { return ciudad; }
    public void setCiudad(String ciudad) {
        if (ciudad == null || ciudad.trim().isEmpty()) {
            throw new IllegalArgumentException("La ciudad no puede estar vacía.");
        }
        this.ciudad = ciudad;
    }

    @Override
    public String toString() {
        return id + ": " + nombre + " (" + ciudad + ")";
    }
}
