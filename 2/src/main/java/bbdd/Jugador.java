package bbdd;

public class Jugador {
    private int id;
    private String nombre;
    private int edad;
    private int equipoId;

    public Jugador() {}

    public Jugador(int id, String nombre, int edad, int equipoId) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.equipoId = equipoId;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }
    public int getEquipoId() { return equipoId; }
    public void setEquipoId(int equipoId) { this.equipoId = equipoId; }

    @Override
    public String toString() {
        return id + ": " + nombre + " (" + edad + " años, equipo: " + equipoId + ")";
    }
}
