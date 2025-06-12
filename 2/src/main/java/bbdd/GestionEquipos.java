package bbdd;

import java.util.ArrayList;
import java.util.List;

public class GestionEquipos {
    private List<Equipo> equipos;

    public GestionEquipos() {
        equipos = new ArrayList<>();
    }

    public Equipo get(int posicion) {
        if (posicion >= 0 && posicion < equipos.size()) {
            return equipos.get(posicion);
        }
        return null;
    }

    public Equipo getById(int id) {
        for (Equipo e : equipos) {
            if (e.getId() == id) return e;
        }
        return null;
    }

    public boolean add(Equipo equipo) {
        if (getById(equipo.getId()) != null) return false;
        equipos.add(equipo);
        return true;
    }

    public boolean replace(Equipo equipo) {
        for (int i = 0; i < equipos.size(); i++) {
            if (equipos.get(i).getId() == equipo.getId()) {
                equipos.set(i, equipo);
                return true;
            }
        }
        return false;
    }

    public boolean remove(Equipo equipo) {
        return equipos.remove(equipo);
    }

    public boolean remove(int id) {
        return equipos.removeIf(e -> e.getId() == id);
    }

    public List<Equipo> getTodos() {
        return equipos;
    }
}
