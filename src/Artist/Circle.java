package Artist;
import javax.swing.*;
import java.awt.*;

public class Circle extends Shape {
    private int radius;

    public Circle(int x, int y, int radius){
        super(x, y);
        this.radius = radius;
    }
    @Override
    public void draw(Graphics g) {
        g.drawOval(x, y,radius,radius);
    }

}
