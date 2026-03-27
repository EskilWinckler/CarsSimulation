import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class View extends JPanel {
    // Fönsterinställningar
    static int windowWidth; //default from AI slop: 1200
    static int windowHeight; // default from AI slop: 800

    // Enkel bil-modell för visualisering (flyttas till egen klass senare)
    static double carX = 100;
    static double carY = 100;
    static double carAngle = 0;

    public View(int windowWidth, int windowHeight, Color colour) {
        this.setPreferredSize(new Dimension(windowWidth, windowHeight));
        this.setBackground(colour); // Gräsmatta (Forest Green)
    }

    @Override
    protected void paintComponent(Graphics g) {
        // render function
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        drawTrack(g2d);
        drawCar(g2d, carX, carY, carAngle);
        int[] color = {255, 0, 0};
        Racecar racecar = new Racecar(new int[]{255,255,0}, 1, 2,3.14, new int[]{100, 100}, 1, new int[]{40,20});
        drawVehicle(g2d, racecar);
        drawUI(g2d);
        drawPoint(g2d);
    }

    private void drawTrack(Graphics2D g) {
        // Rita asfaltsbanan (en enkel oval som start)
        g.setColor(new Color(60, 60, 60)); // Asfaltgrå
        g.setStroke(new BasicStroke(80, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        g.drawOval(100, 100, 1000, 500);

        // Rita mittlinje (streckad)
        g.setColor(Color.WHITE);
        float[] dash = {20f, 20f};
        g.setStroke(new BasicStroke(2, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash, 0.0f));
        g.drawOval(100, 100, 1000, 500);

        // Pit stop område
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(500, 550, 200, 60);
        g.setColor(Color.BLACK);
        g.drawRect(500, 550, 200, 60);
        g.drawString("PIT STOP", 575, 585);
    }

    private void drawVehicle(Graphics2D g, Vehicle vehicle) {
        // rewrite from AI code to draw vehicle objects
        // draw at these coordinates
        g.translate(vehicle.getCoordinates()[0], vehicle.getCoordinates()[1]);
        g.rotate(vehicle.getFacingAngleRad());
        //create color object from color information in vehicle, could alternatively store Color object in Vehicle object TODO
        Color color = new Color(vehicle.getColour()[0], vehicle.getColour()[1], vehicle.getColour()[2]);
        // set colour for drawing
        g.setColor(color);
        // draws the rect centered at the provided coordinates
        g.fillRect(-vehicle.getDimensions()[0]/2, -vehicle.getDimensions()[1]/2, vehicle.getDimensions()[0], vehicle.getDimensions()[1]);
        // I think this resets the drawing angles?
        g.rotate(-vehicle.getFacingAngleRad());
        g.translate(-vehicle.getCoordinates()[0], -vehicle.getDimensions()[1]);
    }
    private void drawCar(Graphics2D g, double x, double y, double angle) {
        g.translate(x, y);
        g.rotate(Math.toRadians(angle));

        // Bilkropp
        g.setColor(Color.RED);
        g.fillRect(-20, -10, 40, 20);

        // Framljus för att se riktning
        g.setColor(Color.YELLOW);
        g.fillRect(15, -10, 5, 5);
        g.fillRect(15, 5, 5, 5);

        g.rotate(-Math.toRadians(angle));
        g.translate(-x, -y);
    }

    private void drawPoint(Graphics2D g) {
        g.setColor(Color.MAGENTA);
        g.fillOval(90,350, 10, 10);
        g.fillOval(600,100, 10, 10);
        g.fillOval(1110,350, 10, 10);
        g.fillOval(600,600, 10, 10);
    }

    private void drawUI(Graphics2D g) {
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 14));
        g.drawString("Race Simulation v0.1", 20, 30);
        g.drawString("Underlag: Asfalt", 20, 50);
    }

    public static void update() {
        // Här läggs fysikberäkningar senare
        // Just nu: bara lite snurr för att se att det lever
        carAngle += 1;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Racing Simulator");
        View gameView = new View(1200, 800, new Color(30, 120, 30));

        frame.add(gameView);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // Simulation Loop
        while (true) {
            long startTime = System.currentTimeMillis();

            update();
            gameView.repaint();

            // Framerate-oberoende (mål: ~60 FPS)
            long duration = System.currentTimeMillis() - startTime;
            long sleepTime = Math.max(2, 16 - duration);
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}