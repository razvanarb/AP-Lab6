package Lab6.Compulsory;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * The configuration panel where the parameters regarding the shapes that will be drawn stand.
 */

public class ConfigurationPanel extends JPanel {

    private Integer[] sidesNr = {0, 3, 4, 5, 6, 7, 8};
    JLabel sizeLabel = new JLabel("Size: ");
    JLabel sidesNrLabel = new JLabel("Number of sides: ");
    JLabel strokeLabel = new JLabel("Stroke size:");
    JTextField sizeTF = new JTextField(10);
    JComboBox sidesNrV = new JComboBox(sidesNr);
    JTextField strokeTF = new JTextField(10);

    public ConfigurationPanel(MainFrame frame) {
        this.setBorder(BorderFactory.createTitledBorder("Configuration Panel"));
        init();
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 25, 10));
    }

    private void init() {
        add(sizeLabel);
        add(sizeTF);
        sizeTF.setText("5");
        add(strokeLabel);
        add(strokeTF);
        strokeTF.setText("5");
        add(sidesNrLabel);
        add(sidesNrV);
        sidesNrV.setSelectedIndex(2);
    }
}
