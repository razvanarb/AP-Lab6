package Lab6.Compulsory;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * The main frame of the app.
 */

public class MainFrame extends JFrame {

    static ConfigurationPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel drawingPanel;

    public MainFrame() {
        super("BRA Lab6 Application");
        init();
    }

    private void init() {
        /**
         * Initializes all the elements of the app including the buttons from the control panel
         */
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        configPanel = new ConfigurationPanel(this);
        controlPanel = new ControlPanel(this);
        drawingPanel = new DrawingPanel(this);
        add(configPanel, BorderLayout.NORTH);
        add(controlPanel, BorderLayout.SOUTH);
        add(drawingPanel, BorderLayout.CENTER);
        controlPanel.resetButton.addActionListener(actionListener);
        controlPanel.saveButton.addActionListener(actionListener);
        controlPanel.loadButton.addActionListener(actionListener);

    }
    /**
     * Actionlistener for all the buttons from the app.
     */
    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == controlPanel.exitButton)
                System.exit(0);
            else {
                if (e.getSource() == controlPanel.resetButton) {
                    drawingPanel.clear();
                } else if (e.getSource() == controlPanel.loadButton) {
                    try {
                        load();
                    } catch (IOException e1) {
                        System.out.println("Fisierul nu exista sau formatul nu este bun.");
                    }
                } else if (e.getSource() == controlPanel.saveButton) {
                    try {
                        save();
                    } catch (IOException e1) {
                        System.out.println("Destinatia nu exista.");
                    }
                }
            }
        }
    };
    /**
     *  The save function and load function of a previous saved "canvas"
     */
    public void save() throws IOException {
        ImageIO.write(drawingPanel.getImage(), "PNG", new File("lab6.png"));
    }

    public void load() throws IOException {
        drawingPanel.setImage(ImageIO.read(new File("lab6.png")));
    }

}
