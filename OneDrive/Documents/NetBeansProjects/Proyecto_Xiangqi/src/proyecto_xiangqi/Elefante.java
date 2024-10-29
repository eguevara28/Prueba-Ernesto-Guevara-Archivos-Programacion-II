/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_xiangqi;

/**
 *
 * @author ernes
 */
public class Elefante extends Pieza {

    @Override
    public boolean seleccionar(int x, int y) {
        this.x = x;
        this.y = y;
        return true;
    }

    @Override
    public boolean moverrojo(int xfinal, int yfinal, String[][] tablero) {
        int dx = xfinal - this.x;
        int dy = yfinal - this.y;

        if ((dx == 2 || dx == -2) && (dy == 2 || dy == -2)) {
            int xIntermedia = this.x + dx / 2;
            int yIntermedia = this.y + dy / 2;

            if (tablero[xIntermedia][yIntermedia].equals("") && xfinal <= 4) {
                if (tablero[xfinal][yfinal].equals("") || !tablero[xfinal][yfinal].equals("rojo")) {
                    this.x = xfinal;
                    this.y = yfinal;
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean movernegro(int xfinal, int yfinal, String[][] tablero) {
        int dx = xfinal - this.x;
        int dy = yfinal - this.y;

        if ((dx == 2 || dx == -2) && (dy == 2 || dy == -2)) {
            int xIntermedia = this.x + dx / 2;
            int yIntermedia = this.y + dy / 2;

            if (tablero[xIntermedia][yIntermedia].equals("") && xfinal >= 5) {
                if (tablero[xfinal][yfinal].equals("") || !tablero[xfinal][yfinal].equals("negro")) {
                    this.x = xfinal;
                    this.y = yfinal;
                    return true;
                }
            }
        }
        return false;
    }
}
