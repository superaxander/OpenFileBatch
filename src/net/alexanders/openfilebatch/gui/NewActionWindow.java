package net.alexanders.openfilebatch.gui;

import net.alexanders.openfilebatch.*;
import net.alexanders.openfilebatch.Action;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;

public class NewActionWindow extends JFrame implements ActionListener, ItemListener {
    public static final String[] filter_options = {"None", "Starts With", "Ends With", "Contains", "Pattern", "Equals"};
    public static final String[] action_options = {"Move", "Copy", "Delete", "Append", "Prepend", "Search Replace"};
    private JLabel from_label;
    private JTextField from_path;
    private JLabel to_label;
    private JTextField to_path;
    private JComboBox<String> filter_combobox;
    private JTextField filter_value;
    private JLabel overwrite_label;
    private JCheckBox overwrite_checkbox;
    private JLabel action_label;
    private JComboBox<String> action_combobox;
    private JButton save_button;
    private JButton execute_button;
    private JTextField action_value1;
    private JTextField action_value2;
    private JButton cancel_button;
    private JLabel placeholder_label;
    private boolean overwrite = false;
    public NewActionWindow()
    {
        super();
        this.setTitle("OpenFileBatch-New Action");
        this.getContentPane().setLayout(new GridLayout(4,4));
        from_label = new JLabel("From:");
        from_path = new JTextField();
        to_label = new JLabel("To:");
        to_path = new JTextField();
        filter_combobox = new JComboBox<>(filter_options);
            filter_combobox.setSelectedItem(filter_options[0]);
        filter_value = new JTextField();
        overwrite_label = new JLabel("Overwrite:");
        overwrite_checkbox = new JCheckBox();
            overwrite_checkbox.addItemListener(this);
        action_label = new JLabel("Action:");
        action_combobox = new JComboBox<>(action_options);
            action_combobox.setSelectedItem(action_options[0]);
        save_button = new JButton("Save");
            save_button.setActionCommand("Save");
            save_button.addActionListener(this);
        execute_button = new JButton("Execute");
            execute_button.setActionCommand("Execute");
            execute_button.addActionListener(this);
        action_value1 = new JTextField();
        action_value2 = new JTextField();
        cancel_button = new JButton("Cancel");
            cancel_button.setActionCommand("Cancel");
            cancel_button.addActionListener(this);
        placeholder_label = new JLabel();
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
        if(e.getActionCommand().equals("Save"))
        {
        String filename = FileOperationHelper.getFreeName(".");
            try {
                BatchFileFactory.generateJSONAction(filename, new Action(new FileSelector(from_path.getText(), new FileSelector.Filter(FileSelector.filterTypes.valueOf(filter_combobox.getSelectedItem().toString().toUpperCase().replaceAll(" ", "_")),
                                                    filter_value.getText())), to_path.getText(), Action.actionTypes.valueOf(action_combobox.getSelectedItem().toString().replaceAll(" ", "_")), overwrite, action_value1.getText(), action_value2.getText()));
                if(System.getProperty("os.name").contains("Windows"))
                {
                    //TODO: generate windows bash file
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e)
    {
        overwrite = (e.getStateChange() == ItemEvent.SELECTED);
    }
}
