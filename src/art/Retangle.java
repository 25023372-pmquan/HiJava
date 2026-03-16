package art;

import java.awt.*;

public class Retangle extends MyShape {
    // chieu dai
    // chieu rong
    // point
    private int width;
    private int height;
    private Point point;

    public Retangle(int width, int height, Point point, String name){
        super(name);
        this.width = width;
        this.height = height;
        this.point = point;
    }

    @Override
    public void draw(Graphics g){
        drawName(g,this.point.getX(),this.point.getY());
        g.drawRect(point.getX(), point.getY(), this.width, this.height);

    }

}
