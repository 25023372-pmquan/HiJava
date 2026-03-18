package Artist;

import javax.swing.*;
import java.awt.*;

public abstract class ShapeConfig extends JPanel{
    protected JTextField xField;
    protected JTextField yField;

    protected void drawInitPoint(){
        xField = new JTextField();
        xField.setMaximumSize(new Dimension(400,20));
        yField = new JTextField();
        yField.setMaximumSize(new Dimension(400,20));

        add(new JLabel("x:"));
        add(xField);
        add(new JLabel("y: "));
        add(yField);
    }
    protected Point getPoint(){
        int x = Integer.parseInt(xField.getText());
        int y = Integer.parseInt(yField.getText());
        return new Point(x,y);
    }

    abstract Shape getShape();
    public static ShapeConfig from(ShapeType type){
        ShapeConfig shapeConfig = null;
        switch (type){
            case CIRCLE -> shapeConfig = new CircleConfig();
            case RECTANGLE -> shapeConfig = new RectangleConfig();
        }
        return shapeConfig;
    }
}
