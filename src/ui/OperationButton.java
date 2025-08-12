package ui;

import calculator.Application;
import enums.Operations;

import javax.swing.*;
import java.awt.*;

public class OperationButton {
    public JButton button;

    public OperationButton(String symbol, Operations operationEnum){
        this.button = new JButton();
        this.button.addActionListener(Application.getInstance());
        this.button.setActionCommand(operationEnum.toString());
        this.button.setBackground(Color.LIGHT_GRAY);
        this.button.setText(String.valueOf(symbol));
        this.button.setSize(50,50);
    }

    public JButton getButton(){
        return this.button;
    }
}
