/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_xiangqi;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author ernes
 */
public class Tablero extends JFrame {

    Peon p = new Peon();
    Rey rey = new Rey();
    Oficial oficial = new Oficial();
    Elefante elefante = new Elefante();
    Cañon cañon = new Cañon();
    Torre torre = new Torre();
    Caballo caballo = new Caballo();

    Jugadores j = new Jugadores();

    boolean turno = true;

    String turnostring = Jugadores.jugadorloggeado;

    JLabel jugadores = new JLabel();

    JTextArea consola = new JTextArea();

    JButton[][] tablerobotones = new JButton[10][9];
    String[][] tablerostring = new String[10][9];

    private String piezaseleccionada = null;

    private int posicionx = 0;
    private int posiciony = 0;

    private ImageIcon peonNegroIcon, peonRojoIcon, torreNegraIcon, torreRojaIcon, canonrojoIcon, canonnegroIcon, oficialNegroIcon, oficialRojoIcon, reyNegroIcon, reyRojoIcon, caballoNegroIcon, caballoRojoIcon, elefanteNegroIcon, elefanteRojoIcon;

    public Tablero() {
        cargarImagenes();
        initComponents();
        iniciartablerostring();
        iniciartablerobotones();
        accionbotones();
    }

    private void cambiarturno() {
        if (turno) {
            turno = false;
        } else if (!turno) {
            turno = true;
        }
    }

    private void cargarImagenes() {
        peonNegroIcon = new ImageIcon(getClass().getResource("/fotos/peonnegro.png"));
        canonrojoIcon = new ImageIcon(getClass().getResource("/fotos/cañonrojo.png"));
        canonnegroIcon = new ImageIcon(getClass().getResource("/fotos/cañonnegro.png"));
        peonRojoIcon = new ImageIcon(getClass().getResource("/fotos/peonrojo.png"));
        torreNegraIcon = new ImageIcon(getClass().getResource("/fotos/torrenegra.png"));
        torreRojaIcon = new ImageIcon(getClass().getResource("/fotos/torrerojo.png"));
        caballoNegroIcon = new ImageIcon(getClass().getResource("/fotos/caballonegro.png"));
        caballoRojoIcon = new ImageIcon(getClass().getResource("/fotos/caballorojo.png"));
        elefanteNegroIcon = new ImageIcon(getClass().getResource("/fotos/elefantenegro.png"));
        elefanteRojoIcon = new ImageIcon(getClass().getResource("/fotos/elefanterojo.png"));
        oficialNegroIcon = new ImageIcon(getClass().getResource("/fotos/oficialnegro.png"));
        oficialRojoIcon = new ImageIcon(getClass().getResource("/fotos/oficialrojo.png"));
        reyNegroIcon = new ImageIcon(getClass().getResource("/fotos/generalnegro.png"));
        reyRojoIcon = new ImageIcon(getClass().getResource("/fotos/generalrojo.png"));
    }

    private void iniciartablerostring() {

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 9; j++) {
                tablerostring[i][j] = "";
            }
        }
        tablerostring[0][0] = "Torre Rojo";
        tablerostring[0][1] = "Caballo Rojo";
        tablerostring[0][2] = "Elefante Rojo";
        tablerostring[0][3] = "Oficial Rojo";
        tablerostring[0][4] = "Rey Rojo";
        tablerostring[0][5] = "Oficial Rojo";
        tablerostring[0][6] = "Elefante Rojo";
        tablerostring[0][7] = "Caballo Rojo";
        tablerostring[0][8] = "Torre Rojo";

        tablerostring[3][0] = "Peon Rojo";
        tablerostring[2][1] = "Cañon Rojo";
        tablerostring[3][2] = "Peon Rojo";
        tablerostring[3][4] = "Peon Rojo";
        tablerostring[3][6] = "Peon Rojo";
        tablerostring[2][7] = "Cañon Rojo";
        tablerostring[3][8] = "Peon Rojo";

        tablerostring[9][0] = "Torre Negro";
        tablerostring[9][1] = "Caballo Negro";
        tablerostring[9][2] = "Elefante Negro";
        tablerostring[9][3] = "Oficial Negro";
        tablerostring[9][4] = "Rey Negro";
        tablerostring[9][5] = "Oficial Negro";
        tablerostring[9][6] = "Elefante Negro";
        tablerostring[9][7] = "Caballo Negro";
        tablerostring[9][8] = "Torre Negro";

        tablerostring[6][0] = "Peon Negro";
        tablerostring[7][1] = "Cañon Negro";
        tablerostring[6][2] = "Peon Negro";
        tablerostring[6][4] = "Peon Negro";
        tablerostring[6][6] = "Peon Negro";
        tablerostring[7][7] = "Cañon Negro";
        tablerostring[6][8] = "Peon Negro";
    }

    public String verificarRey(String[][] tablero) {
        boolean reyRojoEncontrado = false;
        boolean reyNegroEncontrado = false;

        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if (tablero[i][j].equals("Rey Rojo")) {
                    reyRojoEncontrado = true;
                } else if (tablero[i][j].equals("Rey Negro")) {
                    reyNegroEncontrado = true;
                }
            }
        }

        if (!reyRojoEncontrado) {
            return "Negro gana";
        } else if (!reyNegroEncontrado) {
            return "Rojo gana";
        } else {
            return "Continuar";
        }
    }

    private void refrescarlabel() {
        jugadores.setText(Jugadores.jugadorloggeado + " vs " + Jugadores.jugadorcontrario + " | Turno de " + turnostring);
        this.add(jugadores, BorderLayout.NORTH);

        if (turno) {
            turnostring = Jugadores.jugadorloggeado;
            jugadores.setText(Jugadores.jugadorloggeado + " vs " + Jugadores.jugadorcontrario + " | Turno de " + turnostring);
        } else if (!turno) {
            turnostring = Jugadores.jugadorcontrario;
            jugadores.setText(Jugadores.jugadorloggeado + " vs " + Jugadores.jugadorcontrario + " | Turno de " + turnostring);
        }
    }

    private void anunciarganador() {
        String ganador = verificarRey(tablerostring);

        if (ganador.equals("Negro gana")) {
            JOptionPane.showMessageDialog(null, "Gano el Negro");
            j.añadirpuntosganador(Jugadores.jugadorloggeado);
            j.agregarLogsAlComerRey(Jugadores.jugadorloggeado, Jugadores.jugadorcontrario);
            MenuJuego mj = new MenuJuego();
            mj.setVisible(true);
            this.dispose();
        } else if (ganador.equals("Rojo gana")) {
            JOptionPane.showMessageDialog(null, "Gano el Rojo");
            j.añadirpuntosganador(Jugadores.jugadorcontrario);
            j.agregarLogsAlComerRey(Jugadores.jugadorcontrario, Jugadores.jugadorloggeado);
            MenuJuego mj = new MenuJuego();
            mj.setVisible(true);
            this.dispose();
        }
    }

    private void iniciartablerobotones() {
        JPanel panel = new JPanel(new GridLayout(10, 9));
        panel.setSize(800, 600);

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 9; j++) {
                tablerobotones[i][j] = new JButton();
                tablerobotones[i][j].setPreferredSize(new Dimension(60, 60));

                if (tablerostring[i][j] != null && !tablerostring[i][j].equals("")) {
                    switch (tablerostring[i][j]) {
                        case "Peon Negro":
                            tablerobotones[i][j].setIcon(peonNegroIcon);
                            break;
                        case "Torre Negro":
                            tablerobotones[i][j].setIcon(torreNegraIcon);
                            break;
                        case "Caballo Negro":
                            tablerobotones[i][j].setIcon(caballoNegroIcon);
                            break;
                        case "Elefante Negro":
                            tablerobotones[i][j].setIcon(elefanteNegroIcon);
                            break;
                        case "Oficial Negro":
                            tablerobotones[i][j].setIcon(oficialNegroIcon);
                            break;
                        case "Rey Negro":
                            tablerobotones[i][j].setIcon(reyNegroIcon);
                            break;
                        case "Peon Rojo":
                            tablerobotones[i][j].setIcon(peonRojoIcon);
                            break;
                        case "Torre Rojo":
                            tablerobotones[i][j].setIcon(torreRojaIcon);
                            break;
                        case "Caballo Rojo":
                            tablerobotones[i][j].setIcon(caballoRojoIcon);
                            break;
                        case "Elefante Rojo":
                            tablerobotones[i][j].setIcon(elefanteRojoIcon);
                            break;
                        case "Oficial Rojo":
                            tablerobotones[i][j].setIcon(oficialRojoIcon);
                            break;
                        case "Rey Rojo":
                            tablerobotones[i][j].setIcon(reyRojoIcon);
                            break;
                        case "Cañon Rojo":
                            tablerobotones[i][j].setIcon(canonrojoIcon);
                            break;
                        case "Cañon Negro":
                            tablerobotones[i][j].setIcon(canonnegroIcon);
                            break;
                    }
                } else {
                    tablerobotones[i][j].setIcon(null);
                }

                panel.add(tablerobotones[i][j]);
            }
        }

        this.add(panel);
        pack();
    }

    private void accionbotones() {
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 9; y++) {
                final int posX = x;
                final int posY = y;
                tablerobotones[x][y].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (tablerostring[posX][posY].contains("Rojo") && !turno) {
                            if (tablerostring[posX][posY].equals("Peon Rojo")) {
                                if (p.seleccionar(posX, posY)) {
                                    piezaseleccionada = tablerostring[posX][posY];
                                    posicionx = posX;
                                    posiciony = posY;
                                    System.out.println("La pieza seleccionada es " + piezaseleccionada);
                                }
                            } else if (tablerostring[posX][posY].equals("Rey Rojo")) {
                                if (rey.seleccionar(posX, posY)) {
                                    piezaseleccionada = tablerostring[posX][posY];
                                    posicionx = posX;
                                    posiciony = posY;
                                    System.out.println("La pieza seleccionada es " + piezaseleccionada);
                                }
                            } else if (tablerostring[posX][posY].equals("Caballo Rojo")) {
                                if (caballo.seleccionar(posX, posY)) {
                                    piezaseleccionada = tablerostring[posX][posY];
                                    posicionx = posX;
                                    posiciony = posY;
                                    System.out.println("La pieza seleccionada es " + piezaseleccionada);
                                }
                            } else if (tablerostring[posX][posY].equals("Cañon Rojo")) {
                                if (cañon.seleccionar(posX, posY)) {
                                    piezaseleccionada = tablerostring[posX][posY];
                                    posicionx = posX;
                                    posiciony = posY;
                                    System.out.println("La pieza seleccionada es " + piezaseleccionada);
                                }
                            } else if (tablerostring[posX][posY].equals("Oficial Rojo")) {
                                if (oficial.seleccionar(posX, posY)) {
                                    piezaseleccionada = tablerostring[posX][posY];
                                    posicionx = posX;
                                    posiciony = posY;
                                    System.out.println("La pieza seleccionada es " + piezaseleccionada);
                                }
                            } else if (tablerostring[posX][posY].equals("Elefante Rojo")) {
                                if (elefante.seleccionar(posX, posY)) {
                                    piezaseleccionada = tablerostring[posX][posY];
                                    posicionx = posX;
                                    posiciony = posY;
                                    System.out.println("La pieza seleccionada es " + piezaseleccionada);
                                }
                            } else if (tablerostring[posX][posY].equals("Torre Rojo")) {
                                if (torre.seleccionar(posX, posY)) {
                                    piezaseleccionada = tablerostring[posX][posY];
                                    posicionx = posX;
                                    posiciony = posY;
                                    System.out.println("La pieza seleccionada es " + piezaseleccionada);
                                }
                            }
                        } else if (tablerostring[posX][posY].equals("") && piezaseleccionada != null && piezaseleccionada.contains("Rojo") && !turno) {
                            if (piezaseleccionada.equals("Peon Rojo")) {
                                if (p.moverrojo(posX, posY, tablerostring)) {
                                    tablerostring[posicionx][posiciony] = "";
                                    tablerobotones[posicionx][posiciony].setIcon(null);
                                    tablerostring[posX][posY] = "Peon Rojo";
                                    tablerobotones[posX][posY].setIcon(peonRojoIcon);
                                    anunciarganador();
                                    cambiarturno();
                                    refrescarlabel();
                                }
                            } else if (piezaseleccionada.equals("Rey Rojo")) {
                                if (rey.moverrojo(posX, posY, tablerostring)) {
                                    tablerostring[posicionx][posiciony] = "";
                                    tablerobotones[posicionx][posiciony].setIcon(null);
                                    tablerostring[posX][posY] = "Rey Rojo";
                                    tablerobotones[posX][posY].setIcon(reyRojoIcon);
                                    anunciarganador();
                                    cambiarturno();
                                    refrescarlabel();
                                }
                            } else if (piezaseleccionada.equals("Caballo Rojo")) {
                                if (caballo.moverrojo(posX, posY, tablerostring)) {
                                    tablerostring[posicionx][posiciony] = "";
                                    tablerobotones[posicionx][posiciony].setIcon(null);
                                    tablerostring[posX][posY] = "Caballo Rojo";
                                    tablerobotones[posX][posY].setIcon(caballoRojoIcon);
                                    anunciarganador();
                                    cambiarturno();
                                    refrescarlabel();
                                }
                            } else if (piezaseleccionada.equals("Cañon Rojo")) {
                                if (cañon.moverrojo(posX, posY, tablerostring)) {
                                    tablerostring[posicionx][posiciony] = "";
                                    tablerobotones[posicionx][posiciony].setIcon(null);
                                    tablerostring[posX][posY] = "Cañon Rojo";
                                    tablerobotones[posX][posY].setIcon(canonrojoIcon);
                                    anunciarganador();
                                    cambiarturno();
                                    refrescarlabel();
                                }
                            } else if (piezaseleccionada.equals("Oficial Rojo")) {
                                if (oficial.moverrojo(posX, posY, tablerostring)) {
                                    tablerostring[posicionx][posiciony] = "";
                                    tablerobotones[posicionx][posiciony].setIcon(null);
                                    tablerostring[posX][posY] = "Oficial Rojo";
                                    tablerobotones[posX][posY].setIcon(oficialRojoIcon);
                                    anunciarganador();
                                    cambiarturno();
                                    refrescarlabel();
                                }
                            } else if (piezaseleccionada.equals("Elefante Rojo")) {
                                if (elefante.moverrojo(posX, posY, tablerostring)) {
                                    tablerostring[posicionx][posiciony] = "";
                                    tablerobotones[posicionx][posiciony].setIcon(null);
                                    tablerostring[posX][posY] = "Elefante Rojo";
                                    tablerobotones[posX][posY].setIcon(elefanteRojoIcon);
                                    anunciarganador();
                                    cambiarturno();
                                    refrescarlabel();
                                }
                            } else if (piezaseleccionada.equals("Torre Rojo")) {
                                if (torre.moverrojo(posX, posY, tablerostring)) {
                                    tablerostring[posicionx][posiciony] = "";
                                    tablerobotones[posicionx][posiciony].setIcon(null);
                                    tablerostring[posX][posY] = "Torre Rojo";
                                    tablerobotones[posX][posY].setIcon(torreRojaIcon);
                                    anunciarganador();
                                    cambiarturno();
                                    refrescarlabel();
                                }
                            }
                        } else if ((tablerostring[posX][posY].contains("Negro")) && piezaseleccionada != null && piezaseleccionada.contains("Rojo") && !turno) {
                            if (piezaseleccionada.equals("Peon Rojo")) {
                                if (p.moverrojo(posX, posY, tablerostring)) {
                                    String piezacomida=tablerostring[posX][posY];
                                    tablerostring[posicionx][posiciony] = "";
                                    tablerobotones[posicionx][posiciony].setIcon(null);
                                    tablerostring[posX][posY] = "Peon Rojo";
                                    tablerobotones[posX][posY].setIcon(peonRojoIcon);
                                    System.out.println("Se comió la pieza Negra con el Peón Rojo");
                                    consola.append("El Peon Rojo se comio al "+piezacomida+"\n");
                                    anunciarganador();
                                    cambiarturno();
                                    refrescarlabel();
                                }
                            } else if (piezaseleccionada.equals("Rey Rojo")) {
                                if (rey.moverrojo(posX, posY, tablerostring)) {
                                    String piezacomida=tablerostring[posX][posY];
                                    tablerostring[posicionx][posiciony] = "";
                                    tablerobotones[posicionx][posiciony].setIcon(null);
                                    tablerostring[posX][posY] = "Rey Rojo";
                                    tablerobotones[posX][posY].setIcon(reyRojoIcon);
                                    System.out.println("Se comió la pieza Negra con el Rey Rojo");
                                    consola.append("El Rey Rojo se comio al "+piezacomida+"\n");
                                    anunciarganador();
                                    cambiarturno();
                                    refrescarlabel();
                                }
                            } else if (piezaseleccionada.equals("Caballo Rojo")) {
                                if (caballo.moverrojo(posX, posY, tablerostring)) {
                                    String piezacomida=tablerostring[posX][posY];
                                    tablerostring[posicionx][posiciony] = "";
                                    tablerobotones[posicionx][posiciony].setIcon(null);
                                    tablerostring[posX][posY] = "Caballo Rojo";
                                    tablerobotones[posX][posY].setIcon(caballoRojoIcon);
                                    System.out.println("Se comio la pieza negra con el Caballo Rojo");
                                    consola.append("El Caballo Rojo se comio al "+piezacomida+"\n");
                                    anunciarganador();
                                    cambiarturno();
                                    refrescarlabel();
                                }
                            } else if (piezaseleccionada.equals("Cañon Rojo")) {
                                String piezacomida=tablerostring[posX][posY];
                                if (cañon.moverrojo(posX, posY, tablerostring)) {
                                    tablerostring[posicionx][posiciony] = "";
                                    tablerobotones[posicionx][posiciony].setIcon(null);
                                    tablerostring[posX][posY] = "Cañon Rojo";
                                    tablerobotones[posX][posY].setIcon(canonrojoIcon);
                                    System.out.println("Se comio la pieza negra con el Cañon Rojo");
                                    consola.append("El Cañon Rojo se comio al "+piezacomida+"\n");
                                    anunciarganador();
                                    cambiarturno();
                                    refrescarlabel();
                                }
                            } else if (piezaseleccionada.equals("Oficial Rojo")) {
                                if (oficial.moverrojo(posX, posY, tablerostring)) {
                                    String piezacomida=tablerostring[posX][posY];
                                    tablerostring[posicionx][posiciony] = "";
                                    tablerobotones[posicionx][posiciony].setIcon(null);
                                    tablerostring[posX][posY] = "Oficial Rojo";
                                    tablerobotones[posX][posY].setIcon(oficialRojoIcon);
                                    System.out.println("Se comio la pieza negra con el Oficial Rojo");
                                    consola.append("El Oficial Rojo se comio al "+piezacomida+"\n");
                                    anunciarganador();
                                    cambiarturno();
                                    refrescarlabel();
                                }
                            } else if (piezaseleccionada.equals("Elefante Rojo")) {
                                if (elefante.moverrojo(posX, posY, tablerostring)) {
                                    String piezacomida=tablerostring[posX][posY];
                                    tablerostring[posicionx][posiciony] = "";
                                    tablerobotones[posicionx][posiciony].setIcon(null);
                                    tablerostring[posX][posY] = "Elefante Rojo";
                                    tablerobotones[posX][posY].setIcon(elefanteRojoIcon);
                                    System.out.println("Se comio la pieza negra con el oficial rojo");
                                    consola.append("El Elefante Rojo se comio al "+piezacomida+"\n");
                                    anunciarganador();
                                    cambiarturno();
                                    refrescarlabel();
                                }
                            } else if (piezaseleccionada.equals("Torre Rojo")) {
                                if (torre.moverrojo(posX, posY, tablerostring)) {
                                    String piezacomida=tablerostring[posX][posY];
                                    tablerostring[posicionx][posiciony] = "";
                                    tablerobotones[posicionx][posiciony].setIcon(null);
                                    tablerostring[posX][posY] = "Torre Rojo";
                                    tablerobotones[posX][posY].setIcon(torreRojaIcon);
                                    System.out.println("Se comio la pieza negra con la Torre rojo");
                                    consola.append("El Torre Roja se comio al "+piezacomida+"\n");
                                    anunciarganador();
                                    cambiarturno();
                                    refrescarlabel();
                                }
                            }
                        } else if (tablerostring[posX][posY].contains("Negro") && turno) {
                            if (tablerostring[posX][posY].equals("Peon Negro")) {
                                if (p.seleccionar(posX, posY)) {
                                    piezaseleccionada = tablerostring[posX][posY];
                                    posicionx = posX;
                                    posiciony = posY;
                                    System.out.println("La pieza seleccionada es " + piezaseleccionada);
                                }
                            } else if (tablerostring[posX][posY].equals("Rey Negro")) {
                                if (rey.seleccionar(posX, posY)) {
                                    piezaseleccionada = tablerostring[posX][posY];
                                    posicionx = posX;
                                    posiciony = posY;
                                    System.out.println("La pieza seleccionada es " + piezaseleccionada);
                                }
                            } else if (tablerostring[posX][posY].equals("Caballo Negro")) {
                                if (caballo.seleccionar(posX, posY)) {
                                    piezaseleccionada = tablerostring[posX][posY];
                                    posicionx = posX;
                                    posiciony = posY;
                                    System.out.println("La pieza seleccionada es " + piezaseleccionada);
                                }
                            } else if (tablerostring[posX][posY].equals("Cañon Negro")) {
                                if (cañon.seleccionar(posX, posY)) {
                                    piezaseleccionada = tablerostring[posX][posY];
                                    posicionx = posX;
                                    posiciony = posY;
                                    System.out.println("La pieza seleccionada es " + piezaseleccionada);
                                }
                            } else if (tablerostring[posX][posY].equals("Oficial Negro")) {
                                if (oficial.seleccionar(posX, posY)) {
                                    piezaseleccionada = tablerostring[posX][posY];
                                    posicionx = posX;
                                    posiciony = posY;
                                    System.out.println("La pieza seleccionada es " + piezaseleccionada);
                                }
                            } else if (tablerostring[posX][posY].equals("Elefante Negro")) {
                                if (elefante.seleccionar(posX, posY)) {
                                    piezaseleccionada = tablerostring[posX][posY];
                                    posicionx = posX;
                                    posiciony = posY;
                                    System.out.println("La pieza seleccionada es " + piezaseleccionada);
                                }
                            } else if (tablerostring[posX][posY].equals("Torre Negro")) {
                                if (torre.seleccionar(posX, posY)) {
                                    piezaseleccionada = tablerostring[posX][posY];
                                    posicionx = posX;
                                    posiciony = posY;
                                    System.out.println("La pieza seleccionada es " + piezaseleccionada);
                                }
                            }
                        } else if (tablerostring[posX][posY].equals("") && piezaseleccionada != null && piezaseleccionada.contains("Negro") && turno) {
                            if (piezaseleccionada.equals("Peon Negro")) {
                                if (p.movernegro(posX, posY, tablerostring)) {
                                    tablerostring[posicionx][posiciony] = "";
                                    tablerobotones[posicionx][posiciony].setIcon(null);
                                    tablerostring[posX][posY] = "Peon Negro";
                                    tablerobotones[posX][posY].setIcon(peonNegroIcon);
                                    anunciarganador();
                                    cambiarturno();
                                    refrescarlabel();
                                }
                            } else if (piezaseleccionada.equals("Rey Negro")) {
                                if (rey.movernegro(posX, posY, tablerostring)) {
                                    tablerostring[posicionx][posiciony] = "";
                                    tablerobotones[posicionx][posiciony].setIcon(null);
                                    tablerostring[posX][posY] = "Rey Negro";
                                    tablerobotones[posX][posY].setIcon(reyNegroIcon);
                                    anunciarganador();
                                    cambiarturno();
                                    refrescarlabel();
                                }
                            } else if (piezaseleccionada.equals("Caballo Negro")) {
                                if (caballo.movernegro(posX, posY, tablerostring)) {
                                    tablerostring[posicionx][posiciony] = "";
                                    tablerobotones[posicionx][posiciony].setIcon(null);
                                    tablerostring[posX][posY] = "Caballo Negro";
                                    tablerobotones[posX][posY].setIcon(caballoNegroIcon);
                                    anunciarganador();
                                    cambiarturno();
                                    refrescarlabel();
                                }
                            } else if (piezaseleccionada.equals("Cañon Negro")) {
                                if (cañon.movernegro(posX, posY, tablerostring)) {
                                    tablerostring[posicionx][posiciony] = "";
                                    tablerobotones[posicionx][posiciony].setIcon(null);
                                    tablerostring[posX][posY] = "Cañon Negro";
                                    tablerobotones[posX][posY].setIcon(canonnegroIcon);
                                    anunciarganador();
                                    cambiarturno();
                                    refrescarlabel();
                                }
                            } else if (piezaseleccionada.equals("Oficial Negro")) {
                                if (oficial.movernegro(posX, posY, tablerostring)) {
                                    tablerostring[posicionx][posiciony] = "";
                                    tablerobotones[posicionx][posiciony].setIcon(null);
                                    tablerostring[posX][posY] = "Oficial Negro";
                                    tablerobotones[posX][posY].setIcon(oficialNegroIcon);
                                    anunciarganador();
                                    cambiarturno();
                                    refrescarlabel();
                                }
                            } else if (piezaseleccionada.equals("Elefante Negro")) {
                                if (elefante.movernegro(posX, posY, tablerostring)) {
                                    tablerostring[posicionx][posiciony] = "";
                                    tablerobotones[posicionx][posiciony].setIcon(null);
                                    tablerostring[posX][posY] = "Elefante Negro";
                                    tablerobotones[posX][posY].setIcon(elefanteNegroIcon);
                                    anunciarganador();
                                    cambiarturno();
                                    refrescarlabel();
                                }
                            } else if (piezaseleccionada.equals("Torre Negro")) {
                                if (torre.movernegro(posX, posY, tablerostring)) {
                                    tablerostring[posicionx][posiciony] = "";
                                    tablerobotones[posicionx][posiciony].setIcon(null);
                                    tablerostring[posX][posY] = "Torre Negro";
                                    tablerobotones[posX][posY].setIcon(torreNegraIcon);
                                    anunciarganador();
                                    cambiarturno();
                                    refrescarlabel();
                                }
                            }
                        } else if ((tablerostring[posX][posY].contains("Rojo")) && piezaseleccionada != null && piezaseleccionada.contains("Negro") && turno) {
                            if (piezaseleccionada.equals("Peon Negro")) {
                                if (p.movernegro(posX, posY, tablerostring)) {
                                    String piezacomida=tablerostring[posX][posY];
                                    tablerostring[posicionx][posiciony] = "";
                                    tablerobotones[posicionx][posiciony].setIcon(null);
                                    tablerostring[posX][posY] = "Peon Negro";
                                    tablerobotones[posX][posY].setIcon(peonNegroIcon);
                                    consola.append("El Peon Negro se comio a "+piezacomida+"\n");
                                    anunciarganador();
                                    cambiarturno();
                                    refrescarlabel();
                                }
                            } else if (piezaseleccionada.equals("Rey Negro")) {
                                if (rey.movernegro(posX, posY, tablerostring)) {
                                    String piezacomida=tablerostring[posX][posY];
                                    tablerostring[posicionx][posiciony] = "";
                                    tablerobotones[posicionx][posiciony].setIcon(null);
                                    tablerostring[posX][posY] = "Rey Negro";
                                    tablerobotones[posX][posY].setIcon(reyNegroIcon);
                                    consola.append("El Rey Negro se comio a "+piezacomida+"\n");
                                    anunciarganador();
                                    cambiarturno();
                                    refrescarlabel();
                                }
                            } else if (piezaseleccionada.equals("Caballo Negro")) {
                                if (caballo.movernegro(posX, posY, tablerostring)) {
                                    String piezacomida=tablerostring[posX][posY];
                                    tablerostring[posicionx][posiciony] = "";
                                    tablerobotones[posicionx][posiciony].setIcon(null);
                                    tablerostring[posX][posY] = "Caballo Negro";
                                    tablerobotones[posX][posY].setIcon(caballoNegroIcon);
                                    consola.append("El Caballo Negro se comio a "+piezacomida+"\n");
                                    anunciarganador();
                                    cambiarturno();
                                    refrescarlabel();
                                }
                            } else if (piezaseleccionada.equals("Cañon Negro")) {
                                String piezacomida=tablerostring[posX][posY];
                                if (cañon.movernegro(posX, posY, tablerostring)) {
                                    tablerostring[posicionx][posiciony] = "";
                                    tablerobotones[posicionx][posiciony].setIcon(null);
                                    tablerostring[posX][posY] = "Cañon Negro";
                                    tablerobotones[posX][posY].setIcon(canonnegroIcon);
                                    consola.append("El Cañon Negro se comio a "+piezacomida+"\n");
                                    anunciarganador();
                                    cambiarturno();
                                    refrescarlabel();
                                }
                            } else if (piezaseleccionada.equals("Oficial Negro")) {
                                if (oficial.movernegro(posX, posY, tablerostring)) {
                                    String piezacomida=tablerostring[posX][posY];
                                    tablerostring[posicionx][posiciony] = "";
                                    tablerobotones[posicionx][posiciony].setIcon(null);
                                    tablerostring[posX][posY] = "Oficial Negro";
                                    tablerobotones[posX][posY].setIcon(oficialNegroIcon);
                                    consola.append("El Oficial Negro se comio "+piezacomida+"\n");
                                    anunciarganador();
                                    cambiarturno();
                                    refrescarlabel();
                                }
                            } else if (piezaseleccionada.equals("Elefante Negro")) {
                                if (elefante.movernegro(posX, posY, tablerostring)) {
                                    String piezacomida=tablerostring[posX][posY];
                                    tablerostring[posicionx][posiciony] = "";
                                    tablerobotones[posicionx][posiciony].setIcon(null);
                                    tablerostring[posX][posY] = "Elefante Negro";
                                    tablerobotones[posX][posY].setIcon(elefanteNegroIcon);
                                    consola.append("El Elefante Negro se comio "+piezacomida+"\n");
                                    anunciarganador();
                                    cambiarturno();
                                    refrescarlabel();
                                }
                            } else if (piezaseleccionada.equals("Torre Negro")) {
                                if (torre.movernegro(posX, posY, tablerostring)) {
                                    String piezacomida=tablerostring[posX][posY];
                                    tablerostring[posicionx][posiciony] = "";
                                    tablerobotones[posicionx][posiciony].setIcon(null);
                                    tablerostring[posX][posY] = "Torre Negro";
                                    tablerobotones[posX][posY].setIcon(torreNegraIcon);
                                    consola.append("El Torre Negro se comio "+piezacomida+"\n");
                                    anunciarganador();
                                    cambiarturno();
                                    refrescarlabel();
                                }
                            }
                        }
                    }
                });
            }
        }
    }

    private void initComponents() {
        this.setSize(800, 600);
        this.setVisible(true);
        this.setLocationRelativeTo(null);

        JButton rendir = new JButton();
        rendir.setPreferredSize(new Dimension(50, 50));
        rendir.setText("RENDIRSE");
        this.add(rendir, BorderLayout.SOUTH);

        rendir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (turno) {
                    JOptionPane.showMessageDialog(null, "El jugador " + Jugadores.jugadorloggeado + " con las fichas Negras se ha rendido");
                    j.añadirpuntosganador(Jugadores.jugadorcontrario);
                    j.agregarLogsAlRendir(Jugadores.jugadorcontrario, Jugadores.jugadorloggeado);
                    MenuJuego mj = new MenuJuego();
                    mj.setVisible(true);
                    Tablero.this.dispose();
                } else if (!turno) {
                    JOptionPane.showMessageDialog(null, "El jugador " + Jugadores.jugadorcontrario + " con las fichas Rojas se ha rendido");
                    j.añadirpuntosganador(Jugadores.jugadorloggeado);
                    j.agregarLogsAlRendir(Jugadores.jugadorloggeado, Jugadores.jugadorcontrario);
                    MenuJuego mj = new MenuJuego();
                    mj.setVisible(true);
                    Tablero.this.dispose();
                }
            }
        });

        jugadores.setPreferredSize(new Dimension(50, 50));
        refrescarlabel();

        consola.setPreferredSize(new Dimension(300, 50));
        consola.setEnabled(false);

        JScrollPane scrollPane = new JScrollPane(consola);

        this.add(scrollPane, BorderLayout.EAST);
    }

    public static void main(String args[]) {
        Tablero t = new Tablero();
        t.setVisible(true);
    }

}
