package bbdd;

//--- Main.java ---

import java.util.*;

public class main {
 public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     int opcion;
     do {
         System.out.println("\n--- MENÚ PRINCIPAL ---");
         System.out.println("1. Gestionar Equipos");
         System.out.println("2. Gestionar Jugadores");
         System.out.println("3. Gestionar Partidos");
         System.out.println("0. Salir");
         System.out.print("Opción: ");
         opcion = sc.nextInt();
         sc.nextLine();

         switch (opcion) {
             case 1: menuEquipos(sc); break;
             case 2: menuJugadores(sc); break;
             case 3: menuPartidos(sc); break;
         }
     } while (opcion != 0);
     sc.close();
 }

 public static void menuEquipos(Scanner sc) {
     int opcion;
     do {
         System.out.println("\n--- GESTIÓN DE EQUIPOS ---");
         System.out.println("1. Ver Equipos");
         System.out.println("2. Insertar Equipo");
         System.out.println("3. Modificar Equipo");
         System.out.println("4. Eliminar Equipo");
         System.out.println("0. Volver");
         System.out.print("Opción: ");
         opcion = sc.nextInt();
         sc.nextLine();

         switch (opcion) {
             case 1 -> BBDD.listarEquipos().forEach(System.out::println);
             case 2 -> {
                 System.out.print("Nombre: ");
                 String nombre = sc.nextLine();
                 System.out.print("Ciudad: ");
                 String ciudad = sc.nextLine();
                 BBDD.insertarEquipo(new Equipo(0, nombre, ciudad));
             }
             case 3 -> {
                 System.out.print("ID del equipo a modificar: ");
                 int id = sc.nextInt(); sc.nextLine();
                 System.out.print("Nuevo nombre: ");
                 String nombre = sc.nextLine();
                 System.out.print("Nueva ciudad: ");
                 String ciudad = sc.nextLine();
                 BBDD.actualizarEquipo(new Equipo(id, nombre, ciudad));
             }
             case 4 -> {
                 System.out.print("ID del equipo a eliminar: ");
                 int id = sc.nextInt();
                 BBDD.eliminarEquipo(id);
             }
         }
     } while (opcion != 0);
 }

 public static void menuJugadores(Scanner sc) {
     int opcion;
     do {
         System.out.println("\n--- GESTIÓN DE JUGADORES ---");
         System.out.println("1. Ver Jugadores");
         System.out.println("2. Insertar Jugador");
         System.out.println("3. Modificar Jugador");
         System.out.println("4. Eliminar Jugador");
         System.out.println("0. Volver");
         System.out.print("Opción: ");
         opcion = sc.nextInt();
         sc.nextLine();

         switch (opcion) {
             case 1 -> BBDD.listarJugadores().forEach(System.out::println);
             case 2 -> {
                 System.out.print("Nombre: ");
                 String nombre = sc.nextLine();
                 System.out.print("Edad: ");
                 int edad = sc.nextInt();
                 System.out.print("ID del equipo: ");
                 int equipoId = sc.nextInt();
                 BBDD.insertarJugador(new Jugador(0, nombre, edad, equipoId));
             }
             case 3 -> {
                 System.out.print("ID del jugador a modificar: ");
                 int id = sc.nextInt(); sc.nextLine();
                 System.out.print("Nuevo nombre: ");
                 String nombre = sc.nextLine();
                 System.out.print("Nueva edad: ");
                 int edad = sc.nextInt();
                 System.out.print("Nuevo ID equipo: ");
                 int equipoId = sc.nextInt();
                 BBDD.actualizarJugador(new Jugador(id, nombre, edad, equipoId));
             }
             case 4 -> {
                 System.out.print("ID del jugador a eliminar: ");
                 int id = sc.nextInt();
                 BBDD.eliminarJugador(id);
             }
         }
     } while (opcion != 0);
 }

 public static void menuPartidos(Scanner sc) {
     int opcion;
     do {
         System.out.println("\n--- GESTIÓN DE PARTIDOS ---");
         System.out.println("1. Ver Partidos");
         System.out.println("2. Insertar Partido");
         System.out.println("3. Modificar Partido");
         System.out.println("4. Eliminar Partido");
         System.out.println("0. Volver");
         System.out.print("Opción: ");
         opcion = sc.nextInt();
         sc.nextLine();

         switch (opcion) {
             case 1 -> BBDD.listarPartidos().forEach(System.out::println);
             case 2 -> {
                 System.out.print("ID equipo local: ");
                 int local = sc.nextInt();
                 System.out.print("ID equipo visitante: ");
                 int visitante = sc.nextInt();
                 sc.nextLine();
                 System.out.print("Fecha (YYYY-MM-DD): ");
                 String fecha = sc.nextLine();
                 BBDD.insertarPartido(new Partido(0, local, visitante, fecha));
             }
             case 3 -> {
                 System.out.print("ID del partido a modificar: ");
                 int id = sc.nextInt();
                 System.out.print("Nuevo ID local: ");
                 int local = sc.nextInt();
                 System.out.print("Nuevo ID visitante: ");
                 int visitante = sc.nextInt();
                 sc.nextLine();
                 System.out.print("Nueva fecha (YYYY-MM-DD): ");
                 String fecha = sc.nextLine();
                 BBDD.actualizarPartido(new Partido(id, local, visitante, fecha));
             }
             case 4 -> {
                 System.out.print("ID del partido a eliminar: ");
                 int id = sc.nextInt();
                 BBDD.eliminarPartido(id);
             }
         }
     } while (opcion != 0);
 }
}