package ui;

import javax.swing.*;
import java.awt.*;

public class DisplayPanel {

    JPanel displayPanel;
    JLabel numberLabel;

    public DisplayPanel() {
        this.displayPanel = new JPanel();
        this.displayPanel.setLayout(new FlowLayout());
        this.numberLabel = new JLabel("0");
        this.displayPanel.add(this.numberLabel);
        this.displayPanel.setVisible(true);
    }
    public JPanel getDisplayPanel(){
        return this.displayPanel;
    }
    public void setNumberDisplay(String numberString){
        this.numberLabel.setText(numberString);
        this.displayPanel.repaint();
    }
}
