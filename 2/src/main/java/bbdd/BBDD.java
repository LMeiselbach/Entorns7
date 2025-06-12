package bbdd;
	
import java.sql.*;
import java.util.*;

public class BBDD {
    private static final String URL = "jdbc:mysql://localhost:3306/Torneo";
    private static final String USER = "root";
    private static final String PASS = "root";

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }

    public static void mostrarError(SQLException e) {
        System.out.println("Error SQL: " + e.getMessage());
    }

    // --- CRUD EQUIPO ---
    public static boolean insertarEquipo(Equipo eq) {
        try (Connection conn = conectar()) {
            String sql = "INSERT INTO equipo (nombre, ciudad) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, eq.getNombre());
            stmt.setString(2, eq.getCiudad());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            mostrarError(e);
            return false;
        }
    }

    public static boolean actualizarEquipo(Equipo eq) {
        try (Connection conn = conectar()) {
            String sql = "UPDATE equipo SET nombre=?, ciudad=? WHERE id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, eq.getNombre());
            stmt.setString(2, eq.getCiudad());
            stmt.setInt(3, eq.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            mostrarError(e);
            return false;
        }
    }

    public static boolean eliminarEquipo(int id) {
        try (Connection conn = conectar()) {
            String sql = "DELETE FROM equipo WHERE id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            mostrarError(e);
            return false;
        }
    }

    public static List<Equipo> listarEquipos() {
        List<Equipo> lista = new ArrayList<>();
        try (Connection conn = conectar()) {
            String sql = "SELECT * FROM equipo";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                lista.add(new Equipo(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("ciudad")
                ));
            }
        } catch (SQLException e) {
            mostrarError(e);
        }
        return lista;
    }

    // --- CRUD JUGADOR ---
    public static boolean insertarJugador(Jugador j) {
        try (Connection conn = conectar()) {
            String sql = "INSERT INTO jugador (nombre, edad, equipo_id) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, j.getNombre());
            stmt.setInt(2, j.getEdad());
            stmt.setInt(3, j.getEquipoId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            mostrarError(e);
            return false;
        }
    }

    public static boolean actualizarJugador(Jugador j) {
        try (Connection conn = conectar()) {
            String sql = "UPDATE jugador SET nombre=?, edad=?, equipo_id=? WHERE id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, j.getNombre());
            stmt.setInt(2, j.getEdad());
            stmt.setInt(3, j.getEquipoId());
            stmt.setInt(4, j.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            mostrarError(e);
            return false;
        }
    }

    public static boolean eliminarJugador(int id) {
        try (Connection conn = conectar()) {
            String sql = "DELETE FROM jugador WHERE id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            mostrarError(e);
            return false;
        }
    }

    public static List<Jugador> listarJugadores() {
        List<Jugador> lista = new ArrayList<>();
        try (Connection conn = conectar()) {
            String sql = "SELECT * FROM jugador";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                lista.add(new Jugador(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getInt("edad"),
                    rs.getInt("equipo_id")
                ));
            }
        } catch (SQLException e) {
            mostrarError(e);
        }
        return lista;
    }

    // --- CRUD PARTIDO ---
    public static boolean insertarPartido(Partido p) {
        try (Connection conn = conectar()) {
            String sql = "INSERT INTO partido (equipo_local, equipo_visitante, fecha) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, p.getEquipoLocal());
            stmt.setInt(2, p.getEquipoVisitante());
            stmt.setString(3, p.getFecha());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            mostrarError(e);
            return false;
        }
    }

    public static boolean actualizarPartido(Partido p) {
        try (Connection conn = conectar()) {
            String sql = "UPDATE partido SET equipo_local=?, equipo_visitante=?, fecha=? WHERE id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, p.getEquipoLocal());
            stmt.setInt(2, p.getEquipoVisitante());
            stmt.setString(3, p.getFecha());
            stmt.setInt(4, p.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            mostrarError(e);
            return false;
        }
    }

    public static boolean eliminarPartido(int id) {
        try (Connection conn = conectar()) {
            String sql = "DELETE FROM partido WHERE id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            mostrarError(e);
            return false;
        }
    }

    public static List<Partido> listarPartidos() {
        List<Partido> lista = new ArrayList<>();
        try (Connection conn = conectar()) {
            String sql = "SELECT * FROM partido";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                lista.add(new Partido(
                    rs.getInt("id"),
                    rs.getInt("equipo_local"),
                    rs.getInt("equipo_visitante"),
                    rs.getString("fecha")
                ));
            }
        } catch (SQLException e) {
            mostrarError(e);
        }
        return lista;
    }
}

