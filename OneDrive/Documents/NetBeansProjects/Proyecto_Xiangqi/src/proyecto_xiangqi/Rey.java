/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_xiangqi;

/**
 *
 * @author ernes
 */
public class Rey extends Pieza {

    @Override
    public boolean seleccionar(int x, int y) {
        this.x = x;
        this.y = y;
        return true;
    }

    @Override
    public boolean moverrojo(int xfinal, int yfinal, String[][] tablero) {
        if (xfinal >= 0 && xfinal <= 2 && yfinal >= 3 && yfinal <= 5) {
            if ((xfinal == x + 1 && yfinal == y) || (xfinal == x - 1 && yfinal == y) || (xfinal == x && yfinal == y + 1) || (xfinal == x && yfinal == y - 1)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean movernegro(int xfinal, int yfinal, String[][] tablero) {
        if (xfinal >= 7 && xfinal <= 9 && yfinal >= 3 && yfinal <= 5) {
            if ((xfinal == x + 1 && yfinal == y) || (xfinal == x - 1 && yfinal == y) || (xfinal == x && yfinal == y + 1) || (xfinal == x && yfinal == y - 1)) {
                return true;
            }
        }
        return false;
    }

}
