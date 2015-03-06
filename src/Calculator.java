import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Calculator extends JPanel {
    private static final long serialVersionUID = 1L; // Java convention

    public static final int WIDTH = 320; // Setting the width of the calculator
    public static final int HEIGHT = 480; // Setting the height of the calculator

    public Calculator() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT)); // Sets size of calculator
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculator"); // Make a new frame with the name "Calculator"
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Program will terminate when window is closed.
        frame.setResizable(false);
        frame.setLayout(new BorderLayout()); // This layout allows us to center frame on the screen.
        frame.add(new Calculator(), BorderLayout.CENTER);
        frame.pack(); // Set size of frame to the size of the panel.
        frame.setLocationRelativeTo(null); // Will center frame on the screen.
        frame.setVisible(true);
    }
}



