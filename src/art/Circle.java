package art;

import java.awt.*;

public class Circle extends MyShape {
    private int radius;
    private Point center;

    Circle(int radius, Point center, String name){
        super(name);
        this.radius = radius;
        this.center = center;

    }

    @Override
    public void draw(Graphics g){
        drawName(g, this.center.getX(), this.center.getY());
        g.drawOval(this.center.getX(), this.center.getY(), this.radius, this.radius);

    }
}
