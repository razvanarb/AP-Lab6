package Lab6.Compulsory;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
/**
 * The control panel for managing the image being created.
 */
public class ControlPanel extends JPanel {

    JButton loadButton = new JButton("Load");
    JButton saveButton = new JButton("Save");
    JButton resetButton = new JButton("Reset");
    JButton exitButton = new JButton("Exit");

    public ControlPanel(MainFrame frame) {

        this.setBorder(BorderFactory.createTitledBorder("Control Panel"));
        init();
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 25, 10));
    }

    private void init() {
        add(loadButton);
        add(saveButton);
        add(resetButton);
        add(exitButton);
    }
}

