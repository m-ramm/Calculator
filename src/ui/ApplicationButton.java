package ui;

import calculator.Application;

import javax.swing.*;
import java.awt.*;

public class ApplicationButton {

    public JButton button;

    public ApplicationButton(String symbol){
        this.button = new JButton();
        this.button.addActionListener(Application.getInstance());
        this.button.setActionCommand(String.valueOf(symbol));
        this.button.setBackground(Color.ORANGE);
        this.button.setText(String.valueOf(symbol));
        this.button.setSize(50,50);
    }

    public JButton getButton(){
        return this.button;
    }
}
