package ui;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.Hashtable;

import javax.swing.*;

import calculator.Application;

public class GUI {
    Application application;
    MainFrame mainframe;
    ButtonPanel buttonPanel;
    DisplayPanel displayPanel;

    private final int[] numberList = {1,2,3,4,5,6,7,8,9,0};


    public GUI(Application application){
        this.application = application;
        this.buttonPanel = new ButtonPanel();
        this.displayPanel = new DisplayPanel();
        this.mainframe = new MainFrame();
        this.mainframe.getMainframe().getContentPane().setLayout(new BoxLayout(this.mainframe.getMainframe().getContentPane(), BoxLayout.Y_AXIS));
        this.mainframe.getMainframe().add(this.displayPanel.getDisplayPanel());
        this.mainframe.getMainframe().add(this.buttonPanel.getButtonPanel());
        this.mainframe.getMainframe().pack();


    }
    public void initialise() {
        this.mainframe.initialise();
    }

    public void setDisplay(String value) { this.displayPanel.setNumberDisplay(value);}
}
