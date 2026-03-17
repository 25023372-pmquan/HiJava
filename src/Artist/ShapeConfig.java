package Artist;

import javax.swing.*;
import java.awt.*;

public abstract class ShapeConfig {
    protected JTextField xField;
    protected JTextField yField;
    JPanel createConfig(){
        System.out.println("create config of shape config");
        xField = new JTextField();
        xField.setMaximumSize(new Dimension(400,20));
        yField = new JTextField();
        yField.setMaximumSize(new Dimension(400,20));
        JPanel shapePanel = new JPanel();
        shapePanel.setLayout(new BoxLayout(shapePanel, BoxLayout.Y_AXIS));
        shapePanel.add(new JLabel("x:"));
        shapePanel.add(xField);
        shapePanel.add(new JLabel("y: "));
        shapePanel.add(yField);

        return shapePanel;
    }
    abstract Shape getShape();
}
