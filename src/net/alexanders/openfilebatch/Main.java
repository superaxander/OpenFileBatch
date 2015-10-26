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
                controlWindow.setLocationRelativeTo(null);
                controlWindow.setVisible(true);
        //try {
           // BatchFileFactory.generateJSONAction("testAction.json", new Action(new FileSelector("./", new FileSelector.Filter(FileSelector.filterTypes.ENDS_WITH, ".jar")), "./test", Action.actionTypes.COPY, false));
        //} catch (IOException e) {
        //    e.printStackTrace();
        //}
//        try {
//            new Gson().fromJson(new Gson().toJson(new Action(new FileSelector("./", new FileSelector.Filter(FileSelector.filterTypes.ENDS_WITH, ".jar")), "./test", Action.actionTypes.COPY, false)), Action.class).execute();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
