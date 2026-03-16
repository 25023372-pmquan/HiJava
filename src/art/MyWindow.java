package art;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MyWindow extends JPanel {

    private final ArrayList<MyShape> shapes;


    public MyWindow(ArrayList<MyShape> shapes){
        this.shapes = shapes;
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (MyShape shape : shapes) {
            shape.draw(g);
        }
    }
}
