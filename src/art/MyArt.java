package art;

import javax.swing.*;
import java.util.ArrayList;

public class MyArt {
    public static void main(){
        JFrame frame = new JFrame();

        ArrayList<MyShape> shapes = new ArrayList<>();

        // tao List<Shape>
        Point center1 = new Point(100,100);
        Circle circle1 = new Circle(100,center1, "hinhTron1");
        shapes.add(circle1);

        Point point1 = new Point(200, 200);
        Retangle retangle1 = new Retangle(50, 100, point1, "quan");

        shapes.add(retangle1);

        Point center2 = new Point(250, 100);
        Circle circle2 = new Circle(100, center2,"hinhTron2");
        shapes.add(circle2);

        frame.add(new MyWindow(shapes));
        frame.setSize(400,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
