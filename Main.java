import javax.swing.JFrame;

public class Main extends JFrame {
    public static void main(String[] args) {
               
        MyPanel panel = new MyPanel();
        JFrame frame = new JFrame("Solar Bodies");
        frame.add(panel);
        frame.pack();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
