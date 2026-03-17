package Artist;

import javax.swing.*;
import java.awt.*;

public class RectangleConfig extends ShapeConfig {
    private JTextField widthField;
    private JTextField heightField;
    JPanel createConfig(){

        JPanel rectanglePanel = new JPanel();
        rectanglePanel.setLayout(new BoxLayout(rectanglePanel, BoxLayout.Y_AXIS));
        rectanglePanel.add(super.createConfig());
        widthField = new JTextField();
        widthField.setMaximumSize(new Dimension(400,20));
        heightField = new JTextField();
        heightField.setMaximumSize(new Dimension(400,20));

        rectanglePanel.add(new JLabel("Width: "));
        rectanglePanel.add(widthField);
        rectanglePanel.add(new JLabel("Height: "));
        rectanglePanel.add(heightField);
        return rectanglePanel;
    }
    Shape getShape(){
        int x = Integer.parseInt(xField.getText());
        int y = Integer.parseInt(yField.getText());
        int w = Integer.parseInt(widthField.getText());
        int h = Integer.parseInt(heightField.getText());
        return (new Rectangle(x, y , w, h));
    }

}
