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


        CircleConfig circleConfig = new CircleConfig();
        JPanel circlePanel = circleConfig.createConfig();
        RectangleConfig rectangleConfig = new RectangleConfig();
        JPanel rectanglePanel = rectangleConfig.createConfig();

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
                            Shape circle = circleConfig.getShape();
                            shapes.add(circle);
                    }catch (NumberFormatException exception){
                        resultLabel.setText("only number, please!");
                        leftPanel.add(resultLabel);
                    }

                } else if (currentShapeType == ShapeType.RECTANGLE) {
                    try {
                        Shape rectangle = rectangleConfig.getShape();
                        shapes.add(rectangle);
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
