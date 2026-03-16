package Artist;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ArtistApp {
    static ShapeType currentShapeType;
    static void main() {
        JFrame frame = new JFrame("Artist App");
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(1,2));
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        leftPanel.add(new JLabel("select shape:"));
        JLabel resultLabel = new JLabel();

        CardLayout cardLayout = new CardLayout();
        JPanel textFieldPanel = new JPanel(cardLayout);

        JTextField circleXfield = new JTextField();
        circleXfield.setMaximumSize(new Dimension(400,20));
        JTextField circleYfield = new JTextField();
        circleYfield.setMaximumSize(new Dimension(400,20));
        JTextField radiusField = new JTextField();
        radiusField.setMaximumSize(new Dimension(400,20));
        JPanel circlePanel = new JPanel();
        circlePanel.setLayout(new BoxLayout(circlePanel, BoxLayout.Y_AXIS));
        circlePanel.add(new JLabel("x:"));
        circlePanel.add(circleXfield);
        circlePanel.add(new JLabel("y:"));
        circlePanel.add(circleYfield);
        circlePanel.add(new JLabel("Radius:"));
        circlePanel.add(radiusField);

        JTextField rectangleXfield = new JTextField();
        rectangleXfield.setMaximumSize(new Dimension(400,20));
        JTextField rectangleYfield = new JTextField();
        rectangleYfield.setMaximumSize(new Dimension(400,20));
        JTextField widthField = new JTextField();
        widthField.setMaximumSize(new Dimension(400,20));
        JTextField heightField = new JTextField();
        heightField.setMaximumSize(new Dimension(400,20));
        JPanel rectanglePanel = new JPanel();
        rectanglePanel.setLayout(new BoxLayout(rectanglePanel, BoxLayout.Y_AXIS));
        rectanglePanel.add(new JLabel("x:"));
        rectanglePanel.add(rectangleXfield);
        rectanglePanel.add(new JLabel("y:"));
        rectanglePanel.add(rectangleYfield);
        rectanglePanel.add(new JLabel("Width: "));
        rectanglePanel.add(widthField);
        rectanglePanel.add(new JLabel("Height: "));
        rectanglePanel.add(heightField);

        textFieldPanel.add(circlePanel,"circle");
        textFieldPanel.add(rectanglePanel,"rectangle");

        ButtonGroup buttonGroup = new ButtonGroup();
        ShapeType[] shapeTypes = ShapeType.values();
        for(ShapeType shapeType : shapeTypes){
            JRadioButton radioButton = new JRadioButton(shapeType.getShapeName());

            radioButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    resultLabel.setText("");
                    leftPanel.add(resultLabel);
                    currentShapeType = shapeType;
                    cardLayout.show(textFieldPanel, shapeType.getShapeName());
                }
            });

            buttonGroup.add(radioButton);
            leftPanel.add(radioButton);
        }

        leftPanel.add(textFieldPanel);
        JButton drawButton = new JButton("Draw");
        leftPanel.add(drawButton);


        ArrayList<Shape> shapes = new ArrayList<>();
        Display display = new Display(shapes);
        rightPanel.add(display);
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultLabel.setText("");
                leftPanel.add(resultLabel);
                if(currentShapeType == ShapeType.CIRCLE){
                    try {
                        int x = Integer.parseInt(circleXfield.getText());
                        int y = Integer.parseInt(circleYfield.getText());
                        int radius = Integer.parseInt(radiusField.getText());
                        shapes.add(new Circle(x, y ,radius));
                    }catch (NumberFormatException exception){
                        resultLabel.setText("only number, please!");
                        leftPanel.add(resultLabel);
                    }

                } else if (currentShapeType == ShapeType.RECTANGLE) {
                    try {
                        int x = Integer.parseInt(rectangleXfield.getText());
                        int y = Integer.parseInt(rectangleYfield.getText());
                        int width = Integer.parseInt(widthField.getText());
                        int height = Integer.parseInt((heightField.getText()));
                        shapes.add(new Rectangle(x, y, width, height));
                    }catch (NumberFormatException exception){
                        resultLabel.setText("only number, please!");
                        leftPanel.add(resultLabel);
                    }
                }
                display.repaint();
            }
        };
        drawButton.addActionListener(listener);

        frame.setSize(600,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainPanel.add(leftPanel);
        mainPanel.add((rightPanel));
        frame.add(mainPanel);
        frame.setVisible(true);

    }
}
