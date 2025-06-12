package bbdd;

import java.util.ArrayList;
import java.util.List;

public class GestionJugadorPersistente {
    private List<JugadorPersistente> jugadores;

    public GestionJugadorPersistente() {
        jugadores = new ArrayList<>();
    }

    public boolean add(JugadorPersistente j) {
        if (getById(j.getId()) != null) return false;
        jugadores.add(j);
        return true;
    }

    public JugadorPersistente getById(int id) {
        for (JugadorPersistente j : jugadores) {
            if (j.getId() == id) return j;
        }
        return null;
    }

    public boolean replace(JugadorPersistente nuevo) {
        for (int i = 0; i < jugadores.size(); i++) {
            if (jugadores.get(i).getId() == nuevo.getId()) {
                jugadores.set(i, nuevo);
                return true;
            }
        }
        return false;
    }

    public boolean remove(int id) {
        return jugadores.removeIf(j -> j.getId() == id);
    }

    public List<JugadorPersistente> getAll() {
        return jugadores;
    }
}
