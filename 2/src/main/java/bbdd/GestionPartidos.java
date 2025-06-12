package bbdd;

import java.util.ArrayList;
import java.util.List;

public class GestionPartidos {
    private List<Partido> partidos;

    public GestionPartidos() {
        partidos = new ArrayList<>();
    }

    public Partido get(int posicion) {
        if (posicion >= 0 && posicion < partidos.size()) {
            return partidos.get(posicion);
        }
        return null;
    }

    public Partido getById(int id) {
        for (Partido p : partidos) {
            if (p.getId() == id) return p;
        }
        return null;
    }

    public boolean add(Partido partido) {
        if (getById(partido.getId()) != null) return false;
        partidos.add(partido);
        return true;
    }

    public boolean replace(Partido partido) {
        for (int i = 0; i < partidos.size(); i++) {
            if (partidos.get(i).getId() == partido.getId()) {
                partidos.set(i, partido);
                return true;
            }
        }
        return false;
    }

    public boolean remove(Partido partido) {
        return partidos.remove(partido);
    }

    public boolean remove(int id) {
        return partidos.removeIf(p -> p.getId() == id);
    }

    public List<Partido> getTodos() {
        return partidos;
    }
}
