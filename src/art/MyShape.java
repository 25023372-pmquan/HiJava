package art;

import java.awt.*;

public abstract class MyShape {
//    public void draw(Graphics g);
    private String name;
    public MyShape(String name){
        this.name = name;
    }

    protected void drawName(Graphics g, int x, int y){
        g.drawString(this.name ,x, y);
    }

    public abstract void draw(Graphics g);
}
