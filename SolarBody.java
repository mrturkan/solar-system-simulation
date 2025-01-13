import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;

public class SolarBody {
    private double positionX;
    private double positionY;
    private final double mass;
    private final int radius;
    private final Color color;
    private double velocityX;
    private double velocityY;

    private final double AU = 149.6e9;

    public SolarBody(double positionX, double positionY, int radius, double mass, Color color) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.velocityX = 0.0;
        this.velocityY = 0.0;
        this.mass = mass;
        this.radius = radius;
        this.color = color;
    }
    
    // Calculate the attraction forces between bodies, using the Newton's Law of Universal Gravitation
    public double[] calculateAttraction(SolarBody otherBody) {
        double distanceX = otherBody.getPositionX() - positionX;
        double distanceY = otherBody.getPositionY() - positionY;
        double distance = Math.sqrt(distanceX*distanceX + distanceY*distanceY);

        // Avoid division by zero.
        if (distance == 0) {
            return new double[]{0.0, 0.0};
        }

        // Constants
        double g = 6.67430e-11;
        double attractionForce = g *mass*otherBody.getMass() / (distance*distance);
        double angleTheta = Math.atan2(distanceY, distanceX);
        double attractionForceX = attractionForce * Math.cos(angleTheta);
        double attractionForceY = attractionForce * Math.sin(angleTheta);

        return new double[]{attractionForceX, attractionForceY};
    }

    public void updatePosition(List<SolarBody> otherBodies) {
        double attractionForceXtotal = 0;
        double attractionForceYtotal = 0;

        for (SolarBody body : otherBodies) {
            if (body == this) {
                continue;
            }

            double[] forces = calculateAttraction(body);
            attractionForceXtotal += forces[0];
            attractionForceYtotal += forces[1];
        }

        double TIMESTEP = 3600 * 24;
        this.velocityX += (attractionForceXtotal/mass)* TIMESTEP;
        this.velocityY += (attractionForceYtotal/mass)* TIMESTEP;

        this.positionX += velocityX* TIMESTEP;
        this.positionY += velocityY* TIMESTEP;
    }

    public void draw(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        g2D.setColor(color);

        double SCALE = 250 / AU;
        int x = (int) (positionX * SCALE + (double) MyPanel.windowWidth /2);
        int y = (int) (positionY * SCALE + (double) MyPanel.windowHeight /2);

        g2D.fillOval(x - radius/2, y - radius/2, radius, radius);
    }

    // Getters
    public double getPositionX() {
        return positionX;
    }

    public double getPositionY() {
        return positionY;
    }

    public double getMass() {
        return mass;
    }

    public double getAU() {
        return AU;
    }

    // Setters
    public void setVelocityY(double velocityY) {
        this.velocityY = velocityY;
    }
}
