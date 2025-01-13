import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.Timer;

public class MyPanel extends JPanel {
    public static final int windowWidth = 800;
    public static final int windowHeight = 800;

    private final List<SolarBody> bodies = new ArrayList<>();

    public MyPanel() {
        this.setPreferredSize(new Dimension(windowWidth, windowHeight));
        this.setBackground(Color.BLACK);
        
        SolarBody sun = new SolarBody(0, 0, 35, 1.98892e30, Color.YELLOW);
        bodies.add(sun);

        SolarBody earth = new SolarBody(1 * sun.getAU(), 0, 16, 5.9742e24, Color.BLUE);
        earth.setVelocityY(29.783 * 1000);
        bodies.add(earth);

        SolarBody mars =new SolarBody(1.524 * sun.getAU(), 0, 12, 6.39e23, Color.RED);
        mars.setVelocityY(24.077 * 1000);
        bodies.add(mars);

        SolarBody mercury = new SolarBody(0.387 * sun.getAU(), 0, 8, 3.30e23, Color.DARK_GRAY);
        mercury.setVelocityY(-47.4 * 1000);
        bodies.add(mercury);

        SolarBody venus = new SolarBody(0.723 * sun.getAU(), 0, 14, 4.867e24, Color.WHITE);
        venus.setVelocityY(-35.02 * 1000);
        bodies.add(venus);

        Timer timer = new Timer(16, e -> {
            for (SolarBody body : bodies) {
                body.updatePosition(bodies);
            }
            repaint();
            Toolkit.getDefaultToolkit().sync();
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (SolarBody body : bodies) {
            body.draw(g);
        }
    }
}
