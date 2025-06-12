package bbdd;

public class Partido {
    private int id;
    private int equipoLocal;
    private int equipoVisitante;
    private String fecha;

    public Partido() {}

    public Partido(int id, int equipoLocal, int equipoVisitante, String fecha) {
        this.id = id;
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.fecha = fecha;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getEquipoLocal() { return equipoLocal; }
    public void setEquipoLocal(int equipoLocal) { this.equipoLocal = equipoLocal; }
    public int getEquipoVisitante() { return equipoVisitante; }
    public void setEquipoVisitante(int equipoVisitante) { this.equipoVisitante = equipoVisitante; }
    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }

    @Override
    public String toString() {
        return id + ": " + equipoLocal + " vs " + equipoVisitante + " en " + fecha;
    }
}