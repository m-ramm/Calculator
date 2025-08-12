package ui;

import calculator.Application;

import javax.swing.*;
import java.awt.*;

public class NumberButton {
    public JButton button;

    public NumberButton(int number) {
        this.button = new JButton();
        this.button.addActionListener(Application.getInstance());
        this.button.setActionCommand(String.valueOf(number));
        this.button.setBackground(Color.WHITE);
        this.button.setText(String.valueOf(number));
        this.button.setSize(50,50);
    }

    public JButton getButton(){
        return this.button;
    }
}
