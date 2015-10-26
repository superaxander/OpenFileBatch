package net.alexanders.openfilebatch.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewActionWindow extends JFrame implements ActionListener
{
    public static final String[] filter_options = {"None", "Starts With", "Ends With", "Contains", "Pattern", "Equals"};
    public static final String[] action_options = {"Move", "Copy", "Delete", "Append", "Prepend", "Search and Replace"};

    public NewActionWindow()
    {
        super();
        this.setTitle("OpenFileBatch-New Action");
        this.getContentPane().setLayout(new GridLayout(4,4));
        JLabel from_label = new JLabel("From:");
        JTextField from_path = new JTextField();
        JLabel to_label = new JLabel("To:");
        JTextField to_path = new JTextField();
        JComboBox<String> filter_combobox = new JComboBox<>(filter_options);
            filter_combobox.setSelectedItem(filter_options[0]);
        JTextField filter_value = new JTextField();
        JLabel overwrite_label = new JLabel("Overwrite:");
        JCheckBox overwrite_checkbox = new JCheckBox();
        JLabel action_label = new JLabel("Action:");
        JComboBox<String> action_combobox = new JComboBox<>(action_options);
            action_combobox.setSelectedItem(action_options[0]);
        JButton save_button = new JButton("Save");
            save_button.setActionCommand("Save");
            save_button.addActionListener(this);
        JButton execute_button = new JButton("Execute");
            execute_button.setActionCommand("Execute");
            execute_button.addActionListener(this);
        JTextField action_value1 = new JTextField();
        JTextField action_value2 = new JTextField();
        JButton cancel_button = new JButton("Cancel");
            cancel_button.setActionCommand("Cancel");
            cancel_button.addActionListener(this);
        JLabel placeholder_label = new JLabel();
        this.getContentPane().add(from_label);
        this.getContentPane().add(from_path);
        this.getContentPane().add(to_label);
        this.getContentPane().add(to_path);
        this.getContentPane().add(filter_combobox);
        this.getContentPane().add(filter_value);
        this.getContentPane().add(overwrite_label);
        this.getContentPane().add(overwrite_checkbox);
        this.getContentPane().add(action_label);
        this.getContentPane().add(action_combobox);
        this.getContentPane().add(save_button);
        this.getContentPane().add(execute_button);
        this.getContentPane().add(action_value1);
        this.getContentPane().add(action_value2);
        this.getContentPane().add(cancel_button);
        this.getContentPane().add(placeholder_label);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {

    }
}
