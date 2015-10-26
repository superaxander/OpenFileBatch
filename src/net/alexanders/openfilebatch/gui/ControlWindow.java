package net.alexanders.openfilebatch.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlWindow extends JFrame implements ActionListener
{
    public ControlWindow()
    {
        super();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setContentPane(this);
        this.setTitle("OpenFileBatch");
        this.getContentPane().setLayout(new GridLayout(2,2));
        JButton new_button = new JButton("New");
                new_button.setActionCommand("New");
                new_button.addActionListener(this);
        JButton modify_button = new JButton("Modify");
                modify_button.setActionCommand("Modify");
                modify_button.addActionListener(this);
        JButton run_button = new JButton("Run");
                run_button.setActionCommand("Run");
                run_button.addActionListener(this);
        JButton exit_button = new JButton("Exit");
                exit_button.setActionCommand("Exit");
                exit_button.addActionListener(this);
        this.getContentPane().add(new_button);
        this.getContentPane().add(modify_button);
        this.getContentPane().add(run_button);
        this.getContentPane().add(exit_button);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        switch(e.getActionCommand())
        {
            case "New":
                NewActionWindow actionWindow = new NewActionWindow();
                actionWindow.pack();
                actionWindow.setSize(520, 200);
                actionWindow.setVisible(true);
                break;
            case "Modify":
                break;
            case "Run":
                System.out.println(this.getSize().getHeight() + "," + this.getSize().getWidth());
                break;
            case "Exit":
                System.exit(0);
                break;
            default:
                break;
        }
    }
}
