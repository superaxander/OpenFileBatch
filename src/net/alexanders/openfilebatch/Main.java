package net.alexanders.openfilebatch;

import net.alexanders.openfilebatch.gui.ControlWindow;

import java.awt.*;

public class Main
{
    public static final Dimension size = new Dimension(275, 128);

    public static void main(String[] args)
    {
        ControlWindow controlWindow = new ControlWindow();
                controlWindow.pack();
                controlWindow.setSize(size);
                controlWindow.setMinimumSize(size);
                controlWindow.setMaximumSize(size);

                controlWindow.setLocationRelativeTo(null);
                controlWindow.setVisible(true);

    }
}
