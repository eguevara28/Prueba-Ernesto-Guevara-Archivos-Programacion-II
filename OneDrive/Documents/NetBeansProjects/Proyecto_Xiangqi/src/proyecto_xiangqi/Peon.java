/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_xiangqi;

/**
 *
 * @author ernes
 */
public class Peon extends Pieza {
    
    @Override
    public boolean seleccionar(int x, int y){
        this.x=x;
        this.y=y;
        return true;
    }
    
    @Override
    public boolean moverrojo(int xfinal, int yfinal, String[][] tablero){
        if(x<5){
            if(xfinal==x+1 && yfinal==y){
                return true;
            }
        }else if(x>=5){
            if(xfinal==x+1 && yfinal==y || xfinal==x && yfinal==y+1 || xfinal==x && yfinal==y-1){
                return true;
            }
        }
        return false;
    }
    
@Override
public boolean movernegro(int xfinal, int yfinal, String[][] tablero) {
    if (this.x > 4) {
        if (xfinal == this.x - 1 && yfinal == this.y) {
            this.x = xfinal;
            this.y = yfinal;
            return true;
        }
    } else {
        if ((xfinal == this.x - 1 && yfinal == this.y) || (xfinal == this.x && Math.abs(yfinal - this.y) == 1)) {
            this.x = xfinal;
            this.y = yfinal;
            return true;
        }
    }

    return false;
}

}
