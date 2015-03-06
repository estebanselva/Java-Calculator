import java.awt.*;
import javax.swing.*;

public class Calculator extends JPanel {
    private static final long serialVersionUID = 1L; // Java convention

    public static final int WIDTH = 320; // Setting the width of the calculator
    public static final int HEIGHT = 480; // Setting the height of the calculator

    public Calculator() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT)); // Sets size of calculator

        GridBagLayout layout = new GridBagLayout();
        // Setting widths of the grid to 80 because I set the
        // calculator to 320, so I'm splitting them into 4 columns of 80.
        layout.columnWidths = new int[] {80, 80, 80, 80};
        // Setting up row heights to 6 rows of size 80.
        layout.rowHeights = new int[] {80, 80, 80, 80, 80, 80};
        setLayout(layout);

        JButton[] numberButtons = new JButton[10];

        // This will set up the buttons so that JButton[0] in the array will be button 1.
        // JButton[1] will be button 2, and so on.... until all 10 buttons are classified.
        for(int i = 0; i < numberButtons.length; i++) {
            numberButtons[i] = new JButton("" + i);
        }

        GridBagConstraints gbc = new GridBagConstraints(); // Allows us to position our buttons on the screen

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        add(numberButtons[0], gbc);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculator"); // Make a new frame with the name "Calculator"
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // Program will terminate when window is closed.
        frame.setResizable(false);
        frame.setLayout(new BorderLayout()); // This layout allows us to center frame on the screen.
        frame.add(new Calculator(), BorderLayout.CENTER);
        frame.pack(); // Set size of frame to the size of the panel.
        frame.setLocationRelativeTo(null); // Will center frame on the screen.
        frame.setVisible(true);
    }
}



