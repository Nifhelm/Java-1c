import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;


class  Krug {
     int x, y;



     Image sprite;

     public Krug(int x, int y) throws IOException {
         sprite = ImageIO.read(new java.io.File("C:\\Users\\user\\Desktop\\08bf4fc519daedce69e0cda9a7b1414a.jpg"));
         this.x = x;
         this.y = y;
     }


     void move(Rectangle boundaries) {
         if (x < boundaries.width && y <  boundaries.height ) {
             x += 5;

         } else {
             x -= 5;
             y += 5;
         }

         if (x > boundaries.width && y > boundaries.height) {
             x -= 5;
         }
     }

     void draw(Graphics g) {
         g.drawImage(sprite, x ,y , 100, 100, null);
     }
 }

class Boat {
    int x, y;

    Image sprite;

    public Boat(int x, int y) throws IOException {
        this.x = x;
        this.y = y;
        sprite = ImageIO.read(new java.io.File("C:\\Users\\user\\Desktop\\img5.jpg"));
    }

    void processKey(int currentKeyCode) {

        if (currentKeyCode == KeyEvent.VK_UP) {
            y -=3;
        } else if (currentKeyCode == KeyEvent.VK_DOWN) {
            y +=3;
        } else  {

        }
    }

    void draw(Graphics g) {
        g.drawImage(sprite, x ,y , 4, 100, null);
    }
}

class Boat2 {
    int x, y;

    Image sprite;

    public Boat2(int x, int y) throws IOException {
        this.x = x;
        this.y = y;
        sprite = ImageIO.read(new java.io.File("C:\\Users\\user\\Desktop\\img5.jpg"));
    }


    void processKey(int currentKeyCode) {

        if (currentKeyCode == KeyEvent.VK_NUMPAD8) {
            y -=3;
        } else if (currentKeyCode == KeyEvent.VK_NUMPAD5) {
            y +=3;
        }


    }

    void draw(Graphics g) {
        g.drawImage(sprite, x ,y , 4, 100, null);

    }
}

class Panel extends JPanel {
    Boat boat;
    Boat2 boat2;
    Krug krug;



    Panel() throws IOException {
        Timer nt = new Timer(10, e -> repaint());
        nt.start();

        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                int currentKeyCode = e.getKeyCode();
                if (currentKeyCode == KeyEvent.VK_NUMPAD8) {
                    boat2.y -=3;
                } else if (currentKeyCode == KeyEvent.VK_NUMPAD5) {
                    boat2.y +=3;
                } else  {

                }


                if (currentKeyCode == KeyEvent.VK_UP) {
                    boat.y -=3;
                } else if (currentKeyCode == KeyEvent.VK_DOWN) {
                    boat.y +=3;
                } else  {

                }
            }


           @Override
            public void keyReleased(KeyEvent e) {
//                currentKeyCode = 0;
            }
        });

        setFocusable(true);
        boat = new Boat(2, 2);
        boat2 = new Boat2(770, 0);
        krug = new Krug(80, 80);


    }



    public void paintComponent(Graphics g) {
        Rectangle canvas = g.getClipBounds();
        g.clearRect(0, 0, canvas.width, canvas.height);
        krug.move(canvas);

        boat.draw(g);
        boat2.draw(g);
        krug.draw(g);
    }
}

class Frame extends JFrame {
    Frame(int width, int height) throws IOException {
        Panel panel = new Panel();
        Container container = getContentPane();
        container.add(panel);
        setSize(width, height);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}


public class Main {
    public static void main(String[] args) throws IOException {
        new Frame(800, 600);
    }
}
