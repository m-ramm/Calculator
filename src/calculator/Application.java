package calculator;

import calculator.operations.*;
import enums.Operations;
import enums.Status;
import ui.GUI;
import utils.Utils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

public class Application implements ActionListener {
    static Application singleton;

    private GUI ui;
    private Memory memory;
    private Stack num1;
    private Stack num2;
    private Stack operations;
    private String numBuffer;
    private double num1Input;
    private double num2Input;
    private double result;
    private Operation operationInput;
    private Status status;

    private Application(){
//        this.memory = new Memory();
        this.num1 = new Stack();
        this.num2 = new Stack();
        this.operations = new Stack();
        this.numBuffer = "";
        this.status = Status.NUM1;
    }

    public static Application getInstance(){
        if (singleton == null){
            singleton = new Application();
        }
        return singleton;
    }

    public void initialise(){
        this.ui = new GUI(this);
        this.ui.initialise();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        this.handleAction(action);
    }

    public void handleAction(String action) {
        if (Utils.isDouble(action)) {
            if (this.status == Status.NUM1 || this.status == Status.NUM2) {
                this.numBuffer += String.valueOf(action);
                this.ui.setDisplay(this.numBuffer);
            } else if (this.status == Status.OPERATION) {
                this.num1Input = Double.parseDouble(this.numBuffer);
                this.numBuffer = String.valueOf(action);
                this.ui.setDisplay(this.numBuffer);
                this.status = Status.NUM2;
            }
        } else {
            switch(action){
                //? Refactor = as Operation interface
                case "=":
                    if (this.status == Status.NUM2) {
                        this.executeOperation();
                    } else {
                        this.result = Double.parseDouble(this.numBuffer);
                    }
                    this.status = Status.NUM1;
                    break;
                case "C":
                    this.numBuffer = "0";
                    this.ui.setDisplay(this.numBuffer);
                    this.status = Status.NUM1;
                    break;
                default:
                    if (this.status == Status.NUM2) {
                        this.executeOperation();
                    }

                    this.operationInput = this.assignOperation(action);
                    this.status = Status.OPERATION;
                    break;
            }
        }
    }
    private void executeOperation(){
        this.num2Input = Double.parseDouble(this.numBuffer);
        this.result = this.operationInput.execute(this.num1Input, this.num2Input);
        this.numBuffer = String.valueOf(this.result);
        this.ui.setDisplay(this.numBuffer);
        this.num1Input = Double.parseDouble(this.numBuffer);
    }
    private Operation assignOperation(String symbol) {
        Operation operation = new Add();
//        switch(symbol) {
//            //TODO refactor "+" etc. to be enum (need to change setAction in OperationButton)
//            case "+":
//                operation = new Add();
//                break;
//            case "-":
//                operation = new Subtract();
//                break;
//            case "/":
//                operation = new Divide();
//                break;
//            case "x":
//                operation = new Multiply();
//                break;
//            case "ROOT":
//                operation = new Root();
//                break;
//            case "POW":
//                operation = new Power();
//                break;
//        }
        if (symbol.equals(Operations.Add.toString())) {
            operation = new Add();
        } else if (symbol.equals(Operations.Subtract.toString())){
            operation = new Subtract();
        } else if (symbol.equals(Operations.Multiply.toString())){
            operation = new Multiply();
        } else if (symbol.equals(Operations.Divide.toString())){
            operation = new Divide();
        } else if (symbol.equals(Operations.Power.toString())){
            operation = new Power();
        } else if (symbol.equals(Operations.Root.toString())){
            operation = new Root();
        }
        return operation;


    }
}
