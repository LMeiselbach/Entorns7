package bbdd;

import java.util.ArrayList;
import java.util.List;

public class GestionEquipoPersistente {
    private List<EquipoPersistente> equipos = new ArrayList<>();

    public boolean add(EquipoPersistente e) {
        if (getById(e.getId()) != null) return false;
        equipos.add(e);
        return true;
    }

    public EquipoPersistente getById(int id) {
        return equipos.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
    }

    public boolean replace(EquipoPersistente nuevo) {
        for (int i = 0; i < equipos.size(); i++) {
            if (equipos.get(i).getId() == nuevo.getId()) {
                equipos.set(i, nuevo);
                return true;
            }
        }
        return false;
    }

    public boolean remove(int id) {
        return equipos.removeIf(e -> e.getId() == id);
    }
}
