package Artist;

import javax.swing.*;
import java.awt.*;

public class CircleConfig extends ShapeConfig {
    private JTextField radiusField;
    JPanel createConfig(){
        JPanel circlePanel = new JPanel();
        circlePanel.setLayout(new BoxLayout(circlePanel, BoxLayout.Y_AXIS));
        circlePanel.add(super.createConfig());
        radiusField = new JTextField();
        radiusField.setMaximumSize(new Dimension(400,20));
        circlePanel.add(new JLabel("Radius:"));
        circlePanel.add(radiusField);
        return circlePanel;
    }
    @Override
    Shape getShape(){
        int x = Integer.parseInt(xField.getText());
        int y = Integer.parseInt(yField.getText());
        int r = Integer.parseInt(radiusField.getText());
        return (new Circle(x,y,r));
    }
}
