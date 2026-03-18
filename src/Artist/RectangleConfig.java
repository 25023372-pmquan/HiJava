package Artist;

import javax.swing.*;
import java.awt.*;

public class RectangleConfig extends ShapeConfig {
    private JTextField widthField;
    private JTextField heightField;

    RectangleConfig(){
        drawInitPoint();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        widthField = new JTextField();
        widthField.setMaximumSize(new Dimension(400,20));
        heightField = new JTextField();
        heightField.setMaximumSize(new Dimension(400,20));

        add(new JLabel("Width: "));
        add(widthField);
        add(new JLabel("Height: "));
        add(heightField);
    }


    Shape getShape(){
        Point point = getPoint();
        int w = Integer.parseInt(widthField.getText());
        int h = Integer.parseInt(heightField.getText());
        return (new Rectangle(point.getX(), point.getY() , w, h));
    }

}
