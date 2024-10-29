/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_xiangqi;

/**
 *
 * @author ernes
 */
public abstract class Pieza {
   int x=0;
    int y=0;
    
    public Pieza() {
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public void setPosicion(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public abstract boolean seleccionar(int xinicial, int yinicial);
    
    public abstract boolean movernegro(int xfinal, int yfinal, String[][] tablero);
    
    public abstract boolean moverrojo(int xfinal, int yfinal, String[][] tablero);
}



