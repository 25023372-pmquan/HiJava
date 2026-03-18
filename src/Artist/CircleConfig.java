package Artist;

import javax.swing.*;
import java.awt.*;

public class CircleConfig extends ShapeConfig {
    private JTextField radiusField;

    CircleConfig(){
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        drawInitPoint();
        radiusField = new JTextField();
        radiusField.setMaximumSize(new Dimension(400,20));
        add(new JLabel("Radius:"));
        add(radiusField);
    }


    @Override
    Shape getShape(){
        Point point = getPoint();
        int r = Integer.parseInt(radiusField.getText());
        return (new Circle(point.getX(),point.getY(),r));
    }
}
