package Lab6.Compulsory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * The drawing panel "the canvas" where the image is being created.
 */

public class DrawingPanel extends JPanel {

    final MainFrame frame;

    BufferedImage image;
    Graphics2D graphics;
    private int currentMouseX, currentMouseY;

    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        setDoubleBuffered(false);
        this.setBorder(BorderFactory.createTitledBorder("Drawing paper:"));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                currentMouseX = e.getX();
                currentMouseY = e.getY();
                if (graphics != null) {
                    int size = Integer.parseInt(MainFrame.configPanel.sizeTF.getText());
                    int sides = Integer.valueOf((Integer) MainFrame.configPanel.sidesNrV.getSelectedItem());
                    drawShapeAt(currentMouseX, currentMouseY, size, sides);
                    repaint();
                }
            }
        });
    }


    protected void paintComponent(Graphics graphic) {
        if (image == null) {
            image = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
            graphics = image.createGraphics();
            graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            clear();
        }
        graphic.drawImage(image, 0, 0, null);
    }

    public void clear() {
        graphics.setPaint(Color.white);
        graphics.fillRect(0, 0, getSize().width, getSize().height);
        graphics.setPaint(Color.black);
        repaint();
    }

    public void drawShapeAt(int x, int y, int size, int sides) {
        Random rand = new Random();
        graphics.setColor(new Color(rand.nextInt(0xFFFFFF)));
        if (sides != 0)
            graphics.fillPolygon(new RegularPolygon(x, y, size, sides));
        else
            graphics.fillOval(x - (size / 2), y - (size / 2), size, size);
    }

    public void drawShapeRandom(int repeatNo, int sides) {
        while (repeatNo > 0) {
            Random rand = new Random();
            graphics.setColor(new Color(rand.nextInt(0xFFFFFF)));
            int random_x = rand.nextInt(getWidth() - 5);
            int random_y = rand.nextInt(getHeight() - 20);
            int random_radius = rand.nextInt(18 - 5) + 6;
            int random_circle_radius = rand.nextInt(50 - 5) + 6;
            if (sides != 0)
                graphics.fillPolygon(new RegularPolygon(random_x, random_y, random_radius, sides));
            else
                graphics.fillOval(random_x, random_y, random_circle_radius, random_circle_radius);
            repeatNo--;
        }
    }

    public class RegularPolygon extends Polygon {
        public RegularPolygon(int x0, int y0, int radius, int sides) {
            double alpha = 2 * Math.PI / sides;
            for (int i = 0; i < sides; i++) {
                double x = x0 + radius * Math.cos(alpha * i);
                double y = y0 + radius * Math.sin(alpha * i);
                this.addPoint((int) x, (int) y);
            }
        }
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
        graphics = image.createGraphics();
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    }
}
