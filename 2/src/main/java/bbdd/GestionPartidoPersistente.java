package bbdd;

import java.util.ArrayList;
import java.util.List;

public class GestionPartidoPersistente {
    private List<PartidoPersistente> partidos = new ArrayList<>();

    public boolean add(PartidoPersistente p) {
        if (getById(p.getId()) != null) return false;
        partidos.add(p);
        return true;
    }

    public PartidoPersistente getById(int id) {
        for (PartidoPersistente p : partidos) {
            if (p.getId() == id) return p;
        }
        return null;
    }

    public boolean replace(PartidoPersistente nuevo) {
        for (int i = 0; i < partidos.size(); i++) {
            if (partidos.get(i).getId() == nuevo.getId()) {
                partidos.set(i, nuevo);
                return true;
            }
        }
        return false;
    }

    public boolean remove(int id) {
        return partidos.removeIf(p -> p.getId() == id);
    }
}
