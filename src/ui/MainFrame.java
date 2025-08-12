package ui;
import javax.swing.*;
import java.awt.*;


public class MainFrame {
    private JFrame mainframe;

    public MainFrame() {
        this.mainframe = new JFrame();
        this.mainframe.setTitle("Calculator");
        this.mainframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.mainframe.setSize(900, 900);
        this.mainframe.setPreferredSize(new Dimension(800, 500));
        this.mainframe.setLocationRelativeTo(null);     // center frame
    }
    public JFrame getMainframe(){
        return this.mainframe;
    }
    public void initialise() {
        this.mainframe.setVisible(true);
    }

}
