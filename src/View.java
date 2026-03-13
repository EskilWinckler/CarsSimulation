import javax.swing.*;
import java.awt.*;

public class View extends JPanel {
    static boolean startup = true;
    static int windowWidth = 1200;
    static int windowHeight = 640;
    static void update() {
    }

    @Override
    protected void paintComponent (Graphics g) {
        super.paintComponent(g);
        setBackground(new Color(255, 245, 158, 184)); //  // Set the background color to light yellow

        g.setColor(Color.DARK_GRAY); // Set the color for the border lines
        g.drawRect(500, 0, 600, getHeight() - 5);
        //g.drawRect(800, 0, getWidth() - 5, getHeight() - 5);
        g.setColor(Color.BLACK);
        g.drawRect(500, 0, 695, getHeight() - 5);

        // Draw kitchen door
        g.setColor(Color.DARK_GRAY);
        g.fillRect(490, 270, 20, 100);
        g.fillRect(1090, 270, 20, 100);

        // Draw master chef office
        g.setColor(new Color(93, 191, 73, 255));
        g.fillRect(410, 200, 60, 200);

        // Draw the master chef
        g.setColor(Color.WHITE);
        g.fillOval(415, 270, 50, 50);
        // g.fillOval(mChef.getX(), mChef.getY(), mChef.getDiamter(), mChef.getDiamter());

        // Draw the chefs' workplaces
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0, 0, 50, 150); // Prepchef
        g.fillRect(50, 0, 100, 50);
        g.fillRect(350, 50, 100, 100); // Garde Manger
        g.fillRect(450, 445, 50, 150); // Patissier
        g.fillRect(50, 300, 75, 200); // Sous chef


    }

    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("Restuarant Simulation");
        frame.setSize(windowWidth, windowHeight); // Set window size
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        // Add the custom panel (with circles) to the frame
        JPanel panel = new JPanel();
        frame.add(panel);

        // Display the window
        frame.setVisible(true);

        // Setup for the restaurant

        while (true) {
            try {
                Thread.sleep(33); // With the goal of having about 30 fps.
            } catch (Exception threadException) {
                System.out.println("Sleep exception: " + threadException.getMessage());
            }
            update();
            panel.repaint();
        }
    }

}

