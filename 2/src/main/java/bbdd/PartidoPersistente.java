package bbdd;

public class PartidoPersistente {
    private int id;
    private int equipoLocal;
    private int equipoVisitante;
    private String fecha;

    public PartidoPersistente() {}

    public PartidoPersistente(int id, int equipoLocal, int equipoVisitante, String fecha) {
        this.id = id;
        setEquipoLocal(equipoLocal);
        setEquipoVisitante(equipoVisitante);
        setFecha(fecha);
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getEquipoLocal() { return equipoLocal; }
    public void setEquipoLocal(int equipoLocal) {
        if (equipoLocal <= 0) {
            throw new IllegalArgumentException("El equipo local debe tener ID positivo.");
        }
        this.equipoLocal = equipoLocal;
    }

    public int getEquipoVisitante() { return equipoVisitante; }
    public void setEquipoVisitante(int equipoVisitante) {
        if (equipoVisitante <= 0) {
            throw new IllegalArgumentException("El equipo visitante debe tener ID positivo.");
        }
        this.equipoVisitante = equipoVisitante;
    }

    public String getFecha() { return fecha; }
    public void setFecha(String fecha) {
        if (fecha == null || fecha.trim().isEmpty()) {
            throw new IllegalArgumentException("La fecha no puede estar vacía.");
        }
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return id + ": " + equipoLocal + " vs " + equipoVisitante + " en " + fecha;
    }
}
