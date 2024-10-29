/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_xiangqi;

/**
 *
 * @author ernes
 */
public class Oficial extends Pieza {

    @Override
    public boolean seleccionar(int x, int y) {
        this.x = x;
        this.y = y;
        return true;
    }

    @Override
    public boolean movernegro(int xfinal, int yfinal, String[][] tablero) {
        if (x >= 7 && x <= 9 && y >= 3 && y <= 5) {
            if ((xfinal == x + 1 && yfinal == y + 1)
                    || (xfinal == x + 1 && yfinal == y - 1)
                    || (xfinal == x - 1 && yfinal == y + 1)
                    || (xfinal == x - 1 && yfinal == y - 1)) {
                if (xfinal >= 7 && xfinal <= 9 && yfinal >= 3 && yfinal <= 5) {
                    this.x = xfinal;
                    this.y = yfinal;
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean moverrojo(int xfinal, int yfinal, String[][] tablero) {
        if (x >= 0 && x <= 2 && y >= 3 && y <= 5) {
            if ((xfinal == x + 1 && yfinal == y + 1)
                    || (xfinal == x + 1 && yfinal == y - 1)
                    || (xfinal == x - 1 && yfinal == y + 1)
                    || (xfinal == x - 1 && yfinal == y - 1)) {
                if (xfinal >= 0 && xfinal <= 2 && yfinal >= 3 && yfinal <= 5) {
                    this.x = xfinal;
                    this.y = yfinal;
                    return true;
                }
            }
        }
        return false;
    }

}
