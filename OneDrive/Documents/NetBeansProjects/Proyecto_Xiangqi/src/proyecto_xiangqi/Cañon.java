/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_xiangqi;

/**
 *
 * @author ernes
 */
public class Cañon extends Pieza {
    
    @Override
    public boolean seleccionar(int x, int y) {
        this.x = x;
        this.y = y;
        return true;
    }
    
    @Override
    public boolean moverrojo(int xfinal, int yfinal, String[][] tablero) {
        int piezaEntreMedio = 0;

        if (yfinal == this.y && xfinal != this.x) {
            int step = xfinal > this.x ? 1 : -1;
            for (int i = this.x + step; i != xfinal; i += step) {
                if (!tablero[i][this.y].equals("")) {
                    piezaEntreMedio++;
                }
            }
        }
        else if (xfinal == this.x && yfinal != this.y) {
            int step = yfinal > this.y ? 1 : -1;
            for (int i = this.y + step; i != yfinal; i += step) {
                if (!tablero[this.x][i].equals("")) {
                    piezaEntreMedio++;
                }
            }
        } else {
            return false;
        }

        if (piezaEntreMedio == 0 && tablero[xfinal][yfinal].equals("")) {
            this.x = xfinal;
            this.y = yfinal;
            return true;
        }
        else if (piezaEntreMedio == 1 && !tablero[xfinal][yfinal].equals("")) {
            this.x = xfinal;
            this.y = yfinal;
            tablero[xfinal][yfinal] = "Cañon Rojo";
            return true;
        }

        return false;
    }
    
    @Override
    public boolean movernegro(int xfinal, int yfinal, String[][] tablero) {
        int piezaEntreMedio = 0;

        if (yfinal == this.y && xfinal != this.x) {
            int step = xfinal > this.x ? 1 : -1;
            for (int i = this.x + step; i != xfinal; i += step) {
                if (!tablero[i][this.y].equals("")) {
                    piezaEntreMedio++;
                }
            }
        }
        else if (xfinal == this.x && yfinal != this.y) {
            int step = yfinal > this.y ? 1 : -1;
            for (int i = this.y + step; i != yfinal; i += step) {
                if (!tablero[this.x][i].equals("")) {
                    piezaEntreMedio++;
                }
            }
        } else {
            return false;
        }

        if (piezaEntreMedio == 0 && tablero[xfinal][yfinal].equals("")) {
            this.x = xfinal;
            this.y = yfinal;
            return true;
        }
        else if (piezaEntreMedio == 1 && !tablero[xfinal][yfinal].equals("")) {
            this.x = xfinal;
            this.y = yfinal;
            tablero[xfinal][yfinal] = "Cañon Negro";
            return true;
        }

        return false;
    }
}
