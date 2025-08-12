package ui;

import calculator.Application;
import calculator.operations.Operation;
import enums.Operations;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ButtonPanel {
    private JPanel panel;

    private final String[] operationsList = {"+","-","x","/","ROOT","POW"};
    private final Operations[] operationEnumList = {Operations.Add,Operations.Subtract,Operations.Multiply,Operations.Divide,Operations.Root,Operations.Power};
    private final String[] applicationOperationsList = {"C"};

    private ArrayList<NumberButton> numberButtons;
    private ArrayList<OperationButton> operationButtons;
    private ArrayList<ApplicationButton> applicationButtons;
    private ApplicationButton equalsButton;

    public ButtonPanel(){
        this.panel = new JPanel();
        this.panel.setLayout(new GridBagLayout());
        this.numberButtons = new ArrayList<>();
        this.operationButtons = new ArrayList<>();
        this.applicationButtons = new ArrayList<>();
        this.equalsButton = new ApplicationButton("=");
        this.buildButtons();
    }

    public JPanel getButtonPanel(){
        return this.panel;
    }

    private void buildButtons(){
        GridBagConstraints gbc = new GridBagConstraints();

        // Operator Buttons
        gbc.gridx = 3;
        gbc.gridy = 3;
        for (int i=0; i<operationsList.length; i++) {
            gbc.fill = GridBagConstraints.HORIZONTAL;
            OperationButton newButton = new OperationButton(operationsList[i],operationEnumList[i]);
            this.operationButtons.add(newButton);
            this.panel.add(newButton.getButton(),gbc);
            if (gbc.gridy > 0){
                gbc.gridy--;
            } else {
                //FIXME if need to add more operations, will need to adjust how x wraps back up a row
                gbc.gridx--;
            }
        }

        // Application Buttons
        for (int i=0; i<applicationOperationsList.length; i++) {
            gbc.fill = GridBagConstraints.HORIZONTAL;
            ApplicationButton newButton = new ApplicationButton(applicationOperationsList[i]);
            this.applicationButtons.add(newButton);
            this.panel.add(newButton.getButton(),gbc);
        }

        // Equals Button
        gbc.gridx = 3;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.panel.add(equalsButton.getButton(),gbc);

        // Number Buttons
        for (int i=0; i<=9; i++) {
            if (i == 0) {
                gbc.gridx = 1;
                gbc.gridy = 4;
            } else {
                gbc.gridx = (i-1) % 3;
                gbc.gridy = 3 - Math.floorDiv(i-1,3);
            }
            gbc.fill = GridBagConstraints.HORIZONTAL;
            NumberButton newButton = new NumberButton(i);
            this.numberButtons.add(newButton);
            this.panel.add(newButton.getButton(),gbc);
        }
    }
}
