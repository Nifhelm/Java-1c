import javax.swing.*;
import java.awt.*;

class Panel extends JPanel {
    int house_x = 150, house_y = 150;

    Panel() {
        Timer nt = new Timer(15, e -> repaint());
        nt.start();
    }

    private void drawHouse(Graphics g, int x, int y, Color color) {
        g.setColor(color);
        g.fillRect(x - 50, y - 50, 100, 100);

        Polygon polygon = new Polygon();
        polygon.addPoint(x - 70, y - 50);
        polygon.addPoint(x + 70, y - 50);
        polygon.addPoint(x, y - 90);
        g.fillPolygon(polygon);



    }

    public void paintComponent(Graphics g) {
        Rectangle canvas = g.getClipBounds();
        g.clearRect(0, 0, canvas.width, canvas.height);
        drawHouse(g, house_x, house_y, Color.RED);


        if (house_x < 750 && house_y == 150) {
                house_x +=5;

        }

        else  {
                house_x -=5;
                house_y +=5;
        }


        if (house_x > 500 && house_y > 200) {
            house_x -=5;
            house_y -=5;
        }
    }
}

class Frame extends JFrame {
    Frame(int width, int height) {
        Panel panel = new Panel();
        Container container = getContentPane();
        container.add(panel);
        setSize(width, height);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}

public class main {
    public static void main(String[] args) {
        Frame window = new Frame(800, 600);
    }
}
