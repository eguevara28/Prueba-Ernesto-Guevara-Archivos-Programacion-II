/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_xiangqi;

/**
 *
 * @author ernes
 */
public class Torre extends Pieza {

    @Override
    public boolean seleccionar(int x, int y) {
        this.x = x;
        this.y = y;
        return true;
    }
    
    @Override
    public boolean moverrojo(int xfinal, int yfinal, String[][] tablero) {
        if (this.x == xfinal && this.y != yfinal) {
            int incremento = yfinal > this.y ? 1 : -1;
            for (int j = this.y + incremento; j != yfinal; j += incremento) {
                if (!tablero[this.x][j].equals("")) {
                    return false;
                }
            }
        }
        else if (this.y == yfinal && this.x != xfinal) {
            int incremento = xfinal > this.x ? 1 : -1;
            for (int i = this.x + incremento; i != xfinal; i += incremento) {
                if (!tablero[i][this.y].equals("")) {
                    return false;
                }
            }
        } else {
            return false;
        }

        if (tablero[xfinal][yfinal].equals("") || !tablero[xfinal][yfinal].equals("rojo")) {
            this.x = xfinal;
            this.y = yfinal;
            return true;
        }
        return false;
    }

    @Override
    public boolean movernegro(int xfinal, int yfinal, String[][] tablero) {
        if (this.x == xfinal && this.y != yfinal) {
            int incremento = yfinal > this.y ? 1 : -1;
            for (int j = this.y + incremento; j != yfinal; j += incremento) {
                if (!tablero[this.x][j].equals("")) {
                    return false;
                }
            }
        }
        else if (this.y == yfinal && this.x != xfinal) {
            int incremento = xfinal > this.x ? 1 : -1;
            for (int i = this.x + incremento; i != xfinal; i += incremento) {
                if (!tablero[i][this.y].equals("")) {
                    return false;
                }
            }
        } else {
            return false;
        }

        if (tablero[xfinal][yfinal].equals("") || !tablero[xfinal][yfinal].equals("negro")) {
            this.x = xfinal;
            this.y = yfinal;
            return true;
        }
        return false;
    }
}


