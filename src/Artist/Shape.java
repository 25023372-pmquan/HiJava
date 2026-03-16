package Artist;

import java.awt.*;

public abstract class Shape {
    int x;
    int y;
    public Shape(int x, int y){
        this.x = x;
        this.y = y;
    }

    abstract void draw(Graphics g);

}
