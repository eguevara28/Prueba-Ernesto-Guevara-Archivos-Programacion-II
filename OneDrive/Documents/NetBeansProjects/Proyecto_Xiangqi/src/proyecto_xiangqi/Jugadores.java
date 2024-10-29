/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_xiangqi;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;

/**
 *
 * @author ernes
 */
public class Jugadores {

    static Jugadores[] jugadores = new Jugadores[100];
    public static String jugadorloggeado = null;
    public static String jugadorcontrario = null;
    String[] log;
    String username, password;
    int puntos;
    Calendar fechainicio;

    public Jugadores() {
    }

    public Jugadores(String username, String password) {
        this.username = username;
        this.password = password;
        puntos = 0;
        log = new String[10];
        fechainicio = Calendar.getInstance();
    }

    public String getUsername() {
        return username;
    }

    public int getPuntosLogged() {
        Jugadores j = buscarJugador(jugadorloggeado);
        int puntosjugador = j.puntos;
        return puntosjugador;
    }

    public String getFechaInicio() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(fechainicio.getTime());
    }

    public void loggear(String nombre) {
        jugadorloggeado = nombre;
    }

    public void desloggear() {
        jugadorloggeado = null;
    }

    public void oponente(String oponente) {
        jugadorcontrario = oponente;
    }

    public int contarUsuarios() {
        int contador = 0;
        for (Jugadores j : jugadores) {
            if (j != null) {
                contador++;
            }
        }
        return contador;
    }

    public Jugadores buscarJugador(String usuario) {
        for (Jugadores j : jugadores) {
            if (j != null && j.username.equals(usuario)) {
                return j;
            }
        }
        return null;
    }

    public boolean CrearJugador(String nombre, String password, int index) {
        if (index >= jugadores.length) {
            return false;
        }

        if (buscarJugador(nombre) == null) {
            if (jugadores[index] == null) {
                jugadores[index] = new Jugadores(nombre, password);
                return true;
            }
            return CrearJugador(nombre, password, index + 1);
        }
        return false;
    }

    public static String[] nombres() {
        String[] nombre = new String[100];
        int contador = 0;
        for (Jugadores j : jugadores) {
            if (j != null && !j.username.equals(jugadorloggeado)) {
                nombre[contador++] = j.username;
            }
        }
        return nombre;
    }

    public boolean Login(String nombre, String password, int index) {
        if (index >= jugadores.length) {
            return false;
        }
        if (jugadores[index] != null && jugadores[index].username.equals(nombre) && jugadores[index].password.equals(password)) {
            return true;
        }
        return Login(nombre, password, index + 1);
    }

    public boolean CambiarContraseaña(String nombre, String password, String nuevopassword) {
        Jugadores j = buscarJugador(nombre);
        if (j != null && password.equals(j.password)) {
            j.password = nuevopassword;
            return true;
        }
        return false;
    }

    public boolean eliminarCuenta(String nombre, String password) {
        for (int i = 0; i < jugadores.length; i++) {
            Jugadores j = jugadores[i];
            if (j != null && j.getUsername().equals(nombre) && j.password.equals(password)) {
                jugadores[i] = null;
                desloggear();
                return true;
            }
        }
        JOptionPane.showMessageDialog(null, "Error: Usuario no encontrado o contraseña incorrecta.");
        return false;
    }

    private void añadirpuntos() {
        this.puntos += 3;
    }

    public void agregarLogsAlRendir(String ganador, String perdedor) {
        Jugadores gano = buscarJugador(ganador);
        Jugadores perdio = buscarJugador(perdedor);

        for (int i = 0; i < 10; i++) {
            if (gano.log[i] == null) {
                gano.log[i] = gano.username + " vs " + perdio.username + " : El jugador " + perdio.username + " se rindio y ganaste la partida";
                break;
            }
        }

        for (int i = 0; i < 10; i++) {
            if (perdio.log[i] == null) {
                perdio.log[i] = gano.username + " vs " + perdio.username + " : Te rendiste y el jugador " + gano.username + " gano";
                break;
            }
        }
    }

    public String[] obtenerlogs(String username) {
        Jugadores j = buscarJugador(username);
        return j.log;
    }

    public void agregarLogsAlComerRey(String ganador, String perdedor) {
        Jugadores gano = buscarJugador(ganador);
        Jugadores perdio = buscarJugador(perdedor);

        for (int i = 0; i < 10; i++) {
            if (gano.log[i] == null) {
                gano.log[i] = gano.username + " vs " + perdio.username + " : Le comiste el rey al jugador " + perdio.username + " y ganaste";
                break;
            }
        }

        for (int i = 0; i < 10; i++) {
            if (perdio.log[i] == null) {
                perdio.log[i] = gano.username + " vs " + perdio.username + " : El jugador " + gano.username + " te comio el rey y perdiste";
                break;
            }
        }
    }

    public void añadirpuntosganador(String nombreganador) {
        Jugadores j = buscarJugador(nombreganador);
        if (j != null) {
            j.añadirpuntos();
            JOptionPane.showMessageDialog(null, "Felicidades: " + j.getUsername() + " has ganado 3 puntos");
        }
    }

    public String[] getNombresUsuarios() {
        String[] nombres = new String[100];
        int contador = 0;
        for (Jugadores j : jugadores) {
            if (j != null && !j.getUsername().equals(jugadorloggeado)) {
                nombres[contador++] = j.getUsername();
            }
        }
        return nombres;
    }

    public String[] obtenerRanking() {
        int totalUsuarios = contarUsuarios();
        Jugadores[] jugadoresOrdenados = new Jugadores[totalUsuarios];
        int index = 0;
        for (Jugadores j : jugadores) {
            if (j != null) {
                jugadoresOrdenados[index++] = j;
            }
        }

        for (int i = 0; i < jugadoresOrdenados.length - 1; i++) {
            for (int j = i + 1; j < jugadoresOrdenados.length; j++) {
                if (jugadoresOrdenados[j].puntos > jugadoresOrdenados[i].puntos) {
                    Jugadores temp = jugadoresOrdenados[i];
                    jugadoresOrdenados[i] = jugadoresOrdenados[j];
                    jugadoresOrdenados[j] = temp;
                }
            }
        }

        String[] ranking = new String[totalUsuarios];
        for (int i = 0; i < jugadoresOrdenados.length; i++) {
            ranking[i] = (i + 1) + ". " + jugadoresOrdenados[i].username + " - " + jugadoresOrdenados[i].puntos + " puntos";
        }

        return ranking;
    }

}
