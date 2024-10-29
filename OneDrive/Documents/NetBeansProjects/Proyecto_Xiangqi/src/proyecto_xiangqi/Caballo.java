/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_xiangqi;

/**
 *
 * @author ernes
 */
public class Caballo extends Pieza {

    @Override
    public boolean seleccionar(int x, int y) {
        this.x = x;
        this.y = y;
        return true;
    }

    @Override
    public boolean moverrojo(int xfinal, int yfinal, String[][] tablero) {
        if (esMovimientoValido(xfinal, yfinal) && !hayObstaculo(x, y, xfinal, yfinal, tablero)) {
            System.out.println("movimiento");
            return true;
        }
        return false;
    }

    @Override
    public boolean movernegro(int xfinal, int yfinal, String[][] tablero) {
        if (esMovimientoValido(xfinal, yfinal) && !hayObstaculo(x, y, xfinal, yfinal, tablero)) {
            this.x = xfinal;
            this.y = yfinal;
            return true;
        }
        return false;
    }

    private boolean esMovimientoValido(int xfinal, int yfinal) {
        return (xfinal == x + 2 && (yfinal == y + 1 || yfinal == y - 1)) || (xfinal == x - 2 && (yfinal == y + 1 || yfinal == y - 1)) || (xfinal == x + 1 && (yfinal == y + 2 || yfinal == y - 2))|| (xfinal == x - 1 && (yfinal == y + 2 || yfinal == y - 2));
    }

    private boolean hayObstaculo(int x, int y, int xfinal, int yfinal, String[][] tablero) {
        int xObstaculo = (xfinal == x + 2) ? x + 1 : (xfinal == x - 2) ? x - 1 : x;
        int yObstaculo = (yfinal == y + 2) ? y + 1 : (yfinal == y - 2) ? y - 1 : y;

        if (tablero[xObstaculo][yObstaculo] != null && !tablero[xObstaculo][yObstaculo].isEmpty()) {
            return true;
        }
        return false;
    }

}
