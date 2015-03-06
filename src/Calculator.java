import java.awt.*;
import javax.swing.*;

public class Calculator extends JPanel {
    private static final long serialVersionUID = 1L; // Java convention

    public static final int WIDTH = 320; // Setting the width of the calculator
    public static final int HEIGHT = 480; // Setting the height of the calculator

    private GridBagLayout Layout;
    private GridBagConstraints gbc;

    private JButton[] numberButtons;
    private JButton[] opButtons;

    private JTextField field;

    //This will set all the values into play
    // [0] = gridx, [1] = gridy, [2] = gridwidth, [3] = gridheight
    private int[][] numConstraints = new int[][]{
            {0, 5, 2, 1},
            {0, 4, 1, 1},
            {1, 4, 1, 1},
            {2, 4, 1, 1},
            {0, 3, 1, 1},
            {1, 3, 1, 1},
            {2, 3, 1, 1},
            {0, 2, 1, 1},
            {1, 2, 1, 1},
            {2, 2, 1, 1},
    };

    private int[][] opConstraints = new int[][] {
            {2, 5, 1, 1},
            {3, 4, 1, 2},
            {3, 3, 1, 1},
            {3, 2, 1, 1},
            {3, 1, 1, 1},
            {2, 1, 1, 1},
            {1, 1, 1, 1},
            {0, 1, 1, 1},
    };


    public Calculator() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT)); // Sets size of calculator

        Layout = new GridBagLayout();

        // Setting widths of the grid to 80 because I set the
        // calculator to 320, so I'm splitting them into 4 columns of 80.
        Layout.columnWidths = new int[] {80, 80, 80, 80};

        // Setting up row heights to 6 rows of size 80.
        Layout.rowHeights = new int[] {80, 80, 80, 80, 80, 80};
        setLayout(Layout);

        gbc = new GridBagConstraints();

        numberButtons = new JButton[10];
        // This will set up the buttons so that JButton[0] in the array will be button 1.
        // JButton[1] will be button 2, and so on.... until all 10 buttons are classified.
        for(int i = 0; i < numberButtons.length; i++) {
            numberButtons[i] = new JButton("" + i);

            gbc.gridx = numConstraints[i][0];
            gbc.gridy = numConstraints[i][1];
            gbc.gridwidth = numConstraints[i][2];
            gbc.gridheight = numConstraints[i][3];
            gbc.fill = GridBagConstraints.BOTH;
            gbc.insets = new Insets(2, 2, 2, 2); // This sets 2 pixels worth of padding on all sides of buttons.

            add(numberButtons[i], gbc);
        }

        opButtons = new JButton[8];
        // This is where we add all the operational buttons
        opButtons[0] = new JButton(".");
        opButtons[1] = new JButton("=");
        opButtons[2] = new JButton("+");
        opButtons[3] = new JButton("-");
        opButtons[4] = new JButton("*");
        opButtons[5] = new JButton("/");
        opButtons[6] = new JButton("+/-");
        opButtons[7] = new JButton("C");

        for(int x = 0; x < opButtons.length; x++) {
            gbc.gridx = opConstraints[x][0];
            gbc.gridy = opConstraints[x][1];
            gbc.gridwidth = opConstraints[x][2];
            gbc.gridheight = opConstraints[x][3];

            add(opButtons[x], gbc);
        }

        // This will add the text field above the buttons
        field = new JTextField();
        field.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        field.setEditable(false);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 4;
        gbc.gridheight = 1;

        add(field, gbc);

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



