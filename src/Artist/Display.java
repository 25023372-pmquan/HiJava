package Artist;

import art.MyShape;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Display extends JPanel {
    private ArrayList<Shape> shapes;
    public Display(ArrayList<Shape> shapes){
        this.shapes = shapes;
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Shape shape : shapes) {
            shape.draw(g);
        }
    }
}
